import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] exp = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			exp[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(exp);

		int s = 0;
		int e = n - 1;

		int answer = 0;

		while (s < e) {
			if (exp[s] + exp[e] >= m) {
				answer++;
				s++;
				e--;
			} else {
				s++;
			}
		}

		System.out.println(answer);
	}
}