import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int answer = -1001;

		int max = -1001;

		int x;

		while (n-- > 0) {
			x = Integer.parseInt(br.readLine());
			if (max < 0)
				max = x;
			else
				max += x;

			answer = Math.max(answer, max);
		}

		System.out.println(answer);
	}
}