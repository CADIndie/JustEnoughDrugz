package com.blackapple769.justenoughdrugz.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class Food {

    public static final FoodProperties WEED_EDIBLE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.HUNGER, 24000, 0), 1F).effect(new MobEffectInstance(MobEffects.CONFUSION, 24000, 0), 1F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 24000, 0), 1F).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 24000, 0), 1F).build();
}
