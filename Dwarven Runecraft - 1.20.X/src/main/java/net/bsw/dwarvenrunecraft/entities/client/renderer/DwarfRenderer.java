package net.bsw.dwarvenrunecraft.entities.client.renderer;


import com.mojang.blaze3d.vertex.PoseStack;
import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.entities.client.models.DwarfModel;
import net.bsw.dwarvenrunecraft.entities.client.ModModelLayers;
import net.bsw.dwarvenrunecraft.entities.custom.DwarfEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DwarfRenderer extends MobRenderer<DwarfEntity, DwarfModel<DwarfEntity>> {

	public DwarfRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new DwarfModel<>(pContext.bakeLayer(ModModelLayers.DWARF_LAYER)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(DwarfEntity pEntity) {
		return new ResourceLocation(DwarvenRunecraft.MOD_ID, "textures/entity/dwarf.png");
	}

	@Override
	public void render(DwarfEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {

		if(pEntity.isBaby()) {
			pMatrixStack.scale(0.5f, 0.5f, 0.5f);
		}


		super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
	}
}