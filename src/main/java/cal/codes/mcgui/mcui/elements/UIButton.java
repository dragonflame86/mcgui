/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.mcui.elements;

import cal.codes.mcgui.exceptions.RegistryNotFoundException;
import cal.codes.mcgui.mcui.MethodsRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class UIButton extends UIElement {

    public Text contents;
    
    public String onClick;

    public int x;
    public int y;

    public int width;
    public int height;

    public UIButton() {
        type = UIType.BUTTON;
    }

    public String getContents() {
        return contents.asString();
    }

    public Text getContentsAsText() {
        return contents;
    }

}
