package cal.codes.mcgui.mcui.parsers;

import cal.codes.mcgui.mcui.elements.UIDocument;
import cal.codes.mcgui.mcui.elements.UIElement;
import org.jsoup.nodes.Element;

public interface Parser<T extends UIElement> {
    public T parse(Element element, UIDocument doc);
}
