import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int[] cows = new int[n];

		for (int i = 0; i < n; i++) {
			cows[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(cows);
		int m, l, r, loc;
		int answer = 0;

		for (int i = 0; i < n; i++) {
			l = i;
			r = n - 1;
			loc = i;
			while (l <= r) {
				m = (l + r) / 2;
				if (cows[i] + cows[m] <= s) {
					loc = m;
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
			answer += loc - i;
		}
        
		System.out.println(answer);
	}
}