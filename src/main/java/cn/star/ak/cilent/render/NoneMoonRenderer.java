package cn.star.ak.cilent.render;

import cn.star.ak.AlchemyKingdom;
import cn.star.ak.entity.ShivaDance;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;



public class NoneMoonRenderer extends EntityRenderer<ShivaDance> {
	private static final ResourceLocation texture = new ResourceLocation(AlchemyKingdom.MODID, "textures/entity/black.png");
	private final BlackSlabe<ShivaDance> model;

	public NoneMoonRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new BlackSlabe<ShivaDance>(context.bakeLayer(BlackSlabe.LAYER_LOCATION));
	}

	@Override
	public void render(ShivaDance entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		float size = 10- entityIn.getLife()*0.01f;
		size*=2;
		poseStack.scale(size,size,size);
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(ShivaDance entity) {
		return texture;
	}
}
