package com.blackapple769.justenoughdrugz.block;
import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

public class FlaskEntity extends BlockEntity {
    private final NonNullList<ItemStack> items = NonNullList.withSize(2, ItemStack.EMPTY);
    public boolean canBeStirred;
    public boolean isStirred;
    public static float methQuality = 0f;
    public static String methColor;

    public FlaskEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(RegistryHandler.FLASK_ENTITY.get(), pWorldPosition, pBlockState);

    }

    @Override
    public void load(@NotNull CompoundTag pTag) {
        super.load(pTag);
        this.items.clear();
        methQuality = 0.0f;
        ContainerHelper.loadAllItems(pTag, this.items);

        //load base chemical
        if(items.get(0).is(RegistryHandler.METHYLAMINE.get())){
            methColor = "blue";
            methQuality += 0.85f;
        }
        if(items.get(0).is(RegistryHandler.PURE_EPHEDRINE.get())){
            methColor = "white";
            methQuality += 0.6f;
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
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag pTag) {
        super.saveAdditional(pTag);
        writeItems(pTag);
    }

    private void markUpdated() {
        this.setChanged();
        if(this.items.get(0) != ItemStack.EMPTY && this.items.get(1) != ItemStack.EMPTY){
            canBeStirred = true;
        }
        Objects.requireNonNull(this.getLevel()).sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);

    }
    private CompoundTag writeItems(CompoundTag nbt) {
        super.saveAdditional(nbt);
        ContainerHelper.saveAllItems(nbt, items, true);
        return nbt;
    }

    public void stir(){
        Objects.requireNonNull(this.getLevel()).setBlock(this.getBlockPos(), this.getBlockState().setValue(Flask.ISSTIRRED, true), 3);
        this.isStirred = true;
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

    public void setChemicalBase(ItemStack item){
        if(!item.isEmpty() && this.items.get(0) == ItemStack.EMPTY){
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

    public void setAdditionalChemical(ItemStack item){
        if(!item.isEmpty() && this.items.get(1) == ItemStack.EMPTY){

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
