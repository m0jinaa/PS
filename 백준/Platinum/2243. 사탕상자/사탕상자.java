import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[] tree;
	static int[] candy;
	
	static void putCandy(int l, int r, int ind, int amount, int k) {
		if(l<=ind && ind<=r) {
			if(l==r) {
				tree[k]+=amount;
				candy[ind]+=amount;
			}
			else {
				int m = (l+r)/2;
				putCandy(l,m,ind,amount,2*k);
				putCandy(m+1,r,ind,amount,2*k+1);
				tree[k] = tree[2*k]+tree[2*k+1];
			}
		}
	}
	static int getCandy(int l, int r, int rank, int k) {
		int ans;
		if(l==r) {
			tree[k]-=1;
			return l;
		}
		else {
			int m = (l+r)/2;
			if(tree[2*k]<rank) {
				ans = getCandy(m+1,r,rank-tree[2*k],2*k+1);
				tree[k]-=1;
				return ans; 
			}
			else {
				ans = getCandy(l,m,rank,2*k);
				tree[k]-=1;
				return ans;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int degree = 1000000;
		candy = new int[degree];
		tree  = new int[4*degree];
		int a,b,c;
		int ind;
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			switch(a) {
			case 1:
				b = Integer.parseInt(st.nextToken());
				ind = getCandy(0, degree-1, b, 1);
				sb.append(ind+1).append("\n");
				break;
			case 2:
				b = Integer.parseInt(st.nextToken())-1;
				c = Integer.parseInt(st.nextToken());
				putCandy(0, degree-1, b, c, 1);
			}
		}		
		System.out.println(sb.toString());
	}
}