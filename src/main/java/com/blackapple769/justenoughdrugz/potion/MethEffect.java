package com.blackapple769.justenoughdrugz.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.antlr.v4.runtime.misc.NotNull;

public class MethEffect extends MobEffect {
    private int duration;
    public MethEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        if (duration > 100) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, duration - 100, amplifier, false, false));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, duration - 100, amplifier, false, false));
        }
        if (duration <= 100) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, duration, amplifier, false, false));
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
