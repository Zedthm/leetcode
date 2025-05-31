package bishi0523.zomal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/23 3:34
 * @description:
 */
public class AddNumArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String[] numStr = line.split(" ");
        int n = Integer.parseInt(numStr[0]);
        int k = Integer.parseInt(numStr[1]);
        line = br.readLine().trim();
        String[] arrStr = line.split(" ");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            while (map.containsKey(entry.getKey() + index)) {
                Integer temp = map.get(entry.getKey() + index);
                result  += (temp - 1);
                index += k;
            }
        }


    }
}
