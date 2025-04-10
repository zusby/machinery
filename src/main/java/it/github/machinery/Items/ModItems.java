package it.github.machinery.Items;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final String MOD_ID = "machinery";

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

    public static void register(IEventBus eventbus){
        ITEMS.register(eventbus);
    }

}
