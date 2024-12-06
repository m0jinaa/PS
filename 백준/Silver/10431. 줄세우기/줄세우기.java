import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] line;

	static void swap(int x) {
		int t = line[x];
		line[x] = line[x - 1];
		line[x - 1] = t;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = 20;
		line = new int[n];

		int p = Integer.parseInt(br.readLine());

		int t, cnt, x;

		while (p-- > 0) {

			Arrays.fill(line, 0);

			st = new StringTokenizer(br.readLine(), " ");

			t = Integer.parseInt(st.nextToken());
			cnt = 0;

			for (int i = 0; i < n; i++) {
				line[i] = Integer.parseInt(st.nextToken());
				x = i;
				while (x > 0 && line[x] < line[x - 1]) {
					swap(x);
					cnt++;
					x--;
				}
			}

			sb.append(t).append(" ").append(cnt).append("\n");
		}

		System.out.print(sb.toString());
	}
}