package com.blackapple769.justenoughdrugz.client.gui;

import com.blackapple769.justenoughdrugz.JustEnoughDrugz;
import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import com.blackapple769.justenoughdrugz.item.armor.HazmatArmorItem;
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
import net.minecraftforge.client.gui.IIngameOverlay;
import net.minecraftforge.client.gui.OverlayRegistry;


public class JEDZOverlays {
    final static Minecraft minecraft = Minecraft.getInstance();
    private static final ResourceLocation SHROOM_LOCATION = new ResourceLocation(JustEnoughDrugz.MOD_ID,"textures/misc/generic_effect.png");
    private static final ResourceLocation WEED_LOCATION = new ResourceLocation("textures/misc/nausea.png");
    private static final ResourceLocation HAZMAT_OVERLAY_LOCATION = new ResourceLocation(JustEnoughDrugz.MOD_ID,"textures/misc/hazmat_overlay.png");

    public static IIngameOverlay HALLUCINATION_EFFECT_ELEMENT;
    public static IIngameOverlay GENERIC_EFFECT_ELEMENT;
    public static IIngameOverlay HAZMAT_OVERLAY_ELEMENT;


    public static void init() {
        GENERIC_EFFECT_ELEMENT = OverlayRegistry.registerOverlayTop("Generic Overlay", (gui, poseStack, partialTick, screenWidth, screenHeight) -> {
            gui.setupOverlayRenderState(true, false);
            assert minecraft.player != null;
            float weedScaler = 0.1f;
            renderWeedOverlay(weedScaler);

        });

        HALLUCINATION_EFFECT_ELEMENT = OverlayRegistry.registerOverlayTop("Shroom", (gui, poseStack, partialTick, screenWidth, screenHeight) -> {
            gui.setupOverlayRenderState(false, false);
            Minecraft minecraft = Minecraft.getInstance();
            assert minecraft.player != null;
            if (minecraft.player.hasEffect(RegistryHandler.LEAN_EFFECT.get())
                    || minecraft.player.hasEffect(RegistryHandler.COKE_EFFECT.get())
                    || minecraft.player.hasEffect(RegistryHandler.SHROOM_EFFECT.get())
                    || minecraft.player.hasEffect(RegistryHandler.DMT_EFFECT.get())) {
                float Scaler = 0.1f;
                renderShroomOverlay(Scaler);
            }
        });

        HAZMAT_OVERLAY_ELEMENT = OverlayRegistry.registerOverlayTop("Hazmat Overlay", (gui, poseStack, partialTick, screenWidth, screenHeight) -> {
            gui.setupOverlayRenderState(true, false);

            Minecraft minecraft = Minecraft.getInstance();
            if (HazmatArmorItem.maskEquipped && minecraft.options.getCameraType().isFirstPerson()) {
                renderHazmatOverlay(screenWidth, screenHeight, 1.0f);
            }
        });


    }
    private static void renderShroomOverlay(float pScalar) {
        int i = minecraft.getWindow().getGuiScaledWidth();
        int j = minecraft.getWindow().getGuiScaledHeight();
        double d0 = Mth.lerp((double)pScalar, 2.0D, 1.0D);
        float randomizer = Mth.lerp(1f, 1.0f, 5.0f);

        float f = 0.2F * pScalar;
        float f1 = 0.4F * pScalar;
        float f2 = 0.2F * pScalar;
        double d1 = (double)i * d0;
        double d2 = (double)j * d0;
        double d3 = ((double)i - d1) / 2.0D;
        double d4 = ((double)j - d2) / 2.0D;
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        RenderSystem.setShaderColor(f, f1, f2, 1.0F);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, SHROOM_LOCATION);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(d3, d4 + d2, -90.0D).uv(0.0F, 1.0F).endVertex();
        bufferbuilder.vertex(d3 + d1, d4 + d2, -90.0D).uv(1.0F, 1.0F).endVertex();
        bufferbuilder.vertex(d3 + d1, d4, -90.0D).uv(1.0F, 0.0F).endVertex();
        bufferbuilder.vertex(d3, d4, -90.0D).uv(0.0F, 0.0F).endVertex();
        tesselator.end();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 0.5F);
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
    }

    private static void renderWeedOverlay(float pScalar) {
        int i = minecraft.getWindow().getGuiScaledWidth();
        int j = minecraft.getWindow().getGuiScaledHeight();
        double d0 = Mth.lerp((double)pScalar, 2.0D, 1.0D);
        float f = 0.2F * pScalar;
        float f1 = 0.4F * pScalar;
        float f2 = 0.2F * pScalar;
        double d1 = (double)i * d0;
        double d2 = (double)j * d0;
        double d3 = ((double)i - d1) / 2.0D;
        double d4 = ((double)j - d2) / 2.0D;
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        RenderSystem.setShaderColor(f, f1, f2, 1.0F);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, WEED_LOCATION);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(d3, d4 + d2, -90.0D).uv(0.0F, 1.0F).endVertex();
        bufferbuilder.vertex(d3 + d1, d4 + d2, -90.0D).uv(1.0F, 1.0F).endVertex();
        bufferbuilder.vertex(d3 + d1, d4, -90.0D).uv(1.0F, 0.0F).endVertex();
        bufferbuilder.vertex(d3, d4, -90.0D).uv(0.0F, 0.0F).endVertex();
        tesselator.end();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 0.5F);
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
    }

    private static void renderHazmatOverlay(int screenWidth, int screenHeight, float alpha) {
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, alpha);
        RenderSystem.setShaderTexture(0, HAZMAT_OVERLAY_LOCATION);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(0.0D, (double)screenHeight, -90.0D).uv(0.0F, 1.0F).endVertex();
        bufferbuilder.vertex((double)screenWidth, (double)screenHeight, -90.0D).uv(1.0F, 1.0F).endVertex();
        bufferbuilder.vertex((double)screenWidth, 0.0D, -90.0D).uv(1.0F, 0.0F).endVertex();
        bufferbuilder.vertex(0.0D, 0.0D, -90.0D).uv(0.0F, 0.0F).endVertex();
        tesselator.end();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }
}

