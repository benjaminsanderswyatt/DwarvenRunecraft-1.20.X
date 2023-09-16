package net.bsw.dwarvenrunecraft.potion;

import net.bsw.dwarvenrunecraft.DwarvenRunecraft;
import net.bsw.dwarvenrunecraft.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(ForgeRegistries.POTIONS, DwarvenRunecraft.MOD_ID);

    //Add potions here

    public static final RegistryObject<Potion> COLOURED_GLOWING = POTIONS.register("coloured_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.COLOURED_GLOWING.get(), 180*20, 0)));


    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
