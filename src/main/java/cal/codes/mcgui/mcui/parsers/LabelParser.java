package cal.codes.mcgui.mcui.parsers;

import cal.codes.mcgui.mcui.elements.UIDocument;
import cal.codes.mcgui.mcui.elements.UILabel;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

public class LabelParser implements Parser<UILabel> {
    public static LabelParser getInstance() {
        return new LabelParser();
    }
    public UILabel parse(Element element, UIDocument doc) {
        System.out.println(element);
        UILabel lbl = new UILabel();

        Attributes attr = element.attributes();

        // Label contents
        if(attr.get("loc").equals("true")) {
            lbl.contents = new TranslatableText(element.text());
        } else {
            lbl.contents = new LiteralText(element.text());
        }

        // Label events
        if(attr.hasKey("@render")) lbl.renderEvent = attr.get("@render");

        // Label transform
        lbl.fixedWidth = Integer.parseInt(attr.get("fixedwidth"));
        lbl.x = Integer.parseInt(attr.get("x"));
        lbl.y = Integer.parseInt(attr.get("y"));

        if(attr.hasKey("id")) lbl.id = attr.get("id");

        return lbl;
    }
}
