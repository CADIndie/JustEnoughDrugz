package com.blackapple769.justenoughdrugz.client.renderer.blockentity;

import com.blackapple769.justenoughdrugz.JustEnoughDrugz;
import com.blackapple769.justenoughdrugz.block.Flask;
import com.blackapple769.justenoughdrugz.block.FlaskEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class FlaskRenderer implements BlockEntityRenderer<FlaskEntity> {
    public FlaskRenderer() {

    }

    @Override
    public void render(FlaskEntity tileEntityIn, float partialTicks, @NotNull PoseStack matrixStackIn, @NotNull MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
        tileEntityIn.load(tileEntityIn.getUpdateTag());
        NonNullList<ItemStack> tileEntityInventory = tileEntityIn.getInventory();
        int cookingProgress = tileEntityIn.getCookProgress();
        Direction direction = tileEntityIn.getBlockState().getValue(Flask.FACING);
        for (ItemStack itemstack : tileEntityInventory) {
            if (itemstack != ItemStack.EMPTY) {
                matrixStackIn.pushPose();
                // Actual position of the item
                matrixStackIn.translate(0.5D, 0.45D, 0.5D);
                switch (direction) {
                    case EAST -> matrixStackIn.mulPose(new Quaternion(Vector3f.YP, 270, true));
                    case SOUTH -> matrixStackIn.mulPose(new Quaternion(Vector3f.YP, 180, true));
                    case WEST -> matrixStackIn.mulPose(new Quaternion(Vector3f.YP, 90, true));
                    default -> matrixStackIn.mulPose(new Quaternion(Vector3f.YP, 0, true));
                }
                matrixStackIn.translate(0.0D, 0.10D, -0.50D);
                if (tileEntityInventory.get(0) == itemstack) {
                    // First item goes on bottom left
                    matrixStackIn.translate(-0.2D, 0.3125D, 0D);
                } else if (tileEntityInventory.get(1) == itemstack) {
                    // Second item goes on bottom right
                    matrixStackIn.translate(0.2D, 0.3125D, 0D);
                }
                // Scale render
                matrixStackIn.scale(0.3F, 0.3F, 0.3F);
                // Actually render the item
                Minecraft.getInstance().getItemRenderer().renderStatic(itemstack, ItemTransforms.TransformType.FIXED, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn, 0);
                matrixStackIn.popPose();
            }
        }

        if(cookingProgress > 0){
            for (int i = 0; i < cookingProgress; i++) {
                ItemStack itemstack = new ItemStack(Items.FLINT_AND_STEEL);
                matrixStackIn.pushPose();
                // Actual position of the item
                matrixStackIn.translate(0.5D, 0.45D, 0.5D);
                switch (direction) {
                    case EAST -> matrixStackIn.mulPose(new Quaternion(Vector3f.YP, 270, true));
                    case SOUTH -> matrixStackIn.mulPose(new Quaternion(Vector3f.YP, 180, true));
                    case WEST -> matrixStackIn.mulPose(new Quaternion(Vector3f.YP, 90, true));
                    default -> matrixStackIn.mulPose(new Quaternion(Vector3f.YP, 0, true));
                }
                if(i<10){
                    if(i<5){
                        matrixStackIn.translate(0.3D, 0.1D, -0.50D);
                        matrixStackIn.translate(-0.15D*i, 0D, 0D);
                    }else{
                        matrixStackIn.translate(0.3D, -0.1D, -0.50D);
                        matrixStackIn.translate(-0.15D*(i-5), 0D, 0D);
                    }
                }

                // Scale render
                matrixStackIn.scale(0.1F, 0.1F, 0.1F);
                // Actually render the item
                Minecraft.getInstance().getItemRenderer().renderStatic(itemstack, ItemTransforms.TransformType.FIXED, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn, 0);
                matrixStackIn.popPose();

            }
        }
    }



}
