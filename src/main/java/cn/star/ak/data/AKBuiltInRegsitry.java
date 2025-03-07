package cn.star.ak.data;

import cn.star.ak.AlchemyKingdom;
import cn.star.ak.regsitry.AKslashartRegsitry;
import mods.flammpfeil.slashblade.client.renderer.CarryType;
import mods.flammpfeil.slashblade.data.builtin.SlashBladeBuiltInRegistry;
import mods.flammpfeil.slashblade.item.SwordType;
import mods.flammpfeil.slashblade.registry.slashblade.EnchantmentDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.PropertiesDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.RenderDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class AKBuiltInRegsitry {
    //折刀
    public static final ResourceKey<SlashBladeDefinition> pocket_knife=register("pocket_knife");
    //亚特坎
    public static final ResourceKey<SlashBladeDefinition> yataghans=register("yataghans");
    //天丛云
    public static final ResourceKey<SlashBladeDefinition> cloud=register("cloud");
    //昆古尼尔
    public static final ResourceKey<SlashBladeDefinition> kungunier=register("kungunier");
    //狄克维多
    public static final ResourceKey<SlashBladeDefinition> dick_wido=register("dick_wido");
    //御神刀「村雨」
    public static final ResourceKey<SlashBladeDefinition> murasame=register("murasame");
    //斩龙者「村雨」
    public static final ResourceKey<SlashBladeDefinition> kill_dragon=register("kill_dragon");
    //蜘蛛切
    public static final ResourceKey<SlashBladeDefinition> spider=register("spider");
    //童子切安纲
    public static final ResourceKey<SlashBladeDefinition> child=register("child");
    //暴怒
    public static final ResourceKey<SlashBladeDefinition> rage=register("rage");
    //傲慢
    public static final ResourceKey<SlashBladeDefinition> arrogant=register("arrogant");
    //妒忌
    public static final ResourceKey<SlashBladeDefinition> jealous=register("jealous");
    //懒惰
    public static final ResourceKey<SlashBladeDefinition> lazy=register("lazy");
    //色欲
    public static final ResourceKey<SlashBladeDefinition> lust=register("lust");
    //贪婪
    public static final ResourceKey<SlashBladeDefinition> greedy=register("greedy");
    //饕餮
    public static final ResourceKey<SlashBladeDefinition> tai_ti=register("tai_ti");
    public static void registerAll(BootstapContext<SlashBladeDefinition> bootstrap) {

        bootstrap.register(
                pocket_knife, new SlashBladeDefinition(AlchemyKingdom.prefix("pocket_knife"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(AlchemyKingdom.prefix("model/named/pocket_knife/blood.png"))
                                .modelName(AlchemyKingdom.prefix("model/named/pocket_knife/sange.obj"))
                                .effectColor(16777215)
                                .standbyRenderType(CarryType.KATANA)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(AKslashartRegsitry.TimeZero.getId())

                                .baseAttackModifier(33)
                                .maxDamage(180)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10)

                        )
                ));
        bootstrap.register(
                yataghans, new SlashBladeDefinition(AlchemyKingdom.prefix("yataghans"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(AlchemyKingdom.prefix("model/named/yataghans/blood.png"))
                                .modelName(AlchemyKingdom.prefix("model/named/yataghans/sange.obj"))
                                .effectColor(16777215)
                                .standbyRenderType(CarryType.PSO2)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(6)
                                .maxDamage(180)
                                .build(),
                        List.of(
                        )
                ));
        bootstrap.register(
                cloud, new SlashBladeDefinition(AlchemyKingdom.prefix("cloud"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(AlchemyKingdom.prefix("model/named/cloud/blood.png"))
                                .modelName(AlchemyKingdom.prefix("model/named/cloud/sange.obj"))
                                .effectColor(16770048)
                                .standbyRenderType(CarryType.RNINJA)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(AKslashartRegsitry.Immortal.getId())
                                .baseAttackModifier(42)
                                .maxDamage(180)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10)

                        )
                ));
            bootstrap.register(
                kungunier, new SlashBladeDefinition(AlchemyKingdom.prefix("kungunier"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(AlchemyKingdom.prefix("model/named/kungunier/blood.png"))
                                .modelName(AlchemyKingdom.prefix("model/named/kungunier/sange.obj"))
                                .effectColor(16777215)
                                .standbyRenderType(CarryType.NINJA)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(AKslashartRegsitry.Fate.getId())
                                .baseAttackModifier(55)
                                .maxDamage(180)
                                .build(),
                            List.of(
                                    new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 10),
                                    new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 10),
                                    new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 0)

                            )
                ));
            bootstrap.register(
                dick_wido, new SlashBladeDefinition(AlchemyKingdom.prefix("dick_wido"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(AlchemyKingdom.prefix("model/named/dick_wido/blood.png"))
                                .modelName(AlchemyKingdom.prefix("model/named/dick_wido/sange.obj"))
                                .effectColor(16777215)
                                .standbyRenderType(CarryType.NINJA)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                        .slashArtsType(AKslashartRegsitry.BloodsuckingSickle.getId())
                                .baseAttackModifier(24)
                                .maxDamage(180)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 1),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 5)

                        )
                ));
            bootstrap.register(
                murasame, new SlashBladeDefinition(AlchemyKingdom.prefix("murasame"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(AlchemyKingdom.prefix("model/named/murasame/blood.png"))
                                .modelName(AlchemyKingdom.prefix("model/named/murasame/sange.obj"))
                                .effectColor(16777215)
                                .standbyRenderType(CarryType.NINJA)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(AKslashartRegsitry.KingFire.getId())
                                .baseAttackModifier(24)
                                .maxDamage(180)
                                .build(),
                            List.of(
                                    new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                                    new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_PROTECTION), 1),
                                    new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 3),
                                    new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5)

                            )
                ));
            bootstrap.register(
                kill_dragon, new SlashBladeDefinition(AlchemyKingdom.prefix("kill_dragon"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(AlchemyKingdom.prefix("model/named/kill_dragon/blood.png"))
                                .modelName(AlchemyKingdom.prefix("model/named/kill_dragon/sange.obj"))
                                .effectColor(16777215)
                                .standbyRenderType(CarryType.NINJA)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(AKslashartRegsitry.FireSlash.getId())
                                .baseAttackModifier(34)
                                .maxDamage(180)
                                .build(),
                            List.of(
                                    new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 10),
                                    new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_PROTECTION), 4),
                                    new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 10),
                                    new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5)

                            )
                ));
            bootstrap.register(
                spider, new SlashBladeDefinition(AlchemyKingdom.prefix("spider"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(AlchemyKingdom.prefix("model/named/spider/blood.png"))
                                .modelName(AlchemyKingdom.prefix("model/named/spider/sange.obj"))
                                .effectColor(16777215)
                                .standbyRenderType(CarryType.NINJA)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(AKslashartRegsitry.King.getId())
                                .baseAttackModifier(28)
                                .maxDamage(180)
                                .build(),
                            List.of(
                                    new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 7),
                                    new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 3),
                                    new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 1),
                                    new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5)

                            )
                ));
        bootstrap.register(
                child, new SlashBladeDefinition(AlchemyKingdom.prefix("child"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(AlchemyKingdom.prefix("model/named/child/blood.png"))
                                .modelName(AlchemyKingdom.prefix("model/named/child/sange.obj"))
                                .effectColor(16777215)
                                .standbyRenderType(CarryType.NINJA)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(AKslashartRegsitry.King.getId())
                                .baseAttackModifier(28)
                                .maxDamage(180)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 2),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3)

                        )
                ));
        bootstrap.register(
                rage, new SlashBladeDefinition(AlchemyKingdom.prefix("rage"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(AlchemyKingdom.prefix("model/named/sin/rage/blood.png"))
                                .modelName(AlchemyKingdom.prefix("model/named/sin/rage/sange.obj"))
                                .effectColor(16777215)
                                .standbyRenderType(CarryType.NINJA)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(AKslashartRegsitry.Dragon.getId())
                                .baseAttackModifier(45)
                                .maxDamage(180)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 0),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 10)

                        )
                ));
        bootstrap.register(
                arrogant, new SlashBladeDefinition(AlchemyKingdom.prefix("arrogant"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(AlchemyKingdom.prefix("model/named/sin/arrogant/blood.png"))
                                .modelName(AlchemyKingdom.prefix("model/named/sin/arrogant/sange.obj"))
                                .effectColor(16777215)
                                .standbyRenderType(CarryType.NINJA)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(AKslashartRegsitry.TheWrathofIndra.getId())
                                .baseAttackModifier(37)
                                .maxDamage(180)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SWEEPING_EDGE), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 8),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 0)

                        )));
        bootstrap.register(
                jealous, new SlashBladeDefinition(AlchemyKingdom.prefix("jealous"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(AlchemyKingdom.prefix("model/named/sin/jealous/blood.png"))
                                .modelName(AlchemyKingdom.prefix("model/named/sin/jealous/sange.obj"))
                                .effectColor(16777215)
                                .standbyRenderType(CarryType.NINJA)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(AKslashartRegsitry.ruins.getId())
                                .baseAttackModifier(41)
                                .maxDamage(180)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SWEEPING_EDGE), 8),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 15),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 0)
                        )));
        bootstrap.register(
                lazy, new SlashBladeDefinition(AlchemyKingdom.prefix("lazy"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(AlchemyKingdom.prefix("model/named/sin/lazy/blood.png"))
                                .modelName(AlchemyKingdom.prefix("model/named/sin/lazy/sange.obj"))
                                .effectColor(16777215)
                                .standbyRenderType(CarryType.NINJA)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(AKslashartRegsitry.TheEmperorofIce.getId())
                                .baseAttackModifier(34)
                                .maxDamage(180)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 0),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_PROTECTION), 10)
                        )));
        bootstrap.register(
                lust, new SlashBladeDefinition(AlchemyKingdom.prefix("lust"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(AlchemyKingdom.prefix("model/named/sin/lust/blood.png"))
                                .modelName(AlchemyKingdom.prefix("model/named/sin/lust/sange.obj"))
                                .effectColor(16777215)
                                .standbyRenderType(CarryType.NINJA)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(AKslashartRegsitry.WindyEyes.getId())
                                .baseAttackModifier(24)
                                .maxDamage(180)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 0),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5)
                        )));
        bootstrap.register(
                greedy, new SlashBladeDefinition(AlchemyKingdom.prefix("greedy"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(AlchemyKingdom.prefix("model/named/sin/greedy/blood.png"))
                                .modelName(AlchemyKingdom.prefix("model/named/sin/greedy/sange.obj"))
                                .effectColor(16777215)
                                .standbyRenderType(CarryType.NINJA)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(AKslashartRegsitry.LiulifanCity.getId())
                                .baseAttackModifier(30)
                                .maxDamage(180)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 0),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 8),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 10)
                        )));
        bootstrap.register(
                tai_ti, new SlashBladeDefinition(AlchemyKingdom.prefix("tai_ti"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(AlchemyKingdom.prefix("model/named/sin/tai_ti/blood.png"))
                                .modelName(AlchemyKingdom.prefix("model/named/sin/tai_ti/sange.obj"))
                                .effectColor(16777215)
                                .standbyRenderType(CarryType.NINJA)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(AKslashartRegsitry.ShivaDance.getId())
                                .baseAttackModifier(27)
                                .maxDamage(180)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 0),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 3)
                        )));


    }


    private static ResourceKey<SlashBladeDefinition> register(String id) {
        return ResourceKey.create(SlashBladeDefinition.REGISTRY_KEY, AlchemyKingdom.prefix(id));
    }
    static ResourceLocation getEnchantmentID(Enchantment enchantment) {
        return ForgeRegistries.ENCHANTMENTS.getKey(enchantment);
    }

}
