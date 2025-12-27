import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		LinkedList<Integer>[] connectedTo = new LinkedList[n + 1];
		int[] v = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			connectedTo[i] = new LinkedList<>();
			v[i] = -1;
		}

		st = new StringTokenizer(br.readLine(), " ");

		int a;

		for (int i = 1; i <= n; i++) {
			a = Integer.parseInt(st.nextToken());

			connectedTo[a].add(i);
		}

		LinkedList<Integer> q = new LinkedList<>();

		q.add(n);
		v[n] = 0;

		int x;

		while (!q.isEmpty()) {
			x = q.poll();

			for (int y : connectedTo[x]) {
				if (v[y] != -1)
					continue;
				v[y] = v[x] + 1;
				q.add(y);
			}
		}

		for (int i = 1; i <= n; i++) {
			sb.append(v[i]).append("\n");
		}

		System.out.print(sb.toString());
	}
}