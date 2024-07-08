package net.bsw.dwarvenrunecraft.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OreScannerItem extends Item {
    public OreScannerItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder<ItemStack> scanner = super.use(world, entity, hand);

        if(!world.isClientSide) {

            double playerX = entity.getX();
            double playerY = entity.getY();
            double playerZ = entity.getZ();

            boolean found = false;

            for (int x = -10; x <= 10; x++) {
                for (int y = -10; y <= 10; y++) {
                    for (int z = -10; z <= 10; z++) {
                        BlockState block = world.getBlockState(BlockPos.containing(playerX + x, playerY + y, playerZ + z));
                        if (block.is(Tags.Blocks.ORES)){
                            found = true;

                            System.out.println(block);














                        }
                    }
                }
            }

            if (found == true) {
                System.out.println("Found");

            } else {
                System.out.println("Nothing");

            }
        }

        return scanner;
    }


    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.dwarvenrunecraft.ore_scanner.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

}
