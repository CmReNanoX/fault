package com.example.effects;

import com.example.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.TeleportTarget;


public class TeleportEffect extends StatusEffect {

    public TeleportEffect() {
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

        if (entity.hasStatusEffect(ModEffects.TELEPORT_EFFECT)
                && entity.getStatusEffect(ModEffects.TELEPORT_EFFECT).getDuration() <= 1) {

            if (entity instanceof ServerPlayerEntity player) {
                TeleportTarget target = player.getRespawnTarget(true, TeleportTarget.NO_OP);

                player.teleportTo(target);
            }
        }

        return true;
    }
}
