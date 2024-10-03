import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		int n, answer;
		int i;
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine()) - 1;

			answer = 0;
			i = 2;

			while (n > 0) {
				n -= i;

				if (n % i == 0)
					answer++;
				i++;
			}

			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}