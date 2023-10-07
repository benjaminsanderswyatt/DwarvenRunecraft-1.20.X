package net.bsw.dwarvenrunecraft.entities.custom;

import net.bsw.dwarvenrunecraft.item.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class DwarfEntity extends Animal {

    public DwarfEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0,new FloatGoal(this));
        this.goalSelector.addGoal(1,new LookAtPlayerGoal(this, Player.class, 6.0f));
        this.goalSelector.addGoal(2,new TemptGoal(this, 1.0D, Ingredient.of(ModItems.CELESTITE_SHARD.get()),false));
    }


    public static AttributeSupplier setAttributes() {
        return Mob.createLivingAttributes()
                .add(Attributes.MOVEMENT_SPEED,0.3)
                .add(Attributes.MAX_HEALTH,26)
                .add(Attributes.ARMOR,2)
                .add(Attributes.ATTACK_DAMAGE,3)
                .add(Attributes.FOLLOW_RANGE,16)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.2).build();
    }



    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }
}
