public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int incr = update[2];

            diff[start] += incr;
            if (end + 1 < length) {
                diff[end + 1] -= incr;
            }
        }

        for (int i = 1; i < length; i++) {
            diff[i] += diff[i - 1];
        }

        return diff;
    }
}