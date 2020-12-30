package cal.codes.mcgui.mcui.renderers;

import cal.codes.mcgui.mcui.elements.UIDocument;
import cal.codes.mcgui.mcui.elements.UIElement;

public interface Renderer<T extends UIElement> {
    public void render(UIDocument document, T element);
}
