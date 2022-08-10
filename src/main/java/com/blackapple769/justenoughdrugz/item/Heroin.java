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

public class Heroin extends Item {

    /**
     * Constructor for MorphineItem.
     * @param properties the <code>Properties</code> for the item
     */
    public Heroin(Properties properties) {
        super(properties);
    }

    /**
     * Runs when the player right-clicks.
     * @param worldIn the <code>World</code> the player is in
     * @param playerIn the <code>PlayerEntity</code> performing the action
     * @param handIn the <code>Hand</code> the player is using
     * @return ActionResult extending ItemStack
     */
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level worldIn, Player playerIn, @NotNull InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        playerIn.addEffect(new MobEffectInstance(RegistryHandler.MORPHINE_EFFECT.get(), 400, 3, false, true));
        if (!playerIn.isCreative()) {
            itemstack.shrink(1);
            playerIn.getInventory().add(new ItemStack(RegistryHandler.EMPTY_SYRINGE.get()));

        }

        return InteractionResultHolder.sidedSuccess(itemstack, worldIn.isClientSide());
    }
}
