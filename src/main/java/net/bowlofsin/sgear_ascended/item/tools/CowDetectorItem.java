package net.bowlofsin.sgear_ascended.item.tools;

import net.bowlofsin.sgear_ascended.entity.ModEntities;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.List;


public class CowDetectorItem extends Item {
    private final float searchRadius = 50;


    public CowDetectorItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced){
        pTooltipComponents.add(Component.translatable("tooltip.cowsgetmilked.cow_detector.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {

        AABB area = new AABB(pPlayer.getX() - searchRadius / 2, pPlayer.getY() - searchRadius / 2, pPlayer.getZ() - searchRadius / 2,
                pPlayer.getX() + searchRadius / 2, pPlayer.getY() + searchRadius / 2, pPlayer.getZ() + searchRadius / 2);

        List<Entity> foundEntities = pLevel.getEntities(pPlayer, area);

        for (Entity entity: foundEntities) {
            if (entity.getType() == ModEntities.COW.get() || entity.getType() == ModEntities.BULL.get()) {
                pPlayer.displayClientMessage(Component.literal(entity.getName() + " found at " + entity.getPosition(10)), false);
            }
        }

        pPlayer.getItemInHand(pHand).hurtAndBreak(25, pPlayer, player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.use(pLevel, pPlayer, pHand);
    }
}
