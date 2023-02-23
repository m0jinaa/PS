import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static final int MOD = 1_000_000_007;
    static int[] countTree;
    static long[] sumTree;

    static void update(int x, long v) {
        while (x <= n) {
            countTree[x] += 1;
            sumTree[x] += v;
            x += (x & -x);
        }
    }

    static long get(int x, long v) {
        int c = 0;
        long s = 0;
        while (x > 0) {
            c += countTree[x];
            s += sumTree[x];
            x -= (x & -x);
        }

        long ans = (s - c * v) % MOD;

        return ans;
    }

    static class Number implements Comparable<Number> {
        int ind;
        long x;

        public Number(int ind, long x) {
            super();
            this.ind = ind;
            this.x = x;
        }

        @Override
        public int compareTo(Number o) {
            if (this.x != o.x)
                return o.x < this.x ? -1 : 1;
            else
                return o.ind - this.ind;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        countTree = new int[n + 1];
        sumTree = new long[n + 1];

        st = new StringTokenizer(br.readLine(), " ");

        Number[] numbers = new Number[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = new Number(i + 1, Long.parseLong(st.nextToken()));
        }

        Arrays.sort(numbers);
        long answer = 0;
        for (Number number : numbers) {
            answer = (answer + get(number.ind, number.x)) % MOD;
            update(number.ind, number.x);
        }

        System.out.println(answer);
    }

}