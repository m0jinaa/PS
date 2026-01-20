import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		int n, x;

		HashMap<Integer, Integer> map = new HashMap<>();
		int answer = 0;

		while (tc-- > 0) {
			n = Integer.parseInt(br.readLine());
			map.clear();

			int s = 0;
			int e = -1;
			answer = 0;

			for (int i = 0; i < n; i++) {
				x = Integer.parseInt(br.readLine());

				if (!map.containsKey(x) || map.get(x) < s) {
					map.put(x, i);
				} else {
					s = map.get(x) + 1;
					map.put(x, i);
				}
				e = i;
				answer = Math.max(answer, e - s + 1);
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}