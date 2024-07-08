package net.bsw.dwarvenrunecraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.FlowingFluid;

public class LaunchPadBlock extends PressurePlateBlock {

    public LaunchPadBlock(PressurePlateBlock.Sensitivity pSensitivity, BlockBehaviour.Properties pProperties) {
        super(pSensitivity, pProperties, BlockSetType.STONE);
    }


    @Override
    public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
        super.entityInside(blockstate, world, pos, entity);

        if (entity == null)
            return;
        if (entity instanceof LivingEntity livingentity && !livingentity.level().isClientSide()){
            livingentity.addEffect(new MobEffectInstance(MobEffects.POISON, 110, 0));
            livingentity.addEffect(new MobEffectInstance(MobEffects.WITHER, 110, 0));
        }

    }





}
