package net.bsw.dwarvenrunecraft.fluid;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

/*
    FLUID PROPERTIES CHEAT SHEET

    Density: arbitrary value. -ve indicating lighter than air
    Empty: 0
    Water: 1000
    Lava: 3000
    Default: 1000

    Temperature: arbitrary value. no -ve values
    Empty: 0
    Water: 300
    Lava: 1300
    Default: 300

    Viscosity: resistance of movement through fluid
    Empty: 0
    Water: 1000
    Lava: 6000
    Default: 1000

    Motion Scale: a scalar of entities acceleration in the fluid
    Empty: No scaling (1)
    Water: Scaled by 0.014
    Lava: Scaled by 0.007 in Nether dimensions, otherwise 0.0023
    Default: Scaled by 0.014

    Pushing Entity: whether entities are pushed by flowing fluid

    Swimming: if entities can swim in fluid
    Empty: False
    Water: True
    Lava: False
    Default: True

    Drowning: if entity can drown in fluid
    Empty: False
    Water: True
    Lava: False
    Default: True

    Fall Distance Modifier: how much should the fall distance be decreased every tick
    Empty: No scaling (1)
    Water: Scaled by 0
    Lava: Scaled by 0.5
    Default: Scaled by 0.5

    Extinguishing: if the entity can be extinguished by the fluid. (player on fire put out when in water)
    Default: False

    */

public class ModFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPE =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, DwarvenRunecraft.MOD_ID);


    //Unstable Crystal Ichor
    public static final ResourceLocation UNSTABLE_CRYSTAL_ICHOR_STILL_RL = new ResourceLocation(DwarvenRunecraft.MOD_ID, "block/unstable_crystal_ichor_still");
    public static final ResourceLocation UNSTABLE_CRYSTAL_ICHOR_FLOW_RL = new ResourceLocation(DwarvenRunecraft.MOD_ID, "block/unstable_crystal_ichor_flow");
    public static final ResourceLocation UNSTABLE_CRYSTAL_ICHOR_OVERLAY_RL = new ResourceLocation(DwarvenRunecraft.MOD_ID, "misc/in_unstable_crystal_ichor");

    public static final RegistryObject<FluidType> UNSTABLE_CRYSTAL_ICHOR_FLUID_TYPE = register("crystal_ichor_fluid",
            UNSTABLE_CRYSTAL_ICHOR_STILL_RL, UNSTABLE_CRYSTAL_ICHOR_FLOW_RL, UNSTABLE_CRYSTAL_ICHOR_OVERLAY_RL,
            0xC0FFFFFF, new Vector3f(89f / 255f, 17f / 255f, 134f / 255f),
            FluidType.Properties.create().canConvertToSource(false).canDrown(false).canExtinguish(true).canHydrate(false).
                    canPushEntity(true).canSwim(true).density(1000).fallDistanceModifier(0).lightLevel(2).
                    motionScale(-0.014).supportsBoating(true).temperature(500).viscosity(1500));



    //Pure Laguz
    public static final ResourceLocation PURE_LAGUZ_STILL_RL = new ResourceLocation(DwarvenRunecraft.MOD_ID,"block/pure_laguz_still");
    public static final ResourceLocation PURE_LAGUZ_FLOW_RL = new ResourceLocation(DwarvenRunecraft.MOD_ID,"block/pure_laguz_flow");
    public static final ResourceLocation PURE_LAGUZ_OVERLAY_RL = new ResourceLocation(DwarvenRunecraft.MOD_ID, "misc/in_pure_laguz_ichor");

    public static final RegistryObject<FluidType> PURE_LAGUZ_FLUID_TYPE = register("pure_laguz_fluid",
            PURE_LAGUZ_STILL_RL, PURE_LAGUZ_FLOW_RL, PURE_LAGUZ_OVERLAY_RL,
            0xF07FCDFF, new Vector3f(127f / 255f, 205f / 255f, 255f / 255f),
            FluidType.Properties.create().canConvertToSource(true).canDrown(false).canExtinguish(true).canHydrate(true).
                    canPushEntity(true).canSwim(true).density(1000).fallDistanceModifier(0).lightLevel(10).
                    motionScale(0.014).supportsBoating(true).temperature(300).viscosity(1000));


    //Eitr
    public static final ResourceLocation EITR_STILL_RL = new ResourceLocation(DwarvenRunecraft.MOD_ID,"block/eitr_still");
    public static final ResourceLocation EITR_FLOW_RL = new ResourceLocation(DwarvenRunecraft.MOD_ID, "block/eitr_flow");
    public static final ResourceLocation EITR_OVERLAY_RL = new ResourceLocation(DwarvenRunecraft.MOD_ID, "misc/in_eitr");

    public static final RegistryObject<FluidType> EITR_FLUID_TYPE = register("eitr_fluid",
            EITR_STILL_RL, EITR_FLOW_RL, EITR_OVERLAY_RL,
            0xF0127C24, new Vector3f(18f / 255f, 124f / 255f, 36f / 255f),
            FluidType.Properties.create().canConvertToSource(false).canDrown(true).canExtinguish(false).canHydrate(false).
                    canPushEntity(true).canSwim(true).density(2000).fallDistanceModifier(0.5f).lightLevel(0).
                    motionScale(0.010).supportsBoating(true).temperature(400).viscosity(3000));






    private static RegistryObject<FluidType> register(String name, ResourceLocation stillrl, ResourceLocation flowrl, ResourceLocation overlayrl, int tint, Vector3f fog, FluidType.Properties properties){
        return FLUID_TYPE.register(name, () -> new BaseFluidType(stillrl, flowrl, overlayrl, tint, fog, properties));
    }

    public static void register(IEventBus eventBus){
        FLUID_TYPE.register(eventBus);
    }
}

