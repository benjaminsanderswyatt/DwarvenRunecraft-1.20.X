package net.bsw.dwarvenrunecraft.fluid;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.block.ModBlocks;
import net.bsw.dwarvenrunecraft.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, DwarvenRunecraft.MOD_ID);


    //Unstable Crystal Ichor
    public static final RegistryObject<FlowingFluid> SOURCE_UNSTABLE_CRYSTAL_ICHOR = FLUIDS.register("unstable_crystal_ichor_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.UNSTABLE_CRYSTAL_ICHOR_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_UNSTABLE_CRYSTAL_ICHOR = FLUIDS.register("flowing_unstable_crystal_ichor",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.UNSTABLE_CRYSTAL_ICHOR_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties UNSTABLE_CRYSTAL_ICHOR_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.UNSTABLE_CRYSTAL_ICHOR_FLUID_TYPE, SOURCE_UNSTABLE_CRYSTAL_ICHOR, FLOWING_UNSTABLE_CRYSTAL_ICHOR)
            .block(ModBlocks.UNSTABLE_CRYSTAL_ICHOR_BLOCK).bucket(ModItems.UNSTABLE_CRYSTAL_ICHOR_BUCKET)
            .slopeFindDistance(4).explosionResistance(100).levelDecreasePerBlock(2);


    //Pure Laguz
    public static final RegistryObject<FlowingFluid> SOURCE_PURE_LAGUZ = FLUIDS.register("pure_laguz_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.PURE_LAGUZ_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_PURE_LAGUZ = FLUIDS.register("flowing_pure_laguz",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.PURE_LAGUZ_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties PURE_LAGUZ_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.PURE_LAGUZ_FLUID_TYPE, SOURCE_PURE_LAGUZ, FLOWING_PURE_LAGUZ)
            .block(ModBlocks.PURE_LAGUZ_BLOCK).bucket(ModItems.PURE_LAGUZ_BUCKET)
            .explosionResistance(100);

    //change tint in regard to biome


    //Eitr (poison in old norse)
    public static final RegistryObject<FlowingFluid> SOURCE_EITR = FLUIDS.register("eitr_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.EITR_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_EITR = FLUIDS.register("flowing_eitr",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.EITR_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties EITR_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.EITR_FLUID_TYPE, SOURCE_EITR, FLOWING_EITR)
            .block(ModBlocks.EITR_BLOCK).bucket(ModItems.EITR_BUCKET)
            .explosionResistance(20);







    public static void register(IEventBus eventBus){
        FLUIDS.register(eventBus);
    }

}
