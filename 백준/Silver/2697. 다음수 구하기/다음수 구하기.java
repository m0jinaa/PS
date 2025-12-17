import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		char[] num;
		int m;
		int[] digit = new int[10];
		int loc;

		while (n-- > 0) {
			loc = -1;
			Arrays.fill(digit, 0);

			num = br.readLine().toCharArray();
			m = num.length;
			digit[num[m - 1] - '0']++;

			for (int i = m - 2; i >= 0; i--) {
				digit[num[i] - '0']++;
				if (num[i] < num[i + 1]) {
					loc = i;
					break;
				}
			}

			// 가장 큰 수일 때
			if (loc == -1) {
				sb.append("BIGGEST");
			} else {
				// 앞부분은 그대로 출력
				for (int i = 0; i < loc; i++) {
					sb.append(num[i]);
				}

				for (int i = num[loc] - '0' + 1; i < 10; i++) {
					if (digit[i] == 0)
						continue;
					sb.append(i);
					digit[i]--;
					break;
				}
				// 뒷부분은 정렬해서 출력

				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < digit[i]; j++) {
						sb.append(i);
					}
				}
			}

			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}