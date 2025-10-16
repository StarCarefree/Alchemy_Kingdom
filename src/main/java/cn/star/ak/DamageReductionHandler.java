package cn.star.ak;

import cn.star.ak.network.AKvaV;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.fml.loading.moddiscovery.ModInfo;

@Mod.EventBusSubscriber
public class DamageReductionHandler {

    private static boolean isModLoaded = false;

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        checkModlist();
    }

    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event) {
        checkModlist();
    }

    private static void checkModlist() {
        var modIds = FMLLoader.getLoadingModList().getMods().stream()
                .map(ModInfo::getModId)
                .toList();

        isModLoaded = modIds.stream().anyMatch(modId -> modId.equals("sstmod"));
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player player) {
            var talent = player.getCapability(AKvaV.PLAYER_VARIABLES_CAPABILITY,null).orElseGet(null).talent;
            double armorValue = getPlayerArmorValue(player);

            float armorReduction = isModLoaded ? calculateArmorReduction(armorValue) : 0.0f;

            float talentReduction = calculateTalentReduction(talent);

            float totalReduction = armorReduction + talentReduction;

            if (totalReduction > 0) {
                float originalDamage = event.getAmount();
                float reducedDamage = originalDamage * (1.0f - totalReduction);

                event.setAmount(reducedDamage);
            }
        }
    }


    private static double getPlayerArmorValue(Player player) {
        return player.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getValue();
    }

    /**
     * 根据护甲值计算减免百分比
     */
    private static float calculateArmorReduction(double armorValue) {
        if (armorValue >= 30) {
            return 0.20f;
        } else if (armorValue >= 20) {
            return 0.10f;
        } else if (armorValue >= 10) {
            return 0.05f;
        }
        return 0.0f;
    }

    /**
     * 根据血统减免百分比
     */
    private static float calculateTalentReduction(double talent) {
        float reduction = 0.0f;

        if (talent >= 2) {
            reduction += 0.10f;
        }
        if (talent >= 3) {
            reduction += 0.10f;
        }
        if (talent >= 4) {
            reduction += 0.10f;
        }

        return reduction;
    }
}