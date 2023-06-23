import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static String[] numbers = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine" };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();

		for (int i = m; i <= n; i++) {
			list.add(i);
		}

		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				String as = (a / 10 != 0 ? numbers[a / 10] : "") + numbers[a % 10];
				String bs = (b / 10 != 0 ? numbers[b / 10] : "") + numbers[b % 10];

				return as.compareTo(bs);

			}

		});
		int ind = 1;
		for (int x : list) {
			sb.append(x).append(ind % 10 == 0 ? "\n" : " ");
			ind++;
		}

		System.out.println(sb.toString());
	}
}