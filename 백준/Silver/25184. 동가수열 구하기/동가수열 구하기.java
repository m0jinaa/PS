import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int d = n - (n + 1) / 2;

		for (int i = (n + 1) / 2; i >= 1; i--) {
			sb.append(i).append(" ");
			if (i + d != (n + 1) / 2)
				sb.append(i + d).append(" ");
		}

		System.out.println(sb.toString());
	}
}