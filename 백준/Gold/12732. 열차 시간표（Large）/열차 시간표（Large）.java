import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Train implements Comparable<Train> {
		int s, e, type;

		public Train(int s, int e, int type) {
			super();
			this.s = s;
			this.e = e;
			this.type = type;
		}

		@Override
		public int compareTo(Train t) {
			if (this.s != t.s)
				return this.s - t.s;
			else
				return this.e - t.e;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		int T;
		int na, nb;
		PriorityQueue<Integer> trainA = new PriorityQueue<>();
		PriorityQueue<Integer> trainB = new PriorityQueue<>();

		Train[] trains;
		int s, e;
		int a, b;

		for (int t = 1; t <= tc; t++) {
			trainA.clear();
			trainB.clear();

			T = Integer.parseInt(br.readLine());

			a = 0;
			b = 0;

			st = new StringTokenizer(br.readLine(), " ");

			// 각 역에서 출발시켜야하는 전체 열차의 수
			na = Integer.parseInt(st.nextToken());
			nb = Integer.parseInt(st.nextToken());

			trains = new Train[na + nb];

			for (int i = 0; i < na; i++) {
				st = new StringTokenizer(br.readLine(), " :");

				s = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());

				trains[i] = new Train(s, e, 0);
			}

			for (int i = 0; i < nb; i++) {
				st = new StringTokenizer(br.readLine(), " :");

				s = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());

				trains[na + i] = new Train(s, e, 1);
			}

			Arrays.sort(trains);

			// 가장 빠른 출발시간이 기차의 출발시간보다 느리다면 새 차량을 출발시켜야 함.
			for (Train train : trains) {
				if (train.type == 0) {
					if (trainA.isEmpty() || trainA.peek() > train.s) {
						a++;
					} else {
						trainA.poll();
					}
					trainB.add(train.e + T);
				} else {
					if (trainB.isEmpty() || trainB.peek() > train.s) {
						b++;
					} else {
						trainB.poll();
					}
					trainA.add(train.e + T);
				}
			}

			sb.append("Case #").append(t).append(": ").append(a).append(" ").append(b).append("\n");
		}

		System.out.print(sb.toString());
	}
}