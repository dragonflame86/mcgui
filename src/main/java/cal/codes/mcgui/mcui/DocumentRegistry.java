/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.mcui;

import cal.codes.mcgui.exceptions.RegistryNotFoundException;
import cal.codes.mcgui.mcui.elements.UIDocument;
import cal.codes.mcgui.utils.ResourceHelper;

import java.util.HashMap;

public class DocumentRegistry {
    private static HashMap<String, UIDocument> Registry = new HashMap<>();

    /**
     * Register a UIDocument to be used later on.
     * @param id The ID of the file, preferably in namespace:filename format.
     * @param document The UIDocument, use
     * @see ResourceHelper
     * @see MCUIParser
     */
    public static void register(String id, UIDocument document) {
        Registry.put(id, document);
    }
    public static UIDocument fetch(String id) throws RegistryNotFoundException {
        UIDocument f = Registry.get(id);
        if(f == null) throw new RegistryNotFoundException("Key (" + id.toString() + ") does not exist.");
        return f;
    }
}
