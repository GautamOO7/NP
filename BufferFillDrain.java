package org.example;

import java.nio.CharBuffer;

public class BufferFillDrain {
    private static int Index =0;
    private static String[] strings = {
            "Some random string contente 1",
            "Some random string contente 2",
            "Some random string contente 3",
            "Some random string contente 4",
            "Some random string contente 5",
    };
    private static void drainBuffer(CharBuffer buffer){
        while (buffer.hasRemaining()){
            System.out.print(buffer.get());
        }
        System.out.println("");
    }
    private static boolean fillBuffer(CharBuffer buffer){
        if(Index >= strings.length){
            return false;
        }
        String string = strings[Index++];
        for (int i = 0; i < string.length(); i++){
            buffer.put(string.charAt(i));
        }
        return (true);
    }

    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(100);

        while (fillBuffer(buffer)){
            buffer.flip();
            drainBuffer(buffer);
            buffer.clear();
        }
    }
}
