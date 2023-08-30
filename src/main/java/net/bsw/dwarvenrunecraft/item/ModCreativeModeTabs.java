package net.bsw.dwarvenrunecraft.item;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DwarvenRunecraft.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DWARVENRUNECRAFT_TAB = CREATIVE_MODE_TABS.register("dwarvenrunecraft_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ORE_SCANNER.get())) //creative mode icon
                    .title(Component.translatable("creativetab.dwarvenrunecraft_tab"))
                    .displayItems((pParameters, pOutput) -> {


                        pOutput.accept(ModItems.ORE_SCANNER.get());

                        pOutput.accept(ModItems.CELESTITE_SHARD.get());
                        pOutput.accept(ModBlocks.CELESTITE_BLOCK.get());
                        pOutput.accept(ModBlocks.BUDDING_CELESTITE.get());

                        pOutput.accept(ModBlocks.SMALL_CELESTITE_BUD.get());
                        pOutput.accept(ModBlocks.MEDIUM_CELESTITE_BUD.get());
                        pOutput.accept(ModBlocks.LARGE_CELESTITE_BUD.get());
                        pOutput.accept(ModBlocks.CELESTITE_CLUSTER.get());

                        pOutput.accept(ModBlocks.CALCITE_STAIRS.get());
                        pOutput.accept(ModBlocks.CALCITE_SLAB.get());
                        pOutput.accept(ModBlocks.CALCITE_WALL.get());

                        pOutput.accept(ModBlocks.POLISHED_CALCITE.get());
                        pOutput.accept(ModBlocks.POLISHED_CALCITE_STAIRS.get());
                        pOutput.accept(ModBlocks.POLISHED_CALCITE_SLAB.get());
                        pOutput.accept(ModBlocks.POLISHED_CALCITE_WALL.get());

                        pOutput.accept(ModBlocks.DARK_CALCITE.get());
                        pOutput.accept(ModBlocks.DARK_CALCITE_STAIRS.get());
                        pOutput.accept(ModBlocks.DARK_CALCITE_SLAB.get());
                        pOutput.accept(ModBlocks.DARK_CALCITE_WALL.get());

                        pOutput.accept(ModBlocks.POLISHED_DARK_CALCITE.get());
                        pOutput.accept(ModBlocks.POLISHED_DARK_CALCITE_STAIRS.get());
                        pOutput.accept(ModBlocks.POLISHED_DARK_CALCITE_SLAB.get());
                        pOutput.accept(ModBlocks.POLISHED_DARK_CALCITE_WALL.get());

                        pOutput.accept(ModBlocks.GLOWING_GLASS.get());

                        pOutput.accept(ModItems.TRANSFORMATION_DUST.get());
                        pOutput.accept(ModItems.ITEM_MAGNET.get());
                        pOutput.accept(ModItems.SPECTRE_GLASS.get());


                        pOutput.accept(ModItems.BEER.get());





                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
