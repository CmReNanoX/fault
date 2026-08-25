package com.example;

import com.example.items.EssenceItem;
import com.example.items.EssenceIngotItem;
import com.example.items.ErrorEnderPearlItem;
import com.example.items.MegaEnderPearlItem;
import com.example.items.TeleportPotionItem;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.sound.SoundEvents;


public class ModItems {
    public static final Item ESSENCE = registerEssence();
    public static final Item ESSENCE_INGOT = registerEssenceIngot();
    public static final Item ERROR_ENDER_PEARL = registerErrorPearl();
    public static final Item MEGA_ENDER_PEARL = registerMegaPearl();
    public static final Item TELEPORT_POTION = registerTeleportPotion();
    public static final Item WORLD_TELEPORT_POTION = registerWorldTeleportPotion();

    private static Item registerEssence() {
        Identifier id = Identifier.of("fault", "essence");

        RegistryKey<Item> key = RegistryKey.of(
                RegistryKeys.ITEM,
                id
        );

        Item.Settings settings = new Item.Settings()
                .registryKey(key);

        return Registry.register(
                Registries.ITEM,
                key,
                new EssenceItem(settings)
        );
    }

    private static Item registerEssenceIngot() {
        Identifier id = Identifier.of("fault", "essence_ingot");

        RegistryKey<Item> key = RegistryKey.of(
                RegistryKeys.ITEM,
                id
        );

        Item.Settings settings = new Item.Settings()
                .registryKey(key);

        return Registry.register(
                Registries.ITEM,
                key,
                new EssenceIngotItem(settings)
        );
    }

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
                new ErrorEnderPearlItem(settings)
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
                new MegaEnderPearlItem(settings)
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
                new TeleportPotionItem(settings)
        );
    }

    private static Item registerWorldTeleportPotion() {
        Identifier id = Identifier.of(Fault.MOD_ID, "world_teleport_potion");

        RegistryKey<Item> key = RegistryKey.of(
                RegistryKeys.ITEM,
                id
        );

        StatusEffectInstance effect = new StatusEffectInstance(
                ModEffects.WORLD_TELEPORT_EFFECT,
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
                new TeleportPotionItem(settings)
        );
    }


    public static void registerModItems() {
        // Завантаження класу
    }
}