import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] dp = new long[m+1];
        ArrayList<Integer> pretty = new ArrayList<Integer>();
        int t;
        int s;
        for(int i = 1;i<=5000;i++) {
            t = i;
            s = 0;
            while(t>0) {
                s+=t%10;
                t/=10;
            }
            if(i%s==0) {
                pretty.add(i);
            }
        }

        dp[0] = 1;

        for(int p:pretty) {
            if(p>m)
                break;
            for(int i = p;i<=m;i++) {
                dp[i] = (dp[i]+dp[i-p])%k;

            }
        }

        System.out.println(dp[m]);
    }

}