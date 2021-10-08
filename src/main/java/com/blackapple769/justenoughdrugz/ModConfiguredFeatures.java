package com.blackapple769.justenoughdrugz;

import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.blockplacers.SimpleBlockPlacer;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;

public class ModConfiguredFeatures {
    public static final ConfiguredFeature<?, ?> PATCH_GOLDEN_CAP_MUSHROOM = register("patch_brown_mushroom",Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(new SimpleStateProvider(RegistryHandler.GOLDEN_CAP_MUSHROOM.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(64).noProjection().build()));


    private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String p_127056_, ConfiguredFeature<FC, ?> p_127057_) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, p_127056_, p_127057_);
    }


    }

