import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] house;
    static int n,c;

    static boolean check(int d) {
        int cnt = 1;
        int dist = 0;
        for(int i = 1;i<n;i++) {
            dist+=house[i]-house[i-1];
            if(dist>=d) {
                cnt++;
                dist = 0;
            }
        }

        return cnt>=c?true:false;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        house = new int[n];

        for(int i = 0;i<n;i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int s = 0;
        int e = house[n-1]-house[0];

        int ans = 0;
        int m;
        while(s<=e) {
            m = (s+e)/2;
            if(check(m)) {
                ans = Math.max(ans, m);
                s = m+1;
            }
            else {
                e = m-1;
            }
        }

        System.out.println(ans);

    }

}