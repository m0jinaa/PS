import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[] win;
	static int[] count;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		char[] input = br.readLine().toCharArray();

		win = new int[26];
		count = new int[26];

		int cnt = 0;

		for (char c : input) {
			if (c >= 97 && c <= 122) {
				cnt++;
			}
		}
		int a, v;
		while (cnt-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = st.nextToken().charAt(0) - 'a';
			v = Integer.parseInt(st.nextToken());

			win[a] = v;
		}

		int x, y;

		Stack<Integer> stack = new Stack<>();

		boolean correct = true;
		for (char c : input) {

			if (c == ']') {
				y = stack.pop();
				x = stack.pop();
				if (win[x] > count[x] && win[y] == count[y]) {
					stack.add(x);
					count[x]++;
				}

				else if (win[y] > count[y] && win[x] == count[x]) {
					stack.add(y);
					count[y]++;
				} else {
					correct = false;
					break;
				}

			} else if (c >= 'a' && c <= 'z') {

				stack.add(c - 'a');
			}
		}

		for (int i = 0; i < 26; i++) {
			if (count[i] != win[i]) {
				correct = false;
				break;
			}
		}

		if (correct)
			sb.append("Yes\n");
		else
			sb.append("No\n");

		System.out.print(sb.toString());
	}
}