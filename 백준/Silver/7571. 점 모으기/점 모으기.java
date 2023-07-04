import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static class Dot {
        int x, y;

        public Dot(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Dot[] dots = new Dot[m];

        int x, y;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            dots[i] = new Dot(x, y);
        }

        Arrays.sort(dots, new Comparator<Dot>() {

            @Override
            public int compare(Dot d1, Dot d2) {
                return d1.x - d2.x;
            }

        });

        x = dots[m / 2].x;

        Arrays.sort(dots, new Comparator<Dot>() {

            @Override
            public int compare(Dot d1, Dot d2) {
                return d1.y - d2.y;
            }

        });

        y = dots[m / 2].y;

        long answer = 0;

        for (Dot d : dots) {
            answer += Math.abs(x - d.x) + Math.abs(y - d.y);
        }

        System.out.println(answer);
    }
}