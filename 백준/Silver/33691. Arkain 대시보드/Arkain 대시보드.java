import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 고정인 컨테이너 먼저 역순 출력 후
		// 로그를 거꾸로 살펴보면서 이미 출력된거면 패스, 아니면 출력

		int n = Integer.parseInt(br.readLine());

		LinkedList<String> containers = new LinkedList<>();

		Map<String, Integer> lastUsed = new HashMap<>();
		Set<String> pinned = new HashSet<>();

		String name;

		for (int i = 0; i < n; i++) {
			name = br.readLine();

			if (!lastUsed.containsKey(name)) {
				containers.add(name);
			}

			lastUsed.put(name, i);
		}

		int k = Integer.parseInt(br.readLine());

		while (k-- > 0) {
			name = br.readLine();

			pinned.add(name);
		}

		Collections.sort(containers, new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				// 두 컨테이너의 고정여부가 다르다면
				// 고정된게 앞
				// 고정여부 같을 때는 나중에 사용된게 앞

				if (pinned.contains(a) ^ pinned.contains(b)) {
					return pinned.contains(a) ? -1 : 1;
				} else {
					return lastUsed.get(b) - lastUsed.get(a);
				}
			}
		});

		for (String c : containers) {
			sb.append(c).append("\n");
		}

		System.out.print(sb.toString());
	}
}