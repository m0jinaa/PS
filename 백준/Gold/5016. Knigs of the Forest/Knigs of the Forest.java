import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Moose {
		int y, s;

		public Moose(int y, int s) {
			super();
			this.y = y;
			this.s = s;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		int y = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		int year, strength;

		int total = n + k - 1;

		// 년도 순으로 정렬
		PriorityQueue<Moose> mooses = new PriorityQueue<>(new Comparator<Moose>() {

			@Override
			public int compare(Moose a, Moose b) {
				return a.y - b.y;
			}

		});

		mooses.add(new Moose(y, p));

		for (int i = 1; i < total; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			year = Integer.parseInt(st.nextToken());
			strength = Integer.parseInt(st.nextToken());

			mooses.add(new Moose(year, strength));
		}

		// 힘 내림차순으로 정렬하는 순위표 만들기
		PriorityQueue<Moose> rank = new PriorityQueue<>(new Comparator<Moose>() {

			@Override
			public int compare(Moose a, Moose b) {
				return b.s - a.s;
			}
		});

		// 모든 무스의 힘이 다르므로 karl의 힘과 일치하는 값이 나오면 우승하는 것

		boolean win = false;

		Moose m;
		int winYear = -1;

		while (k-- > 0) {
			m = mooses.poll();
			winYear = m.y;
			rank.add(m);
		}

		// 일등 무스
		Moose first;

		while (n-- > 0) {
			first = rank.poll();

			if (first.s == p) {
				win = true;
				break;
			}

			if (!mooses.isEmpty()) {
				m = mooses.poll();

				rank.add(m);

				winYear = m.y;
			}
		}
		sb.append(win ? winYear : "unknown");

		System.out.println(sb.toString());
	}
}