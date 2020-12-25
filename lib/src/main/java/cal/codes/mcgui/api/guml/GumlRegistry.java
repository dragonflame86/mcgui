/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.api.guml;

import cal.codes.mcgui.exceptions.RegistryNotFoundException;
import net.minecraft.util.Identifier;

import java.io.File;
import java.util.HashMap;

public class GumlRegistry {
    private static HashMap<Identifier, File> Registry = new HashMap<Identifier, File>();

    public static void register(Identifier id, File file) {
        Registry.put(id, file);
    }
    public static void fetch(Identifier id) throws RegistryNotFoundException {
        File f = Registry.get(id);
        if(f == null) throw new RegistryNotFoundException("Key (" + id.toString() + ") does not exist.");
    }
}
