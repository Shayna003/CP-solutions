import java.util.*;

class Bank2 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int t = in.nextInt();

            // sort with largest money first (largest time first if there's a tie on time)
            PriorityQueue<int[]> by_money = new PriorityQueue<>((a, b) -> {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return b[0] - a[0];
                }
            });

            // disregarded items added back until their timing is relevant.
            // sort with largest time first (largest money first if there's a tie on time)
            PriorityQueue<int[]> discarded = new PriorityQueue<>((a, b) -> {
                if (a[1] == b[1]) {
                    return b[0] - a[0];
                } else {
                    return b[1] - a[1];
                }
            });

            for (int i = 0; i < n; i++) {
                int[] num = new int[] { in.nextInt(), in.nextInt() };
                if (num[1] >= t - 1) {
                    by_money.add(num);
                } else {
                    discarded.add(num);
                }
            }

            int sum = 0;
            int time = t - 1;
            while (time >= 0) {
                if (!by_money.isEmpty()) {
                    sum += by_money.poll()[0];
                }
                time--;
                while (!discarded.isEmpty() && discarded.peek()[1] >= time) {
                    by_money.add(discarded.poll());
                }
            }
            System.out.println(sum);
        }
    }
}
