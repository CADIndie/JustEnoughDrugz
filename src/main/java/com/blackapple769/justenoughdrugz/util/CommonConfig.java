package com.blackapple769.justenoughdrugz.util;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import org.apache.commons.lang3.tuple.Pair;

public class CommonConfig {

	public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_OII_ORE;
	public static ForgeConfigSpec.ConfigValue<Integer> OIL_ORE_WEIGHT;
	public static ForgeConfigSpec.ConfigValue<Integer> OIL_ORE_TOP_ANCHOR;
	public static ForgeConfigSpec.ConfigValue<Integer> OIL_ORE_BOTTOM_ANCHOR;
	public static ForgeConfigSpec.ConfigValue<Integer> OIL_ORE_SIZE;
	public static ForgeConfigSpec.DoubleValue OIL_ORE_EXPOSED_DISCARD_CHANCE;


	public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SODIUM_BICARBONATE;
	public static ForgeConfigSpec.ConfigValue<Integer> SODIUM_BICARBONATE_WEIGHT;
	public static ForgeConfigSpec.ConfigValue<Integer> SODIUM_BICARBONATE_TOP_ANCHOR;
	public static ForgeConfigSpec.ConfigValue<Integer> SODIUM_BICARBONATE_BOTTOM_ANCHOR;
	public static ForgeConfigSpec.ConfigValue<Integer> SODIUM_BICARBONATE_SIZE;
	public static ForgeConfigSpec.DoubleValue SODIUM_BICARBONATE_EXPOSED_DISCARD_CHANCE;


	public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SULFUR_ORE;
	public static ForgeConfigSpec.ConfigValue<Integer> SULFUR_ORE_WEIGHT;
	public static ForgeConfigSpec.ConfigValue<Integer> SULFUR_ORE_TOP_ANCHOR;
	public static ForgeConfigSpec.ConfigValue<Integer> SULFUR_ORE_BOTTOM_ANCHOR;
	public static ForgeConfigSpec.ConfigValue<Integer> SULFUR_ORE_SIZE;
	public static ForgeConfigSpec.DoubleValue SULFUR_ORE_EXPOSED_DISCARD_CHANCE;


	public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_LITHIUM_ORE;
	public static ForgeConfigSpec.ConfigValue<Integer> LITHIUM_ORE_WEIGHT;
	public static ForgeConfigSpec.ConfigValue<Integer> LITHIUM_ORE_TOP_ANCHOR;
	public static ForgeConfigSpec.ConfigValue<Integer> LITHIUM_ORE_BOTTOM_ANCHOR;
	public static ForgeConfigSpec.ConfigValue<Integer> LITHIUM_ORE_SIZE;
	public static ForgeConfigSpec.DoubleValue LITHIUM_ORE_EXPOSED_DISCARD_CHANCE;

	public static ForgeConfigSpec.ConfigValue<Boolean> ENABLE_RED_PHOSPHORUS;
	public static ForgeConfigSpec.ConfigValue<Integer> RED_PHOSPHORUS_WEIGHT;
	public static ForgeConfigSpec.ConfigValue<Integer> RED_PHOSPHORUS_TOP_ANCHOR;
	public static ForgeConfigSpec.ConfigValue<Integer> RED_PHOSPHORUS_BOTTOM_ANCHOR;
	public static ForgeConfigSpec.ConfigValue<Integer> RED_PHOSPHORUS_SIZE;
	public static ForgeConfigSpec.DoubleValue RED_PHOSPHORUS_EXPOSED_DISCARD_CHANCE;

	public static final ForgeConfigSpec COMMON_SPEC;
	public static final CommonConfig COMMON;


