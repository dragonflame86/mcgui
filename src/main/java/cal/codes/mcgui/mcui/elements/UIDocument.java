/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.mcui.elements;

import cal.codes.mcgui.exceptions.RegistryNotFoundException;
import cal.codes.mcgui.logging.Logger;
import cal.codes.mcgui.mcui.MethodsRegistry;
import cal.codes.mcgui.utils.FinalOverwriter;
import me.lambdaurora.spruceui.screen.SpruceScreen;
import me.lambdaurora.spruceui.widget.SpruceButtonWidget;
import me.lambdaurora.spruceui.widget.SpruceLabelWidget;
import me.lambdaurora.spruceui.widget.SpruceSeparatorWidget;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
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
    public void setTitle(Text title) {
        try {
            FinalOverwriter.setFinalStatic(this.getClass().getField("title"), title);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta)
    {
        // this.renderBackground(matrices);
        this.children().stream().filter(child -> child instanceof Drawable).forEach(child -> ((Drawable) child).render(matrices, mouseX, mouseY, delta));
        this.children().stream().filter(child -> child instanceof SpruceSeparatorWidget).forEach(child -> ((SpruceSeparatorWidget) child).renderWidget(matrices, mouseX, mouseY, delta));

        super.render(matrices, mouseX, mouseY, delta);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 8, 16777215);
        Tooltip.renderAll(this.parent, matrices);
    }

    @Override
    protected void init() {
        super.init();
        nonIDElements.forEach(element -> {
            System.out.println(element);
            if(element.type == UIType.ROOT) return;
            if(element.type == UIType.LABEL) {
                UILabel label = (UILabel) element;
                SpruceLabelWidget tmp = new SpruceLabelWidget(Position.of(label.x, label.y), label.getContentsAsText(), label.fixedWidth);
                tmp.setVisible(true);

                if(((TranslatableText) tmp.getText()).getKey() != null) {
                    tmp.setText(new LiteralText(I18n.translate(((TranslatableText) tmp.getText()).getKey())).setStyle((tmp.getText()).getStyle()));
                }

                this.addChild(tmp);
                Logger.info("Registered label with content - " + label.contents);
                return;
            }
            if(element.type == UIType.BUTTON) {
                UIButton button = (UIButton) element;

                if(((TranslatableText) button.contents).getKey() != null) {
                    button.contents = new LiteralText(I18n.translate(((TranslatableText) button.contents).getKey())).setStyle(button.contents.getStyle());
                }

                SpruceButtonWidget tmp = new SpruceButtonWidget(Position.of(button.x, button.y), button.width, button.height, button.getContentsAsText(), btn -> {
                    try {
                        MethodsRegistry.fetch(button.onClick).onPress(btn);
                    } catch (RegistryNotFoundException e) {
                        e.printStackTrace();
                    }
                });
                tmp.setVisible(true);
                this.addButton(tmp.asVanilla());
                Logger.info("Registered button with action - " + button.onClick);
            }
            if(element.type == UIType.SEPARATOR) {
                UISeparator separator = (UISeparator) element;

                if(((TranslatableText) separator.title).getKey() != null) {
                    separator.title = new LiteralText(I18n.translate(((TranslatableText) separator.title).getKey())).setStyle(separator.title.getStyle());
                }
                SpruceSeparatorWidget tmp = new SpruceSeparatorWidget(Position.of(separator.x, separator.y), separator.width, separator.title);
                tmp.setVisible(true);
                this.addChild(tmp);
                Logger.info("Registered separator.");
            }
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
