import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[] v;
	static ArrayList<Integer>[] connectedTo;

	static int getMinTime(int x) {

		int need = 1;

		int cnt = 0;

		for (int y : connectedTo[x]) {
			if (v[y])
				continue;
			v[y] = true;
			need++;

			cnt += (getMinTime(y) + 1);
		}
        
        // 현재 머무르는 헛간과 연결된 처음가는 헛간에 바이러스를 확산시키기 충분한 소의 수를 만들기 위한 시간
		cnt += (int) Math.ceil(Math.log(need) / Math.log(2));

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		connectedTo = new ArrayList[n + 1];
		v = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			connectedTo[i] = new ArrayList<>();
		}

		int a, b;

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			connectedTo[a].add(b);
			connectedTo[b].add(a);
		}

		v[1] = true;

		int answer = getMinTime(1);

		System.out.println(answer);
	}
}