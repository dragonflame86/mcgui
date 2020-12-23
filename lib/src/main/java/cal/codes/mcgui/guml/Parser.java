/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.guml;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.CustomValue;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.Consumer;

public class Parser {
    /**
     * Parse a GUML file from a string.
     * @param id An identifier in format of mod-namespace:guml-file-name
     * @return A GumlGUI document.
     */
    public static GumlGUI parse(Identifier id) throws Exception {
        Optional<ModContainer> mod = FabricLoader.getInstance().getAllMods().stream().filter(modContainer -> modContainer.getMetadata().getId() == id.getNamespace()).findFirst();
        if(!mod.isPresent()) throw new Exception("Couldn't find a mod with the namespace " + id.getNamespace());
        ModContainer fimod = mod.get();
        CustomValue.CvArray gumls =  fimod.getMetadata().getCustomValue("mcgui:guis").getAsArray();
        final Optional<CustomValue>[] value = new Optional[]{Optional.empty()};
        gumls.forEach(new Consumer<CustomValue>() {
            @Override
            public void accept(CustomValue customValue) {
                if(customValue.getAsString() == id.getPath() + ".guml") {
                    value[0] = Optional.of(customValue);
                }
            }
        });
        if(!value[0].isPresent()) throw new Exception("Couldn't find the .guml with the name " + id.getPath());
        return null;
    }
}
