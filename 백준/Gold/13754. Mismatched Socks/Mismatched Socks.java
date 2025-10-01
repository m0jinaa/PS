import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static long[] socks;

    static boolean makePair(long x) {
        long c = 0;
        long ind = 0;

        for (int i = n - 1; i >= 0; i--) {
            ind += Math.min(socks[i], x);

            if (ind >= x) {
                c++;
                ind %= x;
            }
        }

        return c >= 2;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        long total = 0;

        socks = new long[n];

        for (int i = 0; i < n; i++) {
            socks[i] = Integer.parseInt(br.readLine());
            total += socks[i];
        }

        Arrays.sort(socks);
        
        long s = 1;
        long e = total / 2;

        long answer = 0;

        long m;

        while (s <= e) {
            m = (s + e) / 2;

            if (makePair(m)) {
                answer = m;
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        System.out.println(answer);
    }
}