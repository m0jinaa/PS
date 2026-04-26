import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static Map<String, Integer> map;
	static int ind = 0;

	static int getInd(String tag) {
		if (!map.containsKey(tag)) {
			map.put(tag, ind++);
		}

		return map.get(tag);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		final int MAX = 100_000;
		final String MULTIPLE = "-1\n";
		map = new HashMap<>();

		String answer = MULTIPLE;

		int t;

		int[] cnt = new int[MAX];
		String tag;
		int index;
		int max = 0;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			t = Integer.parseInt(st.nextToken());

			while (t-- > 0) {
				tag = st.nextToken();

				index = getInd(tag);

				cnt[index]++;

				if (cnt[index] > max) {
					answer = tag;
					max = cnt[index];
				} else if (cnt[index] == max) {
					answer = MULTIPLE;
				}
			}
		}

		System.out.println(answer);
	}
}