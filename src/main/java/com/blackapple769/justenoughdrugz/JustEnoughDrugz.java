package com.blackapple769.justenoughdrugz;

import com.blackapple769.justenoughdrugz.init.Registry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("justenoughdrugz")
public class JustEnoughDrugz
{
    public static final String MOD_ID = "justenoughdrugz";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public JustEnoughDrugz() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        Registry.init();



        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }


}
