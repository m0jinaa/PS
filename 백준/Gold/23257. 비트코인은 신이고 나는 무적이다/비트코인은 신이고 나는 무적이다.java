import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[m+1][1024];

        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine()," ");

        for(int i = 0;i<n;i++) {
            nums[i] = Math.abs(Integer.parseInt(st.nextToken()));
            dp[1][nums[i]] = true;
        }

        for(int i = 1;i<m;i++) {
            for(int j = 0;j<1024;j++) {
                if(dp[i][j]) {
                    for(int k : nums) {
                        dp[i+1][j^k] = true;
                    }
                }
            }
        }

        int ans = 0;

        for(int i = 1023;i>=0;i--) {
            if(dp[m][i]) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
}