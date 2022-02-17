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

public class Spirt extends Item {
    public Spirt(Properties pProperties) {
        super(pProperties);
    }
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        if (pEntityLiving instanceof ServerPlayer) {
            ServerPlayer serverplayer = (ServerPlayer)pEntityLiving;
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, pStack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (pEntityLiving instanceof Player) {
            Player pEntityLiving1 = (Player) pEntityLiving;
            pEntityLiving1.addEffect(new MobEffectInstance(RegistryHandler.CAFFEINE_EFFECT.get(), 600, 0, false, true));
            if (!(pEntityLiving1).getAbilities().instabuild) {
                if (pStack.getDamageValue() == pStack.getMaxDamage() - 1) {
                    pStack.shrink(1);
                } else {
                    pStack.hurtAndBreak(1, pEntityLiving1 , (entity) -> entity.broadcastBreakEvent(pEntityLiving1 .getUsedItemHand()));
                }
            }
        }
        return pStack;
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