	CommonConfig(ForgeConfigSpec.Builder builder) {
		builder.push("Common Configuration");

		builder.push("Oil Ore");
		ENABLE_OII_ORE = builder.comment("Enable generation of Oil Ore")
				.define("Enable Oil Ore Generation", true);
		OIL_ORE_WEIGHT = builder.defineInRange("Oil Ore weight", 10, 1, Integer.MAX_VALUE);
		OIL_ORE_TOP_ANCHOR = builder.defineInRange("Oil Ore top anchor", 30, -64, 320);
		OIL_ORE_BOTTOM_ANCHOR = builder.defineInRange("Oil Ore bottom anchor", -64, -64, 320);
		OIL_ORE_SIZE = builder.defineInRange("Oil Ore size", 16, 0, Integer.MAX_VALUE);
		OIL_ORE_EXPOSED_DISCARD_CHANCE = builder.defineInRange("Oil Ore exposed to air discard chance", 0.1D, 0D, 1D);
		builder.pop();


		builder.push("Sodium bicarbonate");
		ENABLE_SODIUM_BICARBONATE = builder.comment("Enable generation of Sodium bicarbonate")
				.define("Enable Sodium bicarbonate Generation", true);
		SODIUM_BICARBONATE_WEIGHT = builder.defineInRange("Sodium bicarbonate weight", 10, 1, Integer.MAX_VALUE);
		SODIUM_BICARBONATE_TOP_ANCHOR = builder.defineInRange("Sodium bicarbonate top anchor", 100, -64, 320);
		SODIUM_BICARBONATE_BOTTOM_ANCHOR = builder.defineInRange("Sodium bicarbonate bottom anchor", -64, -64, 320);
		SODIUM_BICARBONATE_SIZE = builder.defineInRange("Sodium bicarbonate size", 10, 0, Integer.MAX_VALUE);
		SODIUM_BICARBONATE_EXPOSED_DISCARD_CHANCE = builder.defineInRange("Sodium bicarbonate exposed to air discard chance", 0.85D, 0D, 1D);
		builder.pop();

		builder.push("Red phosphorus");
		ENABLE_RED_PHOSPHORUS = builder.comment("Enable generation of Red phosphorus")
				.define("Enable Red phosphorus Generation", true);
		RED_PHOSPHORUS_WEIGHT = builder.defineInRange("Red phosphorus weight", 20, 1, Integer.MAX_VALUE);
		RED_PHOSPHORUS_TOP_ANCHOR = builder.defineInRange("Red phosphorus top anchor", 60, -64, 320);
		RED_PHOSPHORUS_BOTTOM_ANCHOR = builder.defineInRange("Red phosphorus bottom anchor", 40, -64, 320);
		RED_PHOSPHORUS_SIZE = builder.defineInRange("Red phosphorus size", 3, 0, Integer.MAX_VALUE);
		RED_PHOSPHORUS_EXPOSED_DISCARD_CHANCE = builder.defineInRange("Red phosphorus exposed to air discard chance", 0.8D, 0D, 1D);
		builder.pop();


		builder.push("Sulfur ore");
		ENABLE_SULFUR_ORE = builder.comment("Enable generation of Sulfur ore")
				.define("Enable Sulfur ore Generation", true);
		SULFUR_ORE_WEIGHT = builder.defineInRange("Sulfur ore weight", 6, 1, Integer.MAX_VALUE);
		SULFUR_ORE_TOP_ANCHOR = builder.defineInRange("Sulfur ore top anchor", 30, -64, 320);
		SULFUR_ORE_BOTTOM_ANCHOR = builder.defineInRange("Sulfur ore bottom anchor", -64, -64, 320);
		SULFUR_ORE_SIZE = builder.defineInRange("Sulfur ore size", 5, 0, Integer.MAX_VALUE);
		SULFUR_ORE_EXPOSED_DISCARD_CHANCE = builder.defineInRange("Sulfur ore exposed to air discard chance", 0.85D, 0D, 1D);
		builder.pop();


		builder.push("Lithium ore");
		ENABLE_LITHIUM_ORE = builder.comment("Enable generation of Lithium ore")
				.define("Enable Lithium ore Generation", true);
		LITHIUM_ORE_WEIGHT = builder.defineInRange("Lithium ore weight", 6, 1, Integer.MAX_VALUE);
		LITHIUM_ORE_TOP_ANCHOR = builder.defineInRange("Lithium ore top anchor", 64, -64, 320);
		LITHIUM_ORE_BOTTOM_ANCHOR = builder.defineInRange("Lithium ore bottom anchor", -64, -64, 320);
		LITHIUM_ORE_SIZE = builder.defineInRange("Lithium ore size", 10, 0, Integer.MAX_VALUE);
		LITHIUM_ORE_EXPOSED_DISCARD_CHANCE = builder.defineInRange("Lithium ore exposed to air discard chance", 0.85D, 0D, 1D);
		builder.pop();

	}

	static {
		Pair<CommonConfig, ForgeConfigSpec> commonConfigForgeConfigSpecPair = new Builder().configure(CommonConfig::new);

		COMMON_SPEC = commonConfigForgeConfigSpecPair.getRight();
		COMMON = commonConfigForgeConfigSpecPair.getLeft();
	}
}