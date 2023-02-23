import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static String[] words,rwords;
    static int n;

    static int getLow(String str) {
        int s = 0;
        int e = n-1;
        int m;
        int ans = 0;
        int v;
        while(s<=e) {
            m = (s+e)/2;
            v = str.compareTo(words[m]);
            if(v<0) {
                e = m-1;
            }
            else {
                s = m+1;
                ans = m+1;
            }

        }
        return ans;
    }

    static int getHigh(String str) {
        int s = 0;
        int e = n-1;
        int m;
        int ans = 0;
        int v;
        while(s<=e) {
            m = (s+e)/2;
            v = str.compareTo(rwords[m]);
            if(v<=0) {
                e = m-1;
                ans = m;
            }
            else
                s = m+1;
        }
        return ans;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuffer buf;
        n = Integer.parseInt(br.readLine());

        words = new String[n];
        rwords = new String[n];

        char[] arr;
        String s,rs;

        String[][] w = new String[n][2];

        for(int i = 0;i<n;i++) {
            arr = br.readLine().toCharArray();

            Arrays.sort(arr);
            s = new String(arr);
            words[i] = s;

            buf = new StringBuffer(s);

            rs = buf.reverse().toString();

            rwords[i] = rs;

            w[i][0] = s;
            w[i][1] = rs;
        }

        Arrays.sort(words);
        Arrays.sort(rwords);
        int l,r;
        for(String [] str:w) {
            r = getLow(str[1]);
            l = getHigh(str[0])+1;
            sb.append(l).append(" ").append(r).append("\n");
        }

        System.out.println(sb.toString());

    }

}