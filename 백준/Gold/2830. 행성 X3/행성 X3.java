import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] bit = new int[20];
		int x;
		int ind;
		long answer = 0L;

		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(br.readLine());
			ind = 0;

			while (x != 0) {
				bit[ind++] += (x % 2);
				x >>= 1;
			}
		}

		for (int i = 0; i < 20; i++) {
			answer += (1L << i) * (n - bit[i]) * bit[i];
		}

		System.out.println(answer);

	}
}