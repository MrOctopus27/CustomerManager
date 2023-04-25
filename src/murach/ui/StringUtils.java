/*
 * Author: Kevin Alvarado
 * Date: 12/8/2022
 * 
 * Description: This program asks you to enter a command to interact with the app
 */

package murach.ui;

public class StringUtils {

    public static String padWithSpaces(String s, int length) {
        if (s.length() < length) {
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() < length) {
                sb.append(" ");
            }
            return sb.toString();
        } else {
            return s.substring(0, length);
        }
    }
}
