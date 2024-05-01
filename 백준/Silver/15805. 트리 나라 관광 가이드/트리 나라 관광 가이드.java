import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int k = (n - 1) / 2 + 1;

		int[] parent = new int[k];

		Arrays.fill(parent, -2);

		int p = -1;

		st = new StringTokenizer(br.readLine(), " ");
		int x;
		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());

			if (parent[x] == -2) {
				parent[x] = p;
			}

			p = x;
		}

		sb.append(k).append("\n");

		for (int i = 0; i < k; i++) {
			sb.append(parent[i]).append(i == k - 1 ? "\n" : " ");
		}

		System.out.print(sb.toString());
	}
}