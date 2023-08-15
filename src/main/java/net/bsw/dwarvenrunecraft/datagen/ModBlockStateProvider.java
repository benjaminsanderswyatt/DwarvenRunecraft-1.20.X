package net.bsw.dwarvenrunecraft.datagen;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
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


        simpleBlockWithItem(ModBlocks.BUDDING_CELESTITE.get(), cubeAll(ModBlocks.BUDDING_CELESTITE.get()));

        directionalBlock(ModBlocks.SMALL_CELESTITE_BUD.get(), models().cross(getName(ModBlocks.SMALL_CELESTITE_BUD), blockLoc(ModBlocks.SMALL_CELESTITE_BUD)).renderType("cutout"));
        directionalBlock(ModBlocks.MEDIUM_CELESTITE_BUD.get(), models().cross(getName(ModBlocks.MEDIUM_CELESTITE_BUD), blockLoc(ModBlocks.MEDIUM_CELESTITE_BUD)).renderType("cutout"));
        directionalBlock(ModBlocks.LARGE_CELESTITE_BUD.get(), models().cross(getName(ModBlocks.LARGE_CELESTITE_BUD), blockLoc(ModBlocks.LARGE_CELESTITE_BUD)).renderType("cutout"));
        directionalBlock(ModBlocks.CELESTITE_CLUSTER.get(), models().cross(getName(ModBlocks.CELESTITE_CLUSTER), blockLoc(ModBlocks.CELESTITE_CLUSTER)).renderType("cutout"));


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
