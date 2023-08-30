package net.bsw.dwarvenrunecraft.item.custom;

import net.bsw.dwarvenrunecraft.effect.ModEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SpectreGlassItem extends Item {
    public SpectreGlassItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        InteractionResultHolder<ItemStack> spectre = super.use(world, player, hand);
        ItemStack itemstack = player.getItemInHand(hand);

        if (player.isShiftKeyDown()) {

            toggleActive(player, itemstack);

            if (!isActivated(itemstack)){
                //WIP display text "Activated"/"Deactivated"
            }

        }

        return spectre;
    }


    public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int pSlotId, boolean pIsSelected) {

        if (!world.isClientSide() && this.isActivated(itemstack) && entity instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(ModEffects.COLOURED_GLOWING.get(), 210, 0, false, false, true));
        }

    }






    public static void toggleActive(Player player, ItemStack stack){
        if(!player.level().isClientSide){
            boolean active = stack.getOrCreateTag().contains("active") && stack.getOrCreateTag().getBoolean("active");
            stack.getOrCreateTag().putBoolean("active", !active);
        }
    }

    public boolean isActivated(ItemStack stack) {
        return stack.getOrCreateTag().getBoolean("active");
    }


    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.dwarvenrunecraft.spectre_glass.tooltip"));


        ///////////////////////tooltip.add(Component.translatable("tooltip." + ForbiddenArcanus.MOD_ID + (deactivated ? ".deactivated" : ".activated")).withStyle(deactivated ? ChatFormatting.RED : ChatFormatting.GREEN).append(" ").append(toggle));


        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

}
