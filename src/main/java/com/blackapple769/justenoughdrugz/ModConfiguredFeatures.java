package com.blackapple769.justenoughdrugz;

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
}