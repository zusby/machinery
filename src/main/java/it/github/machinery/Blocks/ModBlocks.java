package it.github.machinery.Blocks;

import it.github.machinery.Items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {


    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("machinery");
    public static final DeferredBlock<Block> ELECTRICAL_FURNACE =
            registerBlock("electrical_furnace_block",
                    ()->new Block(BlockBehaviour.Properties.of()
                            .mapColor(MapColor.METAL)
                            .sound(SoundType.ANVIL)));

    public static void register(IEventBus eventbus){
        BLOCKS.register(eventbus);
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }
    private static<T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, ()->new BlockItem(block.get(), new Item.Properties()));
    }



}
