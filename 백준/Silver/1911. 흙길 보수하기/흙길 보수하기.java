import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Pond implements Comparable<Pond> {
        int s, e;

        public Pond(int s, int e) {
            super();
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Pond p) {
            return this.s - p.s;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Pond[] ponds = new Pond[n];
        int s, e;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            ponds[i] = new Pond(s, e);
        }

        Arrays.sort(ponds);
        e = 0;
        int answer = 0;
        int c;
        for (Pond p : ponds) {
            if (p.e <= e) {
                continue;
            }
            if (p.s < e) {
                s = e;
            } else {
                s = p.s;
            }
            c = (int) Math.ceil((p.e - s) * 1.0 / l);
            answer += c;
            e = s + c * l;
        }

        System.out.println(answer);
    }
}