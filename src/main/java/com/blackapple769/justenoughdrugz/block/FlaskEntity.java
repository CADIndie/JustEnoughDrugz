package com.blackapple769.justenoughdrugz.block;
import com.blackapple769.justenoughdrugz.JustEnoughDrugz;
import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Objects;

public class FlaskEntity extends BlockEntity {
    private final NonNullList<ItemStack> items = NonNullList.withSize(2, ItemStack.EMPTY);
    public boolean canBeStirred;
    public int[] isStirred = new int[1];
    public float methQuality = 0f;
    public String methColor;
    private final int[] cookProgress = new int[1];

    public FlaskEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(RegistryHandler.FLASK_ENTITY.get(), pWorldPosition, pBlockState);
    }

    public void giveSludge(Player player, InteractionHand handIn) {
        if(this.items.get(0) != ItemStack.EMPTY && this.items.get(1) != ItemStack.EMPTY){
            if(isStirred[0] == 0){
                methQuality -= 0.20;
            }
            if(this.cookProgress[0] < 4){
                player.getItemInHand(handIn).shrink(1);
                player.getInventory().add(new ItemStack(RegistryHandler.UNDERCOOKED_METH_SLUDGE.get()));
            }else{
                if (Objects.equals(methColor, "blue")) {
                    if (methQuality > 0.90) {
                        player.getItemInHand(handIn).shrink(1);
                        player.getInventory().add(new ItemStack(RegistryHandler.HIGH_QUALITY_BLUE_METH_SLUDGE.get()));
                    }else{
                        player.getItemInHand(handIn).shrink(1);
                        player.getInventory().add(new ItemStack(RegistryHandler.MEDIUM_QUALITY_BLUE_METH_SLUDGE.get()));
                    }
                }else if(Objects.equals(methColor, "white")){
                    if (methQuality > 0.90) {
                        player.getItemInHand(handIn).shrink(1);
                        player.getInventory().add(new ItemStack(RegistryHandler.HIGH_QUALITY_METH_SLUDGE.get()));
                    }else if(methQuality > 0.50){
                        player.getItemInHand(handIn).shrink(1);
                        player.getInventory().add(new ItemStack(RegistryHandler.MEDIUM_QUALITY_METH_SLUDGE.get()));
                    }else{
                        player.getItemInHand(handIn).shrink(1);
                        player.getInventory().add(new ItemStack(RegistryHandler.LOW_QUALITY_METH_SLUDGE.get()));
                    }
                }else if(Objects.equals(methColor, "black")){
                    player.getItemInHand(handIn).shrink(1);
                    player.getInventory().add(new ItemStack(RegistryHandler.BURNT_METH_SLUDGE.get()));
                }
            }
            this.items.clear();
            isStirred[0] = 0;
            methColor = "";
            methQuality = 0f;
            this.cookProgress[0] = 0;
            Objects.requireNonNull(this.getLevel()).setBlock(this.getBlockPos(), this.getBlockState().setValue(Flask.HASBASE, false), 3);
            Objects.requireNonNull(this.getLevel()).setBlock(this.getBlockPos(), this.getBlockState().setValue(Flask.HASADDITIONAL, false), 3);
            Objects.requireNonNull(this.getLevel()).setBlock(this.getBlockPos(), this.getBlockState().setValue(Flask.ISSTIRRED, false), 3);

            markUpdated();

        }

    }

    @Override
    public void load(@NotNull CompoundTag pTag) {
        super.load(pTag);
        this.items.clear();
        canBeStirred = false;
        methQuality = 0.0f;
        ContainerHelper.loadAllItems(pTag, this.items);

        //load base chemical
        if(items.get(0).is(RegistryHandler.METHYLAMINE.get())){
            methColor = "blue";
            methQuality += 0.85f;
        }
        if(items.get(0).is(RegistryHandler.PURE_EPHEDRINE.get())){
            methColor = "white";
            methQuality += 0.75f;
        }
        if(items.get(0).is(RegistryHandler.EPHEDRINE.get())){
            methColor = "white";
            methQuality += 0.5f;
        }
        if(items.get(0).is(RegistryHandler.EPHEDRA_BERRIES.get())){
            methColor = "white";
            methQuality += 0.30f;
        }

        //load additional chemical
        if(items.get(1).is(RegistryHandler.RED_PHOSPHORUS.get())){
            methQuality += 0.15f;
        }
        if(items.get(1).is(RegistryHandler.REFINED_LITHIUM.get())){
            methQuality += 0.10f;
        }
        if(items.get(1).is(RegistryHandler.SULFUR.get())){
            methQuality += 0.06f;
        }
        if(items.get(1).is(RegistryHandler.UNREFINED_LITHIUM.get())){
            methQuality += 0.02f;
        }

        if (pTag.contains("CookProgress", 11)) {
            int[] aint = pTag.getIntArray("CookProgress");
            System.arraycopy(aint, 0, this.cookProgress, 0, Math.min(this.cookProgress.length, aint.length));
        }

        if (pTag.contains("isStirred", 11)) {
            int[] aint = pTag.getIntArray("isStirred");
            System.arraycopy(aint, 0, this.isStirred, 0, Math.min(this.isStirred.length, aint.length));
        }

        if(this.items.get(0) != ItemStack.EMPTY && this.items.get(1) != ItemStack.EMPTY){
            canBeStirred = true;
        }
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag pTag) {
        super.saveAdditional(pTag);
        writeItems(pTag);
        pTag.putIntArray("CookProgress", this.cookProgress);
        pTag.putIntArray("isStirred", this.isStirred);

    }

    private void markUpdated() {
        this.setChanged();
        Objects.requireNonNull(this.getLevel()).sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
        if(this.items.get(0) != ItemStack.EMPTY && this.items.get(1) != ItemStack.EMPTY){
            canBeStirred = true;
        }
    }

    private CompoundTag writeItems(CompoundTag nbt) {
        super.saveAdditional(nbt);
        ContainerHelper.saveAllItems(nbt, items, true);
        return nbt;
    }

    public void stir(){
        if(canBeStirred){
            Objects.requireNonNull(this.getLevel()).setBlock(this.getBlockPos(), this.getBlockState().setValue(Flask.ISSTIRRED, true), 3);
            this.isStirred[0] = 1;
            canBeStirred = false;
        }

    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        return writeItems(new CompoundTag());
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public NonNullList<ItemStack> getInventory(){
        return items;
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(net, pkt);
        handleUpdateTag(pkt.getTag());
    }
    public void cook(){
        if(canBeStirred){
            this.cookProgress[0] += 1;
            if (this.cookProgress[0] > 5) {
                methQuality -= 0.10;
                methColor = "white";
            }
            if(this.cookProgress[0] >= 10){
                methColor = "black";
            }
            markUpdated();
        }

    }

    public int getCookProgress(){
        return this.cookProgress[0];
    }

    public void setChemicalBase(Player player, InteractionHand handIn){
        ItemStack item = player.getItemInHand(handIn);
        if(!item.isEmpty() && this.items.get(0) == ItemStack.EMPTY){
            if(!player.isCreative()){
                player.getItemInHand(handIn).shrink(1);
            }
            if(item.is(RegistryHandler.METHYLAMINE.get())){
                methColor = "blue";
                methQuality += 0.85f;
            }
            if(item.is(RegistryHandler.PURE_EPHEDRINE.get())){
                methColor = "white";
                methQuality += 0.6f;
            }
            if(item.is(RegistryHandler.EPHEDRINE.get())){
                methColor = "white";
                methQuality += 0.5f;
            }
            if(item.is(RegistryHandler.EPHEDRA_BERRIES.get())){
                methColor = "white";
                methQuality += 0.30f;
            }

            this.items.set(0,item);
            Objects.requireNonNull(this.getLevel()).setBlock(this.getBlockPos(), this.getBlockState().setValue(Flask.HASBASE, true), 3);
            markUpdated();
        }
    }

    public void setAdditionalChemical(Player player, InteractionHand handIn){
        ItemStack item = player.getItemInHand(handIn);
        if(!item.isEmpty() && this.items.get(1) == ItemStack.EMPTY){
            if(!player.isCreative()){
                player.getItemInHand(handIn).shrink(1);
            }
            if(item.is(RegistryHandler.RED_PHOSPHORUS.get())){
                methQuality += 0.15f;
            }
            if(item.is(RegistryHandler.REFINED_LITHIUM.get())){
                methQuality += 0.10f;
            }
            if(item.is(RegistryHandler.SULFUR.get())){
                methQuality += 0.06f;
            }
            if(item.is(RegistryHandler.UNREFINED_LITHIUM.get())){
                methQuality += 0.02f;
            }

            this.items.set(1,item);
            Objects.requireNonNull(this.getLevel()).setBlock(this.getBlockPos(), this.getBlockState().setValue(Flask.HASADDITIONAL, true), 3);
            markUpdated();
        }
    }
}
