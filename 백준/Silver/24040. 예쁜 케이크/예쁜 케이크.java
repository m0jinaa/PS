import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		long N;

		while (T-- > 0) {
			N = Long.parseLong(br.readLine());

			if (N % 9 == 0 || N % 3 == 2)
				sb.append("TAK\n");
			else
				sb.append("NIE\n");
		}

		System.out.print(sb.toString());
	}
}