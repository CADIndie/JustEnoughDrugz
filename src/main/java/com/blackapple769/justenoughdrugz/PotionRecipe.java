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
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                new MyNbtIngredient(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.POISON)),
                Ingredient.of(new ItemStack(RegistryHandler.EPHEDRINE.get())),
                new ItemStack(RegistryHandler.PURE_EPHEDRINE.get())));

        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                new MyNbtIngredient(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)),
                Ingredient.of(new ItemStack(RegistryHandler.CLEAR_METH.get())),
                new ItemStack(RegistryHandler.CLEAR_METH_VILE.get())));

        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                new MyNbtIngredient(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)),
                Ingredient.of(new ItemStack(RegistryHandler.BLUE_METH.get())),
                new ItemStack(RegistryHandler.BLUE_METH_VILE.get())));

        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                new MyNbtIngredient(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)),
                Ingredient.of(new ItemStack(RegistryHandler.GREEN_METH.get())),
                new ItemStack(RegistryHandler.CHEAP_METH_VILE.get())));

        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(
                new MyNbtIngredient(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)),
                Ingredient.of(new ItemStack(RegistryHandler.ORANGE_METH.get())),
                new ItemStack(RegistryHandler.CHEAP_METH_VILE.get())));


    }


}
