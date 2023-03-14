package com.blackapple769.justenoughdrugz.client.gui;

import com.blackapple769.justenoughdrugz.JustEnoughDrugz;
import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;



public class JEDZOverlays {
    final static Minecraft minecraft = Minecraft.getInstance();
    private static final ResourceLocation SHROOM_LOCATION = new ResourceLocation(JustEnoughDrugz.MOD_ID,"textures/misc/generic_effect.png");
    public static IGuiOverlay HALLUCINATION_EFFECT_ELEMENT;

    public static void init() {
        HALLUCINATION_EFFECT_ELEMENT = (gui, poseStack, partialTick, screenWidth, screenHeight) -> {
            gui.setupOverlayRenderState(false, false);
            Minecraft minecraft = Minecraft.getInstance();
            assert minecraft.player != null;
            if (minecraft.player.hasEffect(RegistryHandler.LEAN_EFFECT.get())
                    || minecraft.player.hasEffect(RegistryHandler.COKE_EFFECT.get())
                    || minecraft.player.hasEffect(RegistryHandler.SHROOM_EFFECT.get())
                    || minecraft.player.hasEffect(RegistryHandler.DMT_EFFECT.get())) {
                renderShroomOverlay();
            }
        };
    }

    private static void renderShroomOverlay() {
        int i = minecraft.getWindow().getGuiScaledWidth();
        int j = minecraft.getWindow().getGuiScaledHeight();
        double min = 1.5D;
        double max = 2.0D;
        float randomNumber1 = (float) ((float) Math.random()*(max-min+1)+min);
        float randomNumber2 = (float) ((float) Math.random()*(0.1-0f+0.1)+0f);
        float randomNumber3 = ((float) Math.random()*(90-(-90)+1)-90);
        double d1 = (double)i * (randomNumber1);
        double d2 = (double)j * (randomNumber1);
        double d3 = ((double)i - d1) / 2.0D;
        double d4 = ((double)j - d2) / 2.0D;
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        RenderSystem.setShaderColor(randomNumber2, randomNumber2, randomNumber2, 0.5F);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, SHROOM_LOCATION);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(d3, d4 + d2, randomNumber3).uv(0.0F, 1.0F).endVertex();
        bufferbuilder.vertex(d3 + d1, d4 + d2, randomNumber3).uv(1.0F, 1.0F).endVertex();
        bufferbuilder.vertex(d3 + d1, d4, randomNumber3).uv(1.0F, 0.0F).endVertex();
        bufferbuilder.vertex(d3, d4, randomNumber3).uv(0.0F, 0.0F).endVertex();
        tesselator.end();
        RenderSystem.setShaderColor(randomNumber2, randomNumber2, randomNumber2, 0.5F);
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
    }
}

