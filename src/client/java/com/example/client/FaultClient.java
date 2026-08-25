package com.example.client;

import net.fabricmc.api.ClientModInitializer;

public class FaultClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		TeleportClient.register();
	}
}