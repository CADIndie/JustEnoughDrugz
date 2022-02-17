package com.blackapple769.justenoughdrugz.item;

import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.antlr.v4.runtime.misc.NotNull;

public class BlueMethSyringe extends Item {
    public BlueMethSyringe(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull
    InteractionResultHolder<ItemStack> use(@NotNull Level worldIn, Player playerIn, @NotNull InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        playerIn.addEffect(new MobEffectInstance(RegistryHandler.METH_EFFECT.get(), 1600, 4, false, true));
        if (!playerIn.isCreative()) {
            itemstack.shrink(1);
            playerIn.getInventory().add(new ItemStack(RegistryHandler.EMPTY_SYRINGE.get()));
        }
        return InteractionResultHolder.sidedSuccess(itemstack, worldIn.isClientSide());
    }
}
