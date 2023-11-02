import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m,k;
    static int[] dp;

    static int getCnt() {
        dp[0] = 1;

        for(int i = 1;i<=n;i++) {
            for(int j = 1;j<=n;j++) {
                if((j>=m && (j-m)%k==0)||i<j)
                    continue;
                dp[i]+=dp[i-j];
            }
        }

        return dp[n];
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        int t;
        while(tc-->0) {
            st = new StringTokenizer(br.readLine()," ");
            t = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            dp = new int[n+1];

            sb.append(t).append(" ").append(getCnt()).append("\n");
        }

        System.out.println(sb.toString());
    }
}