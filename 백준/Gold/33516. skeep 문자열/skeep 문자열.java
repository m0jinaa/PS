import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> ind = new Stack<>();

		char[] S = br.readLine().toCharArray();
		char[] SKEEP = "skeep".toCharArray();

		int now = 0;
		int answer = 0;

		for (char c : S) {
			if (SKEEP[now] == c) {
				now++;
			} else if (c == 's') {
				// skeep 새로 시작할 가능성이 있기 때문에 ind 저장
				ind.add(now);
				now = 1;
			} else {
				// 새로시작 아님
				ind.clear();
				now = 0;
			}

			while (now == 5) {
				answer++;
				if (ind.isEmpty()) {
					now = 0;
					break;
				}
				now = ind.pop() + 1;
			}
		}

		System.out.println(answer);
	}
}