import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		String[] name = new String[n + 1];

		int[] tail = new int[n + 1];
		int[] next = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			name[i] = br.readLine();
			tail[i] = i;
		}

		int s = 1, e = 1;

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			next[tail[s]] = e;
			tail[s] = tail[e];
		}

		while (s != 0) {
			sb.append(name[s]);
			s = next[s];
		}

		System.out.println(sb.toString());
	}
}