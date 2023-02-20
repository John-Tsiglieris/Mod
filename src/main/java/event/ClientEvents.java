package event;

//import javax.swing.text.JTextComponent.KeyBinding;

//import com.john.mod.Mod;
import block.ModBlocks;
import block.entity.ModBlockEntities;
import block.entity.renderer.GemInfusingStationBlockEntityRenderer;
import client.ThirstHudOverlay;
import networking.ModMessages;
import networking.packet.DrinkWaterC2SPacket;
import networking.packet.ExampleC2SPacket;
import util.KeyBinding;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
	
    @net.minecraftforge.fml.common.Mod.EventBusSubscriber(modid = com.john.mod.Mod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if(KeyBinding.DRINKING_KEY.consumeClick()) {
               ModMessages.sendToServer(new ExampleC2SPacket());
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Pressed a key"));
            }
        }
    }

    @net.minecraftforge.fml.common.Mod.EventBusSubscriber(modid = com.john.mod.Mod.MOD_ID, value = Dist.CLIENT, bus = net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.DRINKING_KEY);
        }

        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
            //event.registerAboveAll("thirst", ThirstHudOverlay.HUD_THIRST);
        }

        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            //event.registerBlockEntityRenderer(ModBlockEntities.GEM_INFUSING_STATION.get(),
                    //GemInfusingStationBlockEntityRenderer::new);
        }
    }
    
}