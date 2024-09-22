import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[] loc = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			loc[i] = Integer.parseInt(st.nextToken());
		}

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				set.add(Math.abs(loc[i] - loc[j]));
			}
		}

		Integer[] len = set.toArray(new Integer[0]);

		int[] poll = new int[m];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < m; i++) {
			poll[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(poll);
		Arrays.sort(len);

		double answer = -1;

		int s, e, mid;
		int l = len.length;
		double size;
		boolean renewed;

		for (int p : poll) {

			renewed = false;

			s = 0;
			e = l - 1;

			while (s <= e) {
				mid = (s + e) / 2;

				size = 0.5 * p * len[mid];

				if (size > r) {
					e = mid - 1;
				} else {
					renewed = true;
					answer = Math.max(answer, size);
					s = mid + 1;
				}
			}
			if (!renewed)
				break;
		}
        
		System.out.println(answer == -1 ? -1 : String.format("%.01f", answer));
	}
}