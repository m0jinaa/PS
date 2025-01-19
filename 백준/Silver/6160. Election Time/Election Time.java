import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class Vote {
		int a, b, ind;
		boolean win;

		public Vote(int a, int b, int ind) {
			super();
			this.a = a;
			this.b = b;
			this.ind = ind;
			this.win = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n, k;

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		Vote[] votes = new Vote[n];

		int a, b;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			votes[i] = new Vote(a, b, i + 1);
		}

		// 1라운드 점수로 정렬
		Arrays.sort(votes, new Comparator<Vote>() {

			@Override
			public int compare(Vote v1, Vote v2) {
				return v2.a - v1.a;
			}
		});

		// 2라운드 진출자 체크
		for (int i = 0; i < k; i++) {
			votes[i].win = true;
		}

		// 2라운드 투표수로 정렬
		Arrays.sort(votes, new Comparator<Vote>() {

			@Override
			public int compare(Vote v1, Vote v2) {
				return v2.b - v1.b;
			}
		});

		int answer = -1;

		for (Vote v : votes) {
			if (!v.win)
				continue;
			answer = v.ind;
			break;
		}

		System.out.println(answer);
	}
}