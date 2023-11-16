import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

//  1   2   4
//  8  16  32
// 64 128 256
public class Main {
	static int[] p = new int[] { 11, 23, 38, 89, 186, 308, 200, 464, 416 };
	static int target;
	static boolean[] v;

	static int getMin() {
		LinkedList<Integer> q = new LinkedList<>();

		q.add(0);
		v[0] = true;

		int answer = -1;

		int x, y, qsize;
		int t = 0;
		end: while (!q.isEmpty()) {
			qsize = q.size();
			while (qsize-- > 0) {
				x = q.poll();

				if (x == target) {
					answer = t;
					break end;
				}

				for (int i = 0; i < 9; i++) {
					y = x ^ p[i];

					if (v[y])
						continue;
					v[y] = true;
					q.add(y);
				}

			}
			t++;
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		char[] row;
		int answer;
		v = new boolean[1 << 9];
		while (tc-- > 0) {

			target = 0;
			Arrays.fill(v, false);

			for (int i = 0; i < 3; i++) {
				row = br.readLine().toCharArray();

				for (int j = 0; j < 3; j++) {
					if (row[j] != '*')
						continue;
					target += (1 << (i * 3 + j));
				}
			}

			answer = getMin();

			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());

	}
}
