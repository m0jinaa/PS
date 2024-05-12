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

		long[] vote = new long[n];

		st = new StringTokenizer(br.readLine(), " ");
		long total = 0;

		for (int i = 0; i < n; i++) {
			vote[i] = Long.parseLong(st.nextToken());
			total += vote[i];
		}

		Arrays.sort(vote);

		long target = (total + 1) / 2;

		int cnt = 1;

		int ind = n - 1;

		while (target > 0) {
			target -= vote[ind--];
			cnt++;
		}

		int answer = m / cnt;

		System.out.println(answer);
	}
}