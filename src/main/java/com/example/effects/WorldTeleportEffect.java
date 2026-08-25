package com.example.effects;

import com.example.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.TeleportTarget;
import net.minecraft.util.math.Vec3d;

public class WorldTeleportEffect extends StatusEffect {

    public WorldTeleportEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xaa00FF);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(
            ServerWorld world,
            LivingEntity entity,
            int amplifier
    ) {

        if (entity.hasStatusEffect(ModEffects.WORLD_TELEPORT_EFFECT)
                && entity.getStatusEffect(ModEffects.WORLD_TELEPORT_EFFECT).getDuration() <= 1) {

            if (entity instanceof ServerPlayerEntity player) {
                TeleportTarget target = new TeleportTarget(
                        world,
                        Vec3d.ofBottomCenter(world.getSpawnPoint().getPos()),
                        Vec3d.ZERO,
                        0.0F,
                        0.0F,
                        TeleportTarget.NO_OP
                );

                player.teleportTo(target);
            }
        }

        return true;
    }
}
