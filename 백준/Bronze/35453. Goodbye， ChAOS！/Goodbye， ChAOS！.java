import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Map<Integer, Integer> map = new HashMap<>();

		map.put(232, 2017);
		map.put(88, 2018);
		map.put(754, 2019);
		map.put(29, 2020);
		map.put(28, 2021);
		map.put(1015, 2022);
		map.put(1295, 2023);
		map.put(1073, 2024);
		map.put(348, 2025);

		int t = Integer.parseInt(br.readLine());

		int n;
		String contest;
		int l;
		int hash;

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			hash = 1;

			while (n-- > 0) {
				contest = br.readLine();
				l = contest.length();
				hash *= l;
			}
			if (map.containsKey(hash)) {
				sb.append(map.get(hash)).append("\n");
			} else {
				sb.append("Goodbye, ChAOS!\n");
			}
		}

		System.out.print(sb.toString());
	}
}