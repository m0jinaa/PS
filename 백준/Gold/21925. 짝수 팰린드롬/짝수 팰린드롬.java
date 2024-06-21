import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] A = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;

		int s, e;

		boolean p;
		for (int i = 0; i < n;) {
			p = false;
			for (int j = i + 1; j < n; j += 2) {
				s = i;
				e = j;

				while (s < e) {
					if (A[s] != A[e])
						break;
					s++;
					e--;
				}

				if (s > e) {
					answer++;
					p = true;
					i = j + 1;
					break;
				}
			}
			if (!p) {
				answer = -1;
				break;
			}
		}

		System.out.println(answer);
	}
}