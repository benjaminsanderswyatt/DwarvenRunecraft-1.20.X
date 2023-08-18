package net.bsw.dwarvenrunecraft.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TransformationDustItem extends Item {
    public TransformationDustItem(Properties pProperties) {
        super(pProperties.stacksTo(1).rarity(Rarity.RARE).stacksTo(16));
    }


    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        double x = pContext.getClickedPos().getX();
        double y = pContext.getClickedPos().getY();
        double z = pContext.getClickedPos().getZ();

        Block targetedBlock = (pContext.getLevel().getBlockState(BlockPos.containing(x, y, z))).getBlock();
        String targetedBlockName = targetedBlock.getDescriptionId().substring(targetedBlock.getDescriptionId().lastIndexOf('.')+1);

        if (targetedBlock == Blocks.STONE || targetedBlock == Blocks.DEEPSLATE || targetedBlock == Blocks.NETHERRACK){
            BlockState rndOre = Blocks.AIR.defaultBlockState();
            rndOre = ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation
                    ("forge:ores_in_ground/" + targetedBlockName))).getRandomElement(RandomSource.create()).get().defaultBlockState();

            pContext.getLevel().setBlock(BlockPos.containing(x, y, z),
                    rndOre,
                    3);

            pContext.getItemInHand().setCount(pContext.getItemInHand().getCount() - 1);

            for (int i = 0; i < 10; i++){
                pContext.getLevel().addParticle(ParticleTypes.GLOW,
                        (x + 0.5 + Mth.nextDouble(RandomSource.create(), -1, 1)),
                        (y + 0.5 + Mth.nextDouble(RandomSource.create(), -1, 1)),
                        (z + 0.5 + Mth.nextDouble(RandomSource.create(), -1, 1)),
                        0, 1, 0);
            }

        }

        return InteractionResult.SUCCESS;
    }




    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.dwarvenrunecraft.transformation_dust.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }


}
