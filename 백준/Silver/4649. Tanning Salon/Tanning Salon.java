import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n;
		char[] customers;
		boolean[] tanning = new boolean[26];

		int leave = 0;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());

			if (n == 0)
				break;

			Arrays.fill(tanning, false);
			customers = st.nextToken().toCharArray();
			leave = 0;

			for (char c : customers) {
				if (tanning[c - 'A']) {
					tanning[c - 'A'] = false;
					n++;
				} else if (n <= 0) {
					leave++;
					tanning[c - 'A'] = true;
					n--;
				} else {
					tanning[c - 'A'] = true;
					n--;
				}
			}

			if (leave == 0)
				sb.append("All customers tanned successfully.\n");
			else
				sb.append(leave).append(" customer(s) walked away.\n");
		}

		System.out.println(sb.toString());
	}
}