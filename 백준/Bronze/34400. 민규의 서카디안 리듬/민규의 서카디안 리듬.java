import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		int time;

		int at;

		while (t-- > 0) {
			time = Integer.parseInt(br.readLine());

			at = time % 25;

			sb.append(at < 17 ? "ONLINE\n" : "OFFLINE\n");
		}

		System.out.print(sb.toString());
	}
}