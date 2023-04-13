import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    static class Meeting implements Comparable<Meeting> {
        int s, e, c;

        public Meeting(int s, int e, int c) {
            super();
            this.s = s;
            this.e = e;
            this.c = c;
        }

        @Override
        public int compareTo(Meeting m) {
            if (this.e != m.e) {
                return this.e - m.e;
            } else {
                return this.s - m.s;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int s,e,c;
        Meeting[] meetings = new Meeting[n];
        int[] time = new int[2*n];
        for(int i= 0;i<n;i++) {
            st = new StringTokenizer(br.readLine()," ");
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(s,e,c);
            time[2*i] = s;
            time[2*i+1] = e;

        }
        Arrays.sort(time);

        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        for(int t:time) {
            if(!map.containsKey(t))
                map.put(t, cnt++);
        }

        int m = cnt;
        int[] dp = new int[m];

        Arrays.sort(meetings);
        int ind = 0;
        int v;

        for(int i = 1;i<m;i++) {
            e = meetings[ind].e;
            if(i==map.get(e)) {
                v = dp[map.get(meetings[ind].s)]+meetings[ind].c;
                if(dp[i-1]<v) {
                    dp[i] = v;
                }
                else {
                    dp[i] = dp[i-1];
                }
                ind++;
            }
            else {
                dp[i] = dp[i-1];
            }
        }

        System.out.println(dp[m-1]);
    }
}