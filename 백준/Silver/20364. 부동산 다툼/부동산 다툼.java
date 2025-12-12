import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		boolean[] occupied = new boolean[n + 1];

		int x, p;
		int now;

		while (q-- > 0) {
			x = Integer.parseInt(br.readLine());

			now = x;
			p = 0;

			while (now > 0) {
				if (occupied[now]) {
					p = now;
				}
				now >>= 1;
			}

			sb.append(p).append("\n");

			if (p == 0) {
				occupied[x] = true;
			}
		}

		System.out.println(sb.toString());
	}
}