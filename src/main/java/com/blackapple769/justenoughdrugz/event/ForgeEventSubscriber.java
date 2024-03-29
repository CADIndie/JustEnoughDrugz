package com.blackapple769.justenoughdrugz.event;

import com.blackapple769.justenoughdrugz.JustEnoughDrugz;
import com.blackapple769.justenoughdrugz.OreGeneratorHandler;
import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import com.blackapple769.justenoughdrugz.util.CommonConfig;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.RegistryEvent.MissingMappings;
import net.minecraftforge.event.RegistryEvent.MissingMappings.Mapping;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import java.util.ArrayList;
import java.util.List;


@EventBusSubscriber(modid = JustEnoughDrugz.MOD_ID, bus = Bus.FORGE)
public class ForgeEventSubscriber {

    @SubscribeEvent
    public static void missingItemMappings(MissingMappings<Item> event) {
        ImmutableList<Mapping<Item>> mappings = event.getMappings(JustEnoughDrugz.MOD_ID);

        if (!mappings.isEmpty()) {

            JustEnoughDrugz.LOGGER.warn("Missing item mappings were found. This probably means an item was renamed or deleted. Attempting to remap...");
            List<String> remappedItems = new ArrayList<>(0);

            ResourceLocation BLUE_METH = new ResourceLocation(JustEnoughDrugz.MOD_ID, "blue_meth");
            ResourceLocation CLEAR_METH = new ResourceLocation(JustEnoughDrugz.MOD_ID, "clear_meth");
            ResourceLocation GREEN_METH = new ResourceLocation(JustEnoughDrugz.MOD_ID, "green_meth");
            ResourceLocation ORANGE_METH = new ResourceLocation(JustEnoughDrugz.MOD_ID, "orange_meth");

            ResourceLocation CHEAP_METH_VILE = new ResourceLocation(JustEnoughDrugz.MOD_ID, "cheap_meth_vile");
            ResourceLocation BLUE_METH_VILE = new ResourceLocation(JustEnoughDrugz.MOD_ID, "blue_meth_vile");
            ResourceLocation CLEAR_METH_VILE = new ResourceLocation(JustEnoughDrugz.MOD_ID, "clear_meth_vile");

            ResourceLocation CHEAP_METH_SYRINGE = new ResourceLocation(JustEnoughDrugz.MOD_ID, "cheap_meth_syringe");
            ResourceLocation BLUE_METH_SYRINGE = new ResourceLocation(JustEnoughDrugz.MOD_ID, "blue_meth_syringe");
            ResourceLocation CLEAR_METH_SYRINGE = new ResourceLocation(JustEnoughDrugz.MOD_ID, "clear_meth_syringe");

            ResourceLocation CHEAP_METH_PIPE = new ResourceLocation(JustEnoughDrugz.MOD_ID, "cheap_meth_pipe");
            ResourceLocation BLUE_METH_PIPE = new ResourceLocation(JustEnoughDrugz.MOD_ID, "blue_meth_pipe");
            ResourceLocation CLEAR_METH_PIPE = new ResourceLocation(JustEnoughDrugz.MOD_ID, "clear_meth_pipe");

            ResourceLocation GOLDEN_CHEAP_METH_PIPE = new ResourceLocation(JustEnoughDrugz.MOD_ID, "golden_cheap_meth_pipe");
            ResourceLocation GOLDEN_BLUE_METH_PIPE = new ResourceLocation(JustEnoughDrugz.MOD_ID, "golden_blue_meth_pipe");
            ResourceLocation GOLDEN_CLEAR_METH_PIPE = new ResourceLocation(JustEnoughDrugz.MOD_ID, "golden_clear_meth_pipe");


            for (Mapping<Item> itemMapping : mappings) {
                if (itemMapping.key.equals(BLUE_METH)) {
                    itemMapping.remap(RegistryHandler.MEDIUM_QUALITY_BLUE_METH.get());
                    remappedItems.add(itemMapping.key.getPath());
                }

                if (itemMapping.key.equals(CLEAR_METH)) {
                    itemMapping.remap(RegistryHandler.MEDIUM_QUALITY_METH.get());
                    remappedItems.add(itemMapping.key.getPath());
                }

                if (itemMapping.key.equals(GREEN_METH) || itemMapping.key.equals(ORANGE_METH)) {
                    itemMapping.remap(RegistryHandler.LOW_QUALITY_METH.get());
                    remappedItems.add(itemMapping.key.getPath());
                }

                if (itemMapping.key.equals(CHEAP_METH_VILE)) {
                    itemMapping.remap(RegistryHandler.LOW_QUALITY_METH_VIAL.get());
                    remappedItems.add(itemMapping.key.getPath());
                }

                if (itemMapping.key.equals(BLUE_METH_VILE)) {
                    itemMapping.remap(RegistryHandler.MEDIUM_QUALITY_BLUE_METH_VIAL.get());
                    remappedItems.add(itemMapping.key.getPath());
                }

                if (itemMapping.key.equals(CLEAR_METH_VILE)) {
                    itemMapping.remap(RegistryHandler.MEDIUM_QUALITY_METH_VIAL.get());
                    remappedItems.add(itemMapping.key.getPath());
                }

                if (itemMapping.key.equals(CHEAP_METH_SYRINGE)) {
                    itemMapping.remap(RegistryHandler.LOW_QUALITY_METH_SYRINGE.get());
                    remappedItems.add(itemMapping.key.getPath());
                }

                if (itemMapping.key.equals(BLUE_METH_SYRINGE)) {
                    itemMapping.remap(RegistryHandler.MEDIUM_QUALITY_BLUE_METH_SYRINGE.get());
                    remappedItems.add(itemMapping.key.getPath());
                }

                if (itemMapping.key.equals(CLEAR_METH_SYRINGE)) {
                    itemMapping.remap(RegistryHandler.MEDIUM_QUALITY_METH_SYRINGE.get());
                    remappedItems.add(itemMapping.key.getPath());
                }

                if (itemMapping.key.equals(CHEAP_METH_PIPE)) {
                    itemMapping.remap(RegistryHandler.LOW_QUALITY_METH_PIPE.get());
                    remappedItems.add(itemMapping.key.getPath());
                }

                if (itemMapping.key.equals(BLUE_METH_PIPE)) {
                    itemMapping.remap(RegistryHandler.MEDIUM_QUALITY_BLUE_METH_PIPE.get());
                    remappedItems.add(itemMapping.key.getPath());
                }

                if (itemMapping.key.equals(CLEAR_METH_PIPE)) {
                    itemMapping.remap(RegistryHandler.MEDIUM_QUALITY_METH_PIPE.get());
                    remappedItems.add(itemMapping.key.getPath());
                }

                if (itemMapping.key.equals(GOLDEN_CHEAP_METH_PIPE)) {
                    itemMapping.remap(RegistryHandler.GOLDEN_LOW_QUALITY_METH_PIPE.get());
                    remappedItems.add(itemMapping.key.getPath());
                }

                if (itemMapping.key.equals(GOLDEN_BLUE_METH_PIPE)) {
                    itemMapping.remap(RegistryHandler.GOLDEN_MEDIUM_QUALITY_BLUE_METH_PIPE.get());
                    remappedItems.add(itemMapping.key.getPath());
                }

                if (itemMapping.key.equals(GOLDEN_CLEAR_METH_PIPE)) {
                    itemMapping.remap(RegistryHandler.GOLDEN_MEDIUM_QUALITY_METH_PIPE.get());
                    remappedItems.add(itemMapping.key.getPath());
                }

            }
            JustEnoughDrugz.LOGGER.warn("Item remapping complete. Remapped entries: {}", remappedItems);
            JustEnoughDrugz.LOGGER.warn("{}/{} items remapped.", remappedItems.size(), mappings.size());
        }
    }
}
