package block.custom;

import javax.annotation.Nullable;
import block.custom.Dynamite;
import entity.custom.CustomEntityType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;

public class Primed_Dynamite extends Entity { //Entity {
	 private static final EntityDataAccessor<Integer> DATA_FUSE_ID = SynchedEntityData.defineId(Primed_Dynamite.class, EntityDataSerializers.INT);
	 private static final int DEFAULT_FUSE_TIME = 160;
	 @Nullable
	 private LivingEntity owner;
	
	 /*
	public Primed_Dynamite(RegistryObject<EntityType<Entity>> dynamite, Level p_19871_) {
		super((EntityType<? extends PrimedTnt>) dynamite, p_19871_);
		this.blocksBuilding = true;
	}
	*/
	
	 /*
	//old constructor with no changes
	public Primed_Dynamite(EntityType<?> p_19870_, Level p_19871_) {
		super(p_19870_, p_19871_);
		this.blocksBuilding = true;
	}
	*/
	
	public Primed_Dynamite(EntityType<? extends Primed_Dynamite> entityType, Level p_19871_) {
		super(entityType, p_19871_);
		this.blocksBuilding = true;
	}
	

	
	 public Primed_Dynamite(Level p_32079_, double p_32080_, double p_32081_, double p_32082_, @Nullable LivingEntity p_32083_) {
	      //this(CustomEntityType.DYNAMITE, p_32079_);
		  this((EntityType<Primed_Dynamite>)CustomEntityType.DYNAMITE, p_32079_);
	      this.setPos(p_32080_, p_32081_, p_32082_);
	      double d0 = p_32079_.random.nextDouble() * (double)((float)Math.PI * 2F);
	      this.setDeltaMovement(-Math.sin(d0) * 0.02D, (double)0.2F, -Math.cos(d0) * 0.02D);
	      this.setFuse(80);
	      this.xo = p_32080_;
	      this.yo = p_32081_;
	      this.zo = p_32082_;
	      this.owner = p_32083_;
	   }
	   
	 
	/*
	 public Primed_Dynamite(Level p_32079_, double p_32080_, double p_32081_, double p_32082_, @Nullable LivingEntity p_32083_) {
	      this(CustomEntityType.DYNAMITE, p_32079_);
	      this.setPos(p_32080_, p_32081_, p_32082_);
	      double d0 = p_32079_.random.nextDouble() * (double)((float)Math.PI * 2F);
	      this.setDeltaMovement(-Math.sin(d0) * 0.02D, (double)0.2F, -Math.cos(d0) * 0.02D);
	      this.setFuse(80);
	      this.xo = p_32080_;
	      this.yo = p_32081_;
	      this.zo = p_32082_;
	      this.owner = p_32083_;
	   }
	   */
	 
	 @Override
	 protected void defineSynchedData() {
	      this.entityData.define(DATA_FUSE_ID, 80);
	   }

     protected Entity.MovementEmission getMovementEmission() {
	      return Entity.MovementEmission.NONE;
	   }

	 public boolean isPickable() {
	      return !this.isRemoved();
	   }
	 
	 
	 public void tick() {
	      if (!this.isNoGravity()) {
	         this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.04D, 0.0D));
	      }

	      this.move(MoverType.SELF, this.getDeltaMovement());
	      this.setDeltaMovement(this.getDeltaMovement().scale(0.98D));
	      if (this.onGround) {
	         this.setDeltaMovement(this.getDeltaMovement().multiply(0.7D, -0.5D, 0.7D));
	      }

	      int i = this.getFuse() - 1;
	      this.setFuse(i);
	      if (i <= 0) {
	         this.discard();
	         if (!this.level.isClientSide) {
	            this.explode();
	         }
	      } else {
	         this.updateInWaterStateAndDoFluidPushing();
	         if (this.level.isClientSide) {
	            this.level.addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 0.5D, this.getZ(), 0.0D, 0.0D, 0.0D);
	         }
	      }

	   }
	   
	 
	 
	 protected void explode() {
	      float f = 4.0F;
	      this.level.explode(this, this.getX(), this.getY(0.0625D), this.getZ(), 4.0F, Level.ExplosionInteraction.TNT);
	   }

	@Override
	protected void readAdditionalSaveData(CompoundTag p_20052_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag p_20139_) {
		// TODO Auto-generated method stub
		
	}
	
	 
	 
	 @Nullable
	   public LivingEntity getOwner() {
	      return this.owner;
	   }

	   protected float getEyeHeight(Pose p_32088_, EntityDimensions p_32089_) {
	      return 0.15F;
	   }
	 
	 
	 
	 public void setFuse(int p_32086_) {
	      this.entityData.set(DATA_FUSE_ID, p_32086_);
	   }

	   public int getFuse() {
	      return this.entityData.get(DATA_FUSE_ID);
	   }

	

}
