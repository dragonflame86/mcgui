/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.api.utils;

import net.fabricmc.loader.api.FabricLoader;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Random;

public class ResourceHelper {
    // get a file from the resources folder
    // works everywhere, IDEA, unit test and JAR file.
    public static InputStream getFileFromResourceAsStream(String fileName, Class root) {

        // The class loader that loaded the class
        InputStream inputStream = root.getClassLoader().getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }

    /*
        The resource URL is not working in the JAR
        If we try to access a file that is inside a JAR,
        It throws NoSuchFileException (linux), InvalidPathException (Windows)

        Resource URL Sample: file:java-io.jar!/json/file1.json
     */
    public static File getFileFromResource(String fileName, Class root) throws Exception {
        URL resource = root.getClassLoader().getResource(fileName);
        System.out.println(resource);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            File tmp = File.createTempFile(String.valueOf(new Random().nextLong()), "cache-mcgui.tmp");
            InputStream in = root.getClassLoader().getResourceAsStream(fileName);
            try(OutputStream outputStream = new FileOutputStream(tmp)) {
                IOUtils.copy(in, outputStream);
            } catch (FileNotFoundException e) {
                throw e;
            } catch (IOException e) {
                throw e;
            }
            if (tmp == null) {
                throw new Exception("File is null.");
            }
            return tmp;
        }

    }
}
