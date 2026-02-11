package net.ra77a3l3.pocketutilities.item;
import net.minecraft.resources.ResourceLocation;
import net.ra77a3l3.pocketutilities.PocketUtilities;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ra77a3l3.pocketutilities.block.ModBlocks;


import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PocketUtilities.MOD_ID);

    public static final Supplier<CreativeModeTab> EXAMPLE_ITEMS_TAB = CREATIVE_MOD_TAB.register("example_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.EXAMPLE_ITEM.get()))
                    .title(Component.translatable("creativetab.pocketutilities.example_items"))
                    .displayItems((ItemDisplayParameters, output) -> {
                        output.accept(ModItems.EXAMPLE_ITEM);
                        output.accept(ModItems.EXAMPLE_ITEM_RAW);
                        output.accept(ModItems.CHISEL);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> EXAMPLE_BLOCKS_TAB = CREATIVE_MOD_TAB.register("example_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.EXAMPLE_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(PocketUtilities.MOD_ID, "example_items_tab"))
                    // Needed to give an order to the tabs
                    .title(Component.translatable("creativetab.pocketutilities.example_blocks"))
                    .displayItems((ItemDisplayParameters, output) -> {
                        output.accept(ModBlocks.EXAMPLE_BLOCK);
                        output.accept(ModBlocks.EXAMPLE_BLOCK_ORE);
                        output.accept(ModBlocks.EXAMPLE_BLOCK_DEEPSLATE_ORE);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MOD_TAB.register(eventBus);
    }
}
