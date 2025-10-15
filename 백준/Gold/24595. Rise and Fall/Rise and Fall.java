import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		boolean up;
		int n;
		char[] number;
		int bef = 0;
		int x;

		while (tc-- > 0) {
			up = true;
			bef = 0;

			number = br.readLine().toCharArray();

			n = number.length;

			for (int i = 0; i < n; i++) {
				x = number[i] - '0';

				if (up) {
					sb.append(x);
					if (bef > x) {
						up = false;
					}
					bef = x;
				} else if (bef < x) {
					while (i++ < n) {
						sb.append(bef);
					}
					break;
				} else {
					sb.append(x);
					bef = x;
				}
			}

			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}