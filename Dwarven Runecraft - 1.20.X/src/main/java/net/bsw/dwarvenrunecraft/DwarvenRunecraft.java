package net.bsw.dwarvenrunecraft;

import com.mojang.logging.LogUtils;
import net.bsw.dwarvenrunecraft.block.ModBlocks;
import net.bsw.dwarvenrunecraft.effect.ModEffects;
import net.bsw.dwarvenrunecraft.entities.ModEntityTypes;
import net.bsw.dwarvenrunecraft.entities.client.renderer.DwarfRenderer;
import net.bsw.dwarvenrunecraft.entities.custom.DwarfEntity;
import net.bsw.dwarvenrunecraft.fluid.ModFluidTypes;
import net.bsw.dwarvenrunecraft.fluid.ModFluids;
import net.bsw.dwarvenrunecraft.item.ModCreativeModeTabs;
import net.bsw.dwarvenrunecraft.item.ModItems;
import net.bsw.dwarvenrunecraft.loot.ModLootModifiers;
import net.bsw.dwarvenrunecraft.potion.ModPotions;
import net.bsw.dwarvenrunecraft.util.ImprovedBrewingRecipe;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DwarvenRunecraft.MOD_ID)
public class DwarvenRunecraft {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "dwarvenrunecraft";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public DwarvenRunecraft() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        ModEntityTypes.register(modEventBus);


        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);



        modEventBus.addListener(this::commonSetup);



        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::commonSetup);
    }


    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

            BrewingRecipeRegistry.addRecipe(new ImprovedBrewingRecipe(Potions.THICK, ModItems.CELESTITE_SHARD.get(), ModPotions.COLOURED_GLOWING.get()));


        });


    }

    // Add the example block item to the ingredients blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            EntityRenderers.register(ModEntityTypes.DWARF.get(), DwarfRenderer::new);




            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_UNSTABLE_CRYSTAL_ICHOR.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_UNSTABLE_CRYSTAL_ICHOR.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_PURE_LAGUZ.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_PURE_LAGUZ.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_EITR.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_EITR.get(), RenderType.translucent());

        }

    }

}
