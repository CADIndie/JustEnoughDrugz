package com.blackapple769.justenoughdrugz;

import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import com.blackapple769.justenoughdrugz.util.CommonConfig;
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
    public static PlacedFeature SULFUR_FEATURE;
    public static PlacedFeature LITHIUM_FEATURE;

    static final List<Integer> OIL_ORE_CONFIG = CommonConfig.OIL_ORE_CONFIG.get();
    static final List<Integer> SODIUM_BICARBONATE_CONFIG = CommonConfig.SODIUM_BICARBONATE_ORE_CONFIG.get();
    static final List<Integer> SULFUR_ORE_CONFIG = CommonConfig.SULFUR_ORE_CONFIG.get();
    static final List<Integer> LITHIUM_ORE_CONFIG = CommonConfig.LITHIUM_ORE_CONFIG.get();

    static List<OreConfiguration.TargetBlockState> targetBlockStates;
    static ConfiguredFeature<?, ?> configuredFeature;


    public static void init() {
        setupOilOre();
        setupSodiumBicarbonateOre();
        setupSulfurOre();
        setupLithiumOre();
    }

    public static void setupOilOre() {
        int orePerVein = OIL_ORE_CONFIG.get(0), veinsPerChunk = OIL_ORE_CONFIG.get(1), belowTop = OIL_ORE_CONFIG.get(2);

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
        int orePerVein = SODIUM_BICARBONATE_CONFIG.get(0), veinsPerChunk = SODIUM_BICARBONATE_CONFIG.get(1), belowTop = SODIUM_BICARBONATE_CONFIG.get(2);

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

    public static void setupSulfurOre() {
        int orePerVein = SULFUR_ORE_CONFIG.get(0), veinsPerChunk = SULFUR_ORE_CONFIG.get(1), belowTop = SULFUR_ORE_CONFIG.get(2);

        BlockState blockState = RegistryHandler.SULFUR_ORE.get().defaultBlockState();

        targetBlockStates = List.of(OreConfiguration.target(OreFeatures.NATURAL_STONE, blockState));

        configuredFeature = FeatureUtils.register(JustEnoughDrugz.MOD_ID + "block/sulfur_ore",
                Feature.ORE.configured(new OreConfiguration(targetBlockStates, orePerVein)));

        SULFUR_FEATURE = PlacementUtils.register(JustEnoughDrugz.MOD_ID + "block/sulfur_ore",
                configuredFeature.placed(List.of(CountPlacement.of(veinsPerChunk), InSquarePlacement.spread(),
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(7),
                                VerticalAnchor.belowTop(belowTop)),
                        BiomeFilter.biome())));

    }

    public static void setupLithiumOre() {
        int orePerVein = LITHIUM_ORE_CONFIG.get(0), veinsPerChunk = LITHIUM_ORE_CONFIG.get(1), belowTop = LITHIUM_ORE_CONFIG.get(2);

        BlockState blockState = RegistryHandler.LITHIUM_ORE.get().defaultBlockState();

        targetBlockStates = List.of(OreConfiguration.target(OreFeatures.NATURAL_STONE, blockState));

        configuredFeature = FeatureUtils.register(JustEnoughDrugz.MOD_ID + "block/lithium_ore",
                Feature.ORE.configured(new OreConfiguration(targetBlockStates, orePerVein)));

        LITHIUM_FEATURE = PlacementUtils.register(JustEnoughDrugz.MOD_ID + "block/lithium_ore",
                configuredFeature.placed(List.of(CountPlacement.of(veinsPerChunk), InSquarePlacement.spread(),
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(7),
                                VerticalAnchor.belowTop(belowTop)),
                        BiomeFilter.biome())));

    }

}