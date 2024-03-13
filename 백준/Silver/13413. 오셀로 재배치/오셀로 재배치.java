import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		int n;
		char[] A, B;
		int ac, bc, diff, d;
		int answer;
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());

			A = br.readLine().toCharArray();
			B = br.readLine().toCharArray();

			ac = 0;
			bc = 0;
			diff = 0;
			answer = 0;

			for (int i = 0; i < n; i++) {
				if (A[i] == 'B')
					ac++;
				if (B[i] == 'B')
					bc++;
				if (A[i] != B[i])
					diff++;
			}

			if (ac == bc) {
				answer = diff / 2;
			} else {
				d = Math.abs(ac - bc);
				answer = d + (diff - d) / 2;
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}