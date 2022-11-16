package com.blackapple769.justenoughdrugz.potion;

import net.minecraft.world.effect.*;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class DmtEffect extends MobEffect {
	private int duration;

	public DmtEffect(MobEffectCategory effectCategory, int p_19452_) {
		super(effectCategory, p_19452_);
	}

	@Override
	public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
		livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, this.duration - 100, amplifier + 10, false, false));
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		this.duration = duration;
		return true;
	}
}