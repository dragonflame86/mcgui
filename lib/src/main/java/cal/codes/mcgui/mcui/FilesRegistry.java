/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.mcui;

import cal.codes.mcgui.exceptions.RegistryNotFoundException;
import cal.codes.mcgui.utils.ResourceHelper;
import net.minecraft.util.Identifier;

import java.io.File;
import java.util.HashMap;

public class FilesRegistry {
    private static HashMap<String, File> Registry = new HashMap<String, File>();

    /**
     * Register a mcui file to be used later on.
     * @param id The ID of the file, preferably in namespace:filename format.
     * @param file The file. You can use ResourceHelper to read files from your resources folder.
     * @see ResourceHelper
     */
    public static void register(String id, File file) {
        Registry.put(id, file);
    }
    public static File fetch(String id) throws RegistryNotFoundException {
        File f = Registry.get(id);
        if(f == null) throw new RegistryNotFoundException("Key (" + id.toString() + ") does not exist.");
        return f;
    }
}
