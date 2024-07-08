package net.bsw.dwarvenrunecraft.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {



    //20 mc ticks = 1 second
    public static final FoodProperties BEER = new FoodProperties.Builder().alwaysEat()
            .nutrition(-1).saturationMod(4)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 12000, 2),1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 150, 2), 0.05f)
            .build();

}
