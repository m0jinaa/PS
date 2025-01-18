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
		long k = Long.parseLong(st.nextToken());

		long[] v = new long[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			v[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(v);

		long speed;

		long answer = Long.MAX_VALUE;

		for (int i = 1; i < n; i++) {
			speed = v[0] * i + v[i] * (n - i);
			answer = Math.min(answer, (k + speed - 1) / speed);
		}

		System.out.println(answer);
	}
}