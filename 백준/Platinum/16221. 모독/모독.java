import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int base;
	static int[] cntTree, andTree;
	
	static void update(int l, int r, int ind, int v, int k) {
		ind+=base;
		cntTree[ind]+=v;
		if(cntTree[ind]==0) {
			andTree[ind] = 0;
		}
		else
			andTree[ind] = 2;
		ind/=2;
		while(ind>0) {
			if(andTree[2*ind]==2) {
				if(andTree[2*ind+1]==2) {
					andTree[ind] = 2;
					cntTree[ind] = cntTree[2*ind]+cntTree[2*ind+1];
				}
				else if(andTree[2*ind+1]==1) {
					andTree[ind] = 1;
					cntTree[ind] = cntTree[2*ind]+cntTree[2*ind+1];
				}
				else {
					andTree[ind] = 1;
					cntTree[ind] = cntTree[2*ind];
				}
			}
			else if(andTree[2*ind]==1) {
				andTree[ind] = 1;
				cntTree[ind] = cntTree[2*ind];
			}
			else {
				andTree[ind] = 0;
				cntTree[ind] = 0;
			}
			ind/=2;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = 1000000;
		
		base = (int)Math.pow(2, Math.ceil(Math.log10(n)/Math.log10(2)));
		
		int N = base<<1;
		base-=1;
		
		int q = Integer.parseInt(br.readLine());
		
		cntTree = new int[N];
		andTree = new int[N];
		
		int t,k;
		
		for(int i = 0;i<q;i++) {
			st = new StringTokenizer(br.readLine()," ");
			t = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			if(t==1) {
				update(1,n,k,1,1);
			}
			else
				update(1,n,k,-1,1);
			
			sb.append(cntTree[1]).append("\n");

		}
		
		System.out.println(sb.toString());
		
	}

}
