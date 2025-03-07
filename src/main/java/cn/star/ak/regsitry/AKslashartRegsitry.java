package cn.star.ak.regsitry;

import mods.flammpfeil.slashblade.registry.combo.ComboState;
import mods.flammpfeil.slashblade.slasharts.SlashArts;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static cn.star.ak.AlchemyKingdom.MODID;

public class AKslashartRegsitry {
    public static final DeferredRegister<SlashArts> SLASH_ARTS =
            DeferredRegister.create(SlashArts.REGISTRY_KEY, MODID);
    public static final RegistryObject<SlashArts> FireSlash;//暝杀炎魔刀
    public static final RegistryObject<SlashArts> Immortal;//不朽
    public static final RegistryObject<SlashArts> BloodsuckingSickle;//吸血镰
    public static final RegistryObject<SlashArts> Fate;//命运
    public static final RegistryObject<SlashArts> King;//王权
    public static final RegistryObject<SlashArts> KingFire;//君焰
    public static final RegistryObject<SlashArts> TimeZero;//时间零
    public static final RegistryObject<SlashArts> TheWrathofIndra;//因陀罗之怒
    public static final RegistryObject<SlashArts> WindyEyes;//风王之瞳
    public static final RegistryObject<SlashArts> ShivaDance;//湿婆业舞
    public static final RegistryObject<SlashArts> LiulifanCity;//琉璃梵城
    public static final RegistryObject<SlashArts> TheEmperorofIce;//冰之皇
    public static final RegistryObject<SlashArts> ruins;//归墟
    public static final RegistryObject<SlashArts> Dragon;//烛龙
     static {
        FireSlash=SLASH_ARTS.register("fire_slash", () -> new SlashArts((e) ->
                AKcomboRegsitry.FireSlashS.getId()));
        Immortal=SLASH_ARTS.register("immortal", () -> new SlashArts((e) ->
                AKcomboRegsitry.ImmortalS.getId()));
        BloodsuckingSickle=SLASH_ARTS.register("bloodsucking_sickle", () -> new SlashArts((e) ->
                AKcomboRegsitry.BloodsuckingSickleS.getId()));
        Fate=SLASH_ARTS.register("fate", () -> new SlashArts((e) ->
                AKcomboRegsitry.fateS.getId()));
        King=SLASH_ARTS.register("king", () -> new SlashArts((e) ->
                AKcomboRegsitry.KingS.getId()));
        KingFire=SLASH_ARTS.register("king_fire", () -> new SlashArts((e) ->
                AKcomboRegsitry.KingFireS.getId()));
        TimeZero=SLASH_ARTS.register("time_zero", () -> new SlashArts((e) ->
                AKcomboRegsitry.TimeZeroS.getId()));
        TheWrathofIndra=SLASH_ARTS.register("the_wrath_of_indra", () -> new SlashArts((e) ->
                AKcomboRegsitry.TheWrathofIndraS.getId()));
        WindyEyes=SLASH_ARTS.register("windy_eyes", () -> new SlashArts((e) ->
                AKcomboRegsitry.WindyEyesS.getId()));
        ShivaDance=SLASH_ARTS.register("shiva_dance", () -> new SlashArts((e) ->
                AKcomboRegsitry.ShivaDanceS.getId()));
        LiulifanCity=SLASH_ARTS.register("liulifan_city", () -> new SlashArts((e) ->
                AKcomboRegsitry.LiulifanCityS.getId()));
        TheEmperorofIce=SLASH_ARTS.register("the_emperor_of_ice", () -> new SlashArts((e) ->
                AKcomboRegsitry.TheEmperorofIceS.getId()));
        ruins=SLASH_ARTS.register("ruins", () -> new SlashArts((e) ->
                AKcomboRegsitry.ruinsS.getId()));
        Dragon=SLASH_ARTS.register("dragon", () -> new SlashArts((e) ->
                AKcomboRegsitry.DragonS.getId()));
    }
}
