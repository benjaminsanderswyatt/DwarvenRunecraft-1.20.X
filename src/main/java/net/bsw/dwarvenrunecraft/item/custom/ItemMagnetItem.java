package net.bsw.dwarvenrunecraft.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemMagnetItem extends Item {
    public ItemMagnetItem(Properties pProperties) {
        super(pProperties);
    }

    int range = 3;



    public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int pSlotId, boolean pIsSelected) {

        if (itemstack.getOrCreateTag().getBoolean("active")){
            getRange(entity,itemstack);
            //Find a way to be able to upgrade the range
            //fist work on runing table and upgrading runeing

            AABB area = new AABB(entity.position().add(-range, -range, -range), entity.position().add(range, range, range));

            List<ItemEntity> items = world.getEntities(EntityType.ITEM, area, item -> item.isAlive());
            items.forEach(item -> item.setPos(entity.getX(), entity.getY(), entity.getZ()));
        }



    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        InteractionResultHolder<ItemStack> magnet = super.use(world, player, hand);
        ItemStack itemstack = player.getItemInHand(hand);

            if (player.isShiftKeyDown()) {




                toggleActive(player, itemstack);

                if (isActivated(itemstack)) {
                    System.out.println(itemstack.getOrCreateTag().getBoolean("active"));
                    //random animation fun
                    Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
                } else {
                    System.out.println("else" + itemstack.getOrCreateTag().getBoolean("active"));

                }
            }



        return magnet;
    }

    public void getRange(Entity player, ItemStack stack){
            stack.getOrCreateTag().putInt("range", range);
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
        pTooltipComponents.add(Component.translatable("tooltip.dwarvenrunecraft.item_magnet.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

}
