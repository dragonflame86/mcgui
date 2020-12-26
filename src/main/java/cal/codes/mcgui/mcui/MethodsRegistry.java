/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.mcui;

import cal.codes.mcgui.exceptions.RegistryNotFoundException;
import me.lambdaurora.spruceui.widget.SpruceButtonWidget;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;

public class MethodsRegistry {
    private static HashMap<String, SpruceButtonWidget.PressAction> Registry = new HashMap<>();

    /**
     * Register a method to be used in a event.
     * @param id The ID of the method. Preferably in namespace:method format.
     * @param method The PressAction interface.
     */
    public static void register(String id, SpruceButtonWidget.PressAction method) {
        Registry.put(id, method);
    }

    public static SpruceButtonWidget.PressAction fetch(String id) throws RegistryNotFoundException {
        SpruceButtonWidget.PressAction f = Registry.get(id);
        if(f == null) throw new RegistryNotFoundException("Key (" + id.toString() + ") does not exist.");
        return f;
    }
}
