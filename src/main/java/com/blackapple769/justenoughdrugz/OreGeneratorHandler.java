package com.blackapple769.justenoughdrugz;

import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RangeDecoratorConfiguration;
import net.minecraft.world.level.levelgen.heightproviders.BiasedToBottomHeight;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;


public class OreGeneratorHandler {
    public static ConfiguredFeature<?, ?> ORE_OIL_CONFIG;


    /**
     * Initialize ore generation setup.
     * @param event the <code>FMLCommonSetupEvent</code> instance
     */
    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {


        ORE_OIL_CONFIG = Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, "oil_ore",
                Feature.ORE.configured(
                        new OreConfiguration(
                                OreConfiguration.Predicates.NATURAL_STONE,
                                RegistryHandler.OIL_ORE.get().defaultBlockState(), 20)
                ).range(new RangeDecoratorConfiguration(BiasedToBottomHeight.of(VerticalAnchor.bottom(), VerticalAnchor.belowTop(20), 20))).count(10)
        );
    }
}

