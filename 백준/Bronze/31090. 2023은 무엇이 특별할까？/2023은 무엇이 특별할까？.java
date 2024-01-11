import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		int n, m;
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			m = n + 1;
			n %= 100;
			if (m % n == 0) {
				sb.append("Good\n");
			} else {
				sb.append("Bye\n");
			}
		}

		System.out.print(sb.toString());
	}
}