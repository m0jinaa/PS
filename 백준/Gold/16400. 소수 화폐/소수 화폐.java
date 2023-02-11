import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static final int MOD = 123_456_789;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> primes = new ArrayList<Integer>();

        boolean[] nums = new boolean[40001];

        Arrays.fill(nums, true);

        nums[0] = nums[1] = false;

        for(int i = 2;i<40001;i++) {
            if(nums[i]) {
                primes.add(i);
                for(int j = i*2;j<40001;j+=i) {
                    nums[j] = false;
                }
            }
        }

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

        dp[0] = 1;

        for(int p:primes) {
            for(int i = p;i<=n;i++) {
                dp[i] = (dp[i]+dp[i-p])%MOD;
            }
        }

        System.out.println(dp[n]);
    }

}