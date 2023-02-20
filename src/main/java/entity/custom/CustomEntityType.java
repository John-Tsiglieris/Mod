package entity.custom;

import java.util.function.Supplier;

import com.john.mod.Mod;

import block.custom.Primed_Dynamite;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.flag.FeatureElement;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CustomEntityType { //<T extends Entity> implements FeatureElement, EntityTypeTest<Entity, T> {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
			DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Mod.MOD_ID);
	
	/*
	public static final EntityType<Primed_Dynamite> DYNAMITE = register("dynamite", 
	EntityType.Builder.<Primed_Dynamite>of(Primed_Dynamite::new, MobCategory.MISC)
			.fireImmune().sized(0.98F, 0.98F)
			.clientTrackingRange(10).updateInterval(10));
	*/
	
	
	/*
	//copied from tutorial chomper
	 public static final RegistryObject<EntityType<Entity>> CHOMPER =
	            ENTITY_TYPES.register("chomper",
	                    () -> EntityType.Builder.of(ChomperEntity::new, MobCategory.MONSTER)
	                            .sized(0.4f, 1.5f)
	                            .build(new ResourceLocation(Mod.MOD_ID, "chomper").toString()));
	*/
	
	
	/*
												//Entity changed from Primed_Dynamite
	   public static final RegistryObject<EntityType<Primed_Dynamite>> DYNAMITE =
	            ENTITY_TYPES.register("dynamite",
	                    () -> EntityType.Builder.<Primed_Dynamite>of(Primed_Dynamite::new, MobCategory.MISC)
	        			.fireImmune().sized(0.98F, 0.98F)
	        			.clientTrackingRange(10).updateInterval(10));
	   */
	
	   
	 //Entity changed from Primed_Dynamite
	   public static final RegistryObject<EntityType<Primed_Dynamite>> DYNAMITE =
	            ENTITY_TYPES.register("dynamite",
	                    (EntityType.Builder<Primed_Dynamite>)EntityType.Builder.<Primed_Dynamite>of(Primed_Dynamite::new, MobCategory.MISC)
	        			.fireImmune().sized(0.98F, 0.98F)
	        			.clientTrackingRange(10).updateInterval(10));
	   
	   /*
	 //Entity changed from Primed_Dynamite
	   public static final RegistryObject<EntityType<Primed_Dynamite>> DYNAMITE =
	            ENTITY_TYPES.register("dynamite",
	                    (EntityType.EntityFactoru<Primed_Dynamite>EntityType.Builder.<Primed_Dynamite>of(Primed_Dynamite::new, MobCategory.MISC)
	        			.fireImmune().sized(0.98F, 0.98F)
	        			.clientTrackingRange(10).updateInterval(10));
	   */
	   
	  
	
	
	
	
	

	/*
	private static <T extends Entity> EntityType<T> register(String p_20635_, EntityType.Builder<T> p_20636_) {
	      return Registry.register(BuiltInRegistries.ENTITY_TYPE, p_20635_, p_20636_.build(p_20635_));
	   }
	*/
	
	public static void register(IEventBus eventBus) {
		ENTITY_TYPES.register(eventBus);
	}
	
	/*
	@Override
	public T tryCast(Entity p_156918_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends Entity> getBaseClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FeatureFlagSet requiredFeatures() {
		// TODO Auto-generated method stub
		return null;
	}
	*/

}
