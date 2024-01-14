import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] nums = new int[k];
		String x;

		LinkedList<String> use = new LinkedList<>();
		for (int i = 0; i < k; i++) {
			x = br.readLine();
			nums[i] = Integer.parseInt(x);
			use.add(x);
		}

		Arrays.sort(nums);

		for (int i = k; i < n; i++) {
			use.add("" + nums[k - 1]);
		}

		Collections.sort(use, new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				String t1 = a + b;
				String t2 = b + a;

				return t2.compareTo(t1);
			}

		});

		for (String s : use) {
			sb.append(s);
		}

		System.out.println(sb.toString());
	}
}