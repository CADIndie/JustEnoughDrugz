package com.blackapple769.justenoughdrugz.init;

import com.blackapple769.justenoughdrugz.JustEnoughDrugz;
import com.blackapple769.justenoughdrugz.block.Flask;
import com.blackapple769.justenoughdrugz.block.FlaskEntity;
import com.blackapple769.justenoughdrugz.block.Pan;
import com.blackapple769.justenoughdrugz.block.PanEntity;
import com.blackapple769.justenoughdrugz.item.*;
import com.blackapple769.justenoughdrugz.item.armor.HazmatArmorItem;
import com.blackapple769.justenoughdrugz.item.materials.CustomArmorMaterials;
import com.blackapple769.justenoughdrugz.potion.*;
import com.blackapple769.justenoughdrugz.util.CreativeTabSorter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.google.common.collect.Sets;
import net.minecraft.sounds.SoundEvent;


@SuppressWarnings("unused")
public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "justenoughdrugz");

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "justenoughdrugz");

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "justenoughdrugz");

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, JustEnoughDrugz.MOD_ID);

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, JustEnoughDrugz.MOD_ID);

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, JustEnoughDrugz.MOD_ID);

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, JustEnoughDrugz.MOD_ID);


    public static void init() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);
        ENTITY_TYPES.register(modEventBus);
        EFFECTS.register(modEventBus);
        SOUND_EVENTS.register(modEventBus);
        BLOCK_ENTITIES.register(modEventBus);
        POTIONS.register(modEventBus);

    }

    public static final CreativeModeTab ITEM_GROUP = new CreativeTabSorter("JustEnoughDrugz");
    public static final CreativeModeTab METH_GROUP = new CreativeTabSorter("JustEnoughDrugzMeth");

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
    public static final RegistryObject<Item> GOLDEN_PIPE = ITEMS.register("golden_pipe", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> CRACK = ITEMS.register("crack", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> GOLDEN_MARIJUANA_PIPE = ITEMS.register("golden_marijuana_pipe", () -> new MarijuanaPipe((new Item.Properties()).tab(ITEM_GROUP).stacksTo(1)));
    public static final RegistryObject<Item> GOLDEN_CRACK_PIPE = ITEMS.register("golden_crack_pipe", () -> new CrackPipe((new Item.Properties()).tab(ITEM_GROUP).stacksTo(1)));
    public static final RegistryObject<Item> PLASTIC = ITEMS.register("plastic", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> BAGGIE_SHROOMS = ITEMS.register("baggie_shrooms", () -> new Item((new Item.Properties()).tab(ITEM_GROUP).craftRemainder(BAGGIE.get())));
    public static final RegistryObject<Item> GOLDEN_CAP_SHROOM = ITEMS.register("golden_cap_shroom", () -> new Shroom((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> STYROFOAM_CUP = ITEMS.register("styrofoam_cup", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> LEAN = ITEMS.register("lean", () -> new Lean((new Item.Properties()).tab(ITEM_GROUP).durability(2)));
    public static final RegistryObject<Item> SPIRT = ITEMS.register("spirt", () -> new Spirt((new Item.Properties()).tab(ITEM_GROUP).durability(2)));
    public static final RegistryObject<Item> CUP_OF_COFFEE = ITEMS.register("cup_of_coffee", () -> new CupOfCoffee((new Item.Properties()).tab(ITEM_GROUP).durability(5)));
    public static final RegistryObject<Item> COUGH_SYRUP = ITEMS.register("cough_syrup", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> DRIED_COFFEE_BEANS = ITEMS.register("dried_coffee_beans", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> MIMOSA_HOSTILIS_BARK = ITEMS.register("mimosa_hostilis_bark", () -> new MimosaBark((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> DMT = ITEMS.register("dmt", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> EMPTY_SYRINGE = ITEMS.register("empty_syringe", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> DMT_SYRINGE = ITEMS.register("dmt_syringe", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP), 400, 4, EMPTY_SYRINGE.get()));
    public static final RegistryObject<Item> HEROINE_SYRINGE = ITEMS.register("heroin_syringe", () -> new Heroin((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> CRACK_PIPE = ITEMS.register("crack_pipe", () -> new CrackPipe((new Item.Properties()).tab(ITEM_GROUP).stacksTo(1)));
    public static final RegistryObject<Item> MARIJUANA_PIPE = ITEMS.register("marijuana_pipe", () -> new MarijuanaPipe((new Item.Properties()).tab(ITEM_GROUP).stacksTo(1)));
    public static final RegistryObject<Item> DMT_PIPE = ITEMS.register("dmt_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP).stacksTo(1), 400, 2, PIPE.get()));
    public static final RegistryObject<Item> GOLDEN_DMT_PIPE = ITEMS.register("golden_dmt_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP).stacksTo(1), 400, 2, GOLDEN_PIPE.get()));
    public static final RegistryObject<Item> DMT_VILE = ITEMS.register("dmt_vile", () -> new Item((new Item.Properties()).tab(ITEM_GROUP).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> EMPTY_PILL_BOTTLE = ITEMS.register("empty_pill_bottle", () -> new Item((new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<Item> PERCS_PILL_BOTTLE = ITEMS.register("percs_pill_bottle", () -> new GenericEffectItem((new Item.Properties()).tab(ITEM_GROUP).durability(4), 650, 3, EMPTY_PILL_BOTTLE.get()));

    //bongs
    public static final RegistryObject<Item> BLUE_BONG = ITEMS.register("blue_bong", () -> new Bong((new Item.Properties()).tab(ITEM_GROUP).durability(3)));
    public static final RegistryObject<Item> RED_BONG = ITEMS.register("red_bong", () -> new Bong((new Item.Properties()).tab(ITEM_GROUP).durability(3)));
    public static final RegistryObject<Item> GREEN_BONG = ITEMS.register("green_bong", () -> new Bong((new Item.Properties()).tab(ITEM_GROUP).durability(3)));
    public static final RegistryObject<Item> PINK_BONG = ITEMS.register("pink_bong", () -> new Bong((new Item.Properties()).tab(ITEM_GROUP).durability(3)));
    public static final RegistryObject<Item> YELLOW_BONG = ITEMS.register("yellow_bong", () -> new Bong((new Item.Properties()).tab(ITEM_GROUP).durability(3)));

    //meth syringes
    public static final RegistryObject<Item> HIGH_QUALITY_BLUE_METH_SYRINGE = ITEMS.register("high_quality_blue_meth_syringe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP), 1000, 8, EMPTY_SYRINGE.get()));
    public static final RegistryObject<Item> MEDIUM_QUALITY_BLUE_METH_SYRINGE = ITEMS.register("medium_quality_blue_meth_syringe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP), 1000, 7, EMPTY_SYRINGE.get()));
    public static final RegistryObject<Item> HIGH_QUALITY_METH_SYRINGE = ITEMS.register("high_quality_meth_syringe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP), 850, 5, EMPTY_SYRINGE.get()));
    public static final RegistryObject<Item> MEDIUM_QUALITY_METH_SYRINGE = ITEMS.register("medium_quality_meth_syringe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP), 850, 4, EMPTY_SYRINGE.get()));
    public static final RegistryObject<Item> LOW_QUALITY_METH_SYRINGE = ITEMS.register("low_quality_meth_syringe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP), 850, 3, EMPTY_SYRINGE.get()));
    public static final RegistryObject<Item> UNDERCOOKED_METH_SYRINGE = ITEMS.register("undercooked_meth_syringe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP), 200, 1, EMPTY_SYRINGE.get()));
    public static final RegistryObject<Item> BURNT_METH_SYRINGE = ITEMS.register("burnt_meth_syringe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP), 400, 1, EMPTY_SYRINGE.get()));

    //meth pipes
    public static final RegistryObject<Item> HIGH_QUALITY_BLUE_METH_PIPE = ITEMS.register("high_quality_blue_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).stacksTo(1), 900, 6, PIPE.get()));
    public static final RegistryObject<Item> MEDIUM_QUALITY_BLUE_METH_PIPE = ITEMS.register("medium_quality_blue_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).stacksTo(1), 900, 5, PIPE.get()));
    public static final RegistryObject<Item> HIGH_QUALITY_METH_PIPE = ITEMS.register("high_quality_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).stacksTo(1), 800, 4, PIPE.get()));
    public static final RegistryObject<Item> MEDIUM_QUALITY_METH_PIPE = ITEMS.register("medium_quality_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).stacksTo(1), 800, 3, PIPE.get()));
    public static final RegistryObject<Item> LOW_QUALITY_METH_PIPE = ITEMS.register("low_quality_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).stacksTo(1), 800, 2, PIPE.get()));
    public static final RegistryObject<Item> UNDERCOOKED_METH_PIPE = ITEMS.register("undercooked_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).stacksTo(1), 200, 1, PIPE.get()));
    public static final RegistryObject<Item> BURNT_METH_PIPE = ITEMS.register("burnt_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).stacksTo(1), 400, 1, PIPE.get()));


    public static final RegistryObject<Item> GOLDEN_HIGH_QUALITY_BLUE_METH_PIPE = ITEMS.register("golden_high_quality_blue_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).stacksTo(1), 900, 6, PIPE.get()));
    public static final RegistryObject<Item> GOLDEN_MEDIUM_QUALITY_BLUE_METH_PIPE = ITEMS.register("golden_medium_quality_blue_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).stacksTo(1), 900, 5, PIPE.get()));
    public static final RegistryObject<Item> GOLDEN_HIGH_QUALITY_METH_PIPE = ITEMS.register("golden_high_quality_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).stacksTo(1), 800, 4, PIPE.get()));
    public static final RegistryObject<Item> GOLDEN_MEDIUM_QUALITY_METH_PIPE = ITEMS.register("golden_medium_quality_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).stacksTo(1), 800, 3, PIPE.get()));
    public static final RegistryObject<Item> GOLDEN_LOW_QUALITY_METH_PIPE = ITEMS.register("golden_low_quality_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).stacksTo(1), 800, 2, PIPE.get()));
    public static final RegistryObject<Item> GOLDEN_UNDERCOOKED_METH_PIPE = ITEMS.register("golden_undercooked_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).stacksTo(1), 200, 1, PIPE.get()));
    public static final RegistryObject<Item> GOLDEN_BURNT_METH_PIPE = ITEMS.register("golden_burnt_meth_pipe", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).stacksTo(1), 400, 1, PIPE.get()));

    //meth vials
    public static final RegistryObject<Item> HIGH_QUALITY_BLUE_METH_VIAL = ITEMS.register("high_quality_blue_meth_vial", () -> new Item((new Item.Properties()).tab(METH_GROUP).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> MEDIUM_QUALITY_BLUE_METH_VIAL = ITEMS.register("medium_quality_blue_meth_vial", () -> new Item((new Item.Properties()).tab(METH_GROUP).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> HIGH_QUALITY_METH_VIAL = ITEMS.register("high_quality_meth_vial", () -> new Item((new Item.Properties()).tab(METH_GROUP).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> MEDIUM_QUALITY_METH_VIAL = ITEMS.register("medium_quality_meth_vial", () -> new Item((new Item.Properties()).tab(METH_GROUP).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> LOW_QUALITY_METH_VIAL = ITEMS.register("low_quality_meth_vial", () -> new Item((new Item.Properties()).tab(METH_GROUP).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> BURNT_METH_VIAL = ITEMS.register("burnt_meth_vial", () -> new Item((new Item.Properties()).tab(METH_GROUP).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> UNDERCOOKED_METH_VIAL = ITEMS.register("undercooked_meth_vial", () -> new Item((new Item.Properties()).tab(METH_GROUP).craftRemainder(Items.GLASS_BOTTLE)));

    //meth
    public static final RegistryObject<Item> HIGH_QUALITY_BLUE_METH = ITEMS.register("high_quality_blue_meth", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).craftRemainder(BAGGIE.get()), 1200, 7, BAGGIE.get()));
    public static final RegistryObject<Item> MEDIUM_QUALITY_BLUE_METH = ITEMS.register("medium_quality_blue_meth", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).craftRemainder(BAGGIE.get()), 1200, 6, BAGGIE.get()));
    public static final RegistryObject<Item> HIGH_QUALITY_METH = ITEMS.register("high_quality_meth", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).craftRemainder(BAGGIE.get()), 1000, 4, BAGGIE.get()));
    public static final RegistryObject<Item> MEDIUM_QUALITY_METH = ITEMS.register("medium_quality_meth", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).craftRemainder(BAGGIE.get()), 1000, 3, BAGGIE.get()));
    public static final RegistryObject<Item> LOW_QUALITY_METH = ITEMS.register("low_quality_meth", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).craftRemainder(BAGGIE.get()), 1000, 2, BAGGIE.get()));
    public static final RegistryObject<Item> BURNT_METH = ITEMS.register("burnt_meth", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).craftRemainder(BAGGIE.get()), 400, 1, BAGGIE.get()));
    public static final RegistryObject<Item> UNDERCOOKED_METH = ITEMS.register("undercooked_meth", () -> new GenericEffectItem((new Item.Properties()).tab(METH_GROUP).craftRemainder(BAGGIE.get()), 800, 1, BAGGIE.get()));

    //meth sludge
    public static final RegistryObject<Item> HIGH_QUALITY_BLUE_METH_SLUDGE = ITEMS.register("high_quality_blue_meth_sludge", () -> new Item((new Item.Properties()).tab(METH_GROUP)));
    public static final RegistryObject<Item> MEDIUM_QUALITY_BLUE_METH_SLUDGE = ITEMS.register("medium_quality_blue_meth_sludge", () -> new Item((new Item.Properties()).tab(METH_GROUP)));
    public static final RegistryObject<Item> BURNT_METH_SLUDGE = ITEMS.register("burnt_meth_sludge", () -> new Item((new Item.Properties()).tab(METH_GROUP)));
    public static final RegistryObject<Item> UNDERCOOKED_METH_SLUDGE = ITEMS.register("undercooked_meth_sludge", () -> new Item((new Item.Properties()).tab(METH_GROUP)));
    public static final RegistryObject<Item> HIGH_QUALITY_METH_SLUDGE = ITEMS.register("high_quality_meth_sludge", () -> new Item((new Item.Properties()).tab(METH_GROUP)));
    public static final RegistryObject<Item> MEDIUM_QUALITY_METH_SLUDGE = ITEMS.register("medium_quality_meth_sludge", () -> new Item((new Item.Properties()).tab(METH_GROUP)));
    public static final RegistryObject<Item> LOW_QUALITY_METH_SLUDGE = ITEMS.register("low_quality_meth_sludge", () -> new Item((new Item.Properties()).tab(METH_GROUP)));

    //meth chemicals
    public static final RegistryObject<Item> EPHEDRA_BERRIES = ITEMS.register("ephedra_berries", () -> new Item((new Item.Properties()).tab(METH_GROUP)));
    public static final RegistryObject<Item> RED_PHOSPHORUS = ITEMS.register("red_phosphorus", () -> new Item((new Item.Properties()).tab(METH_GROUP)));
    public static final RegistryObject<Item> METHYLAMINE = ITEMS.register("methylamine", () -> new Item((new Item.Properties()).tab(METH_GROUP)));
    public static final RegistryObject<Item> EPHEDRINE = ITEMS.register("ephedrine", () -> new Item((new Item.Properties()).tab(METH_GROUP)));
    public static final RegistryObject<Item> PURE_EPHEDRINE = ITEMS.register("pure_ephedrine", () -> new Item((new Item.Properties()).tab(METH_GROUP).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> UNREFINED_LITHIUM = ITEMS.register("unrefined_lithium", () -> new Item((new Item.Properties()).tab(METH_GROUP)));
    public static final RegistryObject<Item> REFINED_LITHIUM = ITEMS.register("refined_lithium", () -> new Item((new Item.Properties()).tab(METH_GROUP)));
    public static final RegistryObject<Item> SULFUR = ITEMS.register("sulfur", () -> new Item((new Item.Properties()).tab(METH_GROUP)));


    //armor
    public static final RegistryObject<HazmatArmorItem> HAZMAT_MASK = ITEMS.register("hazmat_mask", () -> new HazmatArmorItem(CustomArmorMaterials.PLASTIC, EquipmentSlot.HEAD, 1));
    public static final RegistryObject<HazmatArmorItem> HAZMAT_SHIRT = ITEMS.register("hazmat_shirt", () -> new HazmatArmorItem(CustomArmorMaterials.PLASTIC, EquipmentSlot.CHEST, 1));
    public static final RegistryObject<HazmatArmorItem> HAZMAT_LEGGINGS = ITEMS.register("hazmat_leggings", () -> new HazmatArmorItem(CustomArmorMaterials.PLASTIC, EquipmentSlot.LEGS, 2));
    public static final RegistryObject<HazmatArmorItem> HAZMAT_SHOES = ITEMS.register("hazmat_shoes", () -> new HazmatArmorItem(CustomArmorMaterials.PLASTIC, EquipmentSlot.FEET, 1));



    //block
    public static final RegistryObject<FlowerBlock> MIMOSA_HOSTILIS_PLANT = BLOCKS.register("mimosa_hostilis_plant", () -> new FlowerBlock(MobEffects.CONFUSION, 600, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<FlowerBlock> GOLDEN_CAP_MUSHROOM = BLOCKS.register("golden_cap_mushroom", () -> new FlowerBlock(MobEffects.CONFUSION, 600, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<FlowerBlock> EPHEDRA_PLANT = BLOCKS.register("ephedra_plant", () -> new FlowerBlock(MobEffects.CONFUSION, 600, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<DropExperienceBlock> SODIUM_BICARBONATE_ORE = BLOCKS.register("sodium_bicarbonate_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(1.0F, 1.0F)));
    public static final RegistryObject<DropExperienceBlock> OIL_ORE = BLOCKS.register("oil_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(0.4F, 1.0F)));
    public static final RegistryObject<DropExperienceBlock> SULFUR_ORE = BLOCKS.register("sulfur_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(0.4F, 1.0F)));
    public static final RegistryObject<DropExperienceBlock> LITHIUM_ORE = BLOCKS.register("lithium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(0.4F, 1.0F)));
    public static final RegistryObject<Block> FLASK = BLOCKS.register("flask", () -> new Flask(BlockBehaviour.Properties.of(Material.GLASS).strength(0.1f, 0.5f).sound(SoundType.GLASS).noOcclusion()));
    public static final RegistryObject<DropExperienceBlock> RED_PHOSPHORUS_BLOCK = BLOCKS.register("red_phosphorus_block", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(0.5F, 1.0F)));
    public static final RegistryObject<Pan> PAN = BLOCKS.register("pan", () -> new Pan(BlockBehaviour.Properties.of(Material.METAL).strength(0.1f, 0.5f).sound(SoundType.METAL).noOcclusion()));


    //crops
    public static final RegistryObject<Block> PLANTABLE_EPHEDRA = BLOCKS.register("plantable_ephedra", () -> new CropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> WEED_PLANT = BLOCKS.register("weed_plant", () -> new CropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> COCA_PLANT = BLOCKS.register("coca_plant", () -> new CropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> COFFEE_PLANT = BLOCKS.register("coffee_plant", () -> new CropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> PLANTABLE_GOLDEN_CAP_MUSHROOM = BLOCKS.register("plantable_golden_cap_mushroom", () -> new CropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));


    //blockItems
    public static final RegistryObject<BlockItem> COFFEE_BEANS = ITEMS.register("coffee_beans", () -> new BlockItem(COFFEE_PLANT.get(), (new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> WEED_SEED = ITEMS.register("weed_seed", () -> new BlockItem(WEED_PLANT.get(), (new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> EPHEDRA_ROOT = ITEMS.register("ephedra_root", () -> new BlockItem(PLANTABLE_EPHEDRA.get(), (new Item.Properties()).tab(METH_GROUP)));
    public static final RegistryObject<BlockItem> COCA_SEEDS = ITEMS.register("coca_seeds", () -> new BlockItem(COCA_PLANT.get(), (new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> OIL_ORE_ITEM = ITEMS.register("oil_ore_item", () -> new BlockItem(OIL_ORE.get(), (new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> GOLDEN_CAP_MUSHROOM_ITEM = ITEMS.register("golden_cap_mushroom_item", () -> new BlockItem(GOLDEN_CAP_MUSHROOM.get(), (new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> SODIUM_BICARBONATE_ORE_ITEM = ITEMS.register("sodium_bicarbonate_ore_item", () -> new BlockItem(SODIUM_BICARBONATE_ORE.get(), (new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> EPHEDRA_PLANT_ITEM = ITEMS.register("ephedra_plant_item", () -> new BlockItem(EPHEDRA_PLANT.get(), (new Item.Properties()).tab(METH_GROUP)));
    public static final RegistryObject<BlockItem> SULFUR_ORE_ITEM = ITEMS.register("sulfur_ore_item", () -> new BlockItem(SULFUR_ORE.get(), (new Item.Properties()).tab(METH_GROUP)));
    public static final RegistryObject<BlockItem> LITHIUM_ORE_ITEM = ITEMS.register("lithium_ore_item", () -> new BlockItem(LITHIUM_ORE.get(), (new Item.Properties()).tab(METH_GROUP)));
    public static final RegistryObject<BlockItem> MIMOSA_HOSTILIS_PLANT_ITEM = ITEMS.register("mimosa_hostilis_plant_item", () -> new BlockItem(MIMOSA_HOSTILIS_PLANT.get(), (new Item.Properties()).tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> RED_PHOSPHORUS_BLOCK_ITEM = ITEMS.register("red_phosphorus_block_item", () -> new BlockItem(RED_PHOSPHORUS_BLOCK.get(), (new Item.Properties()).tab(METH_GROUP)));
    public static final RegistryObject<BlockItem> FLASK_ITEM = ITEMS.register("flask_item", () -> new BlockItem(FLASK.get(), (new Item.Properties()).tab(METH_GROUP)));
    public static final RegistryObject<BlockItem> PAN_ITEM = ITEMS.register("pan_item", () -> new BlockItem(PAN.get(), (new Item.Properties()).tab(METH_GROUP)));
    public static final RegistryObject<BlockItem> GOLDEN_CAP_MUSHROOM_SPORES = ITEMS.register("golden_cap_mushroom_spores", () -> new BlockItem(PLANTABLE_GOLDEN_CAP_MUSHROOM.get(), (new Item.Properties()).tab(ITEM_GROUP)));




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

    //block entities
    public static final RegistryObject<BlockEntityType<FlaskEntity>> FLASK_ENTITY = BLOCK_ENTITIES.register("flask", () -> new BlockEntityType<>(FlaskEntity::new, Sets.newHashSet(FLASK.get()), null));
    public static final RegistryObject<BlockEntityType<PanEntity>> PAN_ENTITY = BLOCK_ENTITIES.register("pan", () -> new BlockEntityType<>(PanEntity::new, Sets.newHashSet(PAN.get()), null));

}