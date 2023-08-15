package net.bsw.dwarvenrunecraft.item;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.item.custom.OreScannerItem;
import net.bsw.dwarvenrunecraft.item.custom.TransformationDustItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DwarvenRunecraft.MOD_ID);


    //Add items bellow

    public static final RegistryObject<Item> ORE_SCANNER = ITEMS.register("ore_scanner",
            () -> new OreScannerItem(new Item.Properties()));



    public static final RegistryObject<Item> CELESTITE_SHARD = ITEMS.register("celestite_shard",
            () -> new Item(new Item.Properties()));








    public static final RegistryObject<Item> TRANSFORMATION_DUST = ITEMS.register("transformation_dust",
            () -> new TransformationDustItem(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
