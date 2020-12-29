package cal.codes.mcgui.mcui.elements;

import net.minecraft.text.Text;

public class UISeparator extends UIElement {

    public UISeparator() {
        this.type = UIType.SEPARATOR;
    }

    public int x;
    public int y;
    public int width;
    public Text title;

    public String getTitle() {
        return title.asString();
    }
    public Text getTitleAsText() {
        return title;
    }
}
