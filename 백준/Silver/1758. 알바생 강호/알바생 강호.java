import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] money = new int[n];

		for (int i = 0; i < n; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(money);
		long sum = 0;
		int tip;
		for (int i = n - 1; i >= 0; i--) {
			tip = money[i] - (n - 1 - i);

			if (tip < 0)
				continue;
			sum += tip;
		}

		System.out.println(sum);
	}
}