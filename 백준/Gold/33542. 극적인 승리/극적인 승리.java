import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static Target[] targets;

	static class Target implements Comparable<Target> {
		int x, ind;

		public Target(int x, int ind) {
			super();
			this.x = x;
			this.ind = ind;
		}

		@Override
		public int compareTo(Target t) {
			return this.x - t.x;
		}
	}

	static int getMin(int ind, int c) {
		int s = 0;
		int e = n - 1;

		int answer = -1;

		int m;

		while (s <= e) {
			m = (s + e) / 2;

			if (targets[m].ind == ind) { // 왼쪽 손으로 맞춘 과녁 번호와 일치하면 다음꺼 살펴보기
				m++;
				if (m > e) {
					e = m - 2;
				} else if (targets[m].x <= c) {
					s = m + 1;
				} else {
					answer = m;
					e = m - 2;
				}

			} else if (targets[m].x <= c) {
				s = m + 1;
			} else {
				answer = m;
				e = m - 1;
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		n = Integer.parseInt(br.readLine());

		int[] leftTarget = new int[n];

		targets = new Target[n];

		int l, r;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());

			leftTarget[i] = l;
			targets[i] = new Target(r, i);
		}

		Arrays.sort(targets);

		int diff = a - b;

		if (diff < 0) {
			sb.append("-1 -1");
		} else {
			int left = -1;
			int right = -1;

			int minSum = Integer.MAX_VALUE;

			// 왼쪽으로만 쏨
			for (int i = 0; i < n; i++) {
				if (leftTarget[i] > diff && leftTarget[i] < minSum) {
					minSum = leftTarget[i];
					left = i + 1;
				}
			}
			// 오른쪽으로만 쏨
			for (int i = 0; i < n; i++) {
				if (targets[i].x > diff && targets[i].x < minSum) {
					minSum = targets[i].x;
					right = targets[i].ind + 1;
					left = -1;
				}
			}

			// 양손 다 과녁을 맞추는 경우
			int ret;

			for (int i = 0; i < n; i++) {
				// 왼쪽손으로 i번째 과녁을 맞출 때 오른쪽으로는 어느걸 맞춰야하나
				ret = getMin(i, diff - leftTarget[i]);
				if (ret == -1)
					continue;
				if (leftTarget[i] + targets[ret].x < minSum) {
					minSum = leftTarget[i] + targets[ret].x;
					left = i + 1;
					right = targets[ret].ind + 1;
				}
			}

			if (left == -1 && right == -1) {
				sb.append("No");
			} else {
				sb.append(left).append(" ").append(right);
			}

		}

		System.out.println(sb.toString());
	}
}