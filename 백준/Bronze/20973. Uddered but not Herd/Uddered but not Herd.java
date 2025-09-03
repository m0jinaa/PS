import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<Character, Integer> order = new HashMap<>();

		char[] row = br.readLine().toCharArray();

		for (int i = 0; i < 26; i++) {
			order.put(row[i], i);
		}

		char[] humming = br.readLine().toCharArray();

		int now = -1;
		int answer = 1;

		int o;

		for (char c : humming) {
			o = order.get(c);
			if (o <= now) {
				answer++;
			}
			now = o;
		}

		System.out.println(answer);
	}
}