package cn.star.ak.cilent;

import cn.star.ak.cilent.render.CrazyWindyEyesRender;
import cn.star.ak.cilent.render.*;
import cn.star.ak.regsitry.AKEntiteRegristrys;
import mods.flammpfeil.slashblade.client.renderer.entity.DriveRenderer;
import mods.flammpfeil.slashblade.client.renderer.entity.SlashEffectRenderer;
import mods.flammpfeil.slashblade.client.renderer.entity.SummonedSwordRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static cn.star.ak.AlchemyKingdom.MODID;

//客户端渲染
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT, modid = MODID)
public class AKClient {


    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(AKEntiteRegristrys.FireDrive, FireDriveRender::new);
        event.registerEntityRenderer(AKEntiteRegristrys.HealSlash, SlashEffectRenderer::new);
        event.registerEntityRenderer(AKEntiteRegristrys.Kungunier, KungunierRender::new);
        event.registerEntityRenderer(AKEntiteRegristrys.cwee, CrazyWindyEyesRender::new);
        event.registerEntityRenderer(AKEntiteRegristrys.SD, NoneMoonRenderer::new);
        event.registerEntityRenderer(AKEntiteRegristrys.LC, CrazyWindyEyesRender::new);
        event.registerEntityRenderer(AKEntiteRegristrys.DragonS, DragonRender::new);
        event.registerEntityRenderer(AKEntiteRegristrys.EntitySwordS, DragonRender::new);
        event.registerEntityRenderer(AKEntiteRegristrys.TheEmperorofIceS, CrazyWindyEyesRender::new);
        event.registerEntityRenderer(AKEntiteRegristrys.EntityZenith12thsword, SummonedSwordRenderer::new);
    }
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BlackSlabe.LAYER_LOCATION, BlackSlabe::createBodyLayer);
    }

}
