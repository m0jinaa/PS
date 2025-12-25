import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		char[] map = br.readLine().toCharArray();

		boolean[] v = new boolean[n];

		v[0] = true;

		for (int i = 0; i < n; i++) {
			if (!v[i])
				continue;

			if (i + 1 < n && map[i + 1] != '#') {
				v[i + 1] = true;
			}

			if (i + k < n && map[i + k] != '#') {
				v[i + k] = true;
			}
		}

		System.out.println(v[n - 1] ? "YES" : "NO");
	}
}