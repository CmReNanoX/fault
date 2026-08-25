package com.example;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup FAULT = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of("fault", "fault"),
            ItemGroup.create(ItemGroup.Row.TOP, 0)
                    .displayName(Text.translatable("itemGroup.fault.fault"))
                    .icon(() -> new ItemStack(ModItems.MEGA_ENDER_PEARL))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ESSENCE);
                        entries.add(ModItems.ESSENCE_INGOT);

                        entries.add(ModItems.ERROR_ENDER_PEARL);
                        entries.add(ModItems.MEGA_ENDER_PEARL);

                        entries.add(ModItems.TELEPORT_POTION);
                        entries.add(ModItems.WORLD_TELEPORT_POTION);
                    })
                    .build()
    );

    public static void registerModItemGroups() {

    }
}