import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static class Pair implements Comparable<Pair> {
		int x, y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pair p) {
			if (this.x != p.x) {
				return this.x - p.x;
			} else {
				return this.y - p.y;
			}
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		TreeSet<Pair> set = new TreeSet<>();

		int ind = 0;

		int[] nums = new int[10];

		while (st.hasMoreTokens()) {
			nums[ind++] = Integer.parseInt(st.nextToken());
		}

		int k = Integer.parseInt(br.readLine());

		Arrays.sort(nums, 0, ind);
		int cnt = 0;

		for (int i = 0; i < ind; i++) {
			for (int j = i + 1; j < ind; j++) {
				if (nums[i] + nums[j] == k) {
					if (set.add(new Pair(nums[i], nums[j]))) {
						cnt++;
					}
				}
			}
		}

		for (Pair p : set) {
			sb.append(p.x).append(" ").append(p.y).append("\n");
		}

		sb.append(cnt);

		System.out.println(sb.toString());
	}
}