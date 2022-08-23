import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,l;
	static int[] root;
	static boolean[] filled;
	static int find(int x) {
		if(root[x]!=x)
			root[x] = find(root[x]);
		return root[x];
	}
	static void union(int a, int b) {
		root[find(a)] = find(b);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		filled = new boolean[l+1];
		root = new int[l+1];
		for(int i = 0;i<=l;i++) {
			root[i] = i;
		}
		int a,b;
		String answer;
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			answer = "LADICA";
			if(!filled[a]) {//a에 넣을 수 있는지 확인
				filled[a] = true;
				union(a,b);
			}
			else if(!filled[b]) {
				filled[b] = true;
				union(b,a);
			}
			else if(!filled[find(a)]) {
				filled[find(a)] = true;
				union(a,b);
			}
			else if(!filled[find(b)]) {
				filled[find(b)] = true;
				union(b,a);
			}
			else {
				answer = "SMECE";
			}
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}
}