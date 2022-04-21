package com.blackapple769.justenoughdrugz;

<<<<<<< Updated upstream
public class ModConfiguredFeatures {
    // TODO: Fix alongside mushroom stuff, also when worldgen improves
    /*public static final ConfiguredFeature<?, ?> PATCH_GOLDEN_CAP_MUSHROOM = register("patch_brown_mushroom",Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(new SimpleStateProvider(RegistryHandler.GOLDEN_CAP_MUSHROOM.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(64).noProjection().build()));


    private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String p_127056_, ConfiguredFeature<FC, ?> p_127057_) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, p_127056_, p_127057_);
    }*/
=======
import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModConfiguredFeatures {

	public static final PlacedFeature PATCH_GOLDEN_CAP_MUSHROOM = new PlacedFeature(
			Holder.direct(new ConfiguredFeature<>(Feature.RANDOM_PATCH,
					patch(BlockStateProvider.simple(RegistryHandler.GOLDEN_CAP_MUSHROOM.get()), 10))),

			List.of(HeightRangePlacement.triangle(VerticalAnchor.absolute(15),
					VerticalAnchor.absolute(196)
			), BiomeFilter.biome(), InSquarePlacement.spread(), CountPlacement.of(4)));

	public static final PlacedFeature PATCH_EPHEDRA_PLANT = new PlacedFeature(
			Holder.direct(new ConfiguredFeature<>(Feature.RANDOM_PATCH,
					patch(BlockStateProvider.simple(RegistryHandler.EPHEDRA_PLANT.get()), 7))),

			List.of(HeightRangePlacement.triangle(VerticalAnchor.absolute(15),
					VerticalAnchor.absolute(196)
			), BiomeFilter.biome(), InSquarePlacement.spread(), CountPlacement.of(10)));

	public static final PlacedFeature PATCH_MIMOSA_PLANT = new PlacedFeature(
			Holder.direct(new ConfiguredFeature<>(Feature.RANDOM_PATCH,
					patch(BlockStateProvider.simple(RegistryHandler.MIMOSA_HOSTILIS_PLANT.get()), 32))),

			List.of(HeightRangePlacement.triangle(VerticalAnchor.absolute(15),
					VerticalAnchor.absolute(196)
			), BiomeFilter.biome(), InSquarePlacement.spread(), CountPlacement.of(32)));

	private static RandomPatchConfiguration patch(BlockStateProvider stateProvider, int tries) {
		return FeatureUtils.simpleRandomPatchConfiguration(tries, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(stateProvider)));
	}
>>>>>>> Stashed changes
}