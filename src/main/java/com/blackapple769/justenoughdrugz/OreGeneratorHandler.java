package com.blackapple769.justenoughdrugz;

import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;


public class OreGeneratorHandler {
    public static PlacedFeature OIL_ORE_FEATURE;
    public static PlacedFeature SODIUM_BICARBONATE_FEATURE;

    static List<OreConfiguration.TargetBlockState> targetBlockStates;
    static ConfiguredFeature<?, ?> configuredFeature;


    public static void init() {
        setupOilOre();
        setupSodiumBicarbonateOre();
    }

    public static void setupOilOre() {
        int orePerVein = 12, veinsPerChunk = 12, belowTop = 24;

        BlockState blockState = RegistryHandler.OIL_ORE.get().defaultBlockState();

        targetBlockStates = List.of(OreConfiguration.target(OreFeatures.NATURAL_STONE, blockState));

        configuredFeature = FeatureUtils.register(JustEnoughDrugz.MOD_ID + "block/oil_ore",
                Feature.ORE.configured(new OreConfiguration(targetBlockStates, orePerVein)));

        OIL_ORE_FEATURE = PlacementUtils.register(JustEnoughDrugz.MOD_ID + "block/oil_ore",
                configuredFeature.placed(List.of(CountPlacement.of(veinsPerChunk), InSquarePlacement.spread(),
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(7),
                                VerticalAnchor.belowTop(belowTop)),
                        BiomeFilter.biome())));

    }

    public static void setupSodiumBicarbonateOre() {
        int orePerVein = 20, veinsPerChunk = 12, belowTop = 24;

        BlockState blockState = RegistryHandler.SODIUM_BICARBONATE_ORE.get().defaultBlockState();

        targetBlockStates = List.of(OreConfiguration.target(OreFeatures.NATURAL_STONE, blockState));

        configuredFeature = FeatureUtils.register(JustEnoughDrugz.MOD_ID + "block/sodium_bicarbonate_ore",
                Feature.ORE.configured(new OreConfiguration(targetBlockStates, orePerVein)));

        SODIUM_BICARBONATE_FEATURE = PlacementUtils.register(JustEnoughDrugz.MOD_ID + "block/sodium_bicarbonate_ore",
                configuredFeature.placed(List.of(CountPlacement.of(veinsPerChunk), InSquarePlacement.spread(),
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(7),
                                VerticalAnchor.belowTop(belowTop)),
                        BiomeFilter.biome())));

    }

}