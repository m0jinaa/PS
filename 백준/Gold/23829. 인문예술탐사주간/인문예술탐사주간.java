import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static long[] nums;
    static int n;

    static int find(long x) {
        int s = 0;
        int e = n - 1;
        int m;
        int ans = -1;
        while (s <= e) {
            m = (s + e) / 2;
            if (nums[m] <= x) {
                ans = m;
                s = m + 1;
            } else
                e = m - 1;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        long[] sum = new long[n];

        nums = new long[n];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(nums);

        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        int loc;
        long x;
        long dist = 0;
        for (int i = 0; i < q; i++) {
            x = Long.parseLong(br.readLine());
            loc = find(x);
            if (loc == -1) {
                dist = sum[n-1]-n*x;
            }
            else {
                dist = sum[n-1]-2*sum[loc]+2*x*loc+2*x-n*x;
            }

            sb.append(dist).append("\n");

        }

        System.out.println(sb.toString());
    }
}
