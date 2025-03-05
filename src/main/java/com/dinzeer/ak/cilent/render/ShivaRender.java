package com.dinzeer.ak.cilent.render;

import com.dinzeer.ak.entity.CrazyWindyEyes;
import com.dinzeer.ak.entity.ShivaDance;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.client.renderer.model.BladeModelManager;
import mods.flammpfeil.slashblade.client.renderer.model.obj.WavefrontObject;
import mods.flammpfeil.slashblade.client.renderer.util.BladeRenderState;
import mods.flammpfeil.slashblade.client.renderer.util.MSAutoCloser;
import net.irisshaders.iris.shadows.ShadowRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Graph;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.IForgeGuiGraphics;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Random;

import java.awt.*;

@OnlyIn(Dist.CLIENT)
public class ShivaRender<T extends ShivaDance> extends EntityRenderer<T> {
    // 定义圆周分割精度（越大越圆滑）
    private static final int SEGMENTS = 36;
    // 定义基础颜色（RGBA格式）
    private static final float RED = 1.0F;
    private static final float GREEN = 0.0F;
    private static final float BLUE = 0.0F;
    private static final float ALPHA = 0.5F;

    public ShivaRender(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return textureLocation;
    }
    static private final ResourceLocation modelLocation = new ResourceLocation(SlashBlade.MODID,
            "model/util/slashdim.obj");
    static private final ResourceLocation textureLocation = new ResourceLocation(SlashBlade.MODID,
            "model/util/slashdim.png");
    @Override
    public void render(T entity, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource buffer, int packedLight) {

        // 获取半径参数（假设getLife()返回的是倒计时）
        float radius = 7 - entity.getLife();
        if (radius <= 0) return;

        matrixStackIn
                .mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entity.yRotO, entity.getYRot()) - 90.0F));
        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entity.xRotO, entity.getXRot())));

        WavefrontObject model = BladeModelManager.getInstance().getModel(modelLocation);

        int lifetime = entity.getLife();

        double deathTime = lifetime;
        // double baseAlpha = Math.sin(Math.PI * 0.5 * (Math.min(deathTime, Math.max(0,
        // (lifetime - (entity.ticksExisted) - partialTicks))) / deathTime));
        double baseAlpha = (Math.min(deathTime, Math.max(0, (lifetime - (entity.tickCount) - partialTicks)))
                / deathTime);
        baseAlpha = -Math.pow(baseAlpha - 1, 4.0) + 1.0;

        int seed = new Random().nextInt(360);

        matrixStackIn.mulPose(Axis.YP.rotationDegrees(seed));


        matrixStackIn.scale(radius*0.02f, radius*0.02f, radius*0.02f);

        int color =  Color.red.getRGB();
        Color col = new Color(color);
        float[] hsb = Color.RGBtoHSB(col.getRed(), col.getGreen(), col.getBlue(), null);
        int baseColor = Color.HSBtoRGB(0.5f + hsb[0], hsb[1], 0.2f/* hsb[2] */) & 0xFFFFFF;
        matrixStackIn.scale(radius, radius, radius);
        try (MSAutoCloser msacB = MSAutoCloser.pushMatrix(matrixStackIn)) {

            BladeRenderState.setCol(baseColor | ((0xFF & (int) (0x66 * baseAlpha)) << 24));
            BladeRenderState.renderOverridedReverseLuminous(ItemStack.EMPTY, model, "base",
                    this.getTextureLocation(entity), matrixStackIn, buffer, packedLight);
            float cycleTicks = 15;
            float wave = (entity.tickCount + (cycleTicks / (float) 3 * 1) + partialTicks) % cycleTicks;
            float waveScale = 1.0f + 0.03f * wave;
            matrixStackIn.scale(waveScale, waveScale, waveScale);

            BladeRenderState
                    .setCol(baseColor | ((int) (0x88 * ((cycleTicks - wave) / cycleTicks) * baseAlpha) << 24));
            BladeRenderState.renderOverridedReverseLuminous(ItemStack.EMPTY, model, "base",
                    this.getTextureLocation(entity), matrixStackIn, buffer, packedLight);
            super.render(entity, entityYaw, partialTicks, matrixStackIn, buffer, packedLight);
        }catch (Exception in){

        }
    }

}