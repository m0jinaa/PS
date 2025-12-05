import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		long sum = 0;
		long xor = 0;

		int m = Integer.parseInt(br.readLine());

		int order;
		long x;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			order = Integer.parseInt(st.nextToken());

			switch (order) {
			case 1:
				x = Long.parseLong(st.nextToken());
				sum += x;
				xor ^= x;
				break;
			case 2:
				x = Long.parseLong(st.nextToken());
				sum -= x;
				xor ^= x;
				break;
			case 3:
				sb.append(sum).append("\n");
				break;
			case 4:
				sb.append(xor).append("\n");
				break;
			}
		}

		System.out.print(sb.toString());
	}
}