package com.blackapple769.justenoughdrugz.potion;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.antlr.v4.runtime.misc.NotNull;

public class DmtEffect extends MobEffect {
    private int duration;


    public DmtEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, duration - 100, amplifier+10, false, false));
        livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, duration - 100, 0, false, false));
        livingEntity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, duration - 100, 0, false, false));
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        this.duration = duration;
        return true;
    }
}
