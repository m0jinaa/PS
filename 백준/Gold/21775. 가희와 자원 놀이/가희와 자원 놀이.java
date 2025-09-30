import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int[] turns = new int[t];
		int[] hold = new int[n + 1];
		int[] pileOrder = new int[t];
		Map<Integer, Integer> card = new HashMap<>();
		// 공용공간에 있는지 체크
		Map<Integer, Boolean> storage = new HashMap<>();

		int ind = 0;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < t; i++) {
			turns[i] = Integer.parseInt(st.nextToken());
		}

		int id;
		String type;
		int x, c;

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			id = Integer.parseInt(st.nextToken());
			type = st.nextToken();

			pileOrder[i] = id;

			if ("next".equals(type)) {
				card.put(id, 0);
			} else {
				x = Integer.parseInt(st.nextToken());
				if ("acquire".equals(type)) {
					card.put(id, x);
				} else {
					card.put(id, -x);
				}
			}
		}

		for (int turn : turns) {
			// 들고있는 카드가 없다면 더미에서 가져오기
			if (hold[turn] == 0) {
				hold[turn] = pileOrder[ind++];
			}

			sb.append(hold[turn]).append("\n");

			c = card.get(hold[turn]);

			if (c == 0) { // next
				hold[turn] = 0;
				continue;
			} else if (c < 0) { // release
				storage.put(-c, true);
				hold[turn] = 0;
			} else if (!storage.containsKey(c) || storage.get(c)) { // 공용공간에 숫자카드가 존재할 때
				storage.put(c, false);
				hold[turn] = 0;
			}

			// 존재하지않는다면 계속 들고있는다
		}

		System.out.println(sb.toString());
	}
}