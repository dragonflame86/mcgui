/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.mcui;

import cal.codes.mcgui.exceptions.RegistryNotFoundException;
import cal.codes.mcgui.mcui.events.EventHook;

import java.util.HashMap;

public class MethodsRegistry {
    private static HashMap<String, EventHook> Registry = new HashMap<>();

    /**
     * Register a method to be used in a event.
     * @param id The ID of the method. Preferably in namespace:method format.
     * @param method The PressAction interface.
     */
    public static void register(String id, EventHook method) {
        Registry.put(id, method);
    }

    public static EventHook fetch(String id) throws RegistryNotFoundException {
        EventHook f = Registry.get(id);
        if(f == null) throw new RegistryNotFoundException("Key (" + id + ") does not exist.");
        return f;
    }
}
