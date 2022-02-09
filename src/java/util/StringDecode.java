/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.nio.charset.StandardCharsets;

/**
 *
 * @author Bảo Châu Bống
 */
public class StringDecode {

    public static String decode(String input) {
        byte[] bytes = input.getBytes(StandardCharsets.ISO_8859_1);
        input = new String(bytes, StandardCharsets.UTF_8);
        return input;
    }
}
