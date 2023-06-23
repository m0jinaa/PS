import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] product = new int[n];

		for (int i = 0; i < n; i++) {
			product[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(product);
		int sum = 0;

		for (int i = 0; i < n; i++) {
			if ((n - i) % 3 == 0)
				continue;
			sum += product[i];
		}

		System.out.println(sum);
	}
}