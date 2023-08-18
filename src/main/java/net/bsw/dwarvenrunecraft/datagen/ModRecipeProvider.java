package net.bsw.dwarvenrunecraft.datagen;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.block.ModBlocks;
import net.bsw.dwarvenrunecraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.lwjgl.system.macosx.MacOSXLibraryDL;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        ///////CRAFTING

        //Celestite Shard -> Celestite Block
        twoByTwoPacker(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CELESTITE_BLOCK.get(), ModItems.CELESTITE_SHARD.get());



        //Calcite -> Calcite Stairs
        stairBuilder(ModBlocks.CALCITE_STAIRS.get(), Ingredient.of(Items.CALCITE)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(pWriter);
        //Calcite -> Calcite Slab
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_SLAB.get(), Ingredient.of(Items.CALCITE)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(pWriter);
        //Calcite -> Calcite Wall
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_WALL.get(), Ingredient.of(Items.CALCITE)).unlockedBy(getHasName(Items.CALCITE), has(Items.CALCITE)).save(pWriter);

        //Calcite -> Polished Calcite
        polished(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE.get(), Items.CALCITE);
        //Polished Calcite -> Polished Calcite Stairs
        stairBuilder(ModBlocks.POLISHED_CALCITE_STAIRS.get(), Ingredient.of(ModBlocks.POLISHED_CALCITE.get())).unlockedBy(getHasName(ModBlocks.POLISHED_CALCITE.get()), has(ModBlocks.POLISHED_CALCITE.get())).save(pWriter);
        //Polished Calcite -> Polished Calcite Slab
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_SLAB.get(), Ingredient.of(ModBlocks.POLISHED_CALCITE.get())).unlockedBy(getHasName(ModBlocks.POLISHED_CALCITE.get()), has(ModBlocks.POLISHED_CALCITE.get())).save(pWriter);
        //Polished Calcite -> Polished Calcite Wall
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_WALL.get(), Ingredient.of(ModBlocks.POLISHED_CALCITE.get())).unlockedBy(getHasName(ModBlocks.POLISHED_CALCITE.get()), has(ModBlocks.POLISHED_CALCITE.get())).save(pWriter);

        //Dark Calcite -> Dark Calcite Stairs
        stairBuilder(ModBlocks.DARK_CALCITE_STAIRS.get(), Ingredient.of(ModBlocks.DARK_CALCITE.get())).unlockedBy(getHasName(ModBlocks.DARK_CALCITE.get()), has(ModBlocks.DARK_CALCITE.get())).save(pWriter);
        //Dark Calcite -> Dark Calcite Slab
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_CALCITE_SLAB.get(), Ingredient.of(ModBlocks.DARK_CALCITE.get())).unlockedBy(getHasName(ModBlocks.DARK_CALCITE.get()), has(ModBlocks.DARK_CALCITE.get())).save(pWriter);
        //Dark Calcite -> Dark Calcite Wall
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_CALCITE_WALL.get(), Ingredient.of(ModBlocks.DARK_CALCITE.get())).unlockedBy(getHasName(ModBlocks.DARK_CALCITE.get()), has(ModBlocks.DARK_CALCITE.get())).save(pWriter);

        //Dark Calcite -> Polished Dark Calcite
        polished(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DARK_CALCITE.get(), ModBlocks.DARK_CALCITE.get());
        //Polished Dark Calcite -> Polished Dark Calcite Stairs
        stairBuilder(ModBlocks.POLISHED_DARK_CALCITE_STAIRS.get(), Ingredient.of(ModBlocks.POLISHED_DARK_CALCITE.get())).unlockedBy(getHasName(ModBlocks.POLISHED_DARK_CALCITE.get()), has(ModBlocks.POLISHED_DARK_CALCITE.get())).save(pWriter);
        //Polished Dark Calcite -> Polished Dark Calcite Slab
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DARK_CALCITE_SLAB.get(), Ingredient.of(ModBlocks.POLISHED_DARK_CALCITE.get())).unlockedBy(getHasName(ModBlocks.POLISHED_DARK_CALCITE.get()), has(ModBlocks.POLISHED_DARK_CALCITE.get())).save(pWriter);
        //Polished Dark Calcite -> Polished Dark Calcite Wall
        wallBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DARK_CALCITE_WALL.get(), Ingredient.of(ModBlocks.POLISHED_DARK_CALCITE.get())).unlockedBy(getHasName(ModBlocks.POLISHED_DARK_CALCITE.get()), has(ModBlocks.POLISHED_DARK_CALCITE.get())).save(pWriter);




        //Glass + 4x Celestite Shard -> Glowing Glass
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLOWING_GLASS.get(), 2)
                .pattern(" C ")
                .pattern("CGC")
                .pattern(" C ")
                .define('C', ModItems.CELESTITE_SHARD.get())
                .define('G', Items.GLASS)
                .unlockedBy(getHasName(ModItems.CELESTITE_SHARD.get()), has(Items.GLASS))
                .save(pWriter);




        ///////STONECUTTING

        //Calcite -> Calcite Stairs
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.CALCITE_STAIRS.get(),
                Items.CALCITE,
                1
        );
        //Calcite -> 2x Calcite Slab
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.CALCITE_SLAB.get(),
                Items.CALCITE,
                2
        );
        //Calcite -> Calcite Wall
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.CALCITE_WALL.get(),
                Items.CALCITE,
                1
        );
        //Calcite -> Polished Calcite
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_CALCITE.get(),
                Items.CALCITE,
                1
        );
        //Calcite -> Polished Calcite Stairs
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_CALCITE_STAIRS.get(),
                Items.CALCITE,
                1
        );
        //Calcite -> 2x Polished Calcite Slab
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_CALCITE_SLAB.get(),
                Items.CALCITE,
                2
        );
        //Calcite -> Polished Calcite Wall
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_CALCITE_WALL.get(),
                Items.CALCITE,
                1
        );


        //Polished Calcite -> Polished Calcite Stairs
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_CALCITE_STAIRS.get(),
                ModBlocks.POLISHED_CALCITE.get(),
                1
        );
        //Polished Calcite -> 2x Polished Calcite Slab
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_CALCITE_SLAB.get(),
                ModBlocks.POLISHED_CALCITE.get(),
                2
        );
        //Polished Calcite -> Polished Calcite Wall
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_CALCITE_WALL.get(),
                ModBlocks.POLISHED_CALCITE.get(),
                1
        );



        //Dark Calcite -> Dark Calcite Stairs
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.DARK_CALCITE_STAIRS.get(),
                ModBlocks.DARK_CALCITE.get(),
                1
        );
        //Calcite -> 2x Calcite Slab
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.DARK_CALCITE_SLAB.get(),
                ModBlocks.DARK_CALCITE.get(),
                2
        );
        //Calcite -> Calcite Wall
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.DARK_CALCITE_WALL.get(),
                ModBlocks.DARK_CALCITE.get(),
                1
        );
        //Calcite -> Polished Calcite
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_DARK_CALCITE.get(),
                ModBlocks.DARK_CALCITE.get(),
                1
        );
        //Calcite -> Polished Calcite Stairs
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_DARK_CALCITE_STAIRS.get(),
                ModBlocks.DARK_CALCITE.get(),
                1
        );
        //Calcite -> 2x Polished Calcite Slab
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_DARK_CALCITE_SLAB.get(),
                ModBlocks.DARK_CALCITE.get(),
                2
        );
        //Calcite -> Polished Calcite Wall
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_DARK_CALCITE_WALL.get(),
                ModBlocks.DARK_CALCITE.get(),
                1
        );


        //Polished Dark Calcite -> Polished Dark Calcite Stairs
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_DARK_CALCITE_STAIRS.get(),
                ModBlocks.POLISHED_DARK_CALCITE.get(),
                1
        );
        //Polished Calcite -> 2x Polished Calcite Slab
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_DARK_CALCITE_SLAB.get(),
                ModBlocks.POLISHED_DARK_CALCITE.get(),
                2
        );
        //Polished Calcite -> Polished Calcite Wall
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.POLISHED_DARK_CALCITE_WALL.get(),
                ModBlocks.POLISHED_DARK_CALCITE.get(),
                1
        );







        ///////SMELTING

        //Calcite -> Dark Calcite
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(Items.CALCITE),
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.DARK_CALCITE.get(),
                        0.1f,
                        100)
                .unlockedBy("has_calcite", has(Items.CALCITE))
                .save(pWriter, "dark_calcite");

        //Polished Calcite -> Polished Dark Calcite
        SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModBlocks.POLISHED_CALCITE.get()),
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.POLISHED_DARK_CALCITE.get(),
                        0.1f,
                        100)
                .unlockedBy("has_polished_calcite", has(ModBlocks.DARK_CALCITE.get()))
                .save(pWriter, "polished_dark_calcite");



    }



}
