import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken()) * 2;

		HashMap<String, Integer> cities = new HashMap<>();

		st = new StringTokenizer(br.readLine(), " ");
		String city;
		int INF = 100_000_000;
		int[][] withTicket = new int[n][n];
		int[][] withoutTicket = new int[n][n];

		for (int i = 0; i < n; i++) {
			city = st.nextToken();
			cities.put(city, i);
			Arrays.fill(withTicket[i], INF);
			Arrays.fill(withoutTicket[i], INF);
			withTicket[i][i] = 0;
			withoutTicket[i][i] = 0;
		}

		int m = Integer.parseInt(br.readLine());

		int[] order = new int[m];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < m; i++) {
			order[i] = cities.get(st.nextToken());
		}

		HashSet<String> free = new HashSet<>();
		free.add("Mugunghwa");
		free.add("ITX-Saemaeul");
		free.add("ITX-Cheongchun");

		HashSet<String> half = new HashSet<>();
		half.add("S-Train");
		half.add("V-Train");

		int k = Integer.parseInt(br.readLine());

		String type;
		int a, b, c;

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			type = st.nextToken();
			a = cities.get(st.nextToken());
			b = cities.get(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			withoutTicket[a][b] = Math.min(withoutTicket[a][b], c * 2);
			withoutTicket[b][a] = Math.min(withoutTicket[b][a], c * 2);

			if (free.contains(type)) {
				withTicket[a][b] = Math.min(withTicket[a][b], 0);
				withTicket[b][a] = Math.min(withTicket[b][a], 0);
			} else if (half.contains(type)) {
				withTicket[a][b] = Math.min(withTicket[a][b], c);
				withTicket[b][a] = Math.min(withTicket[b][a], c);
			} else {
				withTicket[a][b] = Math.min(withTicket[a][b], c * 2);
				withTicket[b][a] = Math.min(withTicket[b][a], c * 2);
			}
		}

		for (int w = 0; w < n; w++) {
			for (int i = 0; i < n; i++) {
				if (w == i)
					continue;
				for (int j = 0; j < n; j++) {
					if (w == j || i == j)
						continue;
					withTicket[i][j] = Math.min(withTicket[i][j], withTicket[i][w] + withTicket[w][j]);
					withoutTicket[i][j] = Math.min(withoutTicket[i][j], withoutTicket[i][w] + withoutTicket[w][j]);
				}
			}
		}

		long with = r;
		long without = 0;

		for (int i = 1; i < m; i++) {
			a = order[i - 1];
			b = order[i];
			with += withTicket[a][b];
			without += withoutTicket[a][b];
		}
		String answer = "No";
		if (with < without) {
			answer = "Yes";
		}
		System.out.println(answer);
	}
}