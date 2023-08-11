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

        blockWithItem(ModBlocks.BUDDING_CELESTITE);

        /*
        directionalBlock(ModBlocks.CELESTITE_CLUSTER.get(), models().cross(
                getName(ModBlocks.CELESTITE_CLUSTER),
                getBlockRegLocation(ModBlocks.CELESTITE_CLUSTER))
                .renderType("cutout"));
        */


        blockWithItem(ModBlocks.SMALL_CELESTITE_BUD);
        blockWithItem(ModBlocks.MEDIUM_CELESTITE_BUD);
        blockWithItem(ModBlocks.LARGE_CELESTITE_BUD);
        blockWithItem(ModBlocks.CELESTITE_CLUSTER);


    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }


}
