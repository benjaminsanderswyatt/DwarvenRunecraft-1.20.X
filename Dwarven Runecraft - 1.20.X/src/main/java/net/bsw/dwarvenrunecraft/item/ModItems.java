package net.bsw.dwarvenrunecraft.item;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.entities.ModEntityTypes;
import net.bsw.dwarvenrunecraft.fluid.ModFluids;
import net.bsw.dwarvenrunecraft.item.custom.*;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
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

    public static final RegistryObject<Item> ITEM_MAGNET = ITEMS.register("item_magnet",
            () -> new ItemMagnetItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SPECTRE_GLASS = ITEMS.register("spectre_glass",
            () -> new SpectreGlassItem(new Item.Properties().stacksTo(1)));



    public static final RegistryObject<Item> BEER = ITEMS.register("beer",
            () -> new Item(new Item.Properties().food(ModFoods.BEER)));




    //Spawn Eggs
    public static final RegistryObject<Item> DWARF_SPAWN_EGG = ITEMS.register("dwarf_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DWARF,0xFFFFFF,0xAE6EAE, new Item.Properties()));


    //Fluid Bucket Items
    public static final RegistryObject<Item> UNSTABLE_CRYSTAL_ICHOR_BUCKET = ITEMS.register("unstable_crystal_ichor_bucket",
            () -> new BucketItem(ModFluids.SOURCE_UNSTABLE_CRYSTAL_ICHOR,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> PURE_LAGUZ_BUCKET = ITEMS.register("pure_laguz_bucket",
            () -> new BucketItem(ModFluids.SOURCE_PURE_LAGUZ,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> EITR_BUCKET = ITEMS.register("eitr_bucket",
            () -> new BucketItem(ModFluids.SOURCE_EITR,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));







    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
