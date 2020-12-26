/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;

public class TitleTestPress implements ButtonWidget.PressAction {
    private final MinecraftClient client;

    public TitleTestPress(MinecraftClient client) {
        super();
        this.client = client;
    }
    @Override
    public void onPress(ButtonWidget button) {

    }
}
