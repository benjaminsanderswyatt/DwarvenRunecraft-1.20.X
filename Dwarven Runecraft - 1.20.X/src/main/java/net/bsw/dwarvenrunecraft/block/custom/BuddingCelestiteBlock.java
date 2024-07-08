package net.bsw.dwarvenrunecraft.block.custom;


import net.bsw.dwarvenrunecraft.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class BuddingCelestiteBlock extends AmethystBlock {
    public static final int GROWTH_CHANCE = 5;
    private static final Direction[] DIRECTIONS = Direction.values();

    public BuddingCelestiteBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
    }

    /**
     * Performs a random tick on a block.
     */
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[pRandom.nextInt(DIRECTIONS.length)];
            BlockPos blockpos = pPos.relative(direction);
            BlockState blockstate = pLevel.getBlockState(blockpos);
            Block block = null;
            if (canClusterGrowAtState(blockstate)) {
                block = ModBlocks.SMALL_CELESTITE_BUD.get();
            } else if (blockstate.is(ModBlocks.SMALL_CELESTITE_BUD.get()) && blockstate.getValue(CelestiteClusterBlock.FACING) == direction) {
                block = ModBlocks.MEDIUM_CELESTITE_BUD.get();
            } else if (blockstate.is(ModBlocks.MEDIUM_CELESTITE_BUD.get()) && blockstate.getValue(CelestiteClusterBlock.FACING) == direction) {
                block = ModBlocks.LARGE_CELESTITE_BUD.get();
            } else if (blockstate.is(ModBlocks.LARGE_CELESTITE_BUD.get()) && blockstate.getValue(CelestiteClusterBlock.FACING) == direction) {
                block = ModBlocks.CELESTITE_CLUSTER.get();
            }

            if (block != null) {
                BlockState blockstate1 = block.defaultBlockState().setValue(CelestiteClusterBlock.FACING, direction).setValue(CelestiteClusterBlock.WATERLOGGED, Boolean.valueOf(blockstate.getFluidState().getType() == Fluids.WATER));
                pLevel.setBlockAndUpdate(blockpos, blockstate1);
            }

        }
    }

    public static boolean canClusterGrowAtState(BlockState pState) {
        return pState.isAir() || pState.is(Blocks.WATER) && pState.getFluidState().getAmount() == 8;
    }
}