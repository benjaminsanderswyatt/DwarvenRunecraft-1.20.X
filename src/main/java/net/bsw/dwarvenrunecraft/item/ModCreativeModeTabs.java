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
                        //add items to creative tab

                        pOutput.accept(ModItems.ORE_SCANNER.get());

                        pOutput.accept(ModItems.CELESTITE_SHARD.get());

                        //add blocks to creative tab

                        pOutput.accept(ModBlocks.CELESTITE_BLOCK.get());

                        pOutput.accept(ModBlocks.BUDDING_CELESTITE.get());

                        pOutput.accept(ModBlocks.SMALL_CELESTITE_BUD.get());
                        pOutput.accept(ModBlocks.MEDIUM_CELESTITE_BUD.get());
                        pOutput.accept(ModBlocks.LARGE_CELESTITE_BUD.get());
                        pOutput.accept(ModBlocks.CELESTITE_CLUSTER.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
