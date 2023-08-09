package net.bsw.dwarvenrunecraft.item;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
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

                        //add blocks to creative tab


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
