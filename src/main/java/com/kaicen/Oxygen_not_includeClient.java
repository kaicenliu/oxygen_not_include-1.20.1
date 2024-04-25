package com.kaicen;

import com.kaicen.screenhandler.handler.OniScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class Oxygen_not_includeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //ScreenRegistry.register(Minelib.BOX_SCREEN_HANDLER, BoxScreen::new);//教程中的弃用方法
        HandledScreens.register(Oxygen_not_include.CHARGING_FILE, OniScreen::new);
    }
}
