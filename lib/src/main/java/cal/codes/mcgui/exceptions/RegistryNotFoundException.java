/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.exceptions;

public class RegistryNotFoundException extends Exception {
    public String message;
    public RegistryNotFoundException(String msg) {
        message = msg;
    }

    @Override
    public String toString() {
        return "The key was not in the Registry - " + message;
    }
}
