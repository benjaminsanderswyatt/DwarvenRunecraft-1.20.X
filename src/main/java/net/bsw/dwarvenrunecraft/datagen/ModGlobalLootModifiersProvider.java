package net.bsw.dwarvenrunecraft.datagen;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.item.ModItems;
import net.bsw.dwarvenrunecraft.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {

    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, DwarvenRunecraft.MOD_ID);
    }

    @Override
    protected void start() {

        //TRANSFORMATION DUST
        add("transformation_dust_from_witch", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("entities/witch")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()},
                ModItems.TRANSFORMATION_DUST.get()));
        add("transformation_dust_from_igloo_chest", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/igloo_chest")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()},
                ModItems.TRANSFORMATION_DUST.get()));


        //BEER
        add("beer_from_village_toolsmith", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_toolsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()},
                ModItems.BEER.get()));
        add("beer_from_village_weaponsmith", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_weaponsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.3f).build()},
                ModItems.BEER.get()));
        add("beer_from_shipwreck_supply", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/shipwreck_supply")).build(),
                LootItemRandomChanceCondition.randomChance(0.8f).build()},
                ModItems.BEER.get()));
        add("beer_from_hero_of_the_village", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("gameplay/hero_of_the_village/toolsmith_gift")).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build()},
                ModItems.BEER.get()));
        add("beer_from_hero_of_the_village", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("gameplay/hero_of_the_village/weaponsmith_gift")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()},
                ModItems.BEER.get()));


        //ITEM MAGNET
        add("item_magnet_from_simple_dungeon", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build(),
                LootItemRandomChanceCondition.randomChance(0.2f).build()},
                ModItems.ITEM_MAGNET.get()));
        add("item_magnet_from_pillager_outpost", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/pillager_outpost")).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build()},
                ModItems.ITEM_MAGNET.get()));



        //ORE SCANNER
        add("ore_scanner_from_buried_treasure", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/buried_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.05f).build()},
                ModItems.ORE_SCANNER.get()));
        add("ore_scanner_from_shipwreck_treasure", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.01f).build()},
                ModItems.ORE_SCANNER.get()));
        add("ore_scanner_from_ancient_city", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/ancient_city")).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build()},
                ModItems.ORE_SCANNER.get()));



        //CELESTITE SHARDS
        add("celestite_shard_from_village_temple", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_temple")).build(),
                LootItemRandomChanceCondition.randomChance(0.8f).build()},
                ModItems.CELESTITE_SHARD.get()));




    }
}
