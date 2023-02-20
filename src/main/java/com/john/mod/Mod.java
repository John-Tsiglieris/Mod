package com.john.mod;

import com.mojang.logging.LogUtils;

import block.ModBlocks;
import item.ModCreativeModeTabs;
import item.ModItems;
import entity.custom.CustomEntityType;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTab.Builder;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import networking.ModMessages;
import villager.ModVillagers;

//import software.bernie.geckolib3.GeckoLib;

import org.slf4j.Logger;

@net.minecraftforge.fml.common.Mod("co")
public class Mod {
	
	public static final String MOD_ID = "co";
	
	/* obsolete for 1.19.3
	public static final CreativeModeTab MY_TAB = new CreativeModeTab(MOD_ID) {
		
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return null;
		}
	};
	*/
	
	
	
	
	public Mod() {
		
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		//Register new types of objects/items/entities/etc
		ModItems.register(modEventBus); 
		ModBlocks.register(modEventBus);
		CustomEntityType.register(modEventBus);                              // uncomment and game will crash
		ModVillagers.register(modEventBus);
		
		//GeckoLib.initialize();
		
		modEventBus.addListener(this::commonSetup);
		MinecraftForge.EVENT_BUS.register(this);
		
		modEventBus.addListener(this::addCreative);
	}

	
	
	private void commonSetup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			//I think the order you put these in matters???
			ModMessages.register();
			ModVillagers.registerPOIs();
		});
	}
	
	
	
	 public void addCreative(CreativeModeTabEvent.BuildContents event) {
	    	if(event.getTab() == CreativeModeTabs.INGREDIENTS) {
	    		event.accept(ModItems.ZIRCON);
	    		event.accept(ModItems.JASON);
	    		event.accept(ModItems.COMPRESSED_GUNPOWDER);
	    	}
	    	
	    	if(event.getTab() == ModCreativeModeTabs.MOD_TAB) {
	    		event.accept(ModItems.COMPRESSED_GUNPOWDER);
	    		event.accept(ModItems.CLIMBING_PICK);
	    		event.accept(ModBlocks.DEEPSLATE_EMERALD_ORE);
	    		event.accept(ModBlocks.GEM_INFUSING_STATION);
	    		event.accept(ModItems.HOOK);
	    		event.accept(ModItems.JASON);
	    		event.accept(ModItems.SHADOWBEAM_STAFF);
	    		event.accept(ModItems.WRENCH);
	    		event.accept(ModItems.ZIRCON);
	    	}
	    	
	    	if(event.getTab() == CreativeModeTabs.COMBAT) {
	    		event.accept(ModBlocks.DYNAMITE);
	    		event.accept(ModItems.SHADOWBEAM_STAFF);
	    	}
	    	
	    	if(event.getTab() == CreativeModeTabs.REDSTONE_BLOCKS) {
	    		event.accept(ModBlocks.DYNAMITE);
	    	}
	    }
	 
	 
	 
	 //idk what this is for
	 // EventBusSubscriber automatically registers all static methods in the class annotated with @SubscribeEvent
	 @net.minecraftforge.fml.common.Mod.EventBusSubscriber(modid = MOD_ID, bus = net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	 public static class ClientModEvents {
		 @SubscribeEvent
		 public static void onClientSetup(FMLClientSetupEvent event) {
			 
		 }
	 }
	 
}
