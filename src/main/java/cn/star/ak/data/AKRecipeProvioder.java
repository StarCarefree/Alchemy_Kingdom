package cn.star.ak.data;

import cn.star.ak.init.AKItems;
import mods.flammpfeil.slashblade.data.builtin.SlashBladeBuiltInRegistry;
import mods.flammpfeil.slashblade.init.SBItems;
import mods.flammpfeil.slashblade.recipe.RequestDefinition;
import mods.flammpfeil.slashblade.recipe.SlashBladeIngredient;
import mods.flammpfeil.slashblade.recipe.SlashBladeShapedRecipeBuilder;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class AKRecipeProvioder  extends RecipeProvider implements IConditionBuilder {
    public AKRecipeProvioder(PackOutput output) {
        super(output);
    }
    protected void buildRecipes(Consumer<FinishedRecipe> consumer){
        SlashBladeShapedRecipeBuilder.shaped(AKBuiltInRegsitry.yataghans.location())
                .pattern("ABC")
                .pattern("BDE")
                .pattern("CEF")
                .define('A',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .proudSoul(100)
                                .refineCount(1)
                                .build()))
                .define('B',SBItems.proudsoul_ingot)
                .define('C',Items.IRON_INGOT)
                .define('D',Items.BLACK_DYE)
                .define('E',Items.AMETHYST_SHARD)
                .define('F',Items.IRON_SWORD)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(AKBuiltInRegsitry.spider.location())
                .pattern("ABC")
                .pattern("DEF")
                .pattern("GDH")
                .define('A',Items.NETHERITE_INGOT)
                .define('B',Items.LAPIS_BLOCK)
                .define('C',Items.IRON_BLOCK)
                .define('D',SBItems.proudsoul_ingot)
                .define('E',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeBuiltInRegistry.RUBY.location())
                                .killCount(1500)
                                .proudSoul(6000)
                                .refineCount(30)
                                .build()))
                .define('F',Items.OBSIDIAN)
                .define('G',Items.DIAMOND)
                .define('H',Items.REDSTONE)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(AKBuiltInRegsitry.child.location())
                .pattern("ABC")
                .pattern("DEF")
                .pattern("GDH")
                .define('A',Items.NETHERITE_INGOT)
                .define('B',Items.GOLD_BLOCK)
                .define('C',Items.IRON_BLOCK)
                .define('D',SBItems.proudsoul_ingot)
                .define('E',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeBuiltInRegistry.DOUTANUKI.location())
                                .killCount(1500)
                                .proudSoul(6000)
                                .refineCount(30)
                                .build()))
                .define('F',Items.OBSIDIAN)
                .define('G',Items.DIAMOND)
                .define('H',Items.REDSTONE)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(AKBuiltInRegsitry.dick_wido.location())
                .pattern("ABC")
                .pattern("BDE")
                .pattern("FED")
                .define('A',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(AKBuiltInRegsitry.yataghans.location())
                                .killCount(500)
                                .proudSoul(2700)
                                .refineCount(15)
                                .build()))
                .define('B',Items.CRYING_OBSIDIAN)
                .define('C',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeBuiltInRegistry.TAGAYASAN.location())
                                .killCount(500)
                                .proudSoul(6000)
                                .refineCount(15)
                                .build()))
                .define('D',SBItems.proudsoul_ingot)
                .define('E',Items.OBSIDIAN)
                .define('F',Items.NETHERITE_SCRAP)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(AKBuiltInRegsitry.murasame.location())
                .pattern("FBC")
                .pattern("BDE")
                .pattern("AEG")
                .define('A',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(AKBuiltInRegsitry.yataghans.location())
                                .killCount(500)
                                .proudSoul(2700)
                                .refineCount(15)
                                .build()))
                .define('B',Items.MAGMA_BLOCK)
                .define('C',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeBuiltInRegistry.MURAMASA.location())
                                .killCount(1500)
                                .proudSoul(6000)
                                .refineCount(15)
                                .build()))
                .define('E',SBItems.proudsoul_ingot)
                .define('D',Items.SOUL_LANTERN)
                .define('F',Items.BLAZE_POWDER)
                .define('G',Items.FIRE_CHARGE)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(AKBuiltInRegsitry.pocket_knife.location())

                .pattern("ABB")
                .pattern("BCB")
                .pattern("DBA")
                .define('A',SBItems.proudsoul_trapezohedron)
                .define('B',Items.IRON_BLOCK)
                .define('C', AKItems.geM)
                .define('D',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(AKBuiltInRegsitry.yataghans.location())
                                .killCount(2118)
                                .proudSoul(9999)
                                .refineCount(38)
                                .build()))

                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(AKBuiltInRegsitry.kill_dragon.location())
                .pattern("ABC")
                .pattern("BDE")
                .pattern("CEF")
                .define('A',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(AKBuiltInRegsitry.murasame.location())
                                .killCount(2455)
                                .proudSoul(9999)
                                .refineCount(40)
                                .build()))
                .define('B',Items.LAVA_BUCKET)
                .define('C',Items.CRYING_OBSIDIAN)
                .define('D',AKItems.DRAGON_CROSS)
                .define('E',SBItems.proudsoul_crystal)
                .define('F',Items.NETHERITE_INGOT)

                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(AKBuiltInRegsitry.cloud.location())
                .pattern("ABC")
                .pattern("DEB")
                .pattern("FDA")
                .define('A',AKItems.DRAGON_CROSS)
                .define('B',Items.END_STONE)
                .define('C',Items.NETHER_STAR)
                .define('D',Items.NETHERITE_INGOT)
                .define('E',Items.NETHERITE_SWORD)
                .define('F',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeBuiltInRegistry.SANGE.location())
                                .killCount(3000)
                                .proudSoul(12999)
                                .refineCount(43)
                                .build()))

                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(AKBuiltInRegsitry.kungunier.location())
                .pattern(" AA")
                .pattern("BAA")
                .pattern("AB ")
                .define('A',AKItems.worldtree)
                .define('B',SBItems.proudsoul_trapezohedron)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(AKBuiltInRegsitry.rage.location())
                .pattern("ABC")
                .pattern("DEF")
                .pattern("GHA")
                .define('A',AKItems.geM)
                .define('B',Items.ELYTRA)
                .define('C',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeBuiltInRegistry.YAMATO.location())
                                .killCount(99)
                                .proudSoul(999)
                                .refineCount(9)
                                .build()))
                .define('D',Items.END_CRYSTAL)
                .define('E',AKItems.DRAGON_CROSS)
                .define('F',Items.BLAZE_ROD)
                .define('G',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(AKBuiltInRegsitry.yataghans.location())
                                .killCount(3500)
                                .proudSoul(15000)
                                .refineCount(50)
                                .build()))
                .define('H',SBItems.proudsoul_trapezohedron)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

        SlashBladeShapedRecipeBuilder.shaped(AKBuiltInRegsitry.lust.location())
                .pattern("ABC")
                .pattern("DEF")
                .pattern("GHA")
                .define('A',AKItems.geM)
                .define('B',Items.CRYING_OBSIDIAN)
                .define('C',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeBuiltInRegistry.RODAI_WOODEN.location())
                                .killCount(99)
                                .proudSoul(999)
                                .refineCount(9)
                                .build()))
                .define('D',Items.LAPIS_BLOCK)
                .define('E',AKItems.DRAGON_CROSS)
                .define('F',Items.CRYING_OBSIDIAN)
                .define('G',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(AKBuiltInRegsitry.yataghans.location())
                                .killCount(1500)
                                .proudSoul(3000)
                                .refineCount(14)
                                .build()))
                .define('H',SBItems.proudsoul_trapezohedron)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(AKBuiltInRegsitry.lazy.location())
                .pattern("ABC")
                .pattern("DEF")
                .pattern("GHA")
                .define('A',AKItems.geM)
                .define('B',Items.REDSTONE_BLOCK)
                .define('C',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeBuiltInRegistry.RODAI_GOLDEN.location())
                                .killCount(99)
                                .proudSoul(999)
                                .refineCount(9)
                                .build()))
                .define('D',Items.WHITE_BED)
                .define('E',AKItems.DRAGON_CROSS)
                .define('F',Items.WHITE_BED)
                .define('G',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(AKBuiltInRegsitry.yataghans.location())
                                .killCount(2700)
                                .proudSoul(9000)
                                .refineCount(39)
                                .build()))
                .define('H',SBItems.proudsoul_trapezohedron)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(AKBuiltInRegsitry.tai_ti.location())
                .pattern("ABC")
                .pattern("DEF")
                .pattern("GHA")
                .define('A',AKItems.geM)
                .define('B',Items.CAKE)
                .define('C',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeBuiltInRegistry.RODAI_STONE.location())
                                .killCount(99)
                                .proudSoul(999)
                                .refineCount(9)
                                .build()))
                .define('D',Items.POTATO)
                .define('E',AKItems.DRAGON_CROSS)
                .define('F',Items.RABBIT_STEW)
                .define('G',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(AKBuiltInRegsitry.yataghans.location())
                                .killCount(1800)
                                .proudSoul(4500)
                                .refineCount(23)
                                .build()))
                .define('H',SBItems.proudsoul_trapezohedron)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(AKBuiltInRegsitry.greedy.location())
                .pattern("ABC")
                .pattern("DEF")
                .pattern("GHA")
                .define('A',AKItems.geM)
                .define('B',Items.GOLD_BLOCK)
                .define('C',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeBuiltInRegistry.RODAI_IRON.location())
                                .killCount(99)
                                .proudSoul(999)
                                .refineCount(9)
                                .build()))
                .define('D',Items.NETHER_QUARTZ_ORE)
                .define('E',AKItems.DRAGON_CROSS)
                .define('F',Items.HEART_OF_THE_SEA)
                .define('G',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(AKBuiltInRegsitry.yataghans.location())
                                .killCount(2100)
                                .proudSoul(6000)
                                .refineCount(27)
                                .build()))
                .define('H',SBItems.proudsoul_trapezohedron)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(AKBuiltInRegsitry.arrogant.location())
                .pattern("ABC")
                .pattern("DEF")
                .pattern("GHA")
                .define('A',AKItems.geM)
                .define('B',Items.CALIBRATED_SCULK_SENSOR)
                .define('C',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeBuiltInRegistry.RODAI_DIAMOND.location())
                                .killCount(99)
                                .proudSoul(999)
                                .refineCount(9)
                                .build()))
                .define('D',Items.WHITE_BANNER)
                .define('E',AKItems.DRAGON_CROSS)
                .define('F',Items.SPYGLASS)
                .define('G',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(AKBuiltInRegsitry.yataghans.location())
                                .killCount(2700)
                                .proudSoul(9000)
                                .refineCount(39)
                                .build()))
                .define('H',SBItems.proudsoul_trapezohedron)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);
        SlashBladeShapedRecipeBuilder.shaped(AKBuiltInRegsitry.jealous.location())
                .pattern("ABC")
                .pattern("DEF")
                .pattern("GHA")
                .define('A',AKItems.geM)
                .define('B',Items.SCULK_VEIN)
                .define('C',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(SlashBladeBuiltInRegistry.RODAI_NETHERITE.location())
                                .killCount(99)
                                .proudSoul(999)
                                .refineCount(9)
                                .build()))
                .define('D',Items.GLOW_INK_SAC)
                .define('E',AKItems.DRAGON_CROSS)
                .define('F',Items.ECHO_SHARD)
                .define('G',SlashBladeIngredient.of(
                        RequestDefinition.Builder.newInstance()
                                .name(AKBuiltInRegsitry.yataghans.location())
                                .killCount(3000)
                                .proudSoul(11000)
                                .refineCount(45)
                                .build()))
                .define('H',SBItems.proudsoul_trapezohedron)
                .unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade)).save(consumer);

    }
}
