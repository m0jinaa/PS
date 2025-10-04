import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		Map<Integer, Integer> map = new HashMap<>();

		int x;

		st = new StringTokenizer(br.readLine(), " ");

		while (a-- > 0) {
			x = Integer.parseInt(st.nextToken());

			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		st = new StringTokenizer(br.readLine(), " ");

		while (b-- > 0) {
			x = Integer.parseInt(st.nextToken());

			map.put(x, map.getOrDefault(x, 0) + 2);
		}

		Set<Integer> set = new TreeSet<>(map.keySet());

		int bef = 0;

		int answer = 0;

		for (int s : set) {
			if (map.get(s) == 3)
				continue;
			else if (bef != map.get(s)) {
				if (bef != 0)
					answer++;
				bef = map.get(s);
			}
		}

		System.out.println(answer);
	}
}