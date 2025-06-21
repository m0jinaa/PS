import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 트리를 유한하게 만들려면 최소 q에 들어있는 노드의 개수의 2배만큼 V에 원소가 남아있어야 함을 활용

		int n = Integer.parseInt(br.readLine());

		LinkedList<Long> q = new LinkedList<>();

		Set<Long> V = new HashSet<>();

		// V에 남아있는 노드 개수
		int block = n;

		long max = -1;
		st = new StringTokenizer(br.readLine(), " ");

		while (n-- > 0) {
			max = Long.parseLong(st.nextToken());

			V.add(max);
		}

		long answer = 0;
		boolean infinite = false;

		if (!V.contains(1L)) {

			long x, nx;

			answer++;
			q.add(1L);

			end: while (!q.isEmpty()) {
				// 최소 개수가 보장되는지 확인
				if (q.size() * 2 > block) {
					infinite = true;
					break;
				}
				x = q.poll();

				for (int i = 0; i < 2; i++) {
					nx = 2 * x + i;

					if (V.contains(nx)) {
						block--;
						continue;
					} else if (nx > max) {
						infinite = true;
						break end;
					}

					answer++;
					q.add(nx);
				}
			}
		}

		System.out.println(infinite ? -1 : answer);
	}
}