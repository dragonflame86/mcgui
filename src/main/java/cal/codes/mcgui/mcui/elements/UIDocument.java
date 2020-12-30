/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.mcui.elements;

import cal.codes.mcgui.exceptions.RegistryNotFoundException;
import cal.codes.mcgui.logging.Logger;
import cal.codes.mcgui.mcui.MethodsRegistry;
import cal.codes.mcgui.mcui.renderers.ButtonRenderer;
import cal.codes.mcgui.mcui.renderers.LabelRenderer;
import cal.codes.mcgui.mcui.renderers.SeparatorRenderer;
import me.lambdaurora.spruceui.Tooltip;
import me.lambdaurora.spruceui.screen.SpruceScreen;
import me.lambdaurora.spruceui.widget.SpruceSeparatorWidget;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UIDocument extends SpruceScreen {
    public Screen parent;

    public List<UIElement> nonIDElements = new ArrayList<>();
    public HashMap<String, UIElement> IDElements = new HashMap<>();

    // Title
    public boolean showTitle = true;

    // Events
    public String renderEvent;

    public UIDocument(@Nullable Screen parent, Text title) {
        super(title);
        this.parent = parent;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta)
    {
        this.renderBackground(matrices);
        this.children().stream().filter(child -> child instanceof Drawable).forEach(child -> ((Drawable) child).render(matrices, mouseX, mouseY, delta));
        this.children().stream().filter(child -> child instanceof SpruceSeparatorWidget).forEach(child -> ((SpruceSeparatorWidget) child).render(matrices, mouseX, mouseY, delta));

        super.render(matrices, mouseX, mouseY, delta);

        if(showTitle) drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 8, 16777215);

        Tooltip.renderAll(this.parent, matrices);
    }
    public <T extends Element> T add(T element) {
        this.addChild(element);
        return element;
    }

    @Override
    protected void init() {
        super.init();
        try {
            MethodsRegistry.fetch(renderEvent).invoke(null, this, null);
        } catch (RegistryNotFoundException e) {

        }
        IDElements.values().forEach(element -> {
            System.out.println(element);
            if(element.type == UIType.ROOT) return;
            if(element.type == UIType.LABEL) LabelRenderer.getInstance().render(this, (UILabel) element);
            if(element.type == UIType.BUTTON) ButtonRenderer.getInstance().render(this, (UIButton) element);
            if(element.type == UIType.SEPARATOR) SeparatorRenderer.getInstance().render(this, (UISeparator) element);
        });
        nonIDElements.forEach(element -> {
            System.out.println(element);
            if(element.type == UIType.ROOT) return;
            if(element.type == UIType.LABEL) LabelRenderer.getInstance().render(this, (UILabel) element);
            if(element.type == UIType.BUTTON) ButtonRenderer.getInstance().render(this, (UIButton) element);
            if(element.type == UIType.SEPARATOR) SeparatorRenderer.getInstance().render(this, (UISeparator) element);
        });
    }

    public void addElement(UIElement element) {
        if(element.id == null) {
            nonIDElements.add(element);
            Logger.warn("Added element did not have an ID!");
            return;
        }
        IDElements.put(element.id, element);
    }

    public void addElements(List<UIElement> elements) {
        elements.forEach(element -> {
            addElement(element);
        });
    }

}
