package com.blackapple769.justenoughdrugz.potion;

import com.blackapple769.justenoughdrugz.item.data.Data;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.antlr.v4.runtime.misc.NotNull;

public class CokeEffect extends MobEffect {
    private int duration;
    public CokeEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }
    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        Data.data.player = livingEntity;
        livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 600, amplifier, false, true));
        livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 1+amplifier, false, true));
        livingEntity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 600, 2+amplifier, false, true));
        livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, amplifier, false, true));
        livingEntity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 600, amplifier, false, true));
    }

    /**
     * Check if the duration effect is ticking.
     * @param duration the duration
     * @param amplifier the effect amplifier
     * @return boolean
     */
    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        this.duration = duration;
        return true;
    }
}
