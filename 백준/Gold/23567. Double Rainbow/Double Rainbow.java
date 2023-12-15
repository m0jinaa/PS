import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] P = new int[n];

		int pkind = 0;
		int[] pcnt = new int[k + 1];
		for (int i = 0; i < n; i++) {
			P[i] = Integer.parseInt(br.readLine());
			pcnt[P[i]]++;
			if (pcnt[P[i]] == 1) {
				pkind++;
			}
		}

		int[] cnt = new int[k + 1];
		int kind = 0;

		int s = 0;
		int e = 0;

		int answer = n + 1;

		while (e < n) {
			cnt[P[e]]++;
			pcnt[P[e]]--;

			if (cnt[P[e]] == 1)
				kind++;
			if (pcnt[P[e]] == 0) {
				pkind--;
			}
			while (kind == k) {
				if (pkind == k)
					answer = Math.min(answer, e - s + 1);
				cnt[P[s]]--;
				pcnt[P[s]]++;
				if (cnt[P[s]] == 0)
					kind--;
				if (pcnt[P[s++]] == 1)
					pkind++;
			}
			e++;
		}

		System.out.println(answer == n + 1 ? 0 : answer);
	}
}