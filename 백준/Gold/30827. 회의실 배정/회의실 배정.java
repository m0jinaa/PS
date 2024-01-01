import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Meeting implements Comparable<Meeting> {
		int s, e;

		public Meeting(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Meeting m) {
			return this.e - m.e;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] room = new int[k];

		Meeting[] meetings = new Meeting[n];

		int s, e;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			meetings[i] = new Meeting(s, e);
		}

		Arrays.sort(meetings);

		int cnt = 0;
		int ind;
		int max;
		for (Meeting m : meetings) {
			max = -1;
			ind = -1;
			for (int i = 0; i < k; i++) {
				if (room[i] < m.s && max < room[i]) {
					ind = i;
					max = room[i];
				}
			}

			if (ind != -1) {
				cnt++;
				room[ind] = m.e;
			}
		}

		System.out.println(cnt);
	}
}