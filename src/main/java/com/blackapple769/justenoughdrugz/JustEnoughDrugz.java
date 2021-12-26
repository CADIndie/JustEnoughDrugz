package com.blackapple769.justenoughdrugz;

import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
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

        //OreGeneratorHandler.init(event);
    }

    public void onBiomeLoading(BiomeLoadingEvent event) {
        // TODO: remove comments later
        /**
        // Biome modifications
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if (event.getCategory() != Biome.BiomeCategory.NETHER || event.getCategory() != Biome.BiomeCategory.THEEND) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES)
                    .add(() -> OreGeneratorHandler.ORE_OIL_CONFIG);

        }
        if (event.getCategory() == Biome.BiomeCategory.OCEAN) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES)
                    .add(() -> OreGeneratorHandler.SODIUM_BICARBONATE_ORE_CONFIG);

        }
        if (event.getCategory() == Biome.BiomeCategory.SWAMP) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION)
                    .add(() -> ModConfiguredFeatures.PATCH_GOLDEN_CAP_MUSHROOM);

        }
         **/
    }

}