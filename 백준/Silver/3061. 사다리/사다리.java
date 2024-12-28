import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int n;
		int[] ladder;

		int answer = 0;
		int temp;

		while (tc-- > 0) {
			n = Integer.parseInt(br.readLine());

			ladder = new int[n];

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < n; i++) {
				ladder[i] = Integer.parseInt(st.nextToken());
			}

			answer = 0;

			for (int i = 1; i < n; i++) {
				for (int j = i; j > 0; j--) {
					if (ladder[j - 1] < ladder[j])
                        continue;
                    temp = ladder[j - 1];
                    ladder[j - 1] = ladder[j];
                    ladder[j] = temp;
                    answer++;
				}
			}

			sb.append(answer).append("\n");
		}
		System.out.print(sb.toString());
	}
}