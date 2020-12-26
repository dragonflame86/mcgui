/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.mcui;

import cal.codes.mcgui.exceptions.RegistryNotFoundException;
import net.minecraft.util.Identifier;

import java.io.File;
import java.util.HashMap;

public class MCUIRegistry {
    private static HashMap<String, File> Registry = new HashMap<String, File>();

    public static void register(String id, File file) {
        Registry.put(id, file);
    }
    public static File fetch(String id) throws RegistryNotFoundException {
        File f = Registry.get(id);
        if(f == null) throw new RegistryNotFoundException("Key (" + id.toString() + ") does not exist.");
        return f;
    }
}
