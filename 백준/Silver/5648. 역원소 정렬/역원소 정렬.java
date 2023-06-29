import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static String reverse(String x) {
		char[] xarr = x.toCharArray();

		int i = 0;
		int j = xarr.length - 1;
		char c;
		while (i < j) {
			c = xarr[i];
			xarr[i] = xarr[j];
			xarr[j] = c;
			i++;
			j--;
		}

		return String.valueOf(xarr);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());

		long[] nums = new long[n];
		int i = 0;
		String rev;
		while (i < n) {
			while (st.hasMoreTokens()) {
				rev = reverse(st.nextToken());
				nums[i++] = Long.parseLong(rev);
			}

			if (i < n)
				st = new StringTokenizer(br.readLine(), " ");

		}

		Arrays.sort(nums);

		StringBuilder sb = new StringBuilder();

		for (long num : nums) {
			sb.append(num).append("\n");
		}

		System.out.print(sb.toString());
	}
}