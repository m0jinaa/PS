import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class Num implements Comparable<Num> {
		int x, ind;

		public Num(int x, int ind) {
			super();
			this.x = x;
			this.ind = ind;
		}

		@Override
		public int compareTo(Num num) {
			if (this.x != num.x) {
				return num.x - this.x;
			} else {
				return this.ind - num.ind;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Num[] nums = new Num[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			nums[i] = new Num(Integer.parseInt(st.nextToken()), i);
		}

		Arrays.sort(nums);

		Num[] selected = new Num[k];
		System.arraycopy(nums, 0, selected, 0, k);

		Arrays.sort(selected, new Comparator<Num>() {

			@Override
			public int compare(Num n1, Num n2) {
				return n1.ind - n2.ind;
			}
		});

		long answer = 0;

		for (int i = 0; i < k; i++) {
			answer += selected[i].x - i;
		}

		System.out.println(answer);
	}
}