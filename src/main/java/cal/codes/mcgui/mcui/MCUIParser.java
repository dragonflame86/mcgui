/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.mcui;

import cal.codes.mcgui.exceptions.RootElementException;
import cal.codes.mcgui.logging.Logger;
import cal.codes.mcgui.mcui.elements.UIDocument;
import cal.codes.mcgui.mcui.parsers.ButtonParser;
import cal.codes.mcgui.mcui.parsers.LabelParser;
import cal.codes.mcgui.mcui.parsers.SeparatorParser;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import javax.annotation.Nullable;
import java.io.File;

public class MCUIParser {

    private final static String[] validRootNames = new String[] {
            "screen"
    };

    /**
     * Parse a .mcui file from a string.
     * @param mcuiFile A file object, preferably from the FilesRegistry Class.
     * @param usedTemp If you used the ResourceHelper class, mark this as true.
     * @return A MCUI document.
     */
    public static UIDocument parse(File mcuiFile, boolean usedTemp) throws Exception {

        Element raw = Jsoup.parse(mcuiFile, "UTF-8").body().children().first();

        Logger.info(raw.toString());

        if(raw == null) throw new RootElementException("");

        @Nullable UIDocument document = null;

        // Title
        if(raw.attributes().get("title") != null) {
            if(raw.attributes().get("loc").equals("true")) {
                document = new UIDocument(null, new TranslatableText(raw.attributes().get("title")));
            } else {
                document = new UIDocument(null, new LiteralText(raw.attributes().get("title")));
            }
        }

        Logger.info(raw.children());
        // Elements
        for (Element element : raw.children()) {
            Logger.info(element.nodeName());
            if (element.nodeName().equals("label")) {
                document.addElement(LabelParser.parse(element));
            }
            if (element.nodeName().equals("button")) {
                document.addElement(ButtonParser.parse(element));
            }
            if (element.nodeName().equals("separator")) {
                document.addElement(SeparatorParser.parse(element));
            }
        }

        return document;
    }
}

//        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//        Document doc = dBuilder.parse(gumlFile);
//        doc.getDocumentElement().normalize();
//        Element rootElement = doc.getDocumentElement();
//        if(!Arrays.asList(validRootNames).contains(rootElement.getNodeName())) throw new RootElementException(rootElement.getNodeName());
//
//        Logger.info("Began parse of " + gumlFile.getName() + " and root element is: " + rootElement.getNodeName());
//
//        NodeList nodeList = rootElement.getChildNodes();
//
//        if(nodeList.getLength() == 0) throw new EmptyException();
//
//        ArrayList<UIElement> elements = new ArrayList<>();
//
//        for (int i = 0, len = nodeList.getLength(); i < len; i++) {
//            Node currentNode = nodeList.item(i);
//            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
//                if(currentNode.getNodeName() == "Label") {
//                    int x = Integer.parseInt(((Attr) currentNode.getAttributes().getNamedItem("x")).getValue());
//                    int y = Integer.parseInt(((Attr) currentNode.getAttributes().getNamedItem("y")).getValue());
//                    int fixedWidth = Integer.parseInt(((Attr) currentNode.getAttributes().getNamedItem("fixedWidth")).getValue());
//                    String contents = currentNode.getTextContent();
//                    UILabel e = new UILabel();
//                    e.fixedWidth = fixedWidth;
//                    e.x = x;
//                    e.y = y;
//
//                    e.contents = new LiteralText(contents);
//
//                    if(currentNode.getAttributes().getNamedItem("lang") != null && ((Attr) currentNode.getAttributes().getNamedItem("lang")).getValue() == "true") {
//                        e.contents = new TranslatableText(contents);
//                    }
//                    if(currentNode.getAttributes().getNamedItem("id") != null) {
//                        e.id = ((Attr) currentNode.getAttributes().getNamedItem("id")).getValue();
//                    }
//                    elements.add(e);
//                }
//                if(currentNode.getNodeName() == "Button") {
//                    int x = Integer.parseInt(((Attr) currentNode.getAttributes().getNamedItem("x")).getValue());
//                    int y = Integer.parseInt(((Attr) currentNode.getAttributes().getNamedItem("y")).getValue());
//                    int width = Integer.parseInt(((Attr) currentNode.getAttributes().getNamedItem("width")).getValue());
//                    int height = Integer.parseInt(((Attr) currentNode.getAttributes().getNamedItem("height")).getValue());
//
//                    String contents = currentNode.getTextContent();
//                    String registryMethod = ((Attr) currentNode.getAttributes().getNamedItem("method")).getValue();
//
//                    UIButton o = new UIButton();
//                    o.x = x;
//                    o.y = y;
//                    o.width = width;
//                    o.height = height;
//
//                    o.contents = new LiteralText(contents);
//
//                    if(currentNode.getAttributes().getNamedItem("lang") != null && ((Attr) currentNode.getAttributes().getNamedItem("lang")).getValue() == "true") {
//                        o.contents = new TranslatableText(contents);
//                    }
//
//                    o.registryMethod = registryMethod;
//
//                    if(currentNode.getAttributes().getNamedItem("id") != null) {
//                        o.id = ((Attr) currentNode.getAttributes().getNamedItem("id")).getValue();
//                    }
//
//                    elements.add(o);
//
//                }
//            }
//        }
//
//        Logger.info(elements);
//
//        String title = ((Attr) rootElement.getAttributes().getNamedItem("title")).getValue();
//
//        UIDocument UIDoc = new UIDocument(null, new LiteralText(title));
//
//        UIDoc.addElements(elements);

