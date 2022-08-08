import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] tree;
	static int[][] width;
	static int num;
	
	static void dfs(int now,int h) {
		if(tree[now][0]!=-1)
			dfs(tree[now][0],h+1);
		if(width[h][0] == 0)
			width[h][0] = num;
		width[h][1] = num++;
		if(tree[now][1]!=-1)
			dfs(tree[now][1],h+1);
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		tree = new int[n+1][2];
		StringTokenizer st;
		int now = 0;
		int left = 0;
		int right = 0;
		int root = n*(n+1)/2;
		boolean[] sub = new boolean[n+1];
		for(int i = 1;i<=n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			now = Integer.parseInt(st.nextToken());
			left = Integer.parseInt(st.nextToken());
			right = Integer.parseInt(st.nextToken());
			tree[now][0] = left;
			tree[now][1] = right;
			if(left!=-1 && !sub[left])
				root-=left;
			if(right!=-1 && !sub[right])
				root-=right;
			
		}
		width = new int[n][2];
		
		num = 1;
		dfs(root,0);
		int level = 0;
		int max = 0;
		for(int i = 0;i<width.length;i++) {
			int val = width[i][1]-width[i][0]+1;
			if (val>max) {
				max = val;
				level = i+1;
			}
		}	
		System.out.println(level+" "+max);
		
	}
}
