package com.example.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class TeleportClient {

    private static final int TELEPORT_DISTANCE = 20;
    private static final int FADE_TIME_MS = 500;

    private static double lastX;
    private static double lastY;
    private static double lastZ;

    private static boolean initialized = false;
    private static long effectStartTime = 0;

    public static void register() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null || client.world == null) {
                return;
            }

            double x = client.player.getX();
            double y = client.player.getY();
            double z = client.player.getZ();
            if (!initialized) {
                lastX = x;
                lastY = y;
                lastZ = z;
                initialized = true;
                return;
            }

            double dx = x - lastX;
            double dy = y - lastY;
            double dz = z - lastZ;

            double distanceSq = dx * dx + dy * dy + dz * dz;

            if (distanceSq >= TELEPORT_DISTANCE * TELEPORT_DISTANCE) {
                effectStartTime = System.currentTimeMillis();
            }

            lastX = x;
            lastY = y;
            lastZ = z;
        });

        HudRenderCallback.EVENT.register((drawContext, tickDelta) -> {
            renderTeleportEffect(drawContext);
        });
    }

    private static void renderTeleportEffect(DrawContext drawContext) {
        if (effectStartTime == 0) {
            return;
        }

        long elapsed = System.currentTimeMillis() - effectStartTime;

        if (elapsed >= FADE_TIME_MS) {
            effectStartTime = 0;
            return;
        }
        //0x8800AA 0xAA00FF
        int colorA = (int) (255.0f * (1.0f - elapsed / (float) FADE_TIME_MS));
        int colorR = (int) (136.0f + 34.0f * elapsed / (float) FADE_TIME_MS);
        int colorG = 0;
        int colorB = (int) (170.0f + 85.0f * elapsed / (float) FADE_TIME_MS);

        int color = (colorA << 24) | (colorR << 16) | (0) | colorB; //colorG << 8


        MinecraftClient client = MinecraftClient.getInstance();
        drawContext.fill(
                0,
                0,
                client.getWindow().getScaledWidth(),
                client.getWindow().getScaledHeight(),
                color
        );
    }
}
