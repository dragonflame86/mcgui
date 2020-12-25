/**
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */
package cal.codes.mcgui;

import cal.codes.mcgui.api.guml.Parser;
import cal.codes.mcgui.api.utils.ResourceHelper;
import net.fabricmc.api.ModInitializer;

public class MCGuiMain implements ModInitializer {
    @Override
    public void onInitialize() {
        try {
            Parser.parse(ResourceHelper.getFileFromResource("assets/mcgui/guml/test.guml", MCGuiMain.class), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
