package net.bowlofsin.sgear_ascended.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.bowlofsin.sgear_ascended.SGearAscendedMod;
import net.bowlofsin.sgear_ascended.entity.custom.BullEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BullRenderer extends MobRenderer<BullEntity, BullModel<BullEntity>> {

    public BullRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BullModel<>(pContext.bakeLayer(ModModelLayers.BULL_LAYER)), 1.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(BullEntity bullEntity) {
        return ResourceLocation.fromNamespaceAndPath(SGearAscendedMod.MODID, "textures/entity/bull_texture.png");
    }

    @Override
    public void render(BullEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(1, 1, 1);
        }
        else {
            pPoseStack.scale(2.5f, 2.5f, 2.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
