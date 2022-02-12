package com.blackapple769.justenoughdrugz.util;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class CommonConfig {

	public static final ForgeConfigSpec COMMON_SPEC;
	public static final CommonConfig COMMON;

	public static ForgeConfigSpec.ConfigValue<List<Integer>> OIL_ORE_CONFIG;
	public static ForgeConfigSpec.ConfigValue<List<Integer>> SODIUM_BICARBONATE_ORE_CONFIG;
	public static ForgeConfigSpec.ConfigValue<List<Integer>> SULFUR_ORE_CONFIG;
	public static ForgeConfigSpec.ConfigValue<List<Integer>> LITHIUM_ORE_CONFIG;

	CommonConfig(ForgeConfigSpec.Builder builder) {
		builder.push("Common Configuration");

		builder.push("Ore Generation");
		List<Integer> oil_ore_config_list = new ArrayList<>(3);
		oil_ore_config_list.addAll(Arrays.asList(20, 12, 24));
		OIL_ORE_CONFIG = builder
				.comment("Configuration for Oil Ore. Specified as a list. [ore_per_vein, veins_per_chunk, below_top]. Default: [20, 12, 24]")
				.define("oil_ore_config", oil_ore_config_list);

		List<Integer> sodium_bicarbonate_ore_config_list = new ArrayList<>(3);
		sodium_bicarbonate_ore_config_list.addAll(Arrays.asList(20, 12, 24));
		SODIUM_BICARBONATE_ORE_CONFIG = builder
				.comment("Configuration for Sodium Bicarbonate Ore. Specified as a list. [ore_per_vein, veins_per_chunk, below_top]. Default: [20, 12, 24]")
				.define("sodium_bicarbonate_ore_config", sodium_bicarbonate_ore_config_list);

		List<Integer> sulfur_ore_config_list = new ArrayList<>(3);
		sulfur_ore_config_list.addAll(Arrays.asList(10, 12, 24));
		SULFUR_ORE_CONFIG = builder
				.comment("Configuration for Sulfur Ore. Specified as a list. [ore_per_vein, veins_per_chunk, below_top]. Default: [10, 12, 24]")
				.define("sulfur_ore_config", sulfur_ore_config_list);

		List<Integer> lithium_ore_config_list = new ArrayList<>(3);
		lithium_ore_config_list.addAll(Arrays.asList(7, 12, 24));
		LITHIUM_ORE_CONFIG = builder
				.comment("Configuration for Lithium Ore. Specified as a list. [ore_per_vein, veins_per_chunk, below_top]. Default: [7, 12, 24]")
				.define("lithium_ore_config", lithium_ore_config_list);

		builder.pop();

		builder.pop();
	}

	static {
		Pair<CommonConfig, ForgeConfigSpec> commonConfigForgeConfigSpecPair = new Builder().configure(CommonConfig::new);

		COMMON_SPEC = commonConfigForgeConfigSpecPair.getRight();
		COMMON = commonConfigForgeConfigSpecPair.getLeft();
	}
}