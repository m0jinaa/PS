import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static class Taxi implements Comparable<Taxi> {
        int x, y;

        public Taxi(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Taxi t) {
            if (this.x != t.x)
                return this.x - t.x;
            else
                return this.y - t.y;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Taxi> list = new ArrayList<Taxi>();
        int a, b;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (a <= b)
                continue;
            list.add(new Taxi(b, a));
        }

        Collections.sort(list);

        long ans = m;

        int s = 0, e = 0;

        for (Taxi t : list) {
            if (t.x > e) {
                ans += (e - s) * 2;
                s = t.x;
                e = t.y;
            } else {
                e = Math.max(e, t.y);
            }
        }

        ans += (e - s) * 2;
        System.out.println(ans);
    }

}