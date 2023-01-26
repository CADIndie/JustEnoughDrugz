package com.blackapple769.justenoughdrugz.item;

import com.blackapple769.justenoughdrugz.JustEnoughDrugz;
import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import com.blackapple769.justenoughdrugz.item.data.Data;
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
import org.lwjgl.system.CallbackI;


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
            if(Data.data.bong_cool_down == 0){
                boolean isCreative = player.isCreative();
                ItemStack weed = findWeed(livingEntity);
                boolean hasWeed = weed.getItem() == RegistryHandler.WEED.get();
                if(hasWeed){
                    level.playSound(null, player.getX(), player.getY(), player.getZ(),
                            getUseSound(), SoundSource.AMBIENT, 0.5F,
                            1.0F);

                    CriteriaTriggers.CONSUME_ITEM.trigger(player, stack);
                    player.awardStat(Stats.ITEM_USED.get(this));
                    player.addEffect(new MobEffectInstance(RegistryHandler.WEED_EFFECT.get(), 250, 1, false, true));
                    if(!isCreative){
                        weed.shrink(1);
                    }
                }else{
                    level.playSound(null, player.getX(), player.getY(), player.getZ(),
                            getNoUseSound(), SoundSource.AMBIENT, 0.5F,
                            1.0F);
                }
                Data.data.bong_cool_down = 2;
                return stack;
            }else{
                if(Data.data.bong_cool_down-0.75f >= 0){
                    Data.data.bong_cool_down -= 0.75F;
                }else{
                    Data.data.bong_cool_down = 0;
                }
            }
        }
        return stack;
    }
    @Override
    public int getUseDuration(ItemStack pStack) {
        return 12;
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
