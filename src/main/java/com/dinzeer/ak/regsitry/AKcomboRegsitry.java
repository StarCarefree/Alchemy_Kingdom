package com.dinzeer.ak.regsitry;

import com.dinzeer.ak.AlchemyKingdom;
import com.dinzeer.ak.sa.*;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.ability.StunManager;
import mods.flammpfeil.slashblade.init.DefaultResources;
import mods.flammpfeil.slashblade.registry.combo.ComboState;
import mods.flammpfeil.slashblade.slasharts.SlashArts;
import mods.flammpfeil.slashblade.util.AttackManager;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.dinzeer.ak.AlchemyKingdom.MODID;

public class AKcomboRegsitry {
    public static final DeferredRegister<ComboState> COMBO_STATES =
            DeferredRegister.create(ComboState.REGISTRY_KEY,MODID);
    public static final RegistryObject<ComboState> ALL_REUSE = COMBO_STATES.register
            (
                    "all_reuse",
                    ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
                            .motionLoc(DefaultResources.ExMotionLocation).next(entity -> SlashBlade.prefix("none"))
                            .nextOfTimeout(entity -> SlashBlade.prefix("none"))
                            .addTickAction(ComboState.TimeLineTickAction.getBuilder().put(0, AttackManager::playQuickSheathSoundAction).build())
                            .releaseAction(ComboState::releaseActionQuickCharge)::build
            );

