import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static long[] nums;
    static int n;

    static long getGCD(long x, long y) {// x>y
        if (y == 0)
            return x;
        else
            return getGCD(y, x % y);
    }

    static long gcd(int ind, long x) {
        if (ind == n)
            return x;

        long g1 = getGCD(x, nums[ind]);
        long g2 = getGCD(x, nums[ind] + 1);

        if (g1 == 1 && g2 == 1)
            return 1;
        else if (g1 == 1) {
            return gcd(ind + 1, g2);
        } else if (g2 == 1) {
            return gcd(ind + 1, g1);
        } else {
            return Math.max(gcd(ind + 1, g1), gcd(ind + 1, g2));
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        nums = new long[n];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        System.out.println(Math.max(gcd(1, nums[0]), gcd(1, nums[0] + 1)));

    }
}