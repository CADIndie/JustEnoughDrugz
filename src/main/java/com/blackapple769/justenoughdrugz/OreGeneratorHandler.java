package com.blackapple769.justenoughdrugz;

import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import com.blackapple769.justenoughdrugz.util.CommonConfig;
import net.minecraft.core.Holder;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;


public class OreGeneratorHandler {

    public static PlacedFeature OIL_ORE_FEATURE;
    public static PlacedFeature SODIUM_BICARBONATE_FEATURE;
    public static PlacedFeature SULFUR_FEATURE;
    public static PlacedFeature LITHIUM_FEATURE;


    public static void init() {
        OIL_ORE_FEATURE = new PlacedFeature(
                Holder.direct(new ConfiguredFeature<>(Feature.SCATTERED_ORE,
                        new OreConfiguration(OreReplacementTargets.OIL_ORE_TARGETS, CommonConfig.OIL_ORE_SIZE.get(),
                                (float) ((double) CommonConfig.OIL_ORE_EXPOSED_DISCARD_CHANCE.get())))),

                List.of(HeightRangePlacement.triangle(VerticalAnchor.absolute(CommonConfig.OIL_ORE_BOTTOM_ANCHOR.get()),
                                VerticalAnchor.absolute(CommonConfig.OIL_ORE_TOP_ANCHOR.get())),
                        BiomeFilter.biome(),
                        InSquarePlacement.spread(),
                        CountPlacement.of(CommonConfig.OIL_ORE_WEIGHT.get())
                ));

        SODIUM_BICARBONATE_FEATURE = new PlacedFeature(
                Holder.direct(new ConfiguredFeature<>(Feature.SCATTERED_ORE,
                        new OreConfiguration(OreReplacementTargets.SODIUM_BICARBONATE_TARGETS, CommonConfig.SODIUM_BICARBONATE_SIZE.get(),
                                (float) ((double) CommonConfig.SODIUM_BICARBONATE_EXPOSED_DISCARD_CHANCE.get())))),

                List.of(HeightRangePlacement.triangle(VerticalAnchor.absolute(CommonConfig.SODIUM_BICARBONATE_BOTTOM_ANCHOR.get()),
                                VerticalAnchor.absolute(CommonConfig.SODIUM_BICARBONATE_TOP_ANCHOR.get())),
                        BiomeFilter.biome(),
                        InSquarePlacement.spread(),
                        CountPlacement.of(CommonConfig.SODIUM_BICARBONATE_WEIGHT.get())
                ));

        SULFUR_FEATURE = new PlacedFeature(
                Holder.direct(new ConfiguredFeature<>(Feature.SCATTERED_ORE,
                        new OreConfiguration(OreReplacementTargets.SULFUR_ORE_TARGETS, CommonConfig.SULFUR_ORE_SIZE.get(),
                                (float) ((double) CommonConfig.SULFUR_ORE_EXPOSED_DISCARD_CHANCE.get())))),

                List.of(HeightRangePlacement.triangle(VerticalAnchor.absolute(CommonConfig.SULFUR_ORE_BOTTOM_ANCHOR.get()),
                                VerticalAnchor.absolute(CommonConfig.SULFUR_ORE_TOP_ANCHOR.get())),
                        BiomeFilter.biome(),
                        InSquarePlacement.spread(),
                        CountPlacement.of(CommonConfig.SULFUR_ORE_WEIGHT.get())
                ));

        LITHIUM_FEATURE = new PlacedFeature(
                Holder.direct(new ConfiguredFeature<>(Feature.SCATTERED_ORE,
                        new OreConfiguration(OreReplacementTargets.LITHIUM_ORE_TARGETS, CommonConfig.LITHIUM_ORE_SIZE.get(),
                                (float) ((double) CommonConfig.LITHIUM_ORE_EXPOSED_DISCARD_CHANCE.get())))),

                List.of(HeightRangePlacement.triangle(VerticalAnchor.absolute(CommonConfig.LITHIUM_ORE_BOTTOM_ANCHOR.get()),
                                VerticalAnchor.absolute(CommonConfig.LITHIUM_ORE_TOP_ANCHOR.get())),
                        BiomeFilter.biome(),
                        InSquarePlacement.spread(),
                        CountPlacement.of(CommonConfig.LITHIUM_ORE_WEIGHT.get())
                ));
    }

    public static class OreReplacementTargets {
        public static final List<OreConfiguration.TargetBlockState> OIL_ORE_TARGETS = List.of(
                OreConfiguration.target(ReplacementRules.REGULAR_STONE,
                        RegistryHandler.OIL_ORE.get().defaultBlockState())
        );
        public static final List<OreConfiguration.TargetBlockState> SULFUR_ORE_TARGETS = List.of(
                OreConfiguration.target(ReplacementRules.REGULAR_STONE,
                        RegistryHandler.SULFUR_ORE.get().defaultBlockState())

        );
        public static final List<OreConfiguration.TargetBlockState> LITHIUM_ORE_TARGETS = List.of(
                OreConfiguration.target(ReplacementRules.REGULAR_STONE,
                        RegistryHandler.LITHIUM_ORE.get().defaultBlockState())

        );
        public static final List<OreConfiguration.TargetBlockState> SODIUM_BICARBONATE_TARGETS = List.of(
                OreConfiguration.target(ReplacementRules.REGULAR_STONE,
                        RegistryHandler.SODIUM_BICARBONATE_ORE.get().defaultBlockState())

        );
    }

    public static final class ReplacementRules {
        public static final RuleTest REGULAR_STONE = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    }
}