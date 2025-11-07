import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static Map<String, Integer> strength;

	static void init() {
		strength = new HashMap<>();

		strength.put("Shadow", 6);
		strength.put("Gale", 5);
		strength.put("Ranger", 4);
		strength.put("Anvil", 7);
		strength.put("Vexia", 3);
		strength.put("Guardian", 8);
		strength.put("Thunderheart", 6);
		strength.put("Frostwhisper", 2);
		strength.put("Voidclaw", 3);
		strength.put("Ironwood", 3);
		strength.put("Zenith", 4);
		strength.put("Seraphina", 1);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final String THUNDERHEART = "Thunderheart";
		final String ZENITH = "Zenith";
		final String SERAPHINA = "Seraphina";

		init();

		int round = 3;
		int win1 = 0;
		int win2 = 0;
		int total1 = 0;
		int total2 = 0;
		int str1, str2, extra1, extra2, str;
		int n;
		String card;

		for (int i = 1; i <= round; i++) {
			str1 = 0;
			str2 = 0;
			extra1 = 0;
			extra2 = 0;

			// 1번 플레이어 점수 확인

			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());

			// 각 카드에 맞는 strength 더해주기
			for (int j = 0; j < n; j++) {
				card = st.nextToken();
				str = strength.get(card);

				str1 += str;

				// 버프 있는 카드 체크

				if (n == 4 && THUNDERHEART.equals(card)) {
					extra1 += str;
				} else if (i == 2 && ZENITH.equals(card)) {
					extra1 += 5;
				} else if (SERAPHINA.equals(card)) {
					extra1 += n - 1;
				}
			}

			// 2번 플레이어 점수 확인

			st = new StringTokenizer(br.readLine(), " ");

			n = Integer.parseInt(st.nextToken());

			// 각 카드에 맞는 strength 더해주기

			for (int j = 0; j < n; j++) {
				card = st.nextToken();
				str = strength.get(card);

				str2 += str;

				// 버프 있는 카드 체크

				if (n == 4 && THUNDERHEART.equals(card)) {
					extra2 += str;
				} else if (i == 2 && ZENITH.equals(card)) {
					extra2 += 5;
				} else if (SERAPHINA.equals(card)) {
					extra2 += n - 1;
				}
			}

			// 점수 비교 후 누가 이겼는지 체크

			if (str1 + extra1 > str2 + extra2) {
				win1++;
			} else if (str1 + extra1 < str2 + extra2) {
				win2++;
			}

			// 비겼을 때를 대비해서 전체 점수 더하기

			total1 += (str1 + extra1);
			total2 += (str2 + extra2);
		}

		// 이긴 라운드 개수 비교, tie시 전체 점수 비교

		if (win1 > win2) {
			sb.append("Player 1\n");
		} else if (win1 < win2) {
			sb.append("Player 2\n");
		} else if (total1 > total2) {
			sb.append("Player 1\n");
		} else if (total1 < total2) {
			sb.append("Player 2\n");
		} else {
			sb.append("Tie\n");
		}

		System.out.println(sb.toString());
	}
}