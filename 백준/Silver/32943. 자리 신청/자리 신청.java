import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Reservation implements Comparable<Reservation> {
		int t, s, n;

		public Reservation(int t, int s, int n) {
			super();
			this.t = t;
			this.s = s;
			this.n = n;
		}

		@Override
		public int compareTo(Reservation r) {
			return this.t - r.t;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int x = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int t, s, n;

		Reservation[] reservations = new Reservation[k];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			t = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			reservations[i] = new Reservation(t, s, n);
		}

		Arrays.sort(reservations);

		int[] students = new int[x + 1];

		boolean[] occupied = new boolean[c + 1];

		for (Reservation r : reservations) {
			if (occupied[r.s])
				continue;

			occupied[r.s] = true;

			// 미리 예약했던 좌석이 있다면 예약했던 좌석 취소하기
			if (students[r.n] != 0)
				occupied[students[r.n]] = false;

			students[r.n] = r.s;
		}

		for (int i = 1; i <= x; i++) {
			if (students[i] == 0)
				continue;
			sb.append(i).append(" ").append(students[i]).append("\n");
		}

		System.out.print(sb.toString());
	}
}