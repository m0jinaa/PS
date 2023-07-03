import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] paper = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            paper[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(paper);

        int answer = 0;

        for (int i = n; i > 0; i--) {
            if (i <= paper[n - i]) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}