package item;

import com.john.mod.Mod;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = 
			DeferredRegister.create(ForgeRegistries.ITEMS, Mod.MOD_ID);             // Second parameter uses Mod class you made

	/* EXAMPLE FOR NEW ITEMS
	public static final RegistryObject<Item> ITEMNAME = ITEMS.register("itemname",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.MY_TAB))); //tab goes here
	*/
	
	public static final RegistryObject<Item> COMPRESSED_GUNPOWDER = ITEMS.register("compressed_gunpowder",
			() -> new Item(new Item.Properties()));
	
	public static final RegistryObject<Item> HOOK = ITEMS.register("hook",
			() -> new Item(new Item.Properties()));
	
	public static final RegistryObject<Item> CLIMBING_PICK = ITEMS.register("climbing_pick",
			() -> new Item(new Item.Properties()));
	
	public static final RegistryObject<Item> JASON = ITEMS.register("jason",
			() -> new Item(new Item.Properties()));
	
	public static final RegistryObject<Item> SHADOWBEAM_STAFF = ITEMS.register("shadowbeam_staff",
			() -> new Item(new Item.Properties()));
	
	public static final RegistryObject<Item> WRENCH = ITEMS.register("wrench",
			() -> new Item(new Item.Properties()));
	
	public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
			() -> new Item(new Item.Properties()));
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
