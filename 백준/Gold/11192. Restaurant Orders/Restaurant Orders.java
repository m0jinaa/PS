import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		final int MAX = 30000;

		// combi[x] => x로 만들기 전에 넣은 음식의 번호
		int[] combi = new int[MAX + 1];

		Arrays.fill(combi, -2);

		combi[0] = 0;

		int n = Integer.parseInt(br.readLine());

		int[] food = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			food[i] = Integer.parseInt(st.nextToken());
		}

		// 만들 수 있는 조합 찾기
		// combi[x] == -1 => 여러가지 방법 존재
		// combi[x] == -2 => 만드는 방법 없음
		// combi[x] == v => x로 만들기 위해 마지막으로 넣은 음식의 번호가 x임
		// 음식의 번호는 1번부터 시작
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j + food[i] <= MAX; j++) {
				// j로 만드는 경우가 없으면 패스
				if (combi[j] == -2)
					continue;

				// 만드는 방법이 여러가지 있을 때
				if (combi[j] == -1 || combi[j + food[i]] != -2) {
					combi[j + food[i]] = -1;
				} else {
					combi[j + food[i]] = i;
				}
			}
		}

		// 음식 종류 출력을 위한 스택
		// 순서를 거꾸로 살펴보기 때문에 사용
		Stack<Integer> stack = new Stack<>();

		int m = Integer.parseInt(br.readLine());

		int x;

		st = new StringTokenizer(br.readLine(), " ");

		while (m-- > 0) {
			x = Integer.parseInt(st.nextToken());
			if (combi[x] == -2)
				sb.append("Impossible\n");
			else if (combi[x] == -1) {
				sb.append("Ambiguous\n");
			} else {
				// 방법이 한가지 뿐이면 한 메뉴씩 살펴보기
				stack.clear();

				while (x > 0) {
					stack.add(combi[x]);
					x -= food[combi[x]];
				}

				while (!stack.isEmpty()) {
					sb.append(stack.pop()).append(stack.isEmpty() ? "\n" : " ");
				}
			}
		}

		System.out.print(sb.toString());
	}
}