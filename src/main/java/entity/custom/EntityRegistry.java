package entity.custom;

import java.util.function.BiFunction;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.ForgeRegistries;
import com.mojang.datafixers.types.Type;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.Entity;

import block.custom.Primed_Dynamite;

import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;



//will probably delete
/*
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityRegistry 
{
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES;
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES;
    public static final RegistryObject<EntityType<Primed_Dynamite>> DYNAMITE;

    
    public static <T extends Entity> RegistryObject<EntityType<T>> register(final String name, final EntityType.Builder<T> builder) {
        return (RegistryObject<EntityType<T>>)EntityRegistry.ENTITY_TYPES.register(name, () -> builder.m_20712_(name));
    }
    
    static {
    	ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "co");
        BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "co");
        DYNAMITE =
	            ENTITY_TYPES.register("dynamite",
	                    () -> EntityType.Builder.<Primed_Dynamite>of(Primed_Dynamite::new, MobCategory.MISC)
	        			.fireImmune().sized(0.98F, 0.98F)
	        			.clientTrackingRange(10).updateInterval(10));
    }
}

*/