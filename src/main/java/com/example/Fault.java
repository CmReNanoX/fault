package com.example;

import com.example.items.loot.ErrorEnderPearlLoot;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fault implements ModInitializer {
	public static final String MOD_ID = "fault";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerModItemGroups();
		ErrorEnderPearlLoot.registerModLoot();
		LOGGER.info("Hello Fabric world!");
	}
}
