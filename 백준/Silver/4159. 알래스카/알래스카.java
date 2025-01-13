import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n, bef;

		boolean possible;

		int[] charger;

		while ((n = Integer.parseInt(br.readLine())) != 0) {
			charger = new int[n];

			for (int i = 0; i < n; i++) {
				charger[i] = Integer.parseInt(br.readLine());
			}

			bef = 0;
			possible = true;

			Arrays.sort(charger);

			for (int c : charger) {
				if (c - bef <= 200) {
					bef = c;
					continue;
				}

				possible = false;
				break;
			}

			// 마지막 충전소에서 델타정션까지 갔다가 돌아올 수 있는지 확인.
			if (1422 - charger[n - 1] > 100)
				possible = false;

			sb.append(possible ? "POSSIBLE\n" : "IMPOSSIBLE\n");
		}

		System.out.print(sb.toString());
	}
}