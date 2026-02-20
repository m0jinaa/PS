import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		long answer = 0;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int[] V = new int[n];

		for (int i = 0; i < n; i++) {
			V[i] = Integer.parseInt(st.nextToken());
		}

		int[] speed = new int[n + 1];

		speed[n] = 0;

		for (int i = n - 1; i >= 0; i--) {
			speed[i] = Math.min(speed[i + 1] + 1, V[i]);
			answer += speed[i];
		}

		System.out.println(answer);
	}
}