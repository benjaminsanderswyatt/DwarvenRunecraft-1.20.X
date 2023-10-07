package net.bsw.dwarvenrunecraft;

import com.mojang.logging.LogUtils;
import net.bsw.dwarvenrunecraft.block.ModBlocks;
import net.bsw.dwarvenrunecraft.effect.ModEffects;
import net.bsw.dwarvenrunecraft.entities.ModEntityTypes;
import net.bsw.dwarvenrunecraft.entities.client.models.DwarfEntityModel;
import net.bsw.dwarvenrunecraft.entities.client.models.IdentifierEntityModel;
import net.bsw.dwarvenrunecraft.entities.client.renderer.DwarfEntityRenderer;
import net.bsw.dwarvenrunecraft.entities.client.renderer.IdentifierEntityRenderer;
import net.bsw.dwarvenrunecraft.entities.custom.DwarfEntity;
import net.bsw.dwarvenrunecraft.entities.custom.IdentifierEntity;
import net.bsw.dwarvenrunecraft.fluid.ModFluidTypes;
import net.bsw.dwarvenrunecraft.fluid.ModFluids;
import net.bsw.dwarvenrunecraft.item.ModCreativeModeTabs;
import net.bsw.dwarvenrunecraft.item.ModItems;
import net.bsw.dwarvenrunecraft.loot.ModLootModifiers;
import net.bsw.dwarvenrunecraft.potion.ModPotions;
import net.bsw.dwarvenrunecraft.util.ImprovedBrewingRecipe;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
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
        public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
            event.registerEntityRenderer(ModEntityTypes.DWARF.get(), DwarfEntityRenderer::new);
            event.registerEntityRenderer(ModEntityTypes.IDENTIFIER.get(), IdentifierEntityRenderer::new);
        }

        @SubscribeEvent
        public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event){

            event.registerLayerDefinition(DwarfEntityModel.LAYER_LOCATION, DwarfEntityModel::createBodyLayer);
            event.registerLayerDefinition(IdentifierEntityModel.LAYER_LOCATION, IdentifierEntityModel::createBodyLayer);


        }


        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_UNSTABLE_CRYSTAL_ICHOR.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_UNSTABLE_CRYSTAL_ICHOR.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_PURE_LAGUZ.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_PURE_LAGUZ.get(), RenderType.translucent());

            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_EITR.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_EITR.get(), RenderType.translucent());

        }

    }




    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class CommonModEvents {
        @SubscribeEvent
        public static void entityAttributes(EntityAttributeCreationEvent event){
            event.put(ModEntityTypes.DWARF.get(), DwarfEntity.setAttributes());
            event.put(ModEntityTypes.IDENTIFIER.get(), IdentifierEntity.setAttributes());
        }

    }

}
