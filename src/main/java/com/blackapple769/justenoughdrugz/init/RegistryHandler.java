package com.blackapple769.justenoughdrugz.init;

import com.blackapple769.justenoughdrugz.JustEnoughDrugz;
import com.blackapple769.justenoughdrugz.item.*;
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

    public static final RegistryObject<Block> WEED_PLANT = BLOCKS.register("weed_plant", () -> new CropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));
    public static final RegistryObject<Block> COCA_PLANT = BLOCKS.register("coca_plant", () -> new CropBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));


    public static final RegistryObject<OreBlock> SODIUM_BICARBONATE_ORE = BLOCKS.register("sodium_bicarbonate_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.0f, 1.0f)));
    public static final RegistryObject<OreBlock> OIL_ORE = BLOCKS.register("oil_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(1.0f, 1.0f)));

    public static final RegistryObject<BlockItem> WEED_SEED = ITEMS.register("weed_seed", () -> new BlockItem(WEED_PLANT.get(), new Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> COCA_SEEDS = ITEMS.register("coca_seeds", () -> new BlockItem(COCA_PLANT.get(), new Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> OIL_ORE_ITEM = ITEMS.register("oil_ore_item", () -> new BlockItem(OIL_ORE.get(), new Properties().tab(ITEM_GROUP)));
    public static final RegistryObject<BlockItem> SODIUM_BICARBONATE_ORE_ITEM = ITEMS.register("sodium_bicarbonate_ore_item", () -> new BlockItem(SODIUM_BICARBONATE_ORE.get(), new Properties().tab(ITEM_GROUP)));
}
