import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		long a, b;

		while (t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());

			if (b % a == 0 && a != b)
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
		}

		System.out.print(sb.toString());
	}
}