package com.blackapple769.justenoughdrugz.block;
import com.blackapple769.justenoughdrugz.init.RegistryHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.antlr.v4.runtime.misc.NotNull;
import org.jetbrains.annotations.Nullable;



public class Flask extends HorizontalDirectionalBlock implements EntityBlock{
    public static final BooleanProperty HASBASE = BooleanProperty.create("hasbase");
    public static final BooleanProperty HASADDITIONAL = BooleanProperty.create("hasadditional");
    public static final BooleanProperty ISSTIRRED = BooleanProperty.create("isstirred");

    public Flask(Properties p_49224_) {
        super(p_49224_);
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HASBASE, Boolean.FALSE).setValue(HASADDITIONAL, Boolean.FALSE).setValue(ISSTIRRED, Boolean.FALSE));
    }

    @SuppressWarnings("deprecation")
    public @NotNull
    @org.jetbrains.annotations.NotNull
    InteractionResult use(@NotNull BlockState state, Level worldIn, @NotNull BlockPos blockPos,
                          @NotNull Player player, @NotNull InteractionHand handIn,
                          @NotNull BlockHitResult blockRayTraceResult) {

                BlockEntity blockentity = worldIn.getBlockEntity(blockPos);
                if (blockentity instanceof FlaskEntity flaskEntity) {
                    if(!worldIn.isClientSide()){
                        if(player.getItemInHand(handIn).is(RegistryHandler.EPHEDRINE.get())
                                || player.getItemInHand(handIn).is(RegistryHandler.METHYLAMINE.get())
                                || player.getItemInHand(handIn).is(RegistryHandler.EPHEDRA_BERRIES.get())
                                || player.getItemInHand(handIn).is(RegistryHandler.PURE_EPHEDRINE.get()))
                        {
                            flaskEntity.setChemicalBase(player, handIn);
                            return InteractionResult.SUCCESS;
                        }

                        if(player.getItemInHand(handIn).is(RegistryHandler.SULFUR.get())
                                || player.getItemInHand(handIn).is(RegistryHandler.UNREFINED_LITHIUM.get())
                                || player.getItemInHand(handIn).is(RegistryHandler.REFINED_LITHIUM.get())
                                || player.getItemInHand(handIn).is(RegistryHandler.RED_PHOSPHORUS.get()))
                        {
                            flaskEntity.setAdditionalChemical(player, handIn);
                            return InteractionResult.SUCCESS;
                        }


                        if(player.getItemInHand(handIn).is(Items.STICK) && flaskEntity.canBeStirred) {
                            flaskEntity.stir();
                            return InteractionResult.SUCCESS;
                        }

                        if(player.getItemInHand(handIn).is(Items.BUCKET)){
                            flaskEntity.giveSludge(player, handIn);
                        }
                    }

                    if(player.getItemInHand(handIn).is(Items.FLINT_AND_STEEL)){
                        flaskEntity.cook();
                        return InteractionResult.SUCCESS;
                    }
            }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, HASADDITIONAL, HASBASE, ISSTIRRED);
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(HASADDITIONAL, Boolean.FALSE).setValue(HASBASE, Boolean.FALSE).setValue(ISSTIRRED, Boolean.FALSE);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new FlaskEntity(pPos, pState);
    }

    public float getShadeBrightness(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return 1.0F;
    }

    public boolean propagatesSkylightDown(BlockState pState, BlockGetter pReader, BlockPos pPos) {
        return true;
    }
}
