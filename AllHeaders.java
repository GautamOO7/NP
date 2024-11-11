package org.example;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AllHeaders
{
    public static void main(String[] args)
    {
        String urlString = "https://www.w3schools.com/java/";
        try
        {
            URL u = new URL(urlString);
            URLConnection uc = u.openConnection();
            for(int j=1; ; j++)
            {
                String header = uc.getHeaderField(j);
                if(header == null)break;
                System.out.println(uc.getHeaderFieldKey(j) + ": "+ header);
            }
        }
        catch(MalformedURLException ex)
        {
            System.out.println(urlString + "is not a URL I understand.");
        }
        catch(IOException ex)
        {
            System.out.println(ex + ".");
        }
        System.out.println();
    }
}