package cal.codes.mcgui.mcui.renderers;

import cal.codes.mcgui.exceptions.RegistryNotFoundException;
import cal.codes.mcgui.logging.Logger;
import cal.codes.mcgui.mcui.MethodsRegistry;
import cal.codes.mcgui.mcui.elements.UIDocument;
import cal.codes.mcgui.mcui.elements.UILabel;
import me.lambdaurora.spruceui.Position;
import me.lambdaurora.spruceui.widget.SpruceLabelWidget;

public class LabelRenderer implements Renderer<UILabel> {
    public static LabelRenderer getInstance() {
        return new LabelRenderer();
    }
    @Override
    public void render(UIDocument document, UILabel label) {
        SpruceLabelWidget tmp = new SpruceLabelWidget(Position.of(label.x, label.y), label.getContentsAsText(), label.fixedWidth);
        tmp.setVisible(true);

        try {
            MethodsRegistry.fetch(label.renderEvent).invoke(label, document, null);
        } catch (RegistryNotFoundException e) {
            e.printStackTrace();
        }

        document.add(tmp);
        Logger.info("Registered label with content - " + label.contents);
    }
}
