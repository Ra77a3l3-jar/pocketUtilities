package net.ra77a3l3.pocketutilities.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.ra77a3l3.pocketutilities.block.ModBlocks;

import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISELABLE_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.SANDSTONE, Blocks.SMOOTH_SANDSTONE,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.NETHERRACK, ModBlocks.EXAMPLE_BLOCK.get() // Need to do .get() for custom blocks
            );

    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel(); // Get the level where action is performed
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock(); // Get the block that was clicked

        if(CHISELABLE_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) { // Check if we are on server side
                level.setBlockAndUpdate(context.getClickedPos(), CHISELABLE_MAP.get(clickedBlock).defaultBlockState()); // Replace the clicked block with the chiseled version

                // Damage the chisel
                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                // Play a sound effect
                level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }
        return InteractionResult.SUCCESS;
    }
}
