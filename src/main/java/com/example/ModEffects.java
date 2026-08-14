package com.example;

import com.example.effects.TeleportEffect;
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

    public static void registerModEffects() {
        // Завантажуємо клас
    }
}
