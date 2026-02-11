package net.ra77a3l3.pocketutilities.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ra77a3l3.pocketutilities.PocketUtilities;
import net.ra77a3l3.pocketutilities.item.custom.ChiselItem;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PocketUtilities.MOD_ID);

    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> EXAMPLE_ITEM_RAW = ITEMS.register("example_item_raw",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
