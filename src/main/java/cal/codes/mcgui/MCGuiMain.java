/**
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */
package cal.codes.mcgui;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.LiteralText;

public class MCGuiMain implements ModInitializer {
    @Override
    public void onInitialize() {
//        try {
//            MethodsRegistry.register("mcgui:testy_shit", button -> {
//                testMethod();
//            });
//            FilesRegistry.register("mcgui:test_file", ResourceHelper.getFileFromResource("assets/mcgui/test.mcui", MCGuiMain.class));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    public void testMethod() {
        SystemToast toast = SystemToast.create(MinecraftClient.getInstance(), SystemToast.Type.TUTORIAL_HINT,
                new LiteralText("OwO"), new LiteralText("Hello!"));
        MinecraftClient.getInstance().getToastManager().add(toast);
    }
}
