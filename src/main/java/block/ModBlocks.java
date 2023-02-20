package block;

import java.util.function.Supplier;

import com.john.mod.Mod;

import block.custom.*;
import item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS =
			DeferredRegister.create(ForgeRegistries.BLOCKS, Mod.MOD_ID);
	
	//copy this whenever registering a new block
	public static final RegistryObject<Block> DYNAMITE = registerBlock("dynamite",
			() -> new Dynamite(BlockBehaviour.Properties.of(Material.EXPLOSIVE)
					.strength(6f).instabreak()));
	
	public static final RegistryObject<Block> DEEPSLATE_EMERALD_ORE = registerBlock("deepslate_emerald_ore",
			() -> new Dynamite(BlockBehaviour.Properties.of(Material.STONE)
					.strength(10f)));
	
	public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock("jumpy_block",
            () -> new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()));
	
	public static final RegistryObject<Block> GEM_INFUSING_STATION = registerBlock("gem_infusing_station",
            () -> new GemInfusingStationBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()));
	
	
	private static <T extends Block> RegistryObject<T> registerBlock( String name, Supplier<T> block) {
		RegistryObject<T> toReturn = BLOCKS.register(name,  block);
		registerBlockItem(name, toReturn); 
		return toReturn;
	}
	
	
	//Need to learn about generics in Java
	//Go back to tutoial #3 @3 minutes for reason why this exists
	private static<T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
		return ModItems.ITEMS.register(name,  () -> new BlockItem(block.get(),
				new Item.Properties()));
	}
	
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
	
}
