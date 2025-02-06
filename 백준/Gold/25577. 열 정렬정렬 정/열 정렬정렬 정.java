import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] original = new int[n];
		int[] sorted = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		Map<Integer, Integer> loc = new HashMap<>();

		for (int i = 0; i < n; i++) {
			original[i] = Integer.parseInt(st.nextToken());
			sorted[i] = original[i];
			loc.put(original[i], i);
		}

		Arrays.sort(sorted);

		int cnt = 0;

		int l;

		for (int i = 0; i < n; i++) {
			if (sorted[i] == original[i])
				continue;

			cnt++;

			l = loc.get(sorted[i]);

			loc.put(original[i], l);

			original[l] = original[i];
			original[i] = sorted[i];
		}

		System.out.println(cnt);
	}
}