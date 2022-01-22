package com.blackapple769.justenoughdrugz.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class Food {

    public static final FoodProperties SHROOMS = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.CONFUSION, 500, 5), 1F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 4), 1F).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 500, 2), 1F).build();
    public static final FoodProperties WEED_EDIBLE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.HUNGER, 400, 0), 1F).effect(new MobEffectInstance(MobEffects.CONFUSION, 400, 0), 1F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0), 1F).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 0), 1F).build();
}
