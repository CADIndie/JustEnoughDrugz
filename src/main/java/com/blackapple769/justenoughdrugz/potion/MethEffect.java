package com.blackapple769.justenoughdrugz.potion;

import net.minecraft.world.effect.*;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class MethEffect extends MobEffect {
	private int duration;

	public MethEffect(MobEffectCategory p_19451_, int p_19452_) {
		super(p_19451_, p_19452_);
	}

	@Override
	public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
		if (this.duration > 100) {
			livingEntity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, this.duration - 100, amplifier, false, false));
			livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, this.duration - 100, amplifier, false, false));
		}
		if (this.duration <= 100)
			livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, this.duration, amplifier, false, false));
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		this.duration = duration;
		return true;
	}
}