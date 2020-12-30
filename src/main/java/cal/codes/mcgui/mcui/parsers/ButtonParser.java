package cal.codes.mcgui.mcui.parsers;

import cal.codes.mcgui.mcui.elements.UIButton;
import cal.codes.mcgui.mcui.elements.UIDocument;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

public class ButtonParser implements Parser<UIButton> {
    public static ButtonParser getInstance() {
        return new ButtonParser();
    }
    public UIButton parse(Element element, UIDocument doc) {
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
        if(attr.hasKey("@render")) btn.renderEvent = attr.get("@render");

        // Button transform
        btn.x = Integer.parseInt(attr.get("x"));
        btn.y = Integer.parseInt(attr.get("y"));
        btn.width = Integer.parseInt(attr.get("width"));
        btn.height = Integer.parseInt(attr.get("height"));

        if(attr.hasKey("@id")) btn.id = attr.get("id");

        return btn;
    }
}
