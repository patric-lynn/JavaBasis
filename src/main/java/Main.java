import java.util.Scanner;


public class Main {
    public static int breakNum(int[] nums) {
        int ans = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] >= nums[i]) continue;
            int t = (nums[i] - 1) / nums[i + 1];
            ans += t;
            nums[i] /= (t + 1);
        }
        return ans;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(breakNum(nums));
    }
}

