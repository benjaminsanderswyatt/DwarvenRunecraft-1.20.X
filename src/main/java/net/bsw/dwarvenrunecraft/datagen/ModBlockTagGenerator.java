package net.bsw.dwarvenrunecraft.datagen;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DwarvenRunecraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {


        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CELESTITE_BLOCK.get())
                .add(ModBlocks.BUDDING_CELESTITE.get())
                .add(ModBlocks.SMALL_CELESTITE_BUD.get())
                .add(ModBlocks.MEDIUM_CELESTITE_BUD.get())
                .add(ModBlocks.LARGE_CELESTITE_BUD.get())
                .add(ModBlocks.CELESTITE_CLUSTER.get());


        //this.tag(BlockTags.NEEDS_STONE_TOOL)
        //        .add(ModBlocks..get());

        //this.tag(BlockTags.NEEDS_IRON_TOOL)
        //        .add(ModBlocks..get());

        //this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
        //        .add(ModBlocks..get());

        //this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
        //        .add(ModBlocks..get());

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.CALCITE_WALL.get())
                .add(ModBlocks.POLISHED_CALCITE_WALL.get())
                .add(ModBlocks.DARK_CALCITE_WALL.get())
                .add(ModBlocks.POLISHED_DARK_CALCITE_WALL.get());




    }
}
