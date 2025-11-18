import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int q = Integer.parseInt(br.readLine());

		int m;

		int t;
		int wait;

		final int limit = 50;
		final int cycle = 12;

		int time = 366;
		int hour, minute;

		while (q-- > 0) {
			m = Integer.parseInt(br.readLine());

			t = m / limit;
			wait = t * cycle;

			hour = (time + wait) / 60;
			minute = (time + wait) % 60;

			sb.append(String.format("%02d:%02d\n", hour, minute));
		}

		System.out.print(sb.toString());
	}
}