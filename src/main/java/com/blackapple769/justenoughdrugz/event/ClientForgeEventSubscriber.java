package com.blackapple769.justenoughdrugz.event;

import com.blackapple769.justenoughdrugz.JustEnoughDrugz;
import com.blackapple769.justenoughdrugz.client.gui.JEDZOverlays;
import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import com.blackapple769.justenoughdrugz.item.armor.HazmatArmorItem;
import com.blackapple769.justenoughdrugz.item.data.Data;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = JustEnoughDrugz.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientForgeEventSubscriber {
    final static Minecraft minecraft = Minecraft.getInstance();

    @SubscribeEvent
    public static void renderOverlayEvent(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.LAYER) {
            if (Data.data.player != null && minecraft.options.getCameraType().isFirstPerson()) {
                int screenHeight = event.getWindow().getGuiScaledHeight();
                int screenWidth = event.getWindow().getGuiScaledWidth();

                JEDZOverlays.HALLUCINATION_EFFECT_ELEMENT.render((ForgeIngameGui) minecraft.gui,
                            event.getMatrixStack(),
                            event.getPartialTicks(),
                            screenWidth,
                            screenHeight);

            }
        }
    }
}
