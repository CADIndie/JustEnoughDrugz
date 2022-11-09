package com.blackapple769.justenoughdrugz.item.armor;

import com.blackapple769.justenoughdrugz.JustEnoughDrugz;
import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HazmatArmorItem extends ArmorItem {
    private static boolean effectEnabled = false;
    private boolean isLeggings = false;
    public static boolean maskEquipped = false;

    public HazmatArmorItem(ArmorMaterial material, EquipmentSlot slot, int type) {
        super(material, slot, (new Item.Properties().tab(RegistryHandler.METH_GROUP)));
        if (type == 2) {
            isLeggings = true;
        }
    }

    static void setEffectState(boolean state) {
        effectEnabled = state;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return (!isLeggings ? JustEnoughDrugz.MOD_ID + ":textures/armor/hazmat_layer_1.png" : JustEnoughDrugz.MOD_ID + ":textures/armor/hazmat_layer_2.png");
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        // TODO add back maskEquipped = false;
        if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == RegistryHandler.HAZMAT_MASK.get()){
            if(player.getItemBySlot(EquipmentSlot.CHEST).getItem() == RegistryHandler.HAZMAT_SHIRT.get() &&
                    player.getItemBySlot(EquipmentSlot.LEGS).getItem() == RegistryHandler.HAZMAT_LEGGINGS.get() &&
                    player.getItemBySlot(EquipmentSlot.FEET).getItem() == RegistryHandler.HAZMAT_SHOES.get()) {

                setEffectState(!effectEnabled);
                player.removeAllEffects();
            }
            // TODO add back maskEquipped = true;

        }
    }

}
