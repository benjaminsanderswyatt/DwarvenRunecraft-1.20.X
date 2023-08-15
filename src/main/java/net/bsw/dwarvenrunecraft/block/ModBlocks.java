package net.bsw.dwarvenrunecraft.block;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.block.custom.BuddingCelestiteBlock;
import net.bsw.dwarvenrunecraft.block.custom.CelestiteClusterBlock;
import net.bsw.dwarvenrunecraft.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DwarvenRunecraft.MOD_ID);

    //Add blocks

    public static final RegistryObject<Block> CELESTITE_BLOCK = registerBlock("celestite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)));



    public static final Supplier<Block> BUDDING_CELESTITE = registerBlock("budding_celestite",
            () -> new BuddingCelestiteBlock(BlockBehaviour.Properties.of().randomTicks().strength(3F).sound(SoundType.AMETHYST).noLootTable()));



    public static final Supplier<CelestiteClusterBlock> SMALL_CELESTITE_BUD = registerBlock("small_celestite_bud",
            () -> new CelestiteClusterBlock(3, 4, BlockBehaviour.Properties.copy(Blocks.SMALL_AMETHYST_BUD).sound(SoundType.AMETHYST)));
    public static final Supplier<CelestiteClusterBlock> MEDIUM_CELESTITE_BUD = registerBlock("medium_celestite_bud",
            () -> new CelestiteClusterBlock(4, 3, BlockBehaviour.Properties.copy(Blocks.MEDIUM_AMETHYST_BUD).sound(SoundType.AMETHYST).
                    lightLevel((p_60929_) -> {return 1;} )));
    public static final Supplier<CelestiteClusterBlock> LARGE_CELESTITE_BUD = registerBlock("large_celestite_bud",
            () -> new CelestiteClusterBlock(5, 3, BlockBehaviour.Properties.copy(Blocks.LARGE_AMETHYST_BUD).sound(SoundType.AMETHYST).
                    lightLevel((p_60929_) -> {return 2;} )));
    public static final Supplier<CelestiteClusterBlock> CELESTITE_CLUSTER = registerBlock("celestite_cluster",
            () -> new CelestiteClusterBlock(7, 3,
                    BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER).noOcclusion().sound(SoundType.AMETHYST).strength(3F).
                            lightLevel( (p_60929_) ->{return 8;} )));







    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
