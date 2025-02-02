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
		int k = Integer.parseInt(st.nextToken());

		int[] loc = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			loc[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(loc);

		int[] diff = new int[n];

		for (int i = 0; i < n; i++) {
			diff[i] = loc[i + 1] - loc[i];
		}

		Arrays.sort(diff);

		long answer = 0;

		for (int i = 0; i < n - k; i++) {
			answer += diff[i];
		}

		System.out.println(answer);
	}
}