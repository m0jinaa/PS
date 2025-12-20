import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		LinkedList<Integer>[] connectedTo = new LinkedList[n + 1];

		for (int i = 1; i <= n; i++) {
			connectedTo[i] = new LinkedList<>();
		}

		int v, w;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			connectedTo[v].add(w);
			connectedTo[w].add(v);
		}

		boolean[] constructed = new boolean[n + 1];

		int o, x;

		int[] neighbor = new int[n + 1];

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			o = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());

			if (o == 1) {
				if (constructed[x])
					continue;
				constructed[x] = true;
				for (int y : connectedTo[x]) {
					neighbor[y]++;
				}
			} else {
				sb.append(neighbor[x]).append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}