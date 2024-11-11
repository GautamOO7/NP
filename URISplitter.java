package org.example;

import java.net.URI;
import java.net.URISyntaxException;

public class URISplitter {
    public static void main(String[] args) {
        String[] uriList = {
                "tel:+33420432934",
                "https://www.xml.com/pub/a/2003/03/22/stax.html#id=_hbc",
                "urn:isbn:32-43-2434-3",
                "https://user:password@host:8080/path?query#fragment"
        };

        for( int i =0; i< uriList.length;i++){
            try{
                URI u = new URI(uriList[i]);
                System.out.println("The URI is "+u);
                if(u.isOpaque()){
                    System.out.println("This is an opaque URI.");
                    System.out.println("THis scheme is :"+u.getScheme());
                    System.out.println("The scheme specific part is "+u.getRawSchemeSpecificPart());
                    System.out.println("The fragement ID is "+ u.getFragment());
                }else{
                    System.out.println("This is a hierarchical URI.");
                    System.out.println("This scheme is :"+u.getScheme());
                    try{
                        u = u.parseServerAuthority();
                        System.out.println("The host is "+u.getHost());
                        System.out.println("The user info is "+u.getUserInfo());
                        System.out.println("The port is "+u.getPort());
                    }catch (URISyntaxException ex){
                        System.out.println("The authority is "+u.getAuthority());
                    }
                    System.out.println("The path is "+u.getPath());
                    System.out.println("The query is "+u.getQuery());
                    System.out.println("The fragment ID is "+u.getFragment());

                }
            }catch (URISyntaxException ex){
                System.out.println("The URI is "+ex);
            }
        }
    }
}