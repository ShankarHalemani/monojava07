package com.techlabs.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProgramOne {
    public static int groupDivision(List<Integer> levels, int maxSpread) {
        Collections.sort(levels);
        int n = levels.size();
        int numberOfGroups = 0;
        int i = 0;

        while (i < n) {
            numberOfGroups++;
            int startLevel = levels.get(i);

            while (i < n && levels.get(i) - startLevel <= maxSpread) {
                i++;
            }
        }

        return numberOfGroups;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> levels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int tempVariable = scanner.nextInt();
            levels.add(tempVariable);
        }

        int maxSpread = scanner.nextInt();
        int result = groupDivision(levels, maxSpread);
        System.out.println(result);
    }
}
