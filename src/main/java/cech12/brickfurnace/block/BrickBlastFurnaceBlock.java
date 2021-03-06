package cech12.brickfurnace.block;

import cech12.brickfurnace.tileentity.BrickBlastFurnaceTileEntity;
import net.minecraft.block.BlastFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BrickBlastFurnaceBlock extends BlastFurnaceBlock {

    public BrickBlastFurnaceBlock(Block.Properties builder) {
        super(builder);
    }

    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new BrickBlastFurnaceTileEntity();
    }

    /**
     * Interface for handling interaction with blocks that impliment AbstractFurnaceBlock. Called in onBlockActivated
     * inside AbstractFurnaceBlock.
     */
    protected void interactWith(World worldIn, BlockPos pos, PlayerEntity player) {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof BrickBlastFurnaceTileEntity) {
            player.openContainer((INamedContainerProvider)tileentity);
            player.addStat(Stats.INTERACT_WITH_BLAST_FURNACE);
        }

    }
}
