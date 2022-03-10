package com.blackapple769.justenoughdrugz.init;

import com.blackapple769.justenoughdrugz.JustEnoughDrugz;
import com.blackapple769.justenoughdrugz.item.*;
import com.blackapple769.justenoughdrugz.potion.*;
import com.blackapple769.justenoughdrugz.util.CreativeTabSorter;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, JustEnoughDrugz.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, JustEnoughDrugz.MOD_ID);
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, JustEnoughDrugz.MOD_ID);
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, JustEnoughDrugz.MOD_ID);
    public static void init() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);
        EFFECTS.register(modEventBus);

    }

    public static final CreativeModeTab ITEM_GROUP = new CreativeTabSorter("JustEnoughDrugz");
    public static final RegistryObject<Item> ONE_DOLLAR_BILL = ITEMS.register("one_dollar_bill", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> FIVE_DOLLAR_BILL = ITEMS.register("five_dollar_bill", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> TEN_DOLLAR_BILL = ITEMS.register("ten_dollar_bill", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> TWENTY_DOLLAR_BILL = ITEMS.register("twenty_dollar_bill", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> FIFTY_DOLLAR_BILL = ITEMS.register("fifty_dollar_bill", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> HUNDRED_DOLLAR_BILL = ITEMS.register("hundred_dollar_bill", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> WEED = ITEMS.register("weed", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> BAGGIE = ITEMS.register("baggie", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> BLUNT = ITEMS.register("blunt", () -> new BluntItem(new Item.Properties().tab(ITEM_GROUP).durability(5)));
    public static final RegistryObject<Item> WEED_BAGGIE = ITEMS.register("weed_baggie", () -> new Item(new Item.Properties().tab(ITEM_GROUP).craftRemainder(BAGGIE.get())));
    public static final RegistryObject<Item> COCAINE_BAGGIE = ITEMS.register("cocaine_baggie", () -> new Cocaine(new Item.Properties().tab(ITEM_GROUP).craftRemainder(BAGGIE.get())));
    public static final RegistryObject<Item> WEED_EDIBLE = ITEMS.register("weed_edible", () -> new Item(new Item.Properties().tab(ITEM_GROUP).food(Food.WEED_EDIBLE)));
    public static final RegistryObject<Item> GASOLINE = ITEMS.register("gasoline", () -> new Gasoline(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> UNREFINED_OIL = ITEMS.register("unrefined_oil", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> REFINED_OIL = ITEMS.register("refined_oil", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> COCA = ITEMS.register("coca", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> DRIED_COCA = ITEMS.register("dried_coca", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> SODIUM_BICARBONATE = ITEMS.register("sodium_bicarbonate", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> PIPE = ITEMS.register("pipe", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> CRACK_PIPE = ITEMS.register("crack_pipe", () -> new CrackPipe(new Item.Properties().tab(ITEM_GROUP).stacksTo(1)));
    public static final RegistryObject<Item> MARIJUANA_PIPE = ITEMS.register("marijuana_pipe", () -> new MarijuanaPipe(new Item.Properties().tab(ITEM_GROUP).stacksTo(1)));
    public static final RegistryObject<Item> CRACK = ITEMS.register("crack", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> GOLDEN_MARIJUANA_PIPE = ITEMS.register("golden_marijuana_pipe", () -> new MarijuanaPipe(new Item.Properties().tab(ITEM_GROUP).stacksTo(1)));
    public static final RegistryObject<Item> GOLDEN_CRACK_PIPE = ITEMS.register("golden_crack_pipe", () -> new CrackPipe(new Item.Properties().tab(ITEM_GROUP).stacksTo(1)));
    public static final RegistryObject<Item> GOLDEN_PIPE = ITEMS.register("golden_pipe", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> PLASTIC = ITEMS.register("plastic", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> BAGGIE_SHROOMS = ITEMS.register("baggie_shrooms", () -> new Item(new Item.Properties().tab(ITEM_GROUP).craftRemainder(BAGGIE.get())));
    public static final RegistryObject<Item> GOLDEN_CAP_SHROOM = ITEMS.register("golden_cap_shroom", () -> new Item(new Item.Properties().tab(ITEM_GROUP).food(Food.SHROOMS)));
    public static final RegistryObject<Item> EMPTY_SYRINGE = ITEMS.register("empty_syringe", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> HEROINE_SYRINGE = ITEMS.register("heroin_syringe", () -> new Heroin(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> SULFUR = ITEMS.register("sulfur", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> BLUE_METH = ITEMS.register("blue_meth", () -> new BlueMeth(new Item.Properties().tab(ITEM_GROUP).craftRemainder(BAGGIE.get())));
    public static final RegistryObject<Item> ORANGE_METH = ITEMS.register("orange_meth", () -> new CheapMeth(new Item.Properties().tab(ITEM_GROUP).craftRemainder(BAGGIE.get())));
    public static final RegistryObject<Item> CLEAR_METH = ITEMS.register("clear_meth", () -> new ClearMeth(new Item.Properties().tab(ITEM_GROUP).craftRemainder(BAGGIE.get())));
    public static final RegistryObject<Item> GREEN_METH = ITEMS.register("green_meth", () -> new CheapMeth(new Item.Properties().tab(ITEM_GROUP).craftRemainder(BAGGIE.get())));
    public static final RegistryObject<Item> EPHEDRINE = ITEMS.register("ephedrine", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> PURE_EPHEDRINE = ITEMS.register("pure_ephedrine", () -> new Item(new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> UNREFINED_LITHIUM = ITEMS.register("unrefined_lithium", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> REFINED_LITHIUM = ITEMS.register("refined_lithium", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> STYROFOAM_CUP = ITEMS.register("styrofoam_cup", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> LEAN = ITEMS.register("lean", () -> new Lean(new Item.Properties().tab(ITEM_GROUP).durability(2)));
    public static final RegistryObject<Item> SPIRT = ITEMS.register("spirt", () -> new Spirt(new Item.Properties().tab(ITEM_GROUP).durability(2)));
    public static final RegistryObject<Item> COUGH_SYRUP = ITEMS.register("cough_syrup", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> DRIED_COFFEE_BEANS = ITEMS.register("dried_coffee_beans", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryObject<Item> BLUE_METH_SYRINGE = ITEMS.register("blue_meth_syringe", () -> new BlueMethSyringe(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> CLEAR_METH_SYRINGE = ITEMS.register("clear_meth_syringe", () -> new ClearMethSyringe(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> CHEAP_METH_SYRINGE = ITEMS.register("cheap_meth_syringe", () -> new CheapMethSyringe(new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryObject<Item> BLUE_METH_PIPE = ITEMS.register("blue_meth_pipe", () -> new BlueMethPipe(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> CLEAR_METH_PIPE = ITEMS.register("clear_meth_pipe", () -> new ClearMethPipe(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> CHEAP_METH_PIPE = ITEMS.register("cheap_meth_pipe", () -> new CheapMethPipe(new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryObject<Item> GOLDEN_BLUE_METH_PIPE = ITEMS.register("golden_blue_meth_pipe", () -> new BlueMethPipe(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> GOLDEN_CLEAR_METH_PIPE = ITEMS.register("golden_clear_meth_pipe", () -> new ClearMethPipe(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> GOLDEN_CHEAP_METH_PIPE = ITEMS.register("golden_cheap_meth_pipe", () -> new CheapMethPipe(new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryObject<Item> CHEAP_METH_VILE = ITEMS.register("cheap_meth_vile", () -> new CheapMethSyringe(new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> BLUE_METH_VILE = ITEMS.register("blue_meth_vile", () -> new BlueMethSyringe(new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> CLEAR_METH_VILE = ITEMS.register("clear_meth_vile", () -> new ClearMethSyringe(new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.GLASS_BOTTLE)));

    public static final RegistryObject<Item> EMPTY_PILL_BOTTLE = ITEMS.register("empty_pill_bottle", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> PERCS_PILL_BOTTLE = ITEMS.register("percs_pill_bottle", () -> new Percocets(new Item.Properties().tab(ITEM_GROUP).durability(4)));

    //public static final RegistryObject<Block> GROW_LAMP = BLOCKS.register("grow_lamp", () -> new GrowLight(BlockBehaviour.Properties.of(Material.METAL).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));

    public static final RegistryObject<Block> WEED_PLANT = BLOCKS.register("weed_plant", () -> new CropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> COCA_PLANT = BLOCKS.register("coca_plant", () -> new CropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> COFFEE_PLANT = BLOCKS.register("coffee_plant", () -> new CropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    
    public static final RegistryObject<FlowerBlock> GOLDEN_CAP_MUSHROOM = BLOCKS.register("golden_cap_mushroom", () -> new FlowerBlock(MobEffects.CONFUSION, 600, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<FlowerBlock> EPHEDRA_PLANT = BLOCKS.register("ephedra_plant", () -> new FlowerBlock(MobEffects.CONFUSION, 600, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));

    public static final RegistryObject<OreBlock> SODIUM_BICARBONATE_ORE = BLOCKS.register("sodium_bicarbonate_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.0f, 1.0f)));
    public static final RegistryObject<OreBlock> OIL_ORE = BLOCKS.register("oil_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.0f, 1.0f)));
    public static final RegistryObject<OreBlock> SULFUR_ORE = BLOCKS.register("sulfur_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.0f, 1.0f)));
    public static final RegistryObject<OreBlock> LITHIUM_ORE = BLOCKS.register("lithium_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.0f, 1.0f)));

    //public static final RegistryObject<BlockItem> GROW_LAMP_ITEM = ITEMS.register("grow_lamp_item", () -> new BlockItem(GROW_LAMP.get(), new Properties().tab(ITEM_GROUP)));

    public static final RegistryObject<BlockItem> COFFEE_BEANS = ITEMS.register("coffee_beans", () -> new BlockItem(COFFEE_PLANT.get(), new Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> WEED_SEED = ITEMS.register("weed_seed", () -> new BlockItem(WEED_PLANT.get(), new Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> COCA_SEEDS = ITEMS.register("coca_seeds", () -> new BlockItem(COCA_PLANT.get(), new Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> OIL_ORE_ITEM = ITEMS.register("oil_ore_item", () -> new BlockItem(OIL_ORE.get(), new Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> GOLDEN_CAP_MUSHROOM_ITEM = ITEMS.register("golden_cap_mushroom_item", () -> new BlockItem(GOLDEN_CAP_MUSHROOM.get(), new Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> SODIUM_BICARBONATE_ORE_ITEM = ITEMS.register("sodium_bicarbonate_ore_item", () -> new BlockItem(SODIUM_BICARBONATE_ORE.get(), new Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> EPHEDRA_PLANT_ITEM = ITEMS.register("ephedra_plant_item", () -> new BlockItem(EPHEDRA_PLANT.get(), new Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> SULFUR_ORE_ITEM = ITEMS.register("sulfur_ore_item", () -> new BlockItem(SULFUR_ORE.get(), new Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> LITHIUM_ORE_ITEM = ITEMS.register("lithium_ore_item", () -> new BlockItem(LITHIUM_ORE.get(), new Properties().tab(ITEM_GROUP)));

    public static final RegistryObject<MethEffect> METH_EFFECT = EFFECTS.register("meth_effect", () -> new MethEffect(MobEffectCategory.NEUTRAL, 3484189));
    public static final RegistryObject<LeanEffect> LEAN_EFFECT = EFFECTS.register("lean_effect", () -> new LeanEffect(MobEffectCategory.NEUTRAL, 3484189));
    public static final RegistryObject<CaffeineEffect> CAFFEINE_EFFECT = EFFECTS.register("caffeine_effect", () -> new CaffeineEffect(MobEffectCategory.NEUTRAL, 3484189));

    public static final RegistryObject<MorphineEffect> MORPHINE_EFFECT = EFFECTS.register("morphine_effect", () -> new MorphineEffect(MobEffectCategory.NEUTRAL, 3484189));
    public static final RegistryObject<PercocetsEffect> PERC_EFFECT = EFFECTS.register("perc_effect", () -> new PercocetsEffect(MobEffectCategory.NEUTRAL, 3484189));
}