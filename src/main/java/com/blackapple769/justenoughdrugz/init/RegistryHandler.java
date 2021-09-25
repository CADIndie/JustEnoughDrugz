package com.blackapple769.justenoughdrugz.init;

import com.blackapple769.justenoughdrugz.JustEnoughDrugz;
import com.blackapple769.justenoughdrugz.item.BluntItem;
import com.blackapple769.justenoughdrugz.item.Cocaine;
import com.blackapple769.justenoughdrugz.item.Food;
import com.blackapple769.justenoughdrugz.item.Gasoline;
import com.blackapple769.justenoughdrugz.util.CreativeTabSorter;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, JustEnoughDrugz.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, JustEnoughDrugz.MOD_ID);

    public static void init() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);

    }

    public static final CreativeModeTab ITEM_GROUP = new CreativeTabSorter("JustEnoughDrugz");
    public static final RegistryObject<Item> TWENTY_DOLLAR_BILL = ITEMS.register("twenty_dollar_bill", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> WEED = ITEMS.register("weed", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> BAGGIE = ITEMS.register("baggie", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> BLUNT = ITEMS.register("blunt", () -> new BluntItem(new Item.Properties().tab(ITEM_GROUP).durability(5)));
    public static final RegistryObject<Item> WEED_BAGGIE = ITEMS.register("weed_baggie", () -> new Item(new Item.Properties().tab(ITEM_GROUP).craftRemainder(BAGGIE.get())));
    public static final RegistryObject<Item> COCAINE_BAGGIE = ITEMS.register("cocaine_baggie", () -> new Cocaine(new Item.Properties().tab(ITEM_GROUP).craftRemainder(BAGGIE.get())));
    public static final RegistryObject<Item> WEED_EDIBLE = ITEMS.register("weed_edible", () -> new Item(new Item.Properties().tab(ITEM_GROUP).food(Food.WEED_EDIBLE)));
    public static final RegistryObject<Item> GASOLINE = ITEMS.register("gasoline", () -> new Gasoline(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> UNREFINED_OIL = ITEMS.register("unrefined_oil", () -> new Gasoline(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> REFINED_OIL = ITEMS.register("refined_oil", () -> new Gasoline(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> COCA = ITEMS.register("coca", () -> new Gasoline(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<Item> DRIED_COCA = ITEMS.register("dried_coca", () -> new Gasoline(new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryObject<Block> WEED_PLANT = BLOCKS.register("weed_plant", () -> new CropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> COCA_PLANT = BLOCKS.register("coca_plant", () -> new CropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));


    public static final RegistryObject<OreBlock> OIL_ORE = BLOCKS.register("oil_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.0f, 1.0f)));

    public static final RegistryObject<BlockItem> WEED_SEED = ITEMS.register("weed_seed", () -> new BlockItem(WEED_PLANT.get(), new Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> COCA_SEEDS = ITEMS.register("coca_seeds", () -> new BlockItem(COCA_PLANT.get(), new Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> OIL_ORE_ITEM = ITEMS.register("oil_ore_item", () -> new BlockItem(OIL_ORE.get(), new Properties().tab(ITEM_GROUP)));
}
