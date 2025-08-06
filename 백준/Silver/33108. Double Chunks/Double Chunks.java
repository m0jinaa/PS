import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] bar = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			bar[i] = Integer.parseInt(st.nextToken());
		}

		Map<Integer, Integer> map = new HashMap<>();
		int bef = 0;

		int v;
		int c;

		int answer = 1;

		for (int i = 1; i < n; i++) {
			v = bar[i - 1] + bar[i];

			if (v == bef) {
				bef = 0;
			} else {
				c = map.getOrDefault(v, 0) + 1;
				map.put(v, c);
				bef = v;
				answer = Math.max(answer, c);
			}
		}

		System.out.println(answer);
	}
}