import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int ind = 1;
	static HashMap<String, Integer> map;

	static int getInd(String name) {
		map.putIfAbsent(name, ind++);

		return map.get(name);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int max = (n + m) * 2;
		int a, b;
		boolean isWorseThan[][] = new boolean[max + 1][max + 1];

		map = new HashMap<>();
		String[] input;
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" are worse than ");

			a = getInd(input[0]);
			b = getInd(input[1]);
			isWorseThan[a][b] = true;
		}

		for (int k = 1; k <= max; k++) {
			for (int i = 1; i <= max; i++) {
				if (k == i)
					continue;
				for (int j = 1; j <= max; j++) {
					if (k == j || i == j)
						continue;
					isWorseThan[i][j] |= (isWorseThan[i][k] && isWorseThan[k][j]);
				}
			}
		}

		while (m-- > 0) {
			input = br.readLine().split(" are worse than ");

			a = getInd(input[0]);
			b = getInd(input[1]);

			if (isWorseThan[a][b]) {
				sb.append("Fact\n");
			} else if (isWorseThan[b][a]) {
				sb.append("Alternative Fact\n");
			} else {
				sb.append("Pants on Fire\n");
			}
		}

		System.out.print(sb.toString());
	}
}