package com.blackapple769.justenoughdrugz.client;

import com.blackapple769.justenoughdrugz.JustEnoughDrugz;
import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = JustEnoughDrugz.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {

    /**
     * Event handler for the FMLClientSetupEvent.
     * @param event the <code>FMLClientSetupEvent</code> instance
     */
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // Register block renderers
        ItemBlockRenderTypes.setRenderLayer(RegistryHandler.WEED_PLANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegistryHandler.COCA_PLANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegistryHandler.GOLDEN_CAP_MUSHROOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegistryHandler.MIMOSA_HOSTILIS_PLANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegistryHandler.EPHEDRA_PLANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RegistryHandler.PLANTABLE_EPHEDRA.get(), RenderType.cutout());

    }
}