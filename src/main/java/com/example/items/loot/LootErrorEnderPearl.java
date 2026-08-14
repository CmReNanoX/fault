package com.example.items.loot;

import com.example.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;

public class LootErrorEnderPearl {

    public static void registerModLoot() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {

            if (source.isBuiltin()
                    && EntityType.ENDERMAN.getLootTableKey().orElseThrow().equals(key)) {

                LootPool.Builder pool = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.ERROR_ENDER_PEARL))
                        .conditionally(RandomChanceLootCondition.builder(0.01f));

                tableBuilder.pool(pool);
            }
        });
    }
}
