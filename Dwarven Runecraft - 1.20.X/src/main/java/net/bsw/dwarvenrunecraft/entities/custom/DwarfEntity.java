package net.bsw.dwarvenrunecraft.entities.custom;

import net.bsw.dwarvenrunecraft.item.ModItems;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class DwarfEntity extends Animal {
    private static final EntityDataAccessor<Boolean> ATTACK =
            SynchedEntityData.defineId(DwarfEntity.class, EntityDataSerializers.BOOLEAN);

    public DwarfEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout=0;
    public final AnimationState attackAnimationState = new AnimationState();
    private int attackAnimationTimeout=0;

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            setupAnimationStates();
        }
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <=0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.isAttacking() && attackAnimationTimeout <=0) {
            attackAnimationTimeout = 10; // Length in ticks of the attack animation (1s = 20 ticks)
            attackAnimationState.start(this.tickCount);
        }else{
            --this.attackAnimationTimeout;
        }

        if (!this.isAttacking()){
            attackAnimationState.stop();
        }

    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6F, 1f);
        } else {
            f= 0f;
        }

        this.walkAnimation.update(f, 0.2F);


    }


    public void setAttacking(boolean attacking){
        this.entityData.set(ATTACK, attacking);
    }

    public boolean isAttacking(){
        return this.entityData.get(ATTACK);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACK,false);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new TemptGoal(this, 1.0D, Ingredient.of(ModItems.CELESTITE_SHARD.get()),false));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6.0f));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0D));
    }


    public static AttributeSupplier.Builder setAttributes() {
        return Mob.createLivingAttributes()
                .add(Attributes.MOVEMENT_SPEED,0.3)
                .add(Attributes.MAX_HEALTH,26)
                .add(Attributes.ARMOR,2)
                .add(Attributes.ATTACK_DAMAGE,3)
                .add(Attributes.FOLLOW_RANGE,16)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.2);
    }



    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }


    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.VILLAGER_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.VILLAGER_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.VILLAGER_HURT;
    }



    @Override
    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pDimensions) {
        return pDimensions.height * 0.75f;
    }


}
