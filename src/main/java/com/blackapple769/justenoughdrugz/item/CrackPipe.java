package com.blackapple769.justenoughdrugz.item;

import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.antlr.v4.runtime.misc.NotNull;

public class CrackPipe extends Item {
    public CrackPipe(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public @NotNull
    InteractionResultHolder<ItemStack> use(@NotNull Level worldIn, Player playerIn, @NotNull InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);

        if(!playerIn.isCreative()){
            itemstack.shrink(1);
            playerIn.addItem(new ItemStack(RegistryHandler.PIPE.get(), 1));
        }

        playerIn.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 300, 2, false, true));
        playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 1, false, true));
        playerIn.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 300, 2, false, true));
        playerIn.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 2, false, true));

        return InteractionResultHolder.sidedSuccess(itemstack, worldIn.isClientSide());
    }
}

