package com.blackapple769.justenoughdrugz.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class MimosaBark extends Item {

	public MimosaBark(Item.Properties pProperties) {
		super(pProperties);
	}

	@Override
	public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
		return 100;
	}
}