import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		String now;

		char[] row;

		int high, low;
		int cnt = 0;
		while (n-- > 0) {

			now = br.readLine();
			cnt = 0;

			while (!"6174".equals(now)) {
				cnt++;
				high = 0;
				low = 0;

				while (now.length() < 4) {
					now = "0" + now;
				}
				row = now.toCharArray();

				Arrays.sort(row);

				for (int i = 0; i < 4; i++) {
					high = high * 10 + (row[3 - i] - '0');
					low = low * 10 + (row[i] - '0');
				}

				now = "" + (high - low);
			}

			sb.append(cnt).append("\n");
		}

		System.out.println(sb.toString());
	}
}
