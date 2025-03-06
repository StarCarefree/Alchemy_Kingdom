package com.dinzeer.ak.regsitry;

import com.dinzeer.ak.entity.*;
import com.google.common.base.CaseFormat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import static com.dinzeer.ak.AlchemyKingdom.MODID;

public class AKEntiteRegristrys {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);
    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
    public static final ResourceLocation FireDriveLOC = new ResourceLocation(MODID, classToString(FireDriveEntity.class));
    public static EntityType<FireDriveEntity> FireDrive;
    public static final ResourceLocation HealSlashLOC = new ResourceLocation(MODID, classToString(HealSlashEntity.class));
    public static EntityType<HealSlashEntity> HealSlash;
    public static final ResourceLocation KungunierLOC = new ResourceLocation(MODID, classToString(KungunierEntity.class));
    public static EntityType<KungunierEntity> Kungunier;
    public static final ResourceLocation EntityZenith12thSwordLOC = new ResourceLocation(MODID, classToString(EntityZenith12thSword.class));
    public static EntityType<EntityZenith12thSword> EntityZenith12thsword;
    public static final ResourceLocation cwe = new ResourceLocation(MODID, classToString(CrazyWindyEyes.class));
    public static EntityType<CrazyWindyEyes> cwee;
    public static final ResourceLocation SDLOC = new ResourceLocation(MODID, classToString(ShivaDance.class));
    public static EntityType<ShivaDance> SD;
    public static final ResourceLocation LCLOC = new ResourceLocation(MODID, classToString(LiuliFanCity.class));
    public static EntityType<LiuliFanCity> LC;
    public static final ResourceLocation TheEmperorofIceLOC = new ResourceLocation(MODID, classToString(TheEmperorofIce.class));
    public static EntityType<TheEmperorofIce> TheEmperorofIceS;
    public static final ResourceLocation RuinsLOC = new ResourceLocation(MODID, classToString(Ruins.class));
    public static EntityType<Ruins> RuinsS;
    public static final ResourceLocation DragonLOC = new ResourceLocation(MODID, classToString(DragonEntity.class));
    public static EntityType<DragonEntity> DragonS;
    public static final ResourceLocation EntitySwordLOC = new ResourceLocation(MODID, classToString(EntitySword.class));
    public static EntityType<EntitySword> EntitySwordS;
    public static void register(RegisterEvent event){
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<CrazyWindyEyes> entity = cwee = EntityType.Builder
                        .of(CrazyWindyEyes::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(CrazyWindyEyes::createInstance)
                        .build(cwe.toString());
                helper.register(cwe, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<FireDriveEntity> entity = FireDrive = EntityType.Builder
                        .of(FireDriveEntity::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(FireDriveEntity::createInstance)
                        .build(FireDriveLOC.toString());
                helper.register(FireDriveLOC, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<HealSlashEntity> entity = HealSlash = EntityType.Builder
                        .of(HealSlashEntity::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(HealSlashEntity::createInstance)
                        .build(HealSlashLOC.toString());
                helper.register(HealSlashLOC, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<KungunierEntity> entity = Kungunier = EntityType.Builder
                        .of(KungunierEntity::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(KungunierEntity::createInstance)
                        .build(KungunierLOC.toString());
                helper.register(KungunierLOC, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<EntityZenith12thSword> entity = EntityZenith12thsword = EntityType.Builder
                        .of(EntityZenith12thSword::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(EntityZenith12thSword::createInstance)
                        .build(EntityZenith12thSwordLOC.toString());
                helper.register(EntityZenith12thSwordLOC, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<ShivaDance> entity = SD = EntityType.Builder
                        .of(ShivaDance::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(ShivaDance::createInstance)
                        .build(SDLOC.toString());
                helper.register(SDLOC, entity);
            }
        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<LiuliFanCity> entity = LC = EntityType.Builder
                        .of(LiuliFanCity::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(LiuliFanCity::createInstance)
                        .build(LCLOC.toString());
                helper.register(LCLOC, entity);
            }
        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<TheEmperorofIce> entity = TheEmperorofIceS = EntityType.Builder
                        .of(TheEmperorofIce::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(TheEmperorofIce::createInstance)
                        .build(TheEmperorofIceLOC.toString());
                helper.register(TheEmperorofIceLOC, entity);
            }
        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<Ruins> entity = RuinsS = EntityType.Builder
                        .of(Ruins::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(Ruins::createInstance)
                        .build(RuinsLOC.toString());
                helper.register(RuinsLOC, entity);
            }
        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<DragonEntity> entity = DragonS = EntityType.Builder
                        .of(DragonEntity::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(DragonEntity::createInstance)
                        .build(DragonLOC.toString());
                helper.register(DragonLOC, entity);
            }
        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<EntitySword> entity = EntitySwordS = EntityType.Builder
                        .of(EntitySword::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(EntitySword::createInstance)
                        .build(EntitySwordLOC.toString());
                helper.register(EntitySwordLOC, entity);
            }
        });
    }






    public static String classToString(Class<? extends Entity> entityClass)
    {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, entityClass.getSimpleName())
                .replace("entity_", "");
    }





}
