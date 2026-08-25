A company stores employee salaries in a list. Increase each salary by 10% and print the updated salaries using functional transformation techniques.

Program:

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> salaries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            salaries.add(sc.nextInt());
        }

        salaries.stream()
                .map(salary -> salary + salary / 10)
                .forEach(salary -> System.out.print(salary + " "));
    }
}
