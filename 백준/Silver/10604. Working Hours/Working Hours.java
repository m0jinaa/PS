import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String input;
		int total = 0;
		String H;
		int h;
		int hour, minute;
		while (true) {
			input = br.readLine();

			if ("###".equals(input)) {
				hour = total / 60;
				minute = total % 60;

				sb.append(String.format("%d:%02d\n", hour, minute));
				break;
			} else if ("$$$".equals(input)) {
				hour = total / 60;
				minute = total % 60;

				sb.append(String.format("%d:%02d\n", hour, minute));
				total = 0;
				continue;
			} else {

				st = new StringTokenizer(input, ":.");

				H = st.nextToken();

				if ("+".equals(H))
					total += Integer.parseInt(st.nextToken());
				else if ("-".equals(H))
					total -= Integer.parseInt(st.nextToken());
				else {

					h = Integer.parseInt(H);

					total += h * 60;

					if (H.startsWith("+")) {

						if (st.hasMoreTokens()) {
							total += Integer.parseInt(st.nextToken());
						}
					}

					else {
						if (st.hasMoreTokens()) {
							total -= Integer.parseInt(st.nextToken());
						}
					}
				}
			}
		}

		System.out.print(sb.toString());
	}
}