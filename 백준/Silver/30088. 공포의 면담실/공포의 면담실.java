import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		long[] time = new long[n];

		int m;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			m = Integer.parseInt(st.nextToken());

			while (m-- > 0) {
				time[i] += Integer.parseInt(st.nextToken());
			}
		}

		Arrays.sort(time);

		long answer = 0;

		long bef = 0;

		for (int i = 0; i < n; i++) {
			answer += (bef + time[i]);
			bef += time[i];
		}

		System.out.println(answer);
	}
}