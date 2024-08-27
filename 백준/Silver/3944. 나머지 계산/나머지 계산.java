import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		int b, d;
		char[] row;
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			b = Integer.parseInt(st.nextToken());

			row = st.nextToken().toCharArray();

			d = 0;

			for (char c : row) {
				d = d * b + (c - '0');
				d %= (b - 1);
			}

			sb.append(d).append("\n");
		}

		System.out.print(sb.toString());
	}
}