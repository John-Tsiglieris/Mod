package item;

import com.john.mod.Mod;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
//import net.minecraftforge.fml.common.Mod;
//@net.minecraftforge.fml.common.Mod("co")
import net.minecraftforge.eventbus.api.SubscribeEvent;

@net.minecraftforge.fml.common.Mod.EventBusSubscriber(modid = Mod.MOD_ID, bus = net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
	public static CreativeModeTab  MOD_TAB;
	
	
	//create new creative mode tabs
	@SubscribeEvent
	public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
		MOD_TAB = event.registerCreativeModeTab(new ResourceLocation(Mod.MOD_ID, "mod_tab"),
				builder -> builder.icon(() -> new ItemStack(ModItems.COMPRESSED_GUNPOWDER.get())).title(Component.translatable("creativemodetab.mod_tab")));
	}

}
