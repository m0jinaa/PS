import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        int n, x;
        Set<Integer> set = new HashSet<>();

        int answer;

        for (int t = 1; t <= tc; t++) {
            answer = 0;
            set.clear();

            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 1; i <= n; i++) {
                x = Integer.parseInt(st.nextToken());

                // 새로운 element면 True 반환됨
                if (set.add(x)) {
                    answer = i;
                }
            }

            sb.append("Case ").append(t).append(": ").append(answer).append("\n");
        }

        System.out.print(sb.toString());
    }
}