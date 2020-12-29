/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.exceptions;

public class RootElementException extends Exception {
    /**
     * The root element found.
     */
    public String rootElement;
    public RootElementException(String rE) {
        rootElement = rE;
    }

    @Override
    public String toString() {
        return "The root element of the mcui file was not valid: " + rootElement;
    }
}
