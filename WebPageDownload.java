package org.example;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class WebPageDownload {
    public static void main(String[] args) {
        InputStream in = null;
        try {
            URL u = new URL("https://www.google.com");
            in = u.openStream();

            in = new BufferedInputStream(in);

            // chain the InputStreamReader to a Reader
            Reader r = new InputStreamReader(in);
            int c;
            while ((c = r.read()) != -1) {
                System.out.print((char) c);
            }

        } catch (MalformedURLException ex) {
            System.out.println("Provided URL is not a parseable URL");
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
