import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

public class Main {
	static StringBuilder sbl;
	static char[] arr;
	static TreeSet<String> set;
	static ArrayList<Pair> pairs;
	static int n, m, c;
	static boolean[] check;

	static class Pair {
		int l, r;

		public Pair(int l, int r) {
			super();
			this.l = l;
			this.r = r;
		}

		@Override
		public String toString() {
			return "Pair [l=" + l + ", r=" + r + "]";
		}
	}

	static void combi(int ind) {
		if (ind == n) {
			if (c != 0) {
				
				for (int i = 0; i < m; i++) {
					if (check[i])
						continue;
					sbl.append(arr[i]);
				}
				set.add(sbl.toString());
				sbl.setLength(0);
			}
		} else {
			combi(ind + 1);

			check[pairs.get(ind).l] = true;
			check[pairs.get(ind).r] = true;
			c++;
			combi(ind + 1);
			c--;
			check[pairs.get(ind).l] = false;
			check[pairs.get(ind).r] = false;

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sbl = new StringBuilder();
		
		arr = br.readLine().toCharArray();

		pairs = new ArrayList<>();
		set = new TreeSet<>();
		
		Stack<Integer> stack = new Stack<>();

		m = arr.length;

		for (int i = 0; i < m; i++) {
			if (arr[i] == '(') {
				stack.add(i);
			} else if (arr[i] == ')') {
				pairs.add(new Pair(stack.pop(), i));
			}
		}

		n = pairs.size();

		check = new boolean[m];
		
		c = 0;
		combi(0);
		
		for(String s : set) {
			sb.append(s).append("\n");
		}
		System.out.println(sb.toString());
	}
}