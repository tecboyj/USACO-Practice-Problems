package com.Tec_BoyJ;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) throws IOException {
        Problem1 main = new Problem1();
        String[] arr = main.setUp("/Problem1.txt");
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (String s : arr) {
            int s1 = Integer.parseInt(s.substring(0, s.indexOf(" ")));
            int s2 = Integer.parseInt(s.substring(s.indexOf(" ") + 1));
            map.put(s1, s2);
        }
        int arrSet = 0;
        for (int i = 0; i < 100; i++) {
            int s1 = Integer.parseInt(arr[arrSet].substring(0, arr[arrSet].indexOf(" ")));
            int nextArr;
            if (arrSet != 2) nextArr = arrSet + 1;
            else nextArr = 0;
            int s2 = Integer.parseInt(arr[nextArr].substring(0, arr[nextArr].indexOf(" ")));
            if (s2 < map.get(s1) + map.get(s2)) {
                int x = s2 - map.get(s2);
                map.put(s1, map.get(s1) - x);
                map.put(s2, map.get(s2) + x);
            } else {
                map.put(s2, map.get(s2) + map.get(s1));
                map.put(s1, 0);
            }


            if (arrSet != 2) arrSet++;
            else arrSet = 0;
        }
        System.out.println(map);
    }
    public String[] setUp(String string) throws IOException {
        Scanner scanner = new Scanner(getClass().getResource(string).openStream());

        int length = 0;
        while (scanner.hasNextLine()) {
            length++;
            scanner.nextLine();
        }
        String[] arr = new String[length];

        int i = 0;
        scanner = new Scanner(getClass().getResource(string).openStream());
        while (scanner.hasNextLine()) {
            arr[i] = scanner.nextLine();
            i++;
        }
        return arr;
    }
}