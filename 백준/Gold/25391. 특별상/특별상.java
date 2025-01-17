import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class Score {
		int a, b;
		boolean win;

		public Score(int a, int b) {
			super();
			this.a = a;
			this.b = b;
			this.win = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n, m, k;

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		long answer = 0;

		Score[] scores = new Score[n];

		int a, b;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			scores[i] = new Score(a, b);
		}

		// 심판 점수로 정렬
		Arrays.sort(scores, new Comparator<Score>() {

			@Override
			public int compare(Score s1, Score s2) {
				return s2.b - s1.b;
			}
		});

		// 주최자 점수 더하고 상 수여받은 학생 체크
		for (int i = 0; i < k; i++) {
			answer += scores[i].a;
			scores[i].win = true;
		}

		// 주최자 점수로 정렬하면서 상 받은 사람 우선순위에서 제외
		Arrays.sort(scores, new Comparator<Score>() {

			@Override
			public int compare(Score s1, Score s2) {
				if (s1.win)
					return 1;
				else if (s2.win)
					return -1;
				else
					return s2.a - s1.a;
			}
		});

		// 주최자 점수 더하기
		for (int i = 0; i < m; i++) {
			answer += scores[i].a;
		}

		System.out.println(answer);
	}
}