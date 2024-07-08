package net.bsw.dwarvenrunecraft.datagen.loot;

import net.bsw.dwarvenrunecraft.block.ModBlocks;
import net.bsw.dwarvenrunecraft.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        this.dropSelf(ModBlocks.CELESTITE_BLOCK.get());


        this.dropSelf(ModBlocks.CALCITE_STAIRS.get());
        this.dropSelf(ModBlocks.CALCITE_SLAB.get());
        this.dropSelf(ModBlocks.CALCITE_WALL.get());

        this.dropSelf(ModBlocks.POLISHED_CALCITE.get());
        this.dropSelf(ModBlocks.POLISHED_CALCITE_STAIRS.get());
        this.dropSelf(ModBlocks.POLISHED_CALCITE_SLAB.get());
        this.dropSelf(ModBlocks.POLISHED_CALCITE_WALL.get());

        this.dropSelf(ModBlocks.DARK_CALCITE.get());
        this.dropSelf(ModBlocks.DARK_CALCITE_STAIRS.get());
        this.dropSelf(ModBlocks.DARK_CALCITE_SLAB.get());
        this.dropSelf(ModBlocks.DARK_CALCITE_WALL.get());

        this.dropSelf(ModBlocks.POLISHED_DARK_CALCITE.get());
        this.dropSelf(ModBlocks.POLISHED_DARK_CALCITE_STAIRS.get());
        this.dropSelf(ModBlocks.POLISHED_DARK_CALCITE_SLAB.get());
        this.dropSelf(ModBlocks.POLISHED_DARK_CALCITE_WALL.get());


        this.dropSelf(ModBlocks.GLOWING_GLASS.get());




        this.dropSelf(ModBlocks.LAUNCH_PAD.get());






        this.dropWhenSilkTouch(ModBlocks.SMALL_CELESTITE_BUD.get());
        this.dropWhenSilkTouch(ModBlocks.MEDIUM_CELESTITE_BUD.get());
        this.dropWhenSilkTouch(ModBlocks.LARGE_CELESTITE_BUD.get());
        this.add(ModBlocks.CELESTITE_CLUSTER.get(),
                block -> createSilkTouchDispatchTable(block,
                        LootItem.lootTableItem(ModItems.CELESTITE_SHARD.get())
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                                .when(MatchTool.toolMatches(net.minecraft.advancements.critereon.ItemPredicate.Builder.item()
                                        .of(ItemTags.CLUSTER_MAX_HARVESTABLES)))
                                .otherwise(applyExplosionDecay(block, LootItem.lootTableItem(ModItems.CELESTITE_SHARD.get())
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))))));

    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
