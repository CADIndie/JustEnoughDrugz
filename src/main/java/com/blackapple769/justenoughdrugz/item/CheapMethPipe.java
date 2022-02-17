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

public class CheapMethPipe extends Item {
    public CheapMethPipe(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull
    InteractionResultHolder<ItemStack> use(@NotNull Level worldIn, Player playerIn, @NotNull InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        playerIn.addEffect(new MobEffectInstance(RegistryHandler.METH_EFFECT.get(), 400, 1, false, true));
        if (!playerIn.isCreative()) {

            if(itemstack.is(RegistryHandler.GOLDEN_CHEAP_METH_PIPE.get())){
                playerIn.getInventory().add(new ItemStack(RegistryHandler.GOLDEN_PIPE.get()));

            }else{
                playerIn.getInventory().add(new ItemStack(RegistryHandler.PIPE.get()));

            }
            itemstack.shrink(1);
        }
        return InteractionResultHolder.sidedSuccess(itemstack, worldIn.isClientSide());
    }
}