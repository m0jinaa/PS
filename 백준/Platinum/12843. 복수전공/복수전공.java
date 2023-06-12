import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] matched;
	static boolean[] used;
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
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[] departments = new boolean[n + 1];
		used = new boolean[n + 1];
		matched = new int[n + 1];
		canMatch = new ArrayList[n + 1];
		
		int lecture;
		char department;
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			lecture = Integer.parseInt(st.nextToken());
			department = st.nextToken().charAt(0);

			departments[lecture] = department == 'c';
			
			canMatch[i] = new ArrayList<>();
		}

		int answer = n;
		int a, b;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			canMatch[a].add(b);
			canMatch[b].add(a);

		}
		
		for(int i = 1;i<=n;i++) {
			if(!departments[i])
				continue;
			Arrays.fill(used, false);
			if(match(i)) {
				answer--;
			}
		}
		
		System.out.println(answer);
    }
}