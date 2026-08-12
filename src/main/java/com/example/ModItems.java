package com.example;

import com.example.items.ItemErrorEnderPearl;
import com.example.items.ItemMegaEnderPearl;

import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item ERROR_ENDER_PEARL = registerErrorPearl();

    public static final Item MEGA_ENDER_PEARL = registerMegaPearl();

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

    public static void registerModItems() {
        // Завантаження класу
    }
}