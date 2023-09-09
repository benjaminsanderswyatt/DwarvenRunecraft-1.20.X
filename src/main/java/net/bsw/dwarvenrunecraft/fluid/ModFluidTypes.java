package net.bsw.dwarvenrunecraft.fluid;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation CRYSTAL_ICHOR_STILL_RL = new ResourceLocation(DwarvenRunecraft.MOD_ID, "block/animationtesting_still");
    public static final ResourceLocation CRYSTAL_ICHOR_FLOW_RL = new ResourceLocation(DwarvenRunecraft.MOD_ID, "block/animationtesting_flow");
    public static final ResourceLocation CRYSTAL_ICHOR_OVERLAY_RL = new ResourceLocation(DwarvenRunecraft.MOD_ID, "misc/in_crystal_ichor");

    public static final DeferredRegister<FluidType> FLUID_TYPE =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, DwarvenRunecraft.MOD_ID);


    public static final RegistryObject<FluidType> CRYSTAL_ICHOR_FLUID_TYPE = register("crystal_ichor_fluid",
            FluidType.Properties.create().lightLevel(3).canPushEntity(true).viscosity(5));



    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties){
        return FLUID_TYPE.register(name, () -> new BaseFluidType(CRYSTAL_ICHOR_STILL_RL, CRYSTAL_ICHOR_FLOW_RL, CRYSTAL_ICHOR_OVERLAY_RL,
                0xA1E038D0, new Vector3f(224f / 255f, 56f / 255f, 208f / 255f), properties));
    }

    public static void register(IEventBus eventBus){
        FLUID_TYPE.register(eventBus);
    }
}
