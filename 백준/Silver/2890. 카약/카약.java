import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Boat implements Comparable<Boat> {
        int n, d;

        public Boat(int n, int d) {
            super();
            this.n = n;
            this.d = d;
        }

        @Override
        public int compareTo(Boat b) {
            return this.d - b.d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[] row = new char[c];

        int t;
        int d;
        int ind = 0;
        Boat[] boats = new Boat[9];
        for (int i = 0; i < r; i++) {
            row = br.readLine().toCharArray();
            t = -1;
            d = 0;
            for (int j = c - 2; j > 0; j--) {
                if (row[j] != '.') {
                    t = row[j] - '0';
                    break;
                }
                d++;
            }

            if (t == -1)
                continue;
            boats[ind++] = new Boat(t, d);
        }

        int[] ranks = new int[10];

        Arrays.sort(boats);

        int bef = -1;
        int rank = 0;
        for (Boat b : boats) {
            if (b.d > bef) {
                ranks[b.n] = ++rank;
            } else {
                ranks[b.n] = rank;
            }
            bef = b.d;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 9; i++) {
            sb.append(ranks[i]).append("\n");
        }

        System.out.print(sb.toString());
    }
}