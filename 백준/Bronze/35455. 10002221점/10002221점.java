import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int n, s;

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());

			if (s - n != 10_000_000) {
				sb.append("No\n");
			} else {
				sb.append("Yes\n");
			}
		}

		System.out.print(sb.toString());
	}
}