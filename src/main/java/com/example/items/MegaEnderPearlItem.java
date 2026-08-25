package com.example.items;

import com.example.items.entities.MegaEnderPearlEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnderPearlItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class MegaEnderPearlItem extends EnderPearlItem {

    // 16 секунд = 320 ticks
    private static final int COOLDOWN = 320;

    // Стандартна сила Ender Pearl приблизно 1.5.
    // 1.5 × 16 = 24.0
    private static final float SPEED = 24.0F;

    public MegaEnderPearlItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {

        ItemStack stack = player.getStackInHand(hand);

        // Перевірка cooldown
        if (player.getItemCooldownManager().isCoolingDown(stack)) {
            return ActionResult.FAIL;
        }

        if (!world.isClient()) {

            MegaEnderPearlEntity pearl =
                    new MegaEnderPearlEntity(
                            world,
                            player,
                            stack
                    );

            // Напрямок польоту
            pearl.setVelocity(
                    player,
                    player.getPitch(),
                    player.getYaw(),
                    0.0F,
                    SPEED,
                    1.0F
            );

            world.spawnEntity(pearl);

            // Забираємо 1 перлину
            if (!player.getAbilities().creativeMode) {
                stack.decrement(1);
            }

            // 16 секунд cooldown
            player.getItemCooldownManager().set(
                    stack,
                    COOLDOWN
            );
        }

        return ActionResult.SUCCESS;
    }
}