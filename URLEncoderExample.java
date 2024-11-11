package org.example;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLEncoderExample {
    public static void main(String[] args) {
        try{
            System.out.println(URLEncoder.encode("This string has spaces","UTF-8"));
            System.out.println(URLEncoder.encode("This%string%has%Percent%sign","UTF-8"));
            System.out.println(URLEncoder.encode("This*string*has*asterisks","UTF-8"));
            System.out.println(URLEncoder.encode("This+string+has+plus","UTF-8"));
            System.out.println(URLEncoder.encode("This/string/has/slash","UTF-8"));
            System.out.println(URLEncoder.encode("This\"string\"has\"spaces","UTF-8"));
            System.out.println(URLEncoder.encode("This:string:has:colons","UTF-8"));
            System.out.println(URLEncoder.encode("This~string~has~tildes","UTF-8"));
            System.out.println(URLEncoder.encode("This(string)has(parentheses)","UTF-8"));
            System.out.println(URLEncoder.encode("This.string.has.periods","UTF-8"));
            System.out.println(URLEncoder.encode("This=string=has=signs","UTF-8"));
            System.out.println(URLEncoder.encode("This&string&has&ampersands","UTF-8"));
            System.out.println(URLEncoder.encode("This&string&has&ampersands","UTF-8"));
        }catch (UnsupportedEncodingException ex){
            throw  new RuntimeException("Broken VM does not support UTF-8");

        }
    }
}
