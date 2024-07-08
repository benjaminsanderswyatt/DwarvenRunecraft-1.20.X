package net.bsw.dwarvenrunecraft.datagen;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DwarvenRunecraft.MOD_ID , exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.CELESTITE_BLOCK);


        stairsBlock(((StairBlock) ModBlocks.CALCITE_STAIRS.get()), blockTexture(Blocks.CALCITE));
        slabBlock(((SlabBlock) ModBlocks.CALCITE_SLAB.get()), blockTexture(Blocks.CALCITE), blockTexture(Blocks.CALCITE));
        wallBlock(((WallBlock) ModBlocks.CALCITE_WALL.get()), blockTexture(Blocks.CALCITE));

        blockWithItem(ModBlocks.POLISHED_CALCITE);
        stairsBlock(((StairBlock) ModBlocks.POLISHED_CALCITE_STAIRS.get()), blockTexture(ModBlocks.POLISHED_CALCITE.get()));
        slabBlock(((SlabBlock) ModBlocks.POLISHED_CALCITE_SLAB.get()), blockTexture(ModBlocks.POLISHED_CALCITE.get()), blockTexture(ModBlocks.POLISHED_CALCITE.get()));
        wallBlock(((WallBlock) ModBlocks.POLISHED_CALCITE_WALL.get()), blockTexture(ModBlocks.POLISHED_CALCITE.get()));

        blockWithItem(ModBlocks.DARK_CALCITE);
        stairsBlock(((StairBlock) ModBlocks.DARK_CALCITE_STAIRS.get()), blockTexture(ModBlocks.DARK_CALCITE.get()));
        slabBlock(((SlabBlock) ModBlocks.DARK_CALCITE_SLAB.get()), blockTexture(ModBlocks.DARK_CALCITE.get()), blockTexture(ModBlocks.DARK_CALCITE.get()));
        wallBlock(((WallBlock) ModBlocks.DARK_CALCITE_WALL.get()), blockTexture(ModBlocks.DARK_CALCITE.get()));

        blockWithItem(ModBlocks.POLISHED_DARK_CALCITE);
        stairsBlock(((StairBlock) ModBlocks.POLISHED_DARK_CALCITE_STAIRS.get()), blockTexture(ModBlocks.POLISHED_DARK_CALCITE.get()));
        slabBlock(((SlabBlock) ModBlocks.POLISHED_DARK_CALCITE_SLAB.get()), blockTexture(ModBlocks.POLISHED_DARK_CALCITE.get()), blockTexture(ModBlocks.POLISHED_DARK_CALCITE.get()));
        wallBlock(((WallBlock) ModBlocks.POLISHED_DARK_CALCITE_WALL.get()), blockTexture(ModBlocks.POLISHED_DARK_CALCITE.get()));



        simpleBlockWithItem(ModBlocks.GLOWING_GLASS.get(), models().cubeAll(getName(ModBlocks.GLOWING_GLASS), blockLoc(ModBlocks.GLOWING_GLASS)).renderType("translucent"));

        simpleBlockWithItem(ModBlocks.BUDDING_CELESTITE.get(), cubeAll(ModBlocks.BUDDING_CELESTITE.get()));

        directionalBlock(ModBlocks.SMALL_CELESTITE_BUD.get(), models().cross(getName(ModBlocks.SMALL_CELESTITE_BUD), blockLoc(ModBlocks.SMALL_CELESTITE_BUD)).renderType("cutout"));
        directionalBlock(ModBlocks.MEDIUM_CELESTITE_BUD.get(), models().cross(getName(ModBlocks.MEDIUM_CELESTITE_BUD), blockLoc(ModBlocks.MEDIUM_CELESTITE_BUD)).renderType("cutout"));
        directionalBlock(ModBlocks.LARGE_CELESTITE_BUD.get(), models().cross(getName(ModBlocks.LARGE_CELESTITE_BUD), blockLoc(ModBlocks.LARGE_CELESTITE_BUD)).renderType("cutout"));
        directionalBlock(ModBlocks.CELESTITE_CLUSTER.get(), models().cross(getName(ModBlocks.CELESTITE_CLUSTER), blockLoc(ModBlocks.CELESTITE_CLUSTER)).renderType("cutout"));





        pressurePlateBlock(ModBlocks.LAUNCH_PAD.get(), blockLoc(ModBlocks.CELESTITE_BLOCK));



    }

    public String getName(Supplier<? extends Block> block) {
        return block.get().builtInRegistryHolder().key().location().getPath();
    }
    public ResourceLocation blockLoc(Supplier<? extends Block> block) {
        return new ResourceLocation(DwarvenRunecraft.MOD_ID, "block/" + getName(block));
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }


}
