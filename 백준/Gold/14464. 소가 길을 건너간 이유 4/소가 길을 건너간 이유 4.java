import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Cow {
		int s, e;

		public Cow(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] chicken = new int[c];

		for (int i = 0; i < c; i++) {
			chicken[i] = Integer.parseInt(br.readLine());
		}

		PriorityQueue<Cow> pq = new PriorityQueue<>(new Comparator<Cow>() {

			@Override
			public int compare(Cow c1, Cow c2) {
				if (c1.e != c2.e) {
					return c1.e - c2.e;
				} else {
					return c1.s - c2.s;
				}
			}

		});

		Arrays.sort(chicken);

		int s, e;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			pq.add(new Cow(s, e));
		}

		int answer = 0;
		Cow now;
		boolean helped;
		while (!pq.isEmpty()) {
			now = pq.peek();
			helped = false;
			for (int i = 0; i < c; i++) {
				if (0 < chicken[i] && now.s <= chicken[i] && chicken[i] <= now.e) {
					answer++;
					pq.poll();
					helped = true;
					chicken[i] *= -1;
					break;
				}
			}

			if (!helped)
				pq.poll();
		}

		System.out.println(answer);
	}
}