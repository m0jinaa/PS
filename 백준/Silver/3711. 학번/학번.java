import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		int n, m;
		int[] nums;
		Set<Integer> set = new HashSet<>();

		while (tc-- > 0) {
			n = Integer.parseInt(br.readLine());
			nums = new int[n];

			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(br.readLine());
			}

			m = 1;

			while (true) {
				set.clear();
				for (int x : nums) {
					if (set.contains(x % m))
						break;
					set.add(x % m);
				}

				if (set.size() == n) {
					sb.append(m).append("\n");
					break;
				} else
					m++;
			}
		}

		System.out.print(sb.toString());
	}
}