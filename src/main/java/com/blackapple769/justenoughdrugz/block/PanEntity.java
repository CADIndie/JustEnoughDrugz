package com.blackapple769.justenoughdrugz.block;

import com.blackapple769.justenoughdrugz.JustEnoughDrugz;
import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

public class PanEntity extends BlockEntity {
    private final NonNullList<ItemStack> methType = NonNullList.withSize(1, ItemStack.EMPTY);
    public int[] isBroken = new int[1];

    public PanEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(RegistryHandler.PAN_ENTITY.get(), pWorldPosition, pBlockState);
    }

    @Override
    public void load(@NotNull CompoundTag pTag) {
        super.load(pTag);
        this.methType.clear();
        ContainerHelper.loadAllItems(pTag, this.methType);

        if (pTag.contains("isBroken", 11)) {
            int[] aint = pTag.getIntArray("isBroken");
            System.arraycopy(aint, 0, this.isBroken, 0, Math.min(this.isBroken.length, aint.length));
        }


    }

    public void getMeth(Player player, InteractionHand handIn) {
        JustEnoughDrugz.LOGGER.debug(String.valueOf(this.methType.get(0)));
        if(isBroken[0] == 1){
            if(this.methType.get(0).is(RegistryHandler.HIGH_QUALITY_BLUE_METH_SLUDGE.get())){
                player.getItemInHand(handIn).shrink(1);
                player.getInventory().add(new ItemStack(RegistryHandler.HIGH_QUALITY_BLUE_METH.get()));
            }

            if(this.methType.get(0).is(RegistryHandler.MEDIUM_QUALITY_BLUE_METH_SLUDGE.get())){
                player.getItemInHand(handIn).shrink(1);
                player.getInventory().add(new ItemStack(RegistryHandler.MEDIUM_QUALITY_BLUE_METH.get()));

            }

            if(this.methType.get(0).is(RegistryHandler.HIGH_QUALITY_METH_SLUDGE.get())){
                player.getItemInHand(handIn).shrink(1);
                player.getInventory().add(new ItemStack(RegistryHandler.HIGH_QUALITY_METH.get()));

            }

            if(this.methType.get(0).is(RegistryHandler.MEDIUM_QUALITY_METH_SLUDGE.get())){
                player.getItemInHand(handIn).shrink(1);
                player.getInventory().add(new ItemStack(RegistryHandler.MEDIUM_QUALITY_METH.get()));

            }

            if(this.methType.get(0).is(RegistryHandler.LOW_QUALITY_METH_SLUDGE.get())){
                player.getItemInHand(handIn).shrink(1);
                player.getInventory().add(new ItemStack(RegistryHandler.LOW_QUALITY_METH.get()));

            }

            if(this.methType.get(0).is(RegistryHandler.BURNT_METH_SLUDGE.get())){
                player.getItemInHand(handIn).shrink(1);
                player.getInventory().add(new ItemStack(RegistryHandler.BURNT_METH.get()));

            }

            if(this.methType.get(0).is(RegistryHandler.UNDERCOOKED_METH_SLUDGE.get())){
                player.getItemInHand(handIn).shrink(1);
                player.getInventory().add(new ItemStack(RegistryHandler.UNDERCOOKED_METH.get()));

            }

            this.methType.clear();
            isBroken[0] = 0;
            Objects.requireNonNull(this.getLevel()).setBlock(this.getBlockPos(), this.getBlockState().setValue(Pan.TYPE, 0), 3);
            markUpdated();
        }
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.putIntArray("isBroken", this.isBroken);
        writeItems(pTag);
    }

    private void markUpdated() {
        this.setChanged();
        if(isBroken[0] == 1){
            Objects.requireNonNull(this.getLevel()).setBlock(this.getBlockPos(), this.getBlockState().setValue(Pan.ISBROKEN, true), 3);
        }else{
            Objects.requireNonNull(this.getLevel()).setBlock(this.getBlockPos(), this.getBlockState().setValue(Pan.ISBROKEN, false), 3);

        }
        Objects.requireNonNull(this.getLevel()).sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
    }

    private CompoundTag writeItems(CompoundTag nbt) {
        super.saveAdditional(nbt);
        ContainerHelper.saveAllItems(nbt, this.methType, false);
        return nbt;
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        return writeItems(new CompoundTag());
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
    public void breakMeth(){
        JustEnoughDrugz.LOGGER.debug(String.valueOf(this.methType.get(0)));
        if(this.methType.get(0) != ItemStack.EMPTY){
            Objects.requireNonNull(this.getLevel()).setBlock(this.getBlockPos(), this.getBlockState().setValue(Pan.ISBROKEN, true), 3);
            isBroken[0] = 1;
            markUpdated();
        }
    }
    public boolean setMeth( Player player, InteractionHand handIn){
        ItemStack item = new ItemStack(player.getItemInHand(handIn).getItem());
        JustEnoughDrugz.LOGGER.debug(String.valueOf(item));
        if(!item.isEmpty() && this.methType.get(0) == ItemStack.EMPTY){
            if(item.is(RegistryHandler.HIGH_QUALITY_BLUE_METH_SLUDGE.get())){
                Objects.requireNonNull(this.getLevel()).setBlock(this.getBlockPos(), this.getBlockState().setValue(Pan.TYPE, 1), 3);
                this.methType.set(0,item);
                player.getInventory().add(new ItemStack(Items.BUCKET));
                return true;
            }

            if(item.is(RegistryHandler.MEDIUM_QUALITY_BLUE_METH_SLUDGE.get())){
                Objects.requireNonNull(this.getLevel()).setBlock(this.getBlockPos(), this.getBlockState().setValue(Pan.TYPE, 1), 3);
                this.methType.set(0,item);
                player.getInventory().add(new ItemStack(Items.BUCKET));
                return true;
            }

            if(item.is(RegistryHandler.HIGH_QUALITY_METH_SLUDGE.get())){
                Objects.requireNonNull(this.getLevel()).setBlock(this.getBlockPos(), this.getBlockState().setValue(Pan.TYPE, 2), 3);
                this.methType.set(0,item);
                player.getInventory().add(new ItemStack(Items.BUCKET));
                return true;
            }

            if(item.is(RegistryHandler.MEDIUM_QUALITY_METH_SLUDGE.get())){
                Objects.requireNonNull(this.getLevel()).setBlock(this.getBlockPos(), this.getBlockState().setValue(Pan.TYPE, 2), 3);
                this.methType.set(0,item);
                player.getInventory().add(new ItemStack(Items.BUCKET));
                return true;
            }

            if(item.is(RegistryHandler.LOW_QUALITY_METH_SLUDGE.get())){
                Objects.requireNonNull(this.getLevel()).setBlock(this.getBlockPos(), this.getBlockState().setValue(Pan.TYPE, 2), 3);
                this.methType.set(0,item);
                player.getInventory().add(new ItemStack(Items.BUCKET));
                return true;
            }

            if(item.is(RegistryHandler.BURNT_METH_SLUDGE.get())){
                Objects.requireNonNull(this.getLevel()).setBlock(this.getBlockPos(), this.getBlockState().setValue(Pan.TYPE, 3), 3);
                this.methType.set(0,item);
                player.getInventory().add(new ItemStack(Items.BUCKET));
                return true;
            }

            if(item.is(RegistryHandler.UNDERCOOKED_METH_SLUDGE.get())){
                Objects.requireNonNull(this.getLevel()).setBlock(this.getBlockPos(), this.getBlockState().setValue(Pan.TYPE, 4), 3);
                this.methType.set(0,item);
                player.getInventory().add(new ItemStack(Items.BUCKET));
                return true;
            }

        }
        markUpdated();
        return false;
    }

}
