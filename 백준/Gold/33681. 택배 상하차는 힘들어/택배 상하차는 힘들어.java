import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long[] A; // 각 위치별 택배 수
	static boolean[] v; // 방문여부
	static LinkedList<Integer>[] canGo; // 도로연결관계

	static class Answer {
		long cnt; // 박스 개수
		long cost; // 비용

		public Answer(long cnt, long cost) {
			super();
			this.cnt = cnt;
			this.cost = cost;
		}
	}

	static Answer getMinMove(int x) {// 현재 x에 위치
		long max = 0;
		long sum = 0;
		long total = 0;
		Answer ret;
		v[x] = true;

		for (int y : canGo[x]) {
			if (v[y])
				continue;
			ret = getMinMove(y);

			total += ret.cnt;
			max = Math.max(max, ret.cnt);
			sum += ret.cost;
		}

		if (x != 1) {
			// 현재위치가 1이 아니라면 택배를 내리고 다시 실어야하는데
			// 현재 위치에서 갈수 있는 길들중에 가장 많은 택배를 싣고 가야하는곳을 제외한 곳을 내리고 다시 싣기.
			sum += (total - max) * 2;

			// 현재 위치의 택배 내리는 비용 포함.
			sum += A[x];
			total += A[x];
		} else {// 현재위치가 1이라면 택배차에 싣는 비용만 포함
			sum += total;
		}

		return new Answer(total, sum);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		A = new long[n + 1];
		canGo = new LinkedList[n + 1];
		v = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			canGo[i] = new LinkedList<>();
		}

		int a, b;

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			canGo[a].add(b);
			canGo[b].add(a);
		}

		Answer answer = getMinMove(1);

		System.out.println(answer.cost);
	}
}