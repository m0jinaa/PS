import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int[] power = new int[n];

		for (int i = 0; i < n; i++) {
			power[i] = Integer.parseInt(st.nextToken());
		}

		int s = 0;
		int e = n - 1;

		int answer = 0;
		while (s < e) {
			answer = Math.max(answer, (e - s - 1) * (Math.min(power[s], power[e])));

			if (power[s] < power[e]) {
				s++;
			} else {
				e--;
			}
		}

		System.out.println(answer);
	}
}