import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n;

		TreeSet<String> kind = new TreeSet<>();
		HashMap<String, Integer> count = new HashMap<>();

		String name;

		int tc = 0;

		while ((n = Integer.parseInt(br.readLine())) != 0) {
			kind.clear();
			count.clear();
			tc++;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				while (st.countTokens() > 1) {
					st.nextToken();
				}

				name = st.nextToken().toLowerCase();

				if (kind.add(name)) {
					count.put(name, 1);
				} else {
					count.put(name, count.get(name) + 1);
				}
			}

			sb.append("List ").append(tc).append(":\n");

			for (String type : kind) {
				sb.append(type).append(" | ").append(count.get(type)).append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}