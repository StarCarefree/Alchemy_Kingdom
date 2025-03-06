package com.dinzeer.ak.regsitry;

import com.dinzeer.ak.data.AKBuiltInRegsitry;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import mods.flammpfeil.slashblade.slasharts.SlashArts;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.registries.RegistryObject;

import static com.dinzeer.ak.AlchemyKingdom.MODID;
import static com.dinzeer.ak.AlchemyKingdom.REGISTRATE;

public class LangUtil {
    public static void registerAddlang(){
        REGISTRATE.addRawLang(createsalang(AKslashartRegsitry.FireSlash),"FireSlash");
        REGISTRATE.addRawLang(createsalang(AKslashartRegsitry.Immortal),"Immortal");
        REGISTRATE.addRawLang(createsalang(AKslashartRegsitry.BloodsuckingSickle),"BloodsuckingSickle");
        REGISTRATE.addRawLang(createsalang(AKslashartRegsitry.Fate),"fate");
        REGISTRATE.addRawLang(createsalang(AKslashartRegsitry.King),"king");
        REGISTRATE.addRawLang(createsalang(AKslashartRegsitry.KingFire),"king fire");
        REGISTRATE.addRawLang(createsalang(AKslashartRegsitry.TimeZero),"time zero");
        REGISTRATE.addRawLang(createsalang(AKslashartRegsitry.TheWrathofIndra),"The Wrath of Indra");
        REGISTRATE.addRawLang(createsalang(AKslashartRegsitry.WindyEyes),"The eyes of windy");
        REGISTRATE.addRawLang(createsalang(AKslashartRegsitry.ShivaDance),"shiva dance");
        REGISTRATE.addRawLang(createsalang(AKslashartRegsitry.LiulifanCity),"LiulifanCity");
        REGISTRATE.addRawLang(createsalang(AKslashartRegsitry.TheEmperorofIce),"The Emperor of Ice");
        REGISTRATE.addRawLang(createsalang(AKslashartRegsitry.ruins),"ruins");
        REGISTRATE.addRawLang(createsalang(AKslashartRegsitry.Dragon),"Dragon");
        REGISTRATE.addRawLang(createitemlang(AKBuiltInRegsitry.pocket_knife),"pocket knife");
        REGISTRATE.addRawLang(createitemlang(AKBuiltInRegsitry.yataghans),"yataghans");
        REGISTRATE.addRawLang(createitemlang(AKBuiltInRegsitry.cloud),"cloud");
        REGISTRATE.addRawLang(createitemlang(AKBuiltInRegsitry.kungunier),"kungunier");
        REGISTRATE.addRawLang(createitemlang(AKBuiltInRegsitry.dick_wido),"dick wido");
        REGISTRATE.addRawLang(createitemlang(AKBuiltInRegsitry.murasame),"murasame");
        REGISTRATE.addRawLang(createitemlang(AKBuiltInRegsitry.kill_dragon),"kill dragon");
        REGISTRATE.addRawLang(createitemlang(AKBuiltInRegsitry.spider),"spider");
        REGISTRATE.addRawLang(createitemlang(AKBuiltInRegsitry.child),"child");
        REGISTRATE.addRawLang(createitemlang(AKBuiltInRegsitry.rage),"rage");
        REGISTRATE.addRawLang(createitemlang(AKBuiltInRegsitry.arrogant),"arrogant");
        REGISTRATE.addRawLang(createitemlang(AKBuiltInRegsitry.jealous),"jealous");
        REGISTRATE.addRawLang(createitemlang(AKBuiltInRegsitry.lazy),"lazy");
        REGISTRATE.addRawLang(createitemlang(AKBuiltInRegsitry.lust),"lust");
        REGISTRATE.addRawLang(createitemlang(AKBuiltInRegsitry.greedy),"greedy");
        REGISTRATE.addRawLang(createitemlang(AKBuiltInRegsitry.tai_ti),"hunger");

        REGISTRATE.addRawLang("message.ak.talent.b","B!");
        REGISTRATE.addRawLang("message.ak.talent.a","A!");
        REGISTRATE.addRawLang("message.ak.talent.s","S!");
        REGISTRATE.addRawLang("message.ak.talent.up_A","UP A!");
        REGISTRATE.addRawLang("message.ak.talent.up_S","UP S!");
        REGISTRATE.addRawLang("message.ak.talent.up_S+","UP S+!");
        REGISTRATE.addRawLang("itemGroup.ak.ak_items","AK items");
        REGISTRATE.addRawLang("itemGroup.ak.ak_slashblade","AK slashblade");
        REGISTRATE.addRawLang("message.ak.useMixin","You Now Blood Boost");
        REGISTRATE.addRawLang("enchantment.level.0","「cry」");

        REGISTRATE.addRawLang("ak.sword_type.fate","FATE");
        REGISTRATE.addRawLang("ak.sword_type.king","WHITE");
        REGISTRATE.addRawLang("ak.sword_type.sin","sin");

        REGISTRATE.addRawLang("effect.ak.blood_boost","blood boost");
    }
    public static String createitemlang(ResourceKey<SlashBladeDefinition> a){
        return "item."+MODID+"."+a.location().getPath();
    }
    public static String createselang(RegistryObject<SpecialEffect> a){
        return "se."+MODID+"."+a.getId().getPath();
    }
    public static String createsalang(RegistryObject<SlashArts> a){
        return "slash_art."+MODID+"."+a.getId().getPath();
    }
}
