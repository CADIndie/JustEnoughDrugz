package com.blackapple769.justenoughdrugz;

import com.blackapple769.justenoughdrugz.init.PostSetupHandler;
import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import com.mojang.logging.LogUtils;
import net.minecraft.data.worldgen.SurfaceRuleData;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;



// The value here should match an entry in the META-INF/mods.toml file
@Mod("justenoughdrugz")
public class JustEnoughDrugz {
    public static final String MOD_ID = "justenoughdrugz";
    public static final Logger LOGGER = LogUtils.getLogger();

    public JustEnoughDrugz() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        RegistryHandler.init();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
    }

    private void setup(final FMLCommonSetupEvent event) {
        PotionRecipe.setupBrewingRecipes();
        PostSetupHandler.init();
    }
}