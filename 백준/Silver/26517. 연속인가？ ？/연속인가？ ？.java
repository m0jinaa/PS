import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		long k = Long.parseLong(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		long d = Long.parseLong(st.nextToken());

		long left = a * k + b;
		long right = c * k + d;

		if (left == right) {
			sb.append("Yes ").append(left).append("\n");
		} else {
			sb.append("No\n");
		}

		System.out.print(sb.toString());
	}
}