    public static final RegistryObject<ComboState> FireSlashS;//暝杀炎魔刀
    public static final RegistryObject<ComboState> ImmortalS;//不朽
    public static final RegistryObject<ComboState> BloodsuckingSickleS;//吸血镰
    public static final RegistryObject<ComboState> fateS;//命运
    public static final RegistryObject<ComboState> KingS;//王权
    public static final RegistryObject<ComboState> KingFireS;//君焰
    public static final RegistryObject<ComboState> TimeZeroS;//时间零
    public static final RegistryObject<ComboState> TheWrathofIndraS;//因陀罗之怒
    public static final RegistryObject<ComboState> WindyEyesS;//风王之瞳
    public static final RegistryObject<ComboState> ShivaDanceS;
    public static final RegistryObject<ComboState> LiulifanCityS;
    public static final RegistryObject<ComboState> TheEmperorofIceS;
    public static final RegistryObject<ComboState> ruinsS;
    public static final RegistryObject<ComboState> DragonS;
    static {
        FireSlashS = COMBO_STATES.register("prowess",
                ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                        .motionLoc(DefaultResources.ExMotionLocation)
                        .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                        .nextOfTimeout(entity -> AlchemyKingdom.prefix("all_reuse"))
                        .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                                .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false
                                        , 1))
                                .put(3, (entityIn) -> FireSlash.doSlash(entityIn, 90F, 20, Vec3.ZERO, false, 15, 1f, 1f, 2, 16711680)).build())
                        .addHitEffect(StunManager::setStun)
                        ::build);
        ImmortalS = COMBO_STATES.register("immortal",
                ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
                        .motionLoc(DefaultResources.ExMotionLocation)
                        .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                        .nextOfTimeout(entity -> AlchemyKingdom.prefix("all_reuse"))
                        .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                                .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false
                                        , 1))
                                .put(3, Immortal::doSlash).build())
                        .addHitEffect(StunManager::setStun)
                        ::build);
        BloodsuckingSickleS = COMBO_STATES.register("bloodsucking_sickle",
                ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
                        .motionLoc(DefaultResources.ExMotionLocation)
                        .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                        .nextOfTimeout(entity -> AlchemyKingdom.prefix("all_reuse"))
                        .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                                .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false
                                        , 1))
                                .put(3, (entityIn) -> BloodsuckingSickle
                                        .doSlash(entityIn, -30F, Vec3.ZERO, false, false
                                                , 1))
                                .put(4, (entityIn) -> BloodsuckingSickle
                                        .doSlash(entityIn, 40F, Vec3.ZERO, false, false
                                                , 1))
                                .put(5, (entityIn) -> BloodsuckingSickle
                                        .doSlash(entityIn, 50F, Vec3.ZERO, false, false
                                                , 1))
                                .put(6, (entityIn) -> BloodsuckingSickle
                                        .doSlash(entityIn, 80F, Vec3.ZERO, false, false
                                                , 1))
                                .put(7, (entityIn) -> BloodsuckingSickle
                                        .doSlash(entityIn, 90F, Vec3.ZERO, false, false
                                                , 1))
                                .build())
                        .addHitEffect(StunManager::setStun)
                        ::build);
        fateS = COMBO_STATES.register("fate",
                ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
                        .motionLoc(DefaultResources.ExMotionLocation)
                        .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                        .nextOfTimeout(entity -> AlchemyKingdom.prefix("all_reuse"))
                        .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                                .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false
                                        , 1))
                                .put(3, (entityIn) -> Fate.doSlash(entityIn, 0, 20, Vec3.ZERO, false, 320, 5f, 5f, 2, 16777215)).build())
                        .addHitEffect(StunManager::setStun)
                        ::build);
        KingS = COMBO_STATES.register("king",
                ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
                        .motionLoc(DefaultResources.ExMotionLocation)
                        .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                        .nextOfTimeout(entity -> AlchemyKingdom.prefix("all_reuse"))
                        .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                                .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false
                                        , 1))
                                .put(3, King::doSlash).build())
                        .addHitEffect(StunManager::setStun)
                        ::build);
        KingFireS = COMBO_STATES.register("king_fire",
                ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
                        .motionLoc(DefaultResources.ExMotionLocation)
                        .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                        .nextOfTimeout(entity -> AlchemyKingdom.prefix("all_reuse"))
                        .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                                .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false
                                        , 1))
                                .put(3, KingFire::doSlash).build())
                        .addHitEffect(StunManager::setStun)
                        ::build);
        TimeZeroS = COMBO_STATES.register("time_zero",
                ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
                        .motionLoc(DefaultResources.ExMotionLocation)
                        .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                        .nextOfTimeout(entity -> AlchemyKingdom.prefix("all_reuse"))
                        .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                                .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false
                                        , 1))
                                .put(3, TimeZero::doSlash).build())
                        .addHitEffect(StunManager::setStun)
                        ::build);
        TheWrathofIndraS= COMBO_STATES.register("the_wrath_of_indra",
                ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
                        .motionLoc(DefaultResources.ExMotionLocation)
                        .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                        .nextOfTimeout(entity -> AlchemyKingdom.prefix("all_reuse"))
                        .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                                .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false
                                        , 1))
                                .put(3, (entityIn) ->TheWrathofIndra.doSlash(entityIn,true,6F) ).build())
                        .addHitEffect(StunManager::setStun)
                        ::build);
        WindyEyesS = COMBO_STATES.register("windy_eyes",
                ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
                        .motionLoc(DefaultResources.ExMotionLocation)
                        .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                        .nextOfTimeout(entity -> AlchemyKingdom.prefix("all_reuse"))
                        .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                                .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false
                                        , 1))
                                .put(3, WindyEyes::doSlash).build())
                        .addHitEffect(StunManager::setStun)
                        ::build);
        ShivaDanceS = COMBO_STATES.register("shiva_dances",
                ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
                        .motionLoc(DefaultResources.ExMotionLocation)
                        .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                        .nextOfTimeout(entity -> AlchemyKingdom.prefix("all_reuse"))
                        .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                                .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false
                                        , 1))
                                .put(3, ShivaDance::doSlash).build())
                        .addHitEffect(StunManager::setStun)
                        ::build);
        LiulifanCityS = COMBO_STATES.register("citys",
                ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
                        .motionLoc(DefaultResources.ExMotionLocation)
                        .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                        .nextOfTimeout(entity -> AlchemyKingdom.prefix("all_reuse"))
                        .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                                .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false
                                        , 1))
                                .put(3, LiulifanCity::doSlash).build())
                        .addHitEffect(StunManager::setStun)
                        ::build);
        TheEmperorofIceS = COMBO_STATES.register("twh",
                ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
                        .motionLoc(DefaultResources.ExMotionLocation)
                        .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                        .nextOfTimeout(entity -> AlchemyKingdom.prefix("all_reuse"))
                        .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                                .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false
                                        , 1))
                                .put(3, TheEmperorofIce::doSlash).build())
                        .addHitEffect(StunManager::setStun)
                        ::build);
        ruinsS= COMBO_STATES.register("ruins",
                ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
                        .motionLoc(DefaultResources.ExMotionLocation)
                        .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                        .nextOfTimeout(entity -> AlchemyKingdom.prefix("all_reuse"))
                        .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                                .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false
                                        , 1))
                                .put(3,Ruins::doSlash ).build())
                        .addHitEffect(StunManager::setStun)
                        ::build);
        DragonS= COMBO_STATES.register("dragon",
                ComboState.Builder.newInstance().startAndEnd(459, 488).priority(50)
                        .motionLoc(DefaultResources.ExMotionLocation)
                        .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                        .nextOfTimeout(entity -> AlchemyKingdom.prefix("all_reuse"))
                        .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                                .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false
                                        , 1))
                                .put(3,(entityIn) -> Dragon.doSlash(entityIn, 0, 20, Vec3.ZERO, false, 50, 1f, 2f, 2, 16711680) ).build())
                        .addHitEffect(StunManager::setStun)
                        ::build);

    }
}
