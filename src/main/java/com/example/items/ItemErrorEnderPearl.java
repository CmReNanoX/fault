package com.example.items;

import com.example.items.entities.EntityErrorEnderPearl;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemErrorEnderPearl extends EnderPearlItem {

    public ItemErrorEnderPearl(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(
            World world,
            PlayerEntity player,
            Hand hand
    ) {

        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient()) {

            if (player instanceof ServerPlayerEntity serverPlayer) {

                EntityErrorEnderPearl pearl =
                        new EntityErrorEnderPearl(
                                world,
                                serverPlayer,
                                stack
                        );

                /*
                 * Кидаємо як звичайну Ender Pearl.
                 */
                pearl.setVelocity(
                        player,
                        player.getPitch(),
                        player.getYaw(),
                        0.0F,
                        1.5F,
                        1.0F
                );

                world.spawnEntity(pearl);

                /*
                 * Забираємо 1 перлину.
                 */
                if (!player.getAbilities().creativeMode) {
                    stack.decrement(1);
                }
            }
        }

        return ActionResult.SUCCESS;
    }
}