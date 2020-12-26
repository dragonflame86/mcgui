/*
 * MCGui is licensed under the Mozilla Public License 2.0
 * Failure to follow this license will result in further action.
 */

package cal.codes.mcgui.utils;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.util.Random;

public class ResourceHelper {

    /**
     * Get a file from the resources folder of a jar.
     * @param path The path of where the file is.
     * @param root Any class from the jar you want to get resources from.
     * @return A file class you can use.
     * @throws Exception
     */
    public static File getFileFromResource(String path, Class root) throws Exception {
        URL resource = root.getClassLoader().getResource(path);
        System.out.println(resource);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + path);
        } else {
            File tmp = File.createTempFile(String.valueOf(new Random().nextLong()), "cache-mcgui.tmp");
            InputStream in = root.getClassLoader().getResourceAsStream(path);
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
