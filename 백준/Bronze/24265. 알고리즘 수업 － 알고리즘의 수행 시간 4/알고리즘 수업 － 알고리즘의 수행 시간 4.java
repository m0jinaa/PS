import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		long answer = 1L * n * (n - 1) / 2;

		sb.append(answer).append("\n2\n");

		System.out.print(sb.toString());
	}
}