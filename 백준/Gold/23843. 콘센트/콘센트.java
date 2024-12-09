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

		int[] time = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(time);

		int[] consent = new int[m];

		int ind = 0;

		for (int i = n - 1; i >= 0; i--) {
			consent[ind] += time[i];

			if (ind == 0 || consent[ind] == consent[ind - 1]) {
				ind = (ind + 1) % m;
			}
		}

		System.out.println(consent[0]);
	}
}