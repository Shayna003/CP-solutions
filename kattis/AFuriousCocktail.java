import java.util.*;

class Cocktail {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            int t = in.nextInt();

            ArrayList<Integer> nums = new ArrayList<>();
            for (int i = 0; i < n; i++)
                nums.add(in.nextInt());

            Collections.sort(nums, (a, b) -> b - a);

            int max_time = nums.get(0) + t;
            int time = t;
            for (int i = 1; i < n; i++) {
                time += t;
                if (time >= max_time) {
                    System.out.println("NO");
                    return;
                }
                max_time = Math.min(max_time, nums.get(i) + time);
            }
            System.out.println("YES");
        }
    }
}