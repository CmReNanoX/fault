package com.example;

import com.example.effects.TeleportEffect;
import com.example.effects.WorldTeleportEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> TELEPORT_EFFECT =
            Registry.registerReference(
                    Registries.STATUS_EFFECT,
                    Identifier.of(Fault.MOD_ID, "teleport_effect"),
                    new TeleportEffect()
            );
    public static final RegistryEntry<StatusEffect> WORLD_TELEPORT_EFFECT =
            Registry.registerReference(
                    Registries.STATUS_EFFECT,
                    Identifier.of(Fault.MOD_ID, "world_teleport_effect"),
                    new WorldTeleportEffect()
            );

    public static void registerModEffects() {
        // Завантажуємо клас
    }
}
