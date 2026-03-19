import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Cow {

		int ind, t;
		long a;

		public Cow(int ind, long a, int t) {
			super();
			this.ind = ind;
			this.a = a;
			this.t = t;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		LinkedList<Cow> cows = new LinkedList<>();

		long a;
		int t;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Long.parseLong(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			cows.add(new Cow(i, a, t));
		}

		Collections.sort(cows, new Comparator<Cow>() {

			@Override
			public int compare(Cow x, Cow y) {
				return x.a < y.a ? -1 : (x.a > y.a ? 1 : 0);
			}

		});

		long answer = 0L;

		PriorityQueue<Cow> waiting = new PriorityQueue<>(new Comparator<Cow>() {

			@Override
			public int compare(Cow x, Cow y) {
				return x.ind - y.ind;
			}
		});

		long time = 0;

		Cow now;

		long delay;

		while (!cows.isEmpty() || !waiting.isEmpty()) {
			if (!waiting.isEmpty()) {
				now = waiting.poll();

				delay = time - now.a;

				answer = Math.max(answer, delay);

			} else {
				now = cows.poll();
				time = now.a;
			}

			time += now.t;

			while (!cows.isEmpty() && time > cows.peek().a) {
				waiting.add(cows.poll());
			}
		}

		System.out.println(answer);
	}
}