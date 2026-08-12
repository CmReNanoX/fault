package com.example.items.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityMegaEnderPearl extends EnderPearlEntity {

    private static final float DAMAGE = 10.0F;

    private final World pearlWorld;

    public EntityMegaEnderPearl(
            World world,
            LivingEntity owner,
            ItemStack stack
    ) {
        super(world, owner, stack);
        this.pearlWorld = world;
    }

    @Override
    protected void onEntityHit(EntityHitResult hitResult) {

        if (pearlWorld instanceof ServerWorld serverWorld) {

            Entity target = hitResult.getEntity();
            Entity owner = getOwner();

            // Не б'ємо самого власника перлини
            if (owner != null && target != owner) {

                target.damage(
                        serverWorld,
                        serverWorld.getDamageSources().thrown(
                                this,
                                owner
                        ),
                        DAMAGE
                );
            }
        }

        // Виконуємо стандартну логіку Ender Pearl:
        // телепортація власника
        super.onEntityHit(hitResult);
    }
}