package com.blackapple769.justenoughdrugz.item;

import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class Lean extends Item {
    public Lean(Properties pProperties) {
        super(pProperties);
    }
    public @NotNull ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        if (pEntityLiving instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, pStack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (pEntityLiving instanceof Player pEntityLiving1) {
            pEntityLiving1.addEffect(new MobEffectInstance(RegistryHandler.LEAN_EFFECT.get(), 650, 1, false, true));
            if (!(pEntityLiving1).getAbilities().instabuild) {
                if (pStack.getDamageValue() == pStack.getMaxDamage() - 1) {
                    pStack.shrink(1);
                } else {
                    pStack.hurtAndBreak(1, pEntityLiving1 , (entity) -> entity.broadcastBreakEvent(pEntityLiving1 .getUsedItemHand()));
                }
            }
        }
        return pStack.isEmpty() ? new ItemStack(RegistryHandler.STYROFOAM_CUP.get()) : pStack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getUseDuration(ItemStack pStack) {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }


    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
    }

}