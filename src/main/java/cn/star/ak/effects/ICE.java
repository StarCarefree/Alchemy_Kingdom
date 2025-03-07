package cn.star.ak.effects;

import cn.star.ak.AlchemyKingdom;
import cn.star.ak.network.AKvaV;
import cn.star.ak.se.SpecialEffectEx;
import cn.star.ak.utils.WeightedUtil;
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
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;
import java.util.Map;

@Mod.EventBusSubscriber
public class ICE extends MobEffect {
    public ICE() {
        super(MobEffectCategory.HARMFUL , Color.BLUE.getRGB());
    }

    @Override
    public void applyEffectTick(LivingEntity p_19467_, int p_19468_) {
        p_19467_.setDeltaMovement(0,0,0);
        super.applyEffectTick(p_19467_, p_19468_);
    }
}
