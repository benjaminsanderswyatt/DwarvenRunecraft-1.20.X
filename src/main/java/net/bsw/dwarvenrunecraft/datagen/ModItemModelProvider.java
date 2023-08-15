package net.bsw.dwarvenrunecraft.datagen;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.block.ModBlocks;
import net.bsw.dwarvenrunecraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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





        //Blocks with special item models

        block2DItem(ModBlocks.SMALL_CELESTITE_BUD);
        block2DItem(ModBlocks.MEDIUM_CELESTITE_BUD);
        block2DItem(ModBlocks.LARGE_CELESTITE_BUD);
        block2DItem(ModBlocks.CELESTITE_CLUSTER);

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
