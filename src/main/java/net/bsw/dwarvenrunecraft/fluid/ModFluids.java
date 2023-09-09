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

    public static final RegistryObject<FlowingFluid> SOURCE_CRYSTAL_ICHOR = FLUIDS.register("crystal_ichor_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.CRYSTAL_ICHOR_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_CRSTAL_ICHOR = FLUIDS.register("flowing_crystal_ichor",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.CRYSTAL_ICHOR_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties CRYSTAL_ICHOR_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.CRYSTAL_ICHOR_FLUID_TYPE, SOURCE_CRYSTAL_ICHOR,FLOWING_CRSTAL_ICHOR)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.CRYSTAL_ICHOR_BLOCK).bucket(ModItems.CRYSTAL_ICHOR_BUCKET);



    public static void register(IEventBus eventBus){
        FLUIDS.register(eventBus);
    }

}
