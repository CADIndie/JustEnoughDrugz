package com.blackapple769.justenoughdrugz.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.antlr.v4.runtime.misc.NotNull;

public class EdibleItem extends Item {
    public EdibleItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public @NotNull
    InteractionResultHolder<ItemStack> use(@NotNull Level worldIn, Player playerIn, @NotNull InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);

        if (!playerIn.isCreative()) {
            itemstack.shrink(1);
        }

        playerIn.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 24000, 0, false, true));
        playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 24000, 0, false, true));
        playerIn.addEffect(new MobEffectInstance(MobEffects.LUCK, 24000, 0, false, true));
        playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 24000, 0, false, true));
        playerIn.addEffect(new MobEffectInstance(MobEffects.HUNGER, 24000, 0, false, true));


        return InteractionResultHolder.sidedSuccess(itemstack, worldIn.isClientSide());
    }
}