package net.bsw.dwarvenrunecraft.events;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.entities.client.ModModelLayers;
import net.bsw.dwarvenrunecraft.entities.client.models.DwarfModel;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DwarvenRunecraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientModEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.DWARF_LAYER, DwarfModel::createBodyLayer);
    }


}
