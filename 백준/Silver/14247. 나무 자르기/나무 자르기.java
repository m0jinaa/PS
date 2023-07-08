import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Tree implements Comparable<Tree> {
		int h, a;

		@Override
		public int compareTo(Tree tree) {
			return this.a - tree.a;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Tree[] trees = new Tree[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			trees[i] = new Tree();

			trees[i].h = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			trees[i].a = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(trees);

		long answer = 0;

		for (int i = 0; i < n; i++) {
			answer += trees[i].h + trees[i].a * i;
		}

		System.out.println(answer);
	}
}