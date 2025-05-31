package bishi0523.zomal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/23 3:28
 * @description:
 */
public class Weather {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String date = br.readLine().trim();
        int month = Integer.parseInt(date.substring(4, 6));
        if (month >= 3 && month <= 5) {
            System.out.println("spring");
        } else if (month >= 6 && month <= 8) {
            System.out.println("summer");
        } else if (month >= 9 && month <= 11) {
            System.out.println("autumn");
        } else {
            System.out.println("winter");
        }
    }
}
