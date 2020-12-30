package cal.codes.mcgui.mcui.renderers;

import cal.codes.mcgui.exceptions.RegistryNotFoundException;
import cal.codes.mcgui.logging.Logger;
import cal.codes.mcgui.mcui.MethodsRegistry;
import cal.codes.mcgui.mcui.elements.UIButton;
import cal.codes.mcgui.mcui.elements.UIDocument;
import me.lambdaurora.spruceui.Position;
import me.lambdaurora.spruceui.widget.SpruceButtonWidget;

public class ButtonRenderer implements Renderer<UIButton> {
    public static ButtonRenderer getInstance() {
        return new ButtonRenderer();
    }
    @Override
    public void render(UIDocument document, UIButton button) {
        SpruceButtonWidget tmp = new SpruceButtonWidget(Position.of(button.x, button.y), button.width, button.height, button.getContentsAsText(), btn -> {
            try {
                MethodsRegistry.fetch(button.onClick).invoke(button, document, null);
            } catch (RegistryNotFoundException e) {
                e.printStackTrace();
            }
        });
        tmp.setVisible(true);
        document.add(tmp.asVanilla());
        Logger.info("Registered button with action - " + button.onClick);
    }
}
