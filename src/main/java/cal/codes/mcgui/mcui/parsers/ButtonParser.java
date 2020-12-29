package cal.codes.mcgui.mcui.parsers;

import cal.codes.mcgui.mcui.elements.UIButton;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

public class ButtonParser {
    public static UIButton parse(Element element) {
        UIButton btn = new UIButton();

        Attributes attr = element.attributes();

        // Button contents
        if(attr.get("loc").equals("true")) {
            btn.contents = new TranslatableText(element.text());
        } else {
            btn.contents = new LiteralText(element.text());
        }

        // Button events
        if(attr.hasKey("@click")) btn.onClick = attr.get("@click");

        // Button transform
        btn.x = Integer.parseInt(attr.get("x"));
        btn.y = Integer.parseInt(attr.get("y"));
        btn.width = Integer.parseInt(attr.get("width"));
        btn.height = Integer.parseInt(attr.get("height"));

        if(attr.hasKey("@id")) btn.id = attr.get("id");

        return btn;
    }
}
