package net.bsw.dwarvenrunecraft.block;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.block.custom.BuddingCelestiteBlock;
import net.bsw.dwarvenrunecraft.block.custom.CelestiteClusterBlock;
import net.bsw.dwarvenrunecraft.block.custom.LaunchPadBlock;
import net.bsw.dwarvenrunecraft.block.custom.fluid.EitrFluidBlock;
import net.bsw.dwarvenrunecraft.block.custom.fluid.PureLaguzBlock;
import net.bsw.dwarvenrunecraft.fluid.ModFluids;
import net.bsw.dwarvenrunecraft.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
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



    public static final RegistryObject<Block> CALCITE_STAIRS = registerBlock("calcite_stairs",
            () -> new StairBlock(() -> Blocks.CALCITE.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> CALCITE_SLAB = registerBlock("calcite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> CALCITE_WALL = registerBlock("calcite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));

    public static final RegistryObject<Block> POLISHED_CALCITE = registerBlock("polished_calcite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> POLISHED_CALCITE_STAIRS = registerBlock("polished_calcite_stairs",
            () -> new StairBlock(() -> ModBlocks.POLISHED_CALCITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> POLISHED_CALCITE_SLAB = registerBlock("polished_calcite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> POLISHED_CALCITE_WALL = registerBlock("polished_calcite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));

    public static final RegistryObject<Block> DARK_CALCITE = registerBlock("dark_calcite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> DARK_CALCITE_STAIRS = registerBlock("dark_calcite_stairs",
            () -> new StairBlock(() -> ModBlocks.DARK_CALCITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> DARK_CALCITE_SLAB = registerBlock("dark_calcite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> DARK_CALCITE_WALL = registerBlock("dark_calcite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));

    public static final RegistryObject<Block> POLISHED_DARK_CALCITE = registerBlock("polished_dark_calcite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> POLISHED_DARK_CALCITE_STAIRS = registerBlock("polished_dark_calcite_stairs",
            () -> new StairBlock(() -> ModBlocks.POLISHED_DARK_CALCITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> POLISHED_DARK_CALCITE_SLAB = registerBlock("polished_dark_calcite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> POLISHED_DARK_CALCITE_WALL = registerBlock("polished_dark_calcite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));



    public static final RegistryObject<Block> GLOWING_GLASS = registerBlock("glowing_glass",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion().lightLevel((p_60929_) ->{return 15;} )));




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



    public static final RegistryObject<PressurePlateBlock> LAUNCH_PAD = registerBlock("launch_pad",
            () -> new LaunchPadBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)));




    //Fluid blocks
    public static final RegistryObject<LiquidBlock> UNSTABLE_CRYSTAL_ICHOR_BLOCK = BLOCKS.register("crystal_ichor_block",
            () -> new LiquidBlock(ModFluids.SOURCE_UNSTABLE_CRYSTAL_ICHOR, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));

    public static final RegistryObject<LiquidBlock> PURE_LAGUZ_BLOCK = BLOCKS.register("pure_laguz_block",
            () -> new PureLaguzBlock(ModFluids.SOURCE_PURE_LAGUZ.get(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));

    public static final RegistryObject<EitrFluidBlock> EITR_BLOCK = BLOCKS.register("eitr_block",
            () -> new EitrFluidBlock(ModFluids.SOURCE_EITR.get(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));






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
