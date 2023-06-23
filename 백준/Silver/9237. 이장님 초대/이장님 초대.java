import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] plants = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            plants[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(plants);

        int answer = 0;

        for (int i = n - 1; i >= 0; i--) {
            answer = Math.max(answer, n - i + 1 + plants[i]);
        }

        System.out.println(answer);
    }
}