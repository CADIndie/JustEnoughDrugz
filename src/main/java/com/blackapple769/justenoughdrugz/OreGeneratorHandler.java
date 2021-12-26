package com.blackapple769.justenoughdrugz;

import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;


public class OreGeneratorHandler {
    public static ConfiguredFeature<?, ?> ORE_OIL_CONFIG;
    public static ConfiguredFeature<?, ?> SODIUM_BICARBONATE_ORE_CONFIG;


    /**
     * Initialize ore generation setup.
     * @param event the <code>FMLCommonSetupEvent</code> instance
     */

    /**
    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {


        ORE_OIL_CONFIG = Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, "oil_ore",
                Feature.ORE.configured(
                        new OreConfiguration(
                                OreConfiguration.Predicates.NATURAL_STONE,
                                RegistryHandler.OIL_ORE.get().defaultBlockState(), 20)
                ).range(new RangeDecoratorConfiguration(BiasedToBottomHeight.of(VerticalAnchor.bottom(), VerticalAnchor.belowTop(20), 20))).count(10)
        );
        SODIUM_BICARBONATE_ORE_CONFIG = Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, "oil_ore",
                Feature.ORE.configured(
                        new OreConfiguration(
                                OreConfiguration.Predicates.NATURAL_STONE,
                                RegistryHandler.SODIUM_BICARBONATE_ORE.get().defaultBlockState(), 10)
                ).range(new RangeDecoratorConfiguration(BiasedToBottomHeight.of(VerticalAnchor.bottom(), VerticalAnchor.belowTop(20), 20))).count(10)
        );
    }
    */
}

