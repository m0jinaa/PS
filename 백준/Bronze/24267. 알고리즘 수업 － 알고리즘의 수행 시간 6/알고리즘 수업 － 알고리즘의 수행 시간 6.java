import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		long answer = 0;

		for (int i = n - 2; i > 0; i--) {
			answer += (1L * i * (n - i - 1));
		}

		sb.append(answer).append("\n3\n");
		System.out.println(sb.toString());
	}
}