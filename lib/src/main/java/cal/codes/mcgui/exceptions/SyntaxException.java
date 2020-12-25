/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.exceptions;

import java.text.MessageFormat;

public class SyntaxException extends Exception {
    /**
     * The line the error occured on.
     */
    public String line;
    /**
     * The number of the line.
     */
    public int lineNumber;
    /**
     * The character number.
     */
    public int characterNumber;
    public SyntaxException(String ln, int lnNum, int charNum) {
        line = ln; lineNumber = lnNum; characterNumber = charNum;
    }

    /**
     * Get the error as a user friendly string.
     * @return The error, in string format.
     */
    @Override
    public String toString() {
        return MessageFormat.format("[Guml] Syntax error at {0}:{1} \n{2}", lineNumber, characterNumber, line);
    }
}
