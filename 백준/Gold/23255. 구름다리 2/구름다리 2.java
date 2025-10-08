import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[] occupied = new boolean[n + 1];
		int[] color = new int[n + 1];

		ArrayList<Integer>[] connectedTo = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			connectedTo[i] = new ArrayList<>();
		}

		int a, b;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			connectedTo[a].add(b);
			connectedTo[b].add(a);
		}

		for (int i = 1; i <= n; i++) {
			occupied = new boolean[n + 1];
			for (int j : connectedTo[i]) {
				occupied[color[j]] = true;
			}

			for (int j = 1; j <= n; j++) {
				if (occupied[j])
					continue;
				color[i] = j;
				break;
			}
		}

		for (int i = 1; i <= n; i++) {
			sb.append(color[i]).append(i == n ? "\n" : " ");
		}

		System.out.print(sb.toString());
	}
}