import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int N = 1000000;
        int[] dp = new int[N+1];

        int w,v;

        for(int i = 0;i<n;i++) {
            st = new StringTokenizer(br.readLine()," ");
            w = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            for(int j = N;j>=w;j--) {
                dp[j] = Math.max(dp[j], dp[j-w]+v);
            }
        }
        long mk = 1000000;
        long mv = 0;

        int ans = 1;
        int size;
        for(int i = 1;i<=m;i++) {
            size = Integer.parseInt(br.readLine());

            if(size*mv<mk*dp[size]) {
            	mk = size;
            	mv = dp[size];
                ans = i;
            }
        }

        System.out.println(ans);
    }
}
