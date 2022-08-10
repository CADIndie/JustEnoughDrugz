package com.blackapple769.justenoughdrugz;

import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.crafting.NBTIngredient;

public class PotionRecipe {
	static class MyNbtIngredient extends NBTIngredient {
		protected MyNbtIngredient(ItemStack stack) {
			super(stack);
		}
	}
	static void setupBrewingRecipes() {
		//TODO add new meth types to vials
		BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
				new MyNbtIngredient(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.POISON)),
				Ingredient.of(new ItemStack(RegistryHandler.EPHEDRINE.get())),
				new ItemStack(RegistryHandler.PURE_EPHEDRINE.get())));


		BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
				new MyNbtIngredient(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)),
				Ingredient.of(new ItemStack(RegistryHandler.DMT.get())),
				new ItemStack(RegistryHandler.DMT_VILE.get())));

	}


}