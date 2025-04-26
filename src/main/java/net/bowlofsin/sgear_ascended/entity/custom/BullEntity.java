package net.bowlofsin.sgear_ascended.entity.custom;

import net.bowlofsin.sgear_ascended.entity.ModEntities;
import net.bowlofsin.sgear_ascended.entity.ai.BullAttackGoal;
import net.bowlofsin.sgear_ascended.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;


public class BullEntity extends Animal {
    private static final EntityDataAccessor<Boolean> ATTACKING =
            SynchedEntityData.defineId(BullEntity.class, EntityDataSerializers.BOOLEAN);

    public BullEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public final AnimationState idleAnimState = new AnimationState();
    private int idleAnimTimeout = 0;

    public final AnimationState attackAnimState = new AnimationState();
    public int attackAnimTimeout = 0;

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this)); // entity will not sink in water

        this.goalSelector.addGoal(1, new BullAttackGoal(this, 1.0f, true));

        this.goalSelector.addGoal(1, new BreedGoal(this, 1.15f, CowEntity.class));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.25f, Ingredient.of(ModItems.FERTILEOFRUIT.get()), false));

        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.35f));

        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 0.55f));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 3f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ARMOR, 3D)
                .add(Attributes.ATTACK_DAMAGE, 5D)
                .add(Attributes.ATTACK_KNOCKBACK, 1.5D)
                .add(Attributes.FOLLOW_RANGE, 20D)
                ;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            setupAnimStates();
        }

    }

    private void setupAnimStates() {
        if (this.idleAnimTimeout <= 0) {
            this.idleAnimTimeout = this.random.nextInt(40) + 80;
            this.idleAnimState.start(this.tickCount);
        } else {
            --this.idleAnimTimeout;
        }

        if (this.isAttacking() && attackAnimTimeout <= 0) {
            attackAnimTimeout = 80; // length in ticks of atk animation
            attackAnimState.start(this.tickCount);
        } else {
            --this.attackAnimTimeout;
        }

        if (!this.isAttacking()) {
            attackAnimState.stop();
        }
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING,false);
    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(pPartialTick * 6f, 1f);
        } else {
            f = 0f;
        }

        this.walkAnimation.update(f, 0.2f);
    }

    @Override
    public boolean canMate(Animal pOtherAnimal) {
        if (pOtherAnimal == this) {
            return false;
        } else if (pOtherAnimal.getClass() != CowEntity.class) {
            return false;
        } else {
            return this.isInLove() && pOtherAnimal.isInLove();
        }
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob ageableMob) {
        AgeableMob toReturn;
        int chance = this.random.nextIntBetweenInclusive(0, 100);
        if (chance > 20) {
            toReturn = ModEntities.COW.get().create(pLevel);
        }
        else {
            toReturn = ModEntities.BULL.get().create(pLevel);
        }

        return toReturn;
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Items.WHEAT) || pStack.is(ModItems.FERTILEOFRUIT.get());
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.COW_HURT;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.COW_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.COW_DEATH;
    }

    protected void playStepSound(BlockPos pPos, BlockState pBlock) {
        this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
    }
}
