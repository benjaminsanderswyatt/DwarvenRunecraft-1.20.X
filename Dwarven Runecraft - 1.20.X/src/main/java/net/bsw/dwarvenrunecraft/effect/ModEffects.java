package net.bsw.dwarvenrunecraft.effect;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.annotation.Target;

public class ModEffects{
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DwarvenRunecraft.MOD_ID);



    //Add effects here

    public static final RegistryObject<MobEffect> COLOURED_GLOWING = MOB_EFFECTS.register("coloured_glowing",
            () -> new ColouredGlowingEffect(MobEffectCategory.NEUTRAL, 0x000000));






    public static void register (IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
