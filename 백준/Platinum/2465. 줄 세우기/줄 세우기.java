import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int[] tree;
	static int now;
	static int[] people;
	static int[] order;
	
	static int initTree(int s, int e, int k) {
		if(s==e) {
			return tree[k] = 1;
		}
		else {
			int m = (s+e)/2;
			return tree[k] = initTree(s,m,2*k)+initTree(m+1,e,2*k+1);
		}
	}
	
	static void getInd(int s, int e, int cnt, int k) {
		if(s==e) {
			tree[k] = 0;
			order[now] = people[s];
		}
		else {
			tree[k]-=1;
			int m = (s+e)/2;
			if(tree[2*k]<cnt) {
				getInd(m+1,e,cnt-tree[2*k],2*k+1);
			}
			else {
				getInd(s,m,cnt,2*k);
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		people = new int[n];
		int N = 1<<((int)Math.ceil(Math.log10(n)/Math.log10(2))+1);
		tree = new int[N];
		order = new int[n];
		
		initTree(0,n-1,1);
		
		for(int i = 0;i<n;i++) {
			people[i] = Integer.parseInt(br.readLine());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		
		int[] cnt = new int[n];
		for(int i = 0;i<n;i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(people);
		
		for(now = n-1;now>=0;now--) {
			getInd(0,n-1,cnt[now]+1,1);
		}
		
		for(int i = 0;i<n;i++) {
			sb.append(order[i]).append("\n");
		}
		System.out.print(sb.toString());
	}
}
