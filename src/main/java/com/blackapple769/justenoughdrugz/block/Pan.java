package com.blackapple769.justenoughdrugz.block;


import com.blackapple769.justenoughdrugz.JustEnoughDrugz;
import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.antlr.v4.runtime.misc.NotNull;
import org.jetbrains.annotations.Nullable;

public class Pan extends HorizontalDirectionalBlock implements EntityBlock {
    public static final IntegerProperty TYPE = IntegerProperty.create("type", 0, 4);
    public static final BooleanProperty ISBROKEN = BooleanProperty.create("broken");
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);



    public Pan(Properties p_54120_) {
        super(p_54120_);
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(TYPE, 0).setValue(ISBROKEN, false));
    }

    @SuppressWarnings("deprecation")
    public @NotNull
    @org.jetbrains.annotations.NotNull
    InteractionResult use(@NotNull BlockState state, Level worldIn, @NotNull BlockPos blockPos,
                          @NotNull Player player, @NotNull InteractionHand handIn,
                          @NotNull BlockHitResult blockRayTraceResult) {
        if(!worldIn.isClientSide()){
            BlockEntity blockEntity = worldIn.getBlockEntity(blockPos);
            if (blockEntity instanceof PanEntity panEntity) {
                ItemStack itemInHand = player.getItemInHand(handIn);
                if (itemInHand.getItem().equals(RegistryHandler.HIGH_QUALITY_BLUE_METH_SLUDGE.get()) ||
                        itemInHand.getItem().equals(RegistryHandler.MEDIUM_QUALITY_BLUE_METH_SLUDGE.get()) ||
                        itemInHand.getItem().equals(RegistryHandler.HIGH_QUALITY_METH_SLUDGE.get()) ||
                        itemInHand.getItem().equals(RegistryHandler.MEDIUM_QUALITY_METH_SLUDGE.get()) ||
                        itemInHand.getItem().equals(RegistryHandler.LOW_QUALITY_METH_SLUDGE.get()) ||
                        itemInHand.getItem().equals(RegistryHandler.BURNT_METH_SLUDGE.get()) ||
                        itemInHand.getItem().equals(RegistryHandler.UNDERCOOKED_METH_SLUDGE.get())) {

                    boolean result = panEntity.setMeth(player, handIn);
                    if(result){
                        if(!player.isCreative()){
                            player.getItemInHand(handIn).shrink(1);
                        }
                    }
                }else if(itemInHand.getItem().equals(Items.STICK)){
                    panEntity.breakMeth();
                }else if(itemInHand.getItem().equals(RegistryHandler.BAGGIE.get())){
                    panEntity.getMeth(player, handIn);
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(TYPE, 0).setValue(ISBROKEN, false);
    }
    @SuppressWarnings("deprecation")
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext collisionContext) {
        return SHAPE;
    }

    public @org.jetbrains.annotations.NotNull BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPE, ISBROKEN);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new PanEntity(pPos, pState);
    }
}
