/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.mcui.elements;

public class UIElement {
    public String id;
    public UIType type;

    public String renderEvent;

    public UIElement() {
        type = UIType.ROOT;
    }

    public String getId() {
        return id;
    }
}
