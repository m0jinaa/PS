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

		int[] B = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;

		int winning = 0;
		int win = 0;
		for (int i = 0; i < n; i++) {
			if (A[i] == B[i]) {
				answer = Math.max(answer, win);
				winning = -winning;
				win = 1;
			} else if ((A[i] == 1 && B[i] == 2) || (A[i] == 2 && B[i] == 3) || (A[i] == 3 && B[i] == 1)) {
				// B가 이김
				if (winning == 1) {
					win++;
				} else {
					answer = Math.max(answer, win);
					winning = 1;
					win = 1;
				}
			} else {
				// A가 이김
				if (winning == -1) {
					win++;
				} else {
					answer = Math.max(answer, win);
					winning = -1;
					win = 1;
				}
			}
		}

		answer = Math.max(answer, win);

		System.out.println(answer);
	}
}