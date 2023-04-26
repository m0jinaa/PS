import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n,k;
    static long[] sum;
    static long[] dp;

    static int getLoc(int x) {
        int ans = -1;
        int s = x;
        int e = n;
        int m;
        long v;
        while(s<=e) {
            m = (s+e)/2;
            v = sum[m]-sum[x-1];
            if(v>=k) {
                ans = m;
                e = m-1;
            }
            else
                s = m+1;
        }
        return ans;
    }

    static long getMax(int i) {
        if(i>n)
            return 0;
        if(dp[i]!=-1) {
            return dp[i];
        }
        else if(i==n) {
            long v = (sum[n]-sum[n-1]);
            return dp[i] = v>k?v-k:0;
        }
        else {
            int x = getLoc(i);
            if(x==-1)
                return dp[i] = 0;
            long v = sum[x]-sum[i-1];

            return dp[i] = Math.max(getMax(x+1)+(v>k?v-k:0), getMax(i+1));

        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        sum = new long[n+1];
        dp = new long[n+1];

        st = new StringTokenizer(br.readLine()," ");

        for(int i = 1;i<=n;i++) {
            sum[i] = sum[i-1]+Long.parseLong(st.nextToken());
        }

        Arrays.fill(dp, -1);
        dp[0] = 0;

        System.out.println(getMax(1));
    }

}