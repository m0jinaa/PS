import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Line implements Comparable<Line> {
		int a, b;

		public Line(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Line l) {
			return this.a - l.a;
		}

	}

	static int[] wire;
	static int ind;

	static int getInd(int x) {
		int s = 0;
		int e = ind;

		int loc = ind + 1;
		int mid;

		while (s <= e) {
			mid = (s + e) / 2;

			if (wire[mid] > x) {
				loc = mid;
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}

		wire[loc] = x;

		if (loc == ind + 1) {
			ind++;
		}

		return loc;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Line[] lines = new Line[n];

		int a, b;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			lines[i] = new Line(a, b);
		}

		Arrays.sort(lines);

		wire = new int[n];
		ind = -1;

		int[] loc = new int[n];

		for (int i = 0; i < n; i++) {
			loc[i] = getInd(lines[i].b);
		}

		int answer = n - (ind + 1);

		int[] remove = new int[answer];

		int now = ind;
		int x = 0;

		for (int i = n - 1; i >= 0; i--) {
			if (loc[i] == now) {
				now--;
			} else {
				remove[x++] = lines[i].a;
			}
		}

		Arrays.sort(remove);

		sb.append(answer).append("\n");

		for (int r : remove) {
			sb.append(r).append("\n");
		}

		System.out.print(sb.toString());
	}
}