package com.blackapple769.justenoughdrugz.event;

import com.blackapple769.justenoughdrugz.JustEnoughDrugz;
import com.blackapple769.justenoughdrugz.client.gui.JEDZOverlays;
import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import com.blackapple769.justenoughdrugz.item.armor.HazmatArmorItem;
import com.blackapple769.justenoughdrugz.item.data.Data;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;



@Mod.EventBusSubscriber(modid = JustEnoughDrugz.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientForgeEventSubscriber {
    final static Minecraft minecraft = Minecraft.getInstance();

    @SubscribeEvent
    public static void renderOverlayEvent(RenderGuiOverlayEvent.Post event) {
            if (Data.data.player != null && minecraft.options.getCameraType().isFirstPerson()) {
                int screenHeight = event.getWindow().getGuiScaledHeight();
                int screenWidth = event.getWindow().getGuiScaledWidth();

                JEDZOverlays.HALLUCINATION_EFFECT_ELEMENT.render((ForgeGui) minecraft.gui,
                            event.getPoseStack(),
                            event.getPartialTick(),
                            screenWidth,
                            screenHeight);

            }
    }
}
