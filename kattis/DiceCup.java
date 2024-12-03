import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Dice {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int m = in.nextInt();

            ArrayList<Map<Integer, Integer>> odds = new ArrayList<>(n);
            Map<Integer, Integer> start = new HashMap<>();
            for (int i = 0; i < m; i++) {
                start.put(i + 1, 1);
            }
            odds.add(start);

            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> curr = odds.get(i);
                Map<Integer, Integer> next = new HashMap<>();
                curr.forEach((k, v) -> {
                    for (int j = 1; j <= m; j++) {
                        next.putIfAbsent(k + j, 0);
                        next.put(k + j, next.get(k + j) + 1);
                    }
                });
                odds.add(next);
            }

            final int[] max = new int[] { Integer.MIN_VALUE };
            Map<Integer, Integer> last = odds.get(odds.size() - 1);
            last.forEach((k, v) -> {
                if (v > max[0]) {
                    max[0] = v;
                }
            });

            last.forEach((k, v) -> {
                if (v == max[0]) {
                    System.out.println(k);
                }
            });

            System.out.println(odds);
        }
    }
}
