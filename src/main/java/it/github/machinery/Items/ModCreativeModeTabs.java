package it.github.machinery.Items;

import it.github.machinery.Blocks.ModBlocks;
import it.github.machinery.Machinery;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Machinery.MODID);

    public static final Supplier<CreativeModeTab> MACHINERY_MOD_ITEMS = CREATIVE_MODE_TAB.register("machinery_mod_items_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.RAW_ALUMINUM.get()))
            .title(Component.translatable("creativetab.machinery.machinery_mod_items_tab"))
            .displayItems((ItemDisplayParameters, output) -> {
              output.accept(ModItems.RAW_ALUMINUM);
              output.accept(ModItems.ALUMINUM_INGOT);
              output.accept(ModItems.TIN_INGOT);
              output.accept(ModBlocks.ALUMINUM_ORE);
              output.accept(ModBlocks.ELECTRICAL_FURNACE);
              output.accept(ModBlocks.ALUMINUM_BLOCK);
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
