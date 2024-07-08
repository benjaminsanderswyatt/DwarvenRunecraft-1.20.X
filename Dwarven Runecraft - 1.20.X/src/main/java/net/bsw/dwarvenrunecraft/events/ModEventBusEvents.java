package net.bsw.dwarvenrunecraft.events;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.entities.ModEntityTypes;
import net.bsw.dwarvenrunecraft.entities.custom.DwarfEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DwarvenRunecraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntityTypes.DWARF.get(), DwarfEntity.setAttributes().build());
    }


}
