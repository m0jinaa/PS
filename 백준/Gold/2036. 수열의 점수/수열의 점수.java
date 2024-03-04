import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[] pos = new long[n];
		long[] neg = new long[n];

		int p = 0;
		int m = 0;
		int one = 0;

		long x;

		for (int i = 0; i < n; i++) {
			x = Long.parseLong(br.readLine());
			if (x <= 0) {
				neg[m++] = x;
			} else if (x > 1) {
				pos[p++] = x;
			} else {
				one++;
			}
		}

		Arrays.sort(neg);
		Arrays.sort(pos, 0, p);

		long answer = 0;

		int s = 0;
		if (p % 2 != 0) {
			answer += pos[s++];
		}

		for (int i = s; i < p; i += 2) {
			answer += (pos[i] * pos[i + 1]);
		}

		s = 0;
		if (m % 2 != 0) {
			answer += neg[--m];
		}

		for (int i = s; i < m; i += 2) {
			answer += (neg[i] * neg[i + 1]);
		}

		answer += one;
        
		System.out.println(answer);
    }
}