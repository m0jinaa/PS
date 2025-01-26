import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Map<String, Integer> mapA = new HashMap<>();
		Map<String, Integer> mapB = new HashMap<>();

		String result;

		Set<String> set = new HashSet<>();

		for (int i = 0; i < n; i++) {
			result = br.readLine();

			mapA.put(result, mapA.getOrDefault(result, 0) + 1);
			set.add(result);
		}

		for (int i = 0; i < n; i++) {
			result = br.readLine();

			mapB.put(result, mapB.getOrDefault(result, 0) + 1);
			set.add(result);
		}

		int answer = 0;

		for (String s : set) {
			answer += Math.min(mapA.getOrDefault(s, 0), mapB.getOrDefault(s, 0));
		}

		System.out.println(answer);
	}
}