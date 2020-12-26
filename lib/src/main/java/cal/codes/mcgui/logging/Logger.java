/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.logging;

public class Logger {
    public static void info(Object content) {
        System.out.println("[MCGUI] [INFO] " + content.toString());
    }
    public static void warn(Object content) {
        System.out.println("[MCGUI] [WARN] " + content.toString());
    }
    private static void error(Object content) {
        System.out.println("[MCGUI] [ERR!] " + content.toString());
    }
}
