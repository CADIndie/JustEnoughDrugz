package com.blackapple769.justenoughdrugz.item;

import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;


public class Bong extends Item {
    public Bong(Properties pProperties) {
        super(pProperties);
    }

    ItemStack findWeed(LivingEntity livingEntity) {
        Player playerEntity = (Player) livingEntity;
        for (int i = 0; i < playerEntity.getInventory().getContainerSize(); ++i) {
            ItemStack item = playerEntity.getInventory().getItem(i);
            if (item.is(RegistryHandler.WEED.get())) {
                return item;
            }
        }
        return ItemStack.EMPTY;
    }

    public @org.jetbrains.annotations.NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        if (livingEntity instanceof ServerPlayer player) {
            boolean isCreative = player.isCreative();
            ItemStack weed = findWeed(livingEntity);
            boolean hasWeed = weed.getItem() == RegistryHandler.WEED.get();
            if(hasWeed){
                level.playSound(null, player.getX(), player.getY(), player.getZ(),
                        getUseSound(), SoundSource.PLAYERS, 1.0F,
                        1.0F);

                CriteriaTriggers.CONSUME_ITEM.trigger(player, stack);
                player.awardStat(Stats.ITEM_USED.get(this));
                player.addEffect(new MobEffectInstance(RegistryHandler.WEED_EFFECT.get(), 250, 1, false, true));
                if(!isCreative){
                    weed.shrink(1);
                }
            }else{
                level.playSound(null, player.getX(), player.getY(), player.getZ(),
                        getNoUseSound(), SoundSource.PLAYERS, 1.0F,
                        1.0F);
            }
        }
        return stack;
    }


    @Override
    public int getUseDuration(ItemStack pStack) {
        return 50;
    }

    @Override
    public @org.jetbrains.annotations.NotNull UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.NONE;
    }

    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
    }

    SoundEvent getUseSound() {
        return RegistryHandler.BONG_USE_EFFECT.get();
    }
    SoundEvent getNoUseSound() {
        return RegistryHandler.USED_UP_BONG.get();
    }

}
