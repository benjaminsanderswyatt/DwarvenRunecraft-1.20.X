package net.bsw.dwarvenrunecraft.datagen;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.block.ModBlocks;
import net.bsw.dwarvenrunecraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DwarvenRunecraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        simpleItem(ModItems.ORE_SCANNER);

        simpleItem(ModItems.CELESTITE_SHARD);


        simpleItem(ModItems.TRANSFORMATION_DUST);


        simpleItem(ModItems.ITEM_MAGNET);

        simpleItem(ModItems.SPECTRE_GLASS);

        simpleItem(ModItems.BEER);

        //Fluid Bucket
        simpleItem(ModItems.CRYSTAL_ICHOR_BUCKET);





        //Blocks with special item models

        block2DItem(ModBlocks.SMALL_CELESTITE_BUD);
        block2DItem(ModBlocks.MEDIUM_CELESTITE_BUD);
        block2DItem(ModBlocks.LARGE_CELESTITE_BUD);
        block2DItem(ModBlocks.CELESTITE_CLUSTER);




        evenSimplerBlockItem(ModBlocks.CALCITE_STAIRS);
        evenSimplerBlockItem(ModBlocks.CALCITE_SLAB);
        wallItem(ModBlocks.CALCITE_WALL, Blocks.CALCITE);

        evenSimplerBlockItem(ModBlocks.POLISHED_CALCITE_STAIRS);
        evenSimplerBlockItem(ModBlocks.POLISHED_CALCITE_SLAB);
        wallItem(ModBlocks.POLISHED_CALCITE_WALL, ModBlocks.POLISHED_CALCITE.get());

        evenSimplerBlockItem(ModBlocks.DARK_CALCITE_STAIRS);
        evenSimplerBlockItem(ModBlocks.DARK_CALCITE_SLAB);
        wallItem(ModBlocks.DARK_CALCITE_WALL, ModBlocks.DARK_CALCITE.get());

        evenSimplerBlockItem(ModBlocks.POLISHED_DARK_CALCITE_STAIRS);
        evenSimplerBlockItem(ModBlocks.POLISHED_DARK_CALCITE_SLAB);
        wallItem(ModBlocks.POLISHED_DARK_CALCITE_WALL, ModBlocks.POLISHED_DARK_CALCITE.get());


    }

    public void wallItem(RegistryObject<Block> block, Block baseBlock) {
        //the 2nd substring is needed to find out the origin of the block either minecraft or dwarvenrunecraft
        int first = baseBlock.getDescriptionId().indexOf('.');
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(baseBlock.getDescriptionId().substring(first + 1, baseBlock.getDescriptionId().indexOf(".", first+1)),"block/" + ForgeRegistries.BLOCKS.getKey(baseBlock).getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(DwarvenRunecraft.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void block2DItem(Supplier<? extends Block> block){
        getBuilder(block.get().builtInRegistryHolder().key().location().getPath()).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", "block/" + block.get().builtInRegistryHolder().key().location().getPath());
    //builtInRegistryHolder is Deprecated but vanilla Minecraft uses deprecated code consistently so just ignore the warning.
    }



    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DwarvenRunecraft.MOD_ID,"item/" + item.getId().getPath()));
    }


}
