import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		char[] vine;

		int d;
		int max;
		while (n-- > 0) {
			vine = br.readLine().toCharArray();

			max = 0;
			d = 0;

			for (char c : vine) {
				if (c == '[') {
					d++;
				} else {
					d--;
				}
				max = Math.max(max, d);
			}

			sb.append((1 << max)).append("\n");
		}

		System.out.print(sb.toString());
	}
}