package com.blackapple769.justenoughdrugz.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class GrowLight extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {
    public GrowLight(Properties p_54120_) {
        super(p_54120_);
    }
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final BooleanProperty LIT = BlockStateProperties.LIT;

    /**
     * Create the BlockState definition.
     *
     * @param builder the <code>StateContainer.Builder</code> of the block
     */
    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING, LIT);
    }

    /**
     * Determines if the block can exist in a given state.
     *
     * @param state  the <code>BlockState</code> of the block
     * @param reader the <code>IWorldReader</code> for the block
     * @param pos    the <code>BlocKPos</code> the block is at
     * @return boolean
     */

    @SuppressWarnings("deprecation")
    @Override
    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockPos positionAbove = pos.above();
        BlockState stateOpposite = reader.getBlockState(positionAbove);
        return stateOpposite.isFaceSturdy(reader, positionAbove, direction);
    }

    /**
     * Updates the block when required.
     *
     * @param stateIn     the <code>BlockState</code> of the block
     * @param facing      the <code>Direction</code> the block is facing
     * @param facingState the <code>BlockState</code> of the facing block
     * @param worldIn     the <code>IWorld</code> the block is in
     * @param currentPos  the <code>BlockPos</code> the block is at
     * @param facingPos   the <code>BlocKPos</code> the facing block is at
     * @return BlockState
     */
    @SuppressWarnings("deprecation")
    @Override
    public @NotNull BlockState updateShape(BlockState stateIn, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor worldIn, @NotNull BlockPos currentPos, @NotNull BlockPos facingPos) {
        if (stateIn.getValue(WATERLOGGED)) {
            worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
        }
        return facing.getOpposite() == stateIn.getValue(FACING) && !stateIn.canSurvive(worldIn, currentPos) ? Blocks.AIR.defaultBlockState() : stateIn;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(LIT, false).setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER);
    }


    /**
     * Set FluidState properties.
     * Allows the block to exhibit waterlogged behavior.
     *
     * @param state the <code>BlockState</code> of the block
     * @return FluidState
     */
    @SuppressWarnings("deprecation")
    @Override
    public @NotNull FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }



    @SuppressWarnings("deprecation")
    @Override
    public void neighborChanged(@NotNull BlockState state, Level worldIn, @NotNull BlockPos pos, @NotNull Block blockIn, @NotNull BlockPos fromPos, boolean isMoving) {
        if (!worldIn.isClientSide) {
            boolean flag = state.getValue(LIT);
            if (flag != worldIn.hasNeighborSignal(pos)) {
                if (flag) {
                    worldIn.scheduleTick(pos, this, 1);
                } else {
                    worldIn.setBlock(pos, state.cycle(LIT), 3);
                }
            }
        }
    }

    /**
     * Runs when neighboring blocks change state.
     *
     * @param state    the <code>BlockState</code> of the block
     * @param worldIn  the <code>World</code> the block is in
     * @param pos      the <code>BlockPos</code> the block is at
     * @param oldState the <code>BlockState</code> the block previously had
     * @param isMoving determines if the block is moving
     */
    @SuppressWarnings("deprecation")
    @Override
    public void onPlace(BlockState state, @NotNull Level worldIn, @NotNull BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!oldState.is(state.getBlock())) {
            if (worldIn.hasNeighborSignal(pos)) {
                worldIn.setBlock(pos, state.setValue(LIT, true), 3);
            }
        }
    }

    /**
     * Runs once every tick
     *
     * @param state   the <code>BlockState</code> of the block
     * @param worldIn the <code>ServerWorld</code> of the block
     * @param pos     the <code>BlockPos</code> the block is at
     * @param rand    a <code>Random</code> instance
     */
    @SuppressWarnings("deprecation")
    @Override
    public void tick(BlockState state, @NotNull ServerLevel worldIn, @NotNull BlockPos pos, @NotNull Random rand) {
        if (state.getValue(LIT) && !worldIn.hasNeighborSignal(pos)) {
            worldIn.setBlock(pos, state.setValue(LIT, false), 3);
        }
    }

    /**
     * Get the light value of the block.
     *
     * @param state  the <code>BlockState</code> of the block
     * @param reader the <code>IBlockReader</code> of the block
     * @param pos    the <code>BlockPos</code> the block is at
     * @return int
     */
    @Override
    public int getLightEmission(BlockState state, BlockGetter reader, BlockPos pos) {
        if (state.getValue(LIT)) {
            return 15;
        } else {
            return 0;
        }
    }
}
