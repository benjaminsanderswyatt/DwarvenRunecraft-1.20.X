package net.bsw.dwarvenrunecraft.block.custom.fluid;

import net.bsw.dwarvenrunecraft.effect.ModEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

public class PureLaguzBlock extends LiquidBlock {
    public PureLaguzBlock(FlowingFluid pFluid, Properties pProperties) {
        super(pFluid, pProperties);
    }


    @Override
    public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
        super.entityInside(blockstate, world, pos, entity);

        if (entity == null)
            return;
        if (entity instanceof LivingEntity livingentity && !livingentity.level().isClientSide()){
            livingentity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 110, 0));
            livingentity.addEffect(new MobEffectInstance(MobEffects.LUCK, 110, 0));
            livingentity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 110, 0));
            livingentity.addEffect(new MobEffectInstance(ModEffects.COLOURED_GLOWING.get(), 110));
        }





        for (int i = 0; i < 1; i++){

            entity.level().addParticle(ParticleTypes.HEART,
                    (entity.getX() + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)),
                    (entity.getY() + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)),
                    (entity.getZ() + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)),
                    0, 0, 0);

        }

    }


}
