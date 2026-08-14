package com.example;

import com.example.items.ItemErrorEnderPearl;
import com.example.items.ItemMegaEnderPearl;

import com.example.items.ItemTeleportPotion;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.sound.SoundEvents;


public class ModItems {

    public static final Item ERROR_ENDER_PEARL = registerErrorPearl();

    public static final Item MEGA_ENDER_PEARL = registerMegaPearl();

    public static final Item TELEPORT_POTION = registerTeleportPotion();

    private static Item registerErrorPearl() {
        Identifier id = Identifier.of("fault", "error_ender_pearl");

        RegistryKey<Item> key = RegistryKey.of(
                RegistryKeys.ITEM,
                id
        );

        Item.Settings settings = new Item.Settings()
                .maxCount(16)
                .registryKey(key);

        return Registry.register(
                Registries.ITEM,
                key,
                new ItemErrorEnderPearl(settings)
        );
    }

    private static Item registerMegaPearl() {
        Identifier id = Identifier.of("fault", "mega_ender_pearl");

        RegistryKey<Item> key = RegistryKey.of(
                RegistryKeys.ITEM,
                id
        );

        Item.Settings settings = new Item.Settings()
                .maxCount(16)
                .registryKey(key);

        return Registry.register(
                Registries.ITEM,
                key,
                new ItemMegaEnderPearl(settings)
        );
    }

    private static Item registerTeleportPotion() {
        Identifier id = Identifier.of(Fault.MOD_ID, "teleport_potion");

        RegistryKey<Item> key = RegistryKey.of(
                RegistryKeys.ITEM,
                id
        );

        StatusEffectInstance effect = new StatusEffectInstance(
                ModEffects.TELEPORT_EFFECT,
                320, // 16 секунд
                0
        );

        Item.Settings settings = new Item.Settings()
                .maxCount(1)
                .registryKey(key)
                .food(
                        new FoodComponent.Builder()
                                .nutrition(0)
                                .saturationModifier(0)
                                .alwaysEdible()
                                .build(),
                        ConsumableComponent.builder()
                                .consumeSeconds(1.6f)
                                .sound(SoundEvents.ENTITY_GENERIC_DRINK)
                                .build()
                )
                .component(
                        DataComponentTypes.POTION_CONTENTS,
                        new PotionContentsComponent(
                                java.util.Optional.empty(),
                                java.util.Optional.empty(),
                                java.util.List.of(effect),
                                java.util.Optional.empty()
                        )

                );

        return Registry.register(
                Registries.ITEM,
                key,
                new ItemTeleportPotion(settings)
        );
    }




    public static void registerModItems() {
        // Завантаження класу
    }
}