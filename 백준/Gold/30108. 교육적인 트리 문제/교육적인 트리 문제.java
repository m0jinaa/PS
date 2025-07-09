import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		LinkedList<Integer>[] hasChildren = new LinkedList[n + 1];

		for (int i = 1; i <= n; i++) {
			hasChildren[i] = new LinkedList<>();
		}

		st = new StringTokenizer(br.readLine(), " ");

		int p;

		for (int i = 2; i <= n; i++) {
			p = Integer.parseInt(st.nextToken());
			hasChildren[p].add(i);
		}

		int[] A = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer x, Integer y) {
				return A[y] - A[x];
			}
		});

		q.add(1);

		long answer = 0;

		int x;

		while (!q.isEmpty()) {
			x = q.poll();

			answer += A[x];
			sb.append(answer).append("\n");

			for (int y : hasChildren[x]) {
				q.add(y);
			}
		}

		System.out.print(sb.toString());
	}
}