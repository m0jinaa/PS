import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int n;
		int[] invitations;
		int answer;
		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());

			invitations = new int[n];

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < n; i++) {
				invitations[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(invitations);

			answer = invitations[n - 1];

			for (int i = 0; i < n - 1; i += 2) {
				if (invitations[i] != invitations[i + 1]) {
					answer = invitations[i];
					break;
				}
			}

			sb.append("Case #").append(t).append(": ").append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}