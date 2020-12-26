/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.mcui.elements;

import net.minecraft.text.LiteralText;

public class UILabel extends UIElement {

    public String contents;
    public int fixedWidth;
    public int x;
    public int y;

    public UILabel() {
        type = UIType.LABEL;
    }

    public UILabel(String id, String contents, int x, int y, int fixedWidth) {
        super(id);
        type = UIType.LABEL;
        this.contents = contents;
        this.x = x;
        this.y = y;
        this.fixedWidth = fixedWidth;
    }

    public String getContents() {
        return contents;
    }

    public LiteralText getContentsAsLiteralText() {
        return new LiteralText(contents);
    }
}
