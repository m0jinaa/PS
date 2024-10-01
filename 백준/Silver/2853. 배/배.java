import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Set<Integer> set = new HashSet<>();

		int start = Integer.parseInt(br.readLine());

		int now;
		boolean exist;

		while (--n > 0) {
			now = Integer.parseInt(br.readLine());
			exist = false;

			for (int s : set) {
				if ((now - start) % s != 0)
					continue;
				exist = true;
				break;
			}

			if (!exist)
				set.add(now - start);
		}

		int answer = set.size();

		System.out.println(answer);
	}
}