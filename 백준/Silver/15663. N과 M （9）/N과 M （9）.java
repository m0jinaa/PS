import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static Set<String> set;
	static int[] nums;
	static int n, m;
	static boolean[] used;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	static void combi(int x) {
		if (x == m) {
			String s = "";
			for (int i : selected) {
				s += i;
				s += " ";
			}
			if(!set.contains(s)) {
				set.add(s);
				sb.append(s).append("\n");
			}
			
			return;
		} else {
			for (int i = 0; i < n; i++) {
				if (used[i])
					continue;
				selected[x] = nums[i];
				used[i] = true;
				combi(x + 1);
				used[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		set = new TreeSet<String>();
		nums = new int[n];
		selected = new int[m];
		used = new boolean[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		combi(0);

		System.out.println(sb.toString());
	}

}
