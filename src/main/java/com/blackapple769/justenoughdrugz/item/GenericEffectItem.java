package com.blackapple769.justenoughdrugz.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class GenericEffectItem extends Item {

	private final int duration;
	private final int amplifier;
	private final Item returnItem;
	private MobEffect effect = MobEffects.ABSORPTION; // Provide a default effect in case one is not set

	public GenericEffectItem(Item.Properties pProperties, int duration, int amplifier, Item returnItem) {
		super(pProperties);

		this.duration = duration;
		this.amplifier = amplifier;
		this.returnItem = returnItem;
	}

	@NotNull
	public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
		ItemStack itemInHand = player.getItemInHand(hand);
		player.addEffect(new MobEffectInstance(effect, duration, amplifier, false, true));
		if (!player.isCreative()) {
			player.getInventory().add(new ItemStack(returnItem));
			itemInHand.shrink(1);
		}
		return InteractionResultHolder.sidedSuccess(itemInHand, level.isClientSide);
	}

	public void setEffect(MobEffect effect) {
		this.effect = effect;
	}
}