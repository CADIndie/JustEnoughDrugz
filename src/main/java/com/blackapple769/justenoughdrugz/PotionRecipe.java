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

		BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
				new MyNbtIngredient(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)),
				Ingredient.of(new ItemStack(RegistryHandler.DRIED_COFFEE_BEANS.get())),
				new ItemStack(RegistryHandler.CUP_OF_COFFEE.get())));


		//meth vials
		//blue
		BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
				new MyNbtIngredient(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)),
				Ingredient.of(new ItemStack(RegistryHandler.HIGH_QUALITY_BLUE_METH.get())),
				new ItemStack(RegistryHandler.HIGH_QUALITY_BLUE_METH_VIAL.get())));

		BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
				new MyNbtIngredient(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)),
				Ingredient.of(new ItemStack(RegistryHandler.MEDIUM_QUALITY_BLUE_METH.get())),
				new ItemStack(RegistryHandler.MEDIUM_QUALITY_BLUE_METH_VIAL.get())));

		//clear
		BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
				new MyNbtIngredient(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)),
				Ingredient.of(new ItemStack(RegistryHandler.HIGH_QUALITY_METH.get())),
				new ItemStack(RegistryHandler.HIGH_QUALITY_METH_VIAL.get())));

		BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
				new MyNbtIngredient(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)),
				Ingredient.of(new ItemStack(RegistryHandler.MEDIUM_QUALITY_METH.get())),
				new ItemStack(RegistryHandler.MEDIUM_QUALITY_METH_VIAL.get())));

		BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
				new MyNbtIngredient(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)),
				Ingredient.of(new ItemStack(RegistryHandler.LOW_QUALITY_METH.get())),
				new ItemStack(RegistryHandler.LOW_QUALITY_METH_VIAL.get())));

		//other
		BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
				new MyNbtIngredient(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)),
				Ingredient.of(new ItemStack(RegistryHandler.UNDERCOOKED_METH.get())),
				new ItemStack(RegistryHandler.UNDERCOOKED_METH_VIAL.get())));

		BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
				new MyNbtIngredient(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)),
				Ingredient.of(new ItemStack(RegistryHandler.BURNT_METH.get())),
				new ItemStack(RegistryHandler.BURNT_METH_VIAL.get())));
	}


}