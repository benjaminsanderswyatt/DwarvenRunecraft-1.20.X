package net.bsw.dwarvenrunecraft.entities.client.renderer;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.entities.client.models.DwarfEntityModel;
import net.bsw.dwarvenrunecraft.entities.custom.DwarfEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class DwarfEntityRenderer extends MobRenderer<DwarfEntity, DwarfEntityModel<DwarfEntity>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(DwarvenRunecraft.MOD_ID, "textures/entity/dwarf.png");

    public DwarfEntityRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DwarfEntityModel(pContext.bakeLayer(DwarfEntityModel.LAYER_LOCATION)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(DwarfEntity pEntity) {
        return TEXTURE;
        /*
        if(pEntity.isInPowderSnow){
            return texture0;
        }
        return texture1;
        */
    }
}
