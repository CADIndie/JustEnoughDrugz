package com.blackapple769.justenoughdrugz;

import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ClampedInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;

public class ModConfiguredFeatures {
    // TODO: Fix alongside mushroom stuff, also when worldgen improves
    public static final ConfiguredFeature<?, ?> GOLDEN_CAP_MUSHROOM_PATCH = FeatureUtils.register("patch_golden_cap_mushroom", Feature.RANDOM_PATCH.configured(FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(RegistryHandler.GOLDEN_CAP_MUSHROOM.get()))))));

    public static final PlacedFeature PATCH_GOLDEN_CAP_MUSHROOM = PlacementUtils.register("patch_golden_cap_mushroom", ModConfiguredFeatures.GOLDEN_CAP_MUSHROOM_PATCH.placed(RarityFilter.onAverageOnceEvery(64), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, CountPlacement.of(ClampedInt.of(UniformInt.of(-1, 3), 0, 3)), BiomeFilter.biome()));

    private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String p_127056_, ConfiguredFeature<FC, ?> p_127057_) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, p_127056_, p_127057_);
    }
}