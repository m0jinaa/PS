import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] stock = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i <= n; i++) {
			stock[i] = Integer.parseInt(st.nextToken());
		}

		int canMake = 1;

		int coin;

		for (int i = 0; i <= n; i++) {
			coin = (1 << i);

			if (stock[i] == 0)
				continue;
			else if (coin > canMake) {
				break;
			}
			canMake += (coin * stock[i]);
		}

		System.out.println(canMake);
	}
}
