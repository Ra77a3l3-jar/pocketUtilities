package net.ra77a3l3.pocketutilities.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class EngineerNotebookItem extends Item {

    // Constructor
    public EngineerNotebookItem(Properties properties) {
        super(properties);
    }

    // Method to handle right-click interaction with Notebook
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        // Only prints a message server sde
        if(!level.isClientSide) {
            player.sendSystemMessage(Component.literal("You just opened the Engineer's Notebook!"));
        }

        return InteractionResultHolder.success(itemstack);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal("Your guide to portable engineering"));
        tooltipComponents.add(Component.literal("Right-click to read").withStyle(ChatFormatting.GRAY));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
