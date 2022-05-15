package com.blackapple769.justenoughdrugz;

import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraft.core.Holder;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("justenoughdrugz")
public class JustEnoughDrugz {
    public static final String MOD_ID = "justenoughdrugz";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public JustEnoughDrugz() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        RegistryHandler.init();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);

        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.addListener(EventPriority.HIGH, this::onBiomeLoading);
    }

    private void setup(final FMLCommonSetupEvent event) {
        OreGeneratorHandler.init();
        PotionRecipe.setupBrewingRecipes();
    }

    public void onBiomeLoading(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if (event.getCategory() != Biome.BiomeCategory.NETHER && event.getCategory() != Biome.BiomeCategory.THEEND) {
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(OreGeneratorHandler.OIL_ORE_FEATURE));
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(OreGeneratorHandler.SULFUR_FEATURE));
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(OreGeneratorHandler.LITHIUM_FEATURE));
            if (event.getCategory() == Biome.BiomeCategory.OCEAN) {
                generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, Holder.direct(OreGeneratorHandler.SODIUM_BICARBONATE_FEATURE));
            }
            if(event.getCategory() == Biome.BiomeCategory.SWAMP){
                generation.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, Holder.direct(ModConfiguredFeatures.PATCH_GOLDEN_CAP_MUSHROOM));
            }
            if(event.getCategory() == Biome.BiomeCategory.SAVANNA || event.getCategory() == Biome.BiomeCategory.DESERT){
                generation.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, Holder.direct(ModConfiguredFeatures.PATCH_EPHEDRA_PLANT));
            }
            if(event.getCategory() == Biome.BiomeCategory.JUNGLE){
                generation.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, Holder.direct(ModConfiguredFeatures.PATCH_MIMOSA_PLANT));
            }
        }
    }

}