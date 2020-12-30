package cal.codes.mcgui.mcui.parsers;

import cal.codes.mcgui.mcui.elements.UIDocument;
import cal.codes.mcgui.mcui.elements.UISeparator;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

public class SeparatorParser implements Parser<UISeparator> {
    public static SeparatorParser getInstance() {
        return new SeparatorParser();
    }
    public UISeparator parse(Element element, UIDocument doc) {
        UISeparator sep = new UISeparator();

        Attributes attr = element.attributes();

        // Separator contents
        if(attr.hasKey("title")) {
            if(attr.get("loc").equals("true")) {
                sep.title = new TranslatableText(attr.get("title"));
            } else {
                sep.title = new LiteralText(attr.get("title"));
            }
        }

        // Separator events
        if(attr.hasKey("@render")) sep.renderEvent = attr.get("@render");

        // Separator transform
        sep.width = Integer.parseInt(attr.get("width"));
        sep.x = Integer.parseInt(attr.get("x"));
        sep.y = Integer.parseInt(attr.get("y"));

        if(attr.hasKey("id")) sep.id = attr.get("id");

        return sep;
    }
}
