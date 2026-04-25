import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] time = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(time);

		int answer = 0;

		int i = 0;

		int c = 0;
		while (i < n) {
			c++;
			if (i == n - 1 || time[i + 1] != time[i]) {
				answer = Math.max(answer + c, time[i] + c);
				c = 0;
			}

			i++;
		}

		System.out.println(answer);
	}
}