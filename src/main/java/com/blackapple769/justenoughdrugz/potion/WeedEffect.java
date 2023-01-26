package com.blackapple769.justenoughdrugz.potion;

import com.blackapple769.justenoughdrugz.item.data.Data;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.antlr.v4.runtime.misc.NotNull;
import java.util.Random;

public class WeedEffect extends MobEffect {
    private int duration;
    public WeedEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }
    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        Data.data.player = livingEntity;
        livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, duration, amplifier, false, false));
        livingEntity.addEffect(new MobEffectInstance(MobEffects.HUNGER, duration, amplifier, false, false));
        livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, duration, amplifier, false, false));
        double min = 0D;
        double max = 1000D;
        int randomNumber1 = (int) ((float) Math.random()*(max-min+1)+min);
        if(randomNumber1 == 500){
            playHallucination(livingEntity);
        }
    }

    public void playHallucination(LivingEntity player){
        SoundEvent[] sounds = new SoundEvent[]{SoundEvents.CREEPER_PRIMED, SoundEvents.ENDERMAN_STARE, SoundEvents.AMBIENT_CAVE};
        Random generator = new Random();
        int randomIndex = generator.nextInt(sounds.length);
        player.playSound(sounds[randomIndex], 0.1f, 1.0f);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        this.duration = duration;
        return true;
    }
}
