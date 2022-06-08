package com.blackapple769.justenoughdrugz.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.antlr.v4.runtime.misc.NotNull;

public class MorphineEffect extends MobEffect {

    private int duration;

    public MorphineEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }

    /**
     * Runs once each tick while the effect is active.
     * @param livingEntity the <code>LivingEntity</code> with the effect
     * @param amplifier the effect amplifier
     */
    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        if (duration > 200) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, duration - 200, amplifier, false, false));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, duration - 200, amplifier, false, false));
        }
        if (duration <= 200) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, duration, amplifier, false, false));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, duration, amplifier, false, false));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, amplifier, false, false));
        }
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
