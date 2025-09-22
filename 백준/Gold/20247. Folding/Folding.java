import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int p1 = Integer.parseInt(st.nextToken());
        int q1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());
        int q2 = Integer.parseInt(st.nextToken());

        int q = Integer.parseInt(br.readLine());

        int x;

        int np1, nq1, np2, nq2;

        int answer;

        while (q-- > 0) {
            x = Integer.parseInt(br.readLine());

            if (x <= p1) {
                np1 = p1 - x;
                nq1 = q1 - x;
                np2 = p2 - x;
                nq2 = q2 - x;
            } else if (q2 <= x) {
                nq2 = x - p1;
                np2 = x - q1;
                nq1 = x - p2;
                np1 = x - q2;
            } else if (x <= q1) {
                np1 = 0;
                nq1 = Math.max(x - p1, q1 - x);
                np2 = p2 - x;
                nq2 = q2 - x;
            } else if (x <= p2) {
                np1 = x - q1;
                nq1 = x - p1;
                np2 = p2 - x;
                nq2 = q2 - x;
            } else {
                np1 = 0;
                nq1 = Math.max(x - p2, q2 - x);
                np2 = x - q1;
                nq2 = x - p1;
            }

            if (nq1 <= np2 || nq2 <= np1) { // 안겹치는 경우
                answer = nq1 - np1 + nq2 - np2;
            } else { // 겹치는 경우
                answer = Math.max(nq1, nq2) - Math.min(np1, np2);
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}