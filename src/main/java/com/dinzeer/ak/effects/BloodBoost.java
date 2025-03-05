package com.dinzeer.ak.effects;

import com.dinzeer.ak.AlchemyKingdom;
import com.dinzeer.ak.network.AKvaV;
import com.dinzeer.ak.se.SpecialEffectEx;
import com.dinzeer.ak.utils.WeightedUtil;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;
@Mod.EventBusSubscriber
public class BloodBoost extends MobEffect {
    public BloodBoost() {
        super(MobEffectCategory.BENEFICIAL, 0xff0000);
    }

    public static final String cooldownTagName = "BBcooldown";

    private static final double[] damageLevel = {1.4,2.1,3,4.5};

    private static final WeightedUtil<Integer> RandomDamageLevel = new WeightedUtil<>(Map.of(
            -1,839f,
            0,100f,
            1,50f,
            2,10f,
            3,1f
    ));

    @Override
    public void removeAttributeModifiers(LivingEntity p_19469_, AttributeMap p_19470_, int p_19471_) {
        if (p_19471_>=1){
            p_19469_.addEffect(new MobEffectInstance( MobEffects.WEAKNESS , 20*72, (p_19471_+1)*2) );
        }
        super.removeAttributeModifiers(p_19469_, p_19470_, p_19471_);
    }

    @SubscribeEvent
    public static void DamageBoot(LivingHurtEvent event){

        SpecialEffectEx.hurtEventHandle(event,(p,e)->{

            if (p.hasEffect(AlchemyKingdom.EffectAbout.BLOOD_BOOST.get())) {
                int amplifier = p.getEffect(AlchemyKingdom.EffectAbout.BLOOD_BOOST.get()).getAmplifier();
                if (amplifier < 4) {
                    double l = damageLevel[amplifier];
                    SpecialEffectEx.hurtEventAmountBase(event,(float) l);
                }
            }else {
                if (!p.getPersistentData().contains(cooldownTagName) ||p.getPersistentData().getInt(cooldownTagName)<=0) {
                    if (p.getCapability(AKvaV.PLAYER_VARIABLES_CAPABILITY).orElse(null).mixin) {
                        Integer a = RandomDamageLevel.selectRandomKeyBasedOnWeights();
                        if (a != -1) {
                            p.addEffect(new MobEffectInstance(AlchemyKingdom.EffectAbout.BLOOD_BOOST.get(), 42 * 20, a));
                            p.getPersistentData().putInt(cooldownTagName,20*60*3);
                        }
                    }
                }
            }
        });
    }
    @SubscribeEvent
    public static void CooldownHandle(TickEvent.PlayerTickEvent e){
        Player player = e.player;
        int anInt = player.getPersistentData().getInt(cooldownTagName);
        if (anInt >0) {
           if( player.level() instanceof ServerLevel l){
               l.sendParticles(ParticleTypes.SOUL, player.getX(),player.getY()+0.2,player.getZ(),1,0,0,0,0);
               player.getPersistentData().putInt(cooldownTagName,anInt-1);
           }

        }
        }

    }
