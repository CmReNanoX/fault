package com.example.items.entities;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

import java.util.Set;

public class ErrorEnderPearlEntity extends EnderPearlEntity {

    public ErrorEnderPearlEntity(
            World world,
            LivingEntity owner,
            ItemStack stack
    ) {
        super(world, owner, stack);
    }

    @Override
    protected void onCollision(HitResult hitResult) {

        if (!(getEntityWorld() instanceof ServerWorld serverWorld)) {
            discard();
            return;
        }

        if (!(getOwner() instanceof ServerPlayerEntity player)) {
            discard();
            return;
        }

        // 10% шанс — не телепортувати
        if (serverWorld.random.nextFloat() < 0.10F) {
            discard();
            return;
        }

        /*
         * Беремо точку, куди влучила перлина.
         */
        double hitX = hitResult.getPos().x;
        double hitY = hitResult.getPos().y;
        double hitZ = hitResult.getPos().z;

        /*
         * Рандомна точка ±32 блоки
         * від місця попадання.
         */
        double x = hitX
                + (serverWorld.random.nextDouble() * 64.0 - 32.0);

        double y = hitY
                + (serverWorld.random.nextDouble() * 64.0 - 32.0);

        double z = hitZ
                + (serverWorld.random.nextDouble() * 64.0 - 32.0);

        /*
         * Телепортуємо гравця.
         */
        player.teleport(
                serverWorld,
                x,
                y,
                z,
                Set.of(),
                player.getYaw(),
                player.getPitch(),
                true
        );

        discard();
    }
}