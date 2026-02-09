package net.ra77a3l3.pocketutilities.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ra77a3l3.pocketutilities.PocketUtilities;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PocketUtilities.MOD_ID);

    public static final DeferredItem<Item> ENGINEER_NOTEBOOK = ITEMS.register("engineer_notebook",
            () -> new EngineerNotebookItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
