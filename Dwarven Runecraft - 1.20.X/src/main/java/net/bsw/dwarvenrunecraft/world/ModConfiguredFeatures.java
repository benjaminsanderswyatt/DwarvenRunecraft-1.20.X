package net.bsw.dwarvenrunecraft.world;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.block.ModBlocks;
import net.bsw.dwarvenrunecraft.item.ModItems;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> CELESTITE_GEODE = registerKey("celestite_geode");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {



        register(context, CELESTITE_GEODE, Feature.GEODE, new GeodeConfiguration(new GeodeBlockSettings(
                BlockStateProvider.simple(Blocks.AIR), //filling
                BlockStateProvider.simple(ModBlocks.CELESTITE_BLOCK.get()), //inner layer
                BlockStateProvider.simple(ModBlocks.BUDDING_CELESTITE.get()), //alt inner layer
                BlockStateProvider.simple(Blocks.CALCITE), //middle layer
                BlockStateProvider.simple(Blocks.SMOOTH_BASALT), //outer layer
                //inner placements
                List.of(ModBlocks.SMALL_CELESTITE_BUD.get().defaultBlockState(),ModBlocks.MEDIUM_CELESTITE_BUD.get().defaultBlockState(), ModBlocks.LARGE_CELESTITE_BUD.get().defaultBlockState(), ModBlocks.CELESTITE_CLUSTER.get().defaultBlockState()),
                BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                new GeodeLayerSettings(1.7D,2.2D,3.2D,4.2D), //filling, inner layer, middle layer, outer layer
                new GeodeCrackSettings(0.95D,2D,2), //crack size, crack point offset, gen crack chance
                0.30D,0.083D, //alt layer chance (Amethyst is 0.35D), potential placements chance
                true, UniformInt.of(4,6), //outer wall distance
                UniformInt.of(3,4), //distribution points
                UniformInt.of(1,2), //point offset
                -16,16,0.05D,1)); //min gen, max gen, noise mult, invalid block threshhold









    }





    private static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(DwarvenRunecraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
