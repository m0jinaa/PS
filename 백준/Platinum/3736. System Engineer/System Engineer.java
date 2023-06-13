import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static boolean[] used;
	static int[] matched;
	static ArrayList<Integer>[] canMatch;

	static boolean match(int x) {
		for (int y : canMatch[x]) {
			if (used[y])
				continue;
			used[y] = true;
			if (matched[y] == 0 || match(matched[y])) {
				matched[y] = x;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
        
		String input;
		int n, ind, c, x, answer;
        
		while ((input = br.readLine()) != null && !input.isEmpty()) {
			n = Integer.parseInt(input);
			
			canMatch = new ArrayList[n + 1];

			used = new boolean[n + 1];
			matched = new int[n + 1];
			
			for (int i = 1; i <= n; i++) {
				canMatch[i] = new ArrayList<>();
			}

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine(), " :()");
				
				ind = Integer.parseInt(st.nextToken())+1;
				c = Integer.parseInt(st.nextToken());

				while (c-- > 0) {
					x = Integer.parseInt(st.nextToken()) - (n - 1);
					canMatch[ind].add(x);
				}
			}

			answer = 0;

			for (int i = 1; i <= n; i++) {
				Arrays.fill(used, false);
				if (match(i)) {
					answer++;
				}
			}
			
			sb.append(answer).append("\n");
		}
        
		System.out.println(sb.toString());
	}
}