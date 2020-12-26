/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.mcui.elements;

import cal.codes.mcgui.logging.Logger;
import me.lambdaurora.spruceui.screen.SpruceScreen;
import me.lambdaurora.spruceui.widget.SpruceLabelWidget;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import org.jetbrains.annotations.Nullable;

import me.lambdaurora.spruceui.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UIDocument extends SpruceScreen {
    public Screen parent;

    public List<UIElement> nonIDElements = new ArrayList<>();
    public HashMap<String, UIElement> IDElements = new HashMap<>();

    public UIDocument(@Nullable Screen parent, LiteralText title) {
        super(title);
        this.parent = parent;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta)
    {
        this.renderBackground(matrices);
        this.children().stream().filter(child -> child instanceof Drawable).forEach(child -> ((Drawable) child).render(matrices, mouseX, mouseY, delta));
        super.render(matrices, mouseX, mouseY, delta);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 8, 16777215);
        Tooltip.renderAll(this.parent, matrices);
    }

    @Override
    protected void init() {
        super.init();
        nonIDElements.forEach(element -> {
            if(element.type == UIType.ROOT) return;
            if(element.type == UIType.LABEL) {
                UILabel label = (UILabel) element;
                Logger.info(label.contents);
                SpruceLabelWidget tmp = new SpruceLabelWidget(Position.of(label.x, label.y), label.getContentsAsLiteralText(), label.fixedWidth);
                tmp.setVisible(true);
                this.addChild(tmp);
            }
        });
    }

    public void addElement(UIElement element) {
        if(element.id == null) {
            nonIDElements.add(element);
            Logger.warn("Added Element did not have an ID!");
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
