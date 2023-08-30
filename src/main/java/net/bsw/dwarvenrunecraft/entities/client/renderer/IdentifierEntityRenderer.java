package net.bsw.dwarvenrunecraft.entities.client.renderer;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.entities.client.models.IdentifierEntityModel;
import net.bsw.dwarvenrunecraft.entities.custom.IdentifierEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class IdentifierEntityRenderer extends MobRenderer<IdentifierEntity, IdentifierEntityModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DwarvenRunecraft.MOD_ID, "entity/identifier.png");

    public IdentifierEntityRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new IdentifierEntityModel(pContext.bakeLayer(IdentifierEntityModel.LAYER_LOCATION)),0);
    }

    @Override
    public ResourceLocation getTextureLocation(IdentifierEntity pEntity) {
        return TEXTURE;
    }
}
