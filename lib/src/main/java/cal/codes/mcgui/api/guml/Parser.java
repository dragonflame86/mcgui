/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.api.guml;

import cal.codes.mcgui.exceptions.RootElementException;
import cal.codes.mcgui.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Arrays;

public class Parser {

    private final static String[] validRootNames = new String[] {
            "ClientGUI"
    };

    /**
     * Parse a GUML file from a string.
     * @param gumlFile A file object, preferably from the GumlRegistry Class.
     * @param usedTemp If you used the ResourceHelper class, mark this as true.
     * @return A GumlGUI document.
     */
    public static GumlGUI parse(File gumlFile, boolean usedTemp) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(gumlFile);
        doc.getDocumentElement().normalize();
        Element rootElement = doc.getDocumentElement();
        if(!Arrays.asList(validRootNames).contains(rootElement.getNodeName())) throw new RootElementException(rootElement.getNodeName());

        Logger.info("Began parse of " + gumlFile.getName() + " and root element is: " + rootElement.getNodeName());

        if(usedTemp) gumlFile.delete();

        return null;
    }
}
