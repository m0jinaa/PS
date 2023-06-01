import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		int[] bridge = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			bridge[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		int s = Integer.parseInt(st.nextToken()) - 1;
		int e = Integer.parseInt(st.nextToken()) - 1;

		int[] v = new int[n];

		Arrays.fill(v, -1);

		LinkedList<Integer> list = new LinkedList<>();

		list.add(s);

		v[s] = 0;
		int now;
		int answer = -1;
		int k, nx;
		while (!list.isEmpty()) {
			now = list.poll();

			if (now == e) {
				answer = v[now];
				break;
			} else {
				nx = now;
				while ((nx -= bridge[now]) >= 0) {
					if (v[nx] == -1) {
						v[nx] = v[now] + 1;
						list.add(nx);
					}
				}

				nx = now;
				while ((nx += bridge[now]) < n) {
					if (v[nx] == -1) {
						v[nx] = v[now] + 1;
						list.add(nx);
					}
				}
			}
		}

		System.out.println(answer);
	}
}