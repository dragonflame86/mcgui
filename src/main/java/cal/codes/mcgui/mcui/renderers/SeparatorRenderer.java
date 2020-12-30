package cal.codes.mcgui.mcui.renderers;

import cal.codes.mcgui.exceptions.RegistryNotFoundException;
import cal.codes.mcgui.logging.Logger;
import cal.codes.mcgui.mcui.MethodsRegistry;
import cal.codes.mcgui.mcui.elements.UIDocument;
import cal.codes.mcgui.mcui.elements.UISeparator;
import me.lambdaurora.spruceui.Position;
import me.lambdaurora.spruceui.widget.SpruceSeparatorWidget;

public class SeparatorRenderer implements Renderer<UISeparator> {
    public static SeparatorRenderer getInstance() {
        return new SeparatorRenderer();
    }
    @Override
    public void render(UIDocument document, UISeparator separator) {
        try {
            MethodsRegistry.fetch(separator.renderEvent).invoke(separator, document);
        } catch (RegistryNotFoundException e) {
            e.printStackTrace();
        }

        SpruceSeparatorWidget tmp = new SpruceSeparatorWidget(Position.of(separator.x, separator.y), separator.width, separator.title);
        tmp.setVisible(true);
        document.add(tmp);
        Logger.info("Registered separator.");
    }
}
