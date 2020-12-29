/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.mcui.elements;

import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

public class UILabel extends UIElement {

    public Text contents;
    public int fixedWidth;
    public int x;
    public int y;


    public UILabel() {
        type = UIType.LABEL;
    }

    public String getContents() {
        return contents.asString();
    }

    public Text getContentsAsText() {
        return contents;
    }
}
