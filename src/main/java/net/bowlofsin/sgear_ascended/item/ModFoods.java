package net.bowlofsin.sgear_ascended.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;


public class ModFoods {
    public static final FoodProperties RICH_MILK_BUCKET = new FoodProperties.Builder().alwaysEat().nutrition(8).saturationMod(1.6f).effect(new MobEffectInstance(MobEffects.SATURATION, 100, 100), 1).build();
    public static final FoodProperties FERTILEOFRUIT = new FoodProperties.Builder().alwaysEat().nutrition(16).saturationMod(2.6f).build();

}
