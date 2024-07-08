package net.bsw.dwarvenrunecraft.datagen;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(PackOutput output) {
        super(output, DwarvenRunecraft.MOD_ID, "en_GB");
    }

    @Override
    protected void addTranslations() {

        //  ITEMS
        add("item.dwarvenrunecraft.ore_scanner", "Ore Scanner");
        add("tooltip.dwarvenrunecraft.ore_scanner.tooltip", "Right click and find stuff");

        add("item.dwarvenrunecraft.item_magnet", "Item Magnet");
        add("tooltip.dwarvenrunecraft.item_magnet.tooltip", "You start to feel very attractive");
        add("tooltip.dwarvenrunecraft.item_magnet.active.tooltip", "Activated");
        add("tooltip.dwarvenrunecraft.item_magnet.deactive.tooltip", "Deactivated");

        add("item.dwarvenrunecraft.spectre_glass", "Spectre Glass");
        add("tooltip.dwarvenrunecraft.spectre_glass.tooltip", "I see your souls");

        add("item.dwarvenrunecraft.beer", "Beer");

        add("item.dwarvenrunecraft.celestite_shard", "Celestite Shard");

        add("item.dwarvenrunecraft.transformation_dust", "Transformation Dust");
        add("tooltip.dwarvenrunecraft.transformation_dust.tooltip", "Right click on stone for some dwarven luck");


        //  BLOCKS
        //this works as well
        //add(ModBlocks.CELESTITE_BLOCK.get(),"Block of Celestite");

        add("block.dwarvenrunecraft.celestite_block", "Block of Celestite");

        add("block.dwarvenrunecraft.calcite_stairs", "Calcite Stairs");
        add("block.dwarvenrunecraft.calcite_slab", "Calcite Slab");
        add("block.dwarvenrunecraft.calcite_wall", "Calcite Wall");

        add("block.dwarvenrunecraft.polished_calcite", "Polished Calcite");
        add("block.dwarvenrunecraft.polished_calcite_stairs", "Polished Calcite Stairs");
        add("block.dwarvenrunecraft.polished_calcite_slab", "Polished Calcite Slab");
        add("block.dwarvenrunecraft.polished_calcite_wall", "Polished Calcite Wall");

        add("block.dwarvenrunecraft.dark_calcite", "Dark Calcite");
        add("block.dwarvenrunecraft.dark_celestite_block", "Block of Dark Calcite");

        add("block.dwarvenrunecraft.dark_calcite_stairs", "Dark Calcite Stairs");
        add("block.dwarvenrunecraft.dark_calcite_slab", "Dark Calcite Slab");
        add("block.dwarvenrunecraft.dark_calcite_wall", "Dark Calcite Wall");

        add("block.dwarvenrunecraft.polished_dark_calcite", "Polished Dark Calcite");
        add("block.dwarvenrunecraft.polished_dark_calcite_stairs", "Polished Dark Calcite Stairs");
        add("block.dwarvenrunecraft.polished_dark_calcite_slab", "Polished Dark Calcite Slab");
        add("block.dwarvenrunecraft.polished_dark_calcite_wall", "Polished Dark Calcite Wall");

        add("block.dwarvenrunecraft.glowing_glass", "Glowing Glass");

        add("block.dwarvenrunecraft.budding_celestite", "Budding Celestite");
        add("block.dwarvenrunecraft.small_celestite_bud", "Small Celestite Bud");
        add("block.dwarvenrunecraft.medium_celestite_bud", "Medium Celestite Bud");
        add("block.dwarvenrunecraft.large_celestite_bud", "Large Celestite Bud");
        add("block.dwarvenrunecraft.celestite_cluster", "Celestite Cluster");


        //  POTIONS
        add("effect.dwarvenrunecraft.coloured_glowing", "Coloured Glowing");
        add("item.minecraft.potion.effect.coloured_potion", "Coloured Glowing Potion");
        add("item.minecraft.splash_potion.effect.coloured_potion", "Splash Potion of Coloured Glowing");
        add("item.minecraft.lingering_potion.effect.coloured_potion", "Lingering Potion of Coloured Glowing");
        add("item.minecraft.tipped_arrow.effect.coloured_potion", "Tipped Colourful Arrow");

        //  FLUIDS
        add("item.dwarvenrunecraft.unstable_crystal_ichor_bucket", "Bucket of Unstable Crystal Ichor");
        add("item.dwarvenrunecraft.pure_laguz_bucket", "Bucket of Pure Laguz");
        add("item.dwarvenrunecraft.eitr_bucket", "Bucket of Eiter");

        //  ENTITY
        add("item.dwarvenrunecraft.dwarf_spawn_egg", "Dwarf Spawn Egg");

        //dwarf
        add("entity.dwarvenrunecraft.dwarf_entity", "Dwarf");
        add("items.dwarvenrunecraft.dwarf_spawn_egg","Spawn Dwarf");


        //"key.category.dwarvenrunecraft.key": "Dwarven Runecraft Mod",
        //"key.dwarvenrunecraft.soul_inventory": "Open Soul Inventory",

        //  CREATIVE TAB
        add("creativetab.dwarvenrunecraft_tab", "Dwarven Runecraft");
    }
}
