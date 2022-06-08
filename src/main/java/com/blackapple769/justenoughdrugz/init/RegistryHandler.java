package com.blackapple769.justenoughdrugz.init;

import com.blackapple769.justenoughdrugz.JustEnoughDrugz;
import com.blackapple769.justenoughdrugz.item.*;
import com.blackapple769.justenoughdrugz.potion.*;
import com.blackapple769.justenoughdrugz.util.CreativeTabSorter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.sounds.SoundEvent;


@SuppressWarnings("unused")
public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "justenoughdrugz");

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "justenoughdrugz");

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "justenoughdrugz");

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, JustEnoughDrugz.MOD_ID);


    public static void init() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);
        EFFECTS.register(modEventBus);
        SOUND_EVENTS.register(modEventBus);

    }

    public static final CreativeModeTab ITEM_GROUP = new CreativeTabSorter("JustEnoughDrugz");

    //items
    public static final RegistryObject<Item> ONE_DOLLAR_BILL = ITEMS.register("one_dollar_bill", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> FIVE_DOLLAR_BILL = ITEMS.register("five_dollar_bill", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> TEN_DOLLAR_BILL = ITEMS.register("ten_dollar_bill", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> TWENTY_DOLLAR_BILL = ITEMS.register("twenty_dollar_bill", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> FIFTY_DOLLAR_BILL = ITEMS.register("fifty_dollar_bill", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> HUNDRED_DOLLAR_BILL = ITEMS.register("hundred_dollar_bill", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> WEED = ITEMS.register("weed", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> BAGGIE = ITEMS.register("baggie", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> BLUNT = ITEMS.register("blunt", () -> new BluntItem((new Item.Properties()).tab(ITEM_GROUP).durability(5)));
    public static final RegistryObject<Item> WEED_BAGGIE = ITEMS.register("weed_baggie", () -> new Item((new Item.Properties()).tab(ITEM_GROUP).craftRemainder(BAGGIE.get())));
    public static final RegistryObject<Item> COCAINE_BAGGIE = ITEMS.register("cocaine_baggie", () -> new Cocaine((new Item.Properties()).tab(ITEM_GROUP).craftRemainder(BAGGIE.get())));
    public static final RegistryObject<Item> WEED_EDIBLE = ITEMS.register("weed_edible", () -> new WeedEdible((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> GASOLINE = ITEMS.register("gasoline", () -> new Gasoline((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> UNREFINED_OIL = ITEMS.register("unrefined_oil", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> REFINED_OIL = ITEMS.register("refined_oil", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> COCA = ITEMS.register("coca", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> DRIED_COCA = ITEMS.register("dried_coca", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> SODIUM_BICARBONATE = ITEMS.register("sodium_bicarbonate", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> PIPE = ITEMS.register("pipe", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> CRACK = ITEMS.register("crack", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> GOLDEN_MARIJUANA_PIPE = ITEMS.register("golden_marijuana_pipe", () -> new MarijuanaPipe((new Item.Properties()).tab(ITEM_GROUP).stacksTo(1)));
    public static final RegistryObject<Item> GOLDEN_CRACK_PIPE = ITEMS.register("golden_crack_pipe", () -> new CrackPipe((new Item.Properties()).tab(ITEM_GROUP).stacksTo(1)));
    public static final RegistryObject<Item> GOLDEN_PIPE = ITEMS.register("golden_pipe", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> PLASTIC = ITEMS.register("plastic", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> BAGGIE_SHROOMS = ITEMS.register("baggie_shrooms", () -> new Item((new Item.Properties()).tab(ITEM_GROUP).craftRemainder(BAGGIE.get())));
    public static final RegistryObject<Item> GOLDEN_CAP_SHROOM = ITEMS.register("golden_cap_shroom", () -> new Shroom((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> SULFUR = ITEMS.register("sulfur", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> BLUE_METH = ITEMS.register("blue_meth", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP).craftRemainder(BAGGIE.get()), 800, 4, BAGGIE.get()));
    public static final RegistryObject<Item> ORANGE_METH = ITEMS.register("orange_meth", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP).craftRemainder(BAGGIE.get()), 200, 0, BAGGIE.get()));
    public static final RegistryObject<Item> CLEAR_METH = ITEMS.register("clear_meth", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP).craftRemainder(BAGGIE.get()), 400, 2, BAGGIE.get()));
    public static final RegistryObject<Item> GREEN_METH = ITEMS.register("green_meth", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP).craftRemainder(BAGGIE.get()), 200, 0, BAGGIE.get()));
    public static final RegistryObject<Item> EPHEDRINE = ITEMS.register("ephedrine", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> PURE_EPHEDRINE = ITEMS.register("pure_ephedrine", () -> new Item((new Item.Properties()).tab(ITEM_GROUP).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> UNREFINED_LITHIUM = ITEMS.register("unrefined_lithium", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> REFINED_LITHIUM = ITEMS.register("refined_lithium", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> STYROFOAM_CUP = ITEMS.register("styrofoam_cup", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> LEAN = ITEMS.register("lean", () -> new Lean((new Item.Properties()).tab(ITEM_GROUP).durability(2)));
    public static final RegistryObject<Item> SPIRT = ITEMS.register("spirt", () -> new Spirt((new Item.Properties()).tab(ITEM_GROUP).durability(2)));
    public static final RegistryObject<Item> CUP_OF_COFFEE = ITEMS.register("cup_of_coffee", () -> new CupOfCoffee((new Item.Properties()).tab(ITEM_GROUP).durability(5)));
    public static final RegistryObject<Item> COUGH_SYRUP = ITEMS.register("cough_syrup", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> DRIED_COFFEE_BEANS = ITEMS.register("dried_coffee_beans", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> MIMOSA_HOSTILIS_BARK = ITEMS.register("mimosa_hostilis_bark", () -> new MimosaBark((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> DMT = ITEMS.register("dmt", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> EMPTY_SYRINGE = ITEMS.register("empty_syringe", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> BLUE_METH_SYRINGE = ITEMS.register("blue_meth_syringe", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP), 1600, 4, EMPTY_SYRINGE.get()));
    public static final RegistryObject<Item> CLEAR_METH_SYRINGE = ITEMS.register("clear_meth_syringe", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP), 800, 4, EMPTY_SYRINGE.get()));
    public static final RegistryObject<Item> CHEAP_METH_SYRINGE = ITEMS.register("cheap_meth_syringe", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP), 400, 2, EMPTY_SYRINGE.get()));
    public static final RegistryObject<Item> DMT_SYRINGE = ITEMS.register("dmt_syringe", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP), 400, 4, EMPTY_SYRINGE.get()));
    public static final RegistryObject<Item> HEROINE_SYRINGE = ITEMS.register("heroin_syringe", () -> new Heroin((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> BLUE_METH_PIPE = ITEMS.register("blue_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP).stacksTo(1), 800, 3, PIPE.get()));
    public static final RegistryObject<Item> CLEAR_METH_PIPE = ITEMS.register("clear_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP).stacksTo(1), 600, 2, PIPE.get()));
    public static final RegistryObject<Item> CHEAP_METH_PIPE = ITEMS.register("cheap_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP).stacksTo(1), 400, 1, PIPE.get()));
    public static final RegistryObject<Item> CRACK_PIPE = ITEMS.register("crack_pipe", () -> new CrackPipe((new Item.Properties()).tab(ITEM_GROUP).stacksTo(1)));
    public static final RegistryObject<Item> MARIJUANA_PIPE = ITEMS.register("marijuana_pipe", () -> new MarijuanaPipe((new Item.Properties()).tab(ITEM_GROUP).stacksTo(1)));
    public static final RegistryObject<Item> DMT_PIPE = ITEMS.register("dmt_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP).stacksTo(1), 400, 2, PIPE.get()));
    public static final RegistryObject<Item> GOLDEN_BLUE_METH_PIPE = ITEMS.register("golden_blue_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP), 800, 3, GOLDEN_PIPE.get()));
    public static final RegistryObject<Item> GOLDEN_CLEAR_METH_PIPE = ITEMS.register("golden_clear_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP), 600, 2, GOLDEN_PIPE.get()));
    public static final RegistryObject<Item> GOLDEN_CHEAP_METH_PIPE = ITEMS.register("golden_cheap_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP), 400, 1, GOLDEN_PIPE.get()));
    public static final RegistryObject<Item> GOLDEN_DMT_PIPE = ITEMS.register("golden_dmt_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP).stacksTo(1), 400, 2, GOLDEN_PIPE.get()));
    public static final RegistryObject<Item> CHEAP_METH_VILE = ITEMS.register("cheap_meth_vile", () -> new Item((new Item.Properties()).tab(ITEM_GROUP).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> BLUE_METH_VILE = ITEMS.register("blue_meth_vile", () -> new Item((new Item.Properties()).tab(ITEM_GROUP).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> CLEAR_METH_VILE = ITEMS.register("clear_meth_vile", () -> new Item((new Item.Properties()).tab(ITEM_GROUP).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> DMT_VILE = ITEMS.register("dmt_vile", () -> new Item((new Item.Properties()).tab(ITEM_GROUP).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> EMPTY_PILL_BOTTLE = ITEMS.register("empty_pill_bottle", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> PERCS_PILL_BOTTLE = ITEMS.register("percs_pill_bottle", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP).durability(4), 650, 3, EMPTY_PILL_BOTTLE.get()));
    public static final RegistryObject<Item> EPHEDRA_BERRIES = ITEMS.register("ephedra_berries", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> BLUE_BONG = ITEMS.register("blue_bong", () -> new Bong((new Item.Properties()).tab(ITEM_GROUP).durability(3)));
    public static final RegistryObject<Item> RED_BONG = ITEMS.register("red_bong", () -> new Bong((new Item.Properties()).tab(ITEM_GROUP).durability(3)));
    public static final RegistryObject<Item> GREEN_BONG = ITEMS.register("green_bong", () -> new Bong((new Item.Properties()).tab(ITEM_GROUP).durability(3)));
    public static final RegistryObject<Item> PINK_BONG = ITEMS.register("pink_bong", () -> new Bong((new Item.Properties()).tab(ITEM_GROUP).durability(3)));


    //block
    public static final RegistryObject<Block> PLANTABLE_EPHEDRA = BLOCKS.register("plantable_ephedra", () -> new CropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> WEED_PLANT = BLOCKS.register("weed_plant", () -> new CropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> COCA_PLANT = BLOCKS.register("coca_plant", () -> new CropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> COFFEE_PLANT = BLOCKS.register("coffee_plant", () -> new CropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<FlowerBlock> MIMOSA_HOSTILIS_PLANT = BLOCKS.register("mimosa_hostilis_plant", () -> new FlowerBlock(MobEffects.CONFUSION, 600, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<FlowerBlock> GOLDEN_CAP_MUSHROOM = BLOCKS.register("golden_cap_mushroom", () -> new FlowerBlock(MobEffects.CONFUSION, 600, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<FlowerBlock> EPHEDRA_PLANT = BLOCKS.register("ephedra_plant", () -> new FlowerBlock(MobEffects.CONFUSION, 600, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<OreBlock> SODIUM_BICARBONATE_ORE = BLOCKS.register("sodium_bicarbonate_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.0F, 1.0F)));
    public static final RegistryObject<OreBlock> OIL_ORE = BLOCKS.register("oil_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.0F, 1.0F)));
    public static final RegistryObject<OreBlock> SULFUR_ORE = BLOCKS.register("sulfur_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.0F, 1.0F)));
    public static final RegistryObject<OreBlock> LITHIUM_ORE = BLOCKS.register("lithium_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.0F, 1.0F)));

    //blockItems
    public static final RegistryObject<BlockItem> COFFEE_BEANS = ITEMS.register("coffee_beans", () -> new BlockItem(COFFEE_PLANT.get(), (new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> WEED_SEED = ITEMS.register("weed_seed", () -> new BlockItem(WEED_PLANT.get(), (new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> EPHEDRA_ROOT = ITEMS.register("ephedra_root", () -> new BlockItem(PLANTABLE_EPHEDRA.get(), (new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> COCA_SEEDS = ITEMS.register("coca_seeds", () -> new BlockItem(COCA_PLANT.get(), (new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> OIL_ORE_ITEM = ITEMS.register("oil_ore_item", () -> new BlockItem(OIL_ORE.get(), (new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> GOLDEN_CAP_MUSHROOM_ITEM = ITEMS.register("golden_cap_mushroom_item", () -> new BlockItem(GOLDEN_CAP_MUSHROOM.get(), (new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> SODIUM_BICARBONATE_ORE_ITEM = ITEMS.register("sodium_bicarbonate_ore_item", () -> new BlockItem(SODIUM_BICARBONATE_ORE.get(), (new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> EPHEDRA_PLANT_ITEM = ITEMS.register("ephedra_plant_item", () -> new BlockItem(EPHEDRA_PLANT.get(), (new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> SULFUR_ORE_ITEM = ITEMS.register("sulfur_ore_item", () -> new BlockItem(SULFUR_ORE.get(), (new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> LITHIUM_ORE_ITEM = ITEMS.register("lithium_ore_item", () -> new BlockItem(LITHIUM_ORE.get(), (new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> MIMOSA_HOSTILIS_PLANT_ITEM = ITEMS.register("mimosa_hostilis_plant_item", () -> new BlockItem(MIMOSA_HOSTILIS_PLANT.get(), (new Item.Properties()).tab(ITEM_GROUP)));

    //effects
    public static final RegistryObject<MethEffect> METH_EFFECT = EFFECTS.register("meth_effect", () -> new MethEffect(MobEffectCategory.NEUTRAL, 3484189));
    public static final RegistryObject<LeanEffect> LEAN_EFFECT = EFFECTS.register("lean_effect", () -> new LeanEffect(MobEffectCategory.NEUTRAL, 3484189));
    public static final RegistryObject<CaffeineEffect> CAFFEINE_EFFECT = EFFECTS.register("caffeine_effect", () -> new CaffeineEffect(MobEffectCategory.NEUTRAL, 3484189));
    public static final RegistryObject<MorphineEffect> MORPHINE_EFFECT = EFFECTS.register("morphine_effect", () -> new MorphineEffect(MobEffectCategory.NEUTRAL, 3484189));
    public static final RegistryObject<DmtEffect> DMT_EFFECT = EFFECTS.register("dmt_effect", () -> new DmtEffect(MobEffectCategory.NEUTRAL, 3484189));
    public static final RegistryObject<WeedEffect> WEED_EFFECT = EFFECTS.register("weed_effect", () -> new WeedEffect(MobEffectCategory.NEUTRAL, 3484189));
    public static final RegistryObject<PercocetsEffect> PERC_EFFECT = EFFECTS.register("perc_effect", () -> new PercocetsEffect(MobEffectCategory.NEUTRAL, 3484189));
    public static final RegistryObject<ShroomEffect> SHROOM_EFFECT = EFFECTS.register("shroom_effect", () -> new ShroomEffect(MobEffectCategory.NEUTRAL, 3484189));
    public static final RegistryObject<CokeEffect> COKE_EFFECT = EFFECTS.register("coke_effect", () -> new CokeEffect(MobEffectCategory.NEUTRAL, 3484189));


    //sounds
    public static final RegistryObject<SoundEvent> BONG_USE_EFFECT = SOUND_EVENTS.register("bong_use_effect", () -> new SoundEvent(new ResourceLocation(JustEnoughDrugz.MOD_ID, "bong_use")));
    public static final RegistryObject<SoundEvent> USED_UP_BONG = SOUND_EVENTS.register("used_up_bong", () -> new SoundEvent(new ResourceLocation(JustEnoughDrugz.MOD_ID, "used_up_bong")));

}