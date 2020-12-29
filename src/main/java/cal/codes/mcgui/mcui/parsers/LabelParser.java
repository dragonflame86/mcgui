package cal.codes.mcgui.mcui.parsers;

import cal.codes.mcgui.mcui.elements.UILabel;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

public class LabelParser {
    public static UILabel parse(Element element) {
        UILabel lbl = new UILabel();

        Attributes attr = element.attributes();

        // Label contents
        if(attr.get("loc").equals("true")) {
            lbl.contents = new TranslatableText(element.text());
        } else {
            lbl.contents = new LiteralText(element.text());
        }

        // Label events

        // Label transform
        lbl.fixedWidth = Integer.parseInt(attr.get("fixedWidth"));
        lbl.x = Integer.parseInt(attr.get("x"));
        lbl.y = Integer.parseInt(attr.get("y"));

        if(attr.hasKey("id")) lbl.id = attr.get("id");

        return lbl;
    }
}
