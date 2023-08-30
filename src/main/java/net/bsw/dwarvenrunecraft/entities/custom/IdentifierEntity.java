package net.bsw.dwarvenrunecraft.entities.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.level.Level;

public class IdentifierEntity extends AmbientCreature {
    public IdentifierEntity(EntityType<? extends AmbientCreature> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    public static AttributeSupplier setAttributes() {
        return AmbientCreature.createLivingAttributes()
                .add(Attributes.MAX_HEALTH,1D).build();
    }

    public boolean isIgnoringBlockTriggers() {
        return true;
    }

    public boolean isPushable() {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
    }














}
