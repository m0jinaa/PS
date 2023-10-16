import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] tree;
	static int n;

	static void update(int x) {
		while (x <= n) {
			tree[x]++;
			x += (x & (-x));
		}
	}

	static int get(int x) {
		int ret = 0;

		while (x > 0) {
			ret += tree[x];
			x -= (x & (-x));
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");

		tree = new int[n + 1];

		int[] input = new int[n];

		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		int j = n - 1;

		// 이미 정렬되어있어 움직이지 않아도 되는 경우 제외하기
		while (j > 0 && input[j - 1] < input[j])
			j--;

		sb.append(j).append("\n");

		for (int i = j; i < n; i++) {
			update(input[i]);
		}

		int x;
		for (int i = 0; i < j; i++) {
			x = j - 1 - i + get(input[i]);
			sb.append(x).append(i == j - 1 ? "\n" : " ");
			update(input[i]);
		}

		System.out.print(sb.toString());

	}
}