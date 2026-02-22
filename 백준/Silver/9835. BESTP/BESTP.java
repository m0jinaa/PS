import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int v = 0;
		char[] row;
		int max = 0;
		boolean escape = false;
		boolean end = false;

		end: while (true) {
			row = br.readLine().toCharArray();

			for (char c : row) {
				switch (c) {
				case 'o':
					v += 100;
					break;
				case 'e':
					v += 10;
					break;
				case 'g':
					v += 1;
					break;
				case 'a':
					break;
				case 'b':
					v -= 1;
					break;
				case 'i':
					v -= 10;
					break;
				case 'u':
					v -= 100;
					break;
				case ',':
					end = true;
					break;
				case '.':
					escape = true;
					break;
				}

				v = Math.max(v, 0);

				max = Math.max(max, v);

				if (end || escape) {
					sb.append(max).append("\n");
					max = 0;
					v = 0;
					end = false;

				}

				if (escape) {
					break end;
				}
			}
		}

		System.out.print(sb.toString());
	}
}