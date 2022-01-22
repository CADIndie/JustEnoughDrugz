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

public class Percocets extends Item {
    public Percocets(Properties pProperties) {
        super(pProperties);
    }

    /**
     * Runs when the player right-clicks.
     * @param worldIn the <code>World</code> the player is in
     * @param playerIn the <code>PlayerEntity</code> performing the action
     * @param handIn the <code>Hand</code> the player is using
     * @return ActionResult extending ItemStack
     */
    @Override
    public @NotNull
    InteractionResultHolder<ItemStack> use(@NotNull Level worldIn, Player playerIn, @NotNull InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        playerIn.addEffect(new MobEffectInstance(RegistryHandler.PERC_EFFECT.get(), 650, 3, false, true));
        if (!playerIn.isCreative()) {
            if(itemstack.getDamageValue() == itemstack.getMaxDamage()-1){
                playerIn.getInventory().add(new ItemStack(RegistryHandler.EMPTY_PILL_BOTTLE.get()));

                itemstack.shrink(1);


            }else{
                itemstack.hurtAndBreak(1, playerIn, (entity) -> entity.broadcastBreakEvent(playerIn.getUsedItemHand()));

            }


        }
        return InteractionResultHolder.sidedSuccess(itemstack, worldIn.isClientSide());
    }
}
