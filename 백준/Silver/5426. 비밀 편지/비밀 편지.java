import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		char[] letter;

		int n;
		int now = 0;
		int r;
		while (tc-- > 0) {
			letter = br.readLine().toCharArray();

			n = letter.length;

			r = (int) Math.sqrt(n);
			now = r - 1;

			while (now != n) {
				if (now >= n) {
					now = now % r - 1;
				}
				sb.append(letter[now]);
				now += r;
			}

			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}