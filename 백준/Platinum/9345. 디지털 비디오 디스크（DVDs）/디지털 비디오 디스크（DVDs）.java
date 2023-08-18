import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int[] video;
	static int[] minTree;
	static int[] maxTree;
	static final int MAX = Integer.MAX_VALUE;
	static final int MIN = Integer.MIN_VALUE;
	static int initMin(int s, int e, int k) {
		if(s==e) {
			return minTree[k] = s;
		}
		else {
			int m = (s+e)/2;
			return minTree[k] = Math.min(initMin(s,m,2*k), initMin(m+1,e,2*k+1));
		}
	}
	
	static int initMax(int s, int e, int k) {
		if(s==e) {
			return maxTree[k] = s;
		}
		else {
			int m = (s+e)/2;
			return maxTree[k] = Math.max(initMax(s,m,2*k), initMax(m+1,e,2*k+1));
		}
	}
	
	static int getMin(int l, int r, int s, int e, int k) {
		if(r<s || e<l)
			return MAX;
		else if(s<=l && r<=e) {
			return minTree[k];
		}
		else {
			int m = (l+r)/2;
			return Math.min(getMin(l,m,s,e,2*k), getMin(m+1,r,s,e,2*k+1));
		}
	}
	static int getMax(int l, int r, int s, int e, int k) {
		if(r<s || e<l)
			return MIN;
		else if(s<=l && r<=e) {
			return maxTree[k];
		}
		else {
			int m = (l+r)/2;
			return Math.max(getMax(l,m,s,e,2*k), getMax(m+1,r,s,e,2*k+1));
		}
	}
	
	static int updateMin(int l, int r, int ind, int v, int k) {
		if(l<=ind&& ind<=r) {
			if(l==r) {
				return minTree[k] = v;
			}
			else {
				int m = (l+r)/2;
				return minTree[k] = Math.min(updateMin(l,m,ind,v,2*k), updateMin(m+1,r,ind,v,2*k+1));
			}
		}
		else {
			return minTree[k];
		}
	}
	static int updateMax(int l, int r, int ind, int v, int k) {
		if(l<=ind&& ind<=r) {
			if(l==r) {
				return maxTree[k] = v;
			}
			else {
				int m = (l+r)/2;
				return maxTree[k] = Math.max(updateMax(l,m,ind,v,2*k), updateMax(m+1,r,ind,v,2*k+1));
			}
		}
		else {
			return maxTree[k];
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n,k,N;
		int q,a,b,temp;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0;t<tc;t++) {
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			video = new int[n];
			for(int i = 0;i<n;i++) {
				video[i] = i;
			}
			
			N = 1<<((int)Math.ceil(Math.log10(n)/Math.log10(2))+1);
			
			minTree = new int[N];
			maxTree = new int[N];
			
			initMin(0,n-1,1);
			initMax(0,n-1,1);
			
			for(int i = 0;i<k;i++) {
				st = new StringTokenizer(br.readLine()," ");
				q = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				switch(q) {
				case 0:
					updateMin(0,n-1,a,video[b],1);
					updateMin(0,n-1,b,video[a],1);
					updateMax(0,n-1,a,video[b],1);
					updateMax(0,n-1,b,video[a],1);
					temp = video[a];
					video[a] =video[b];
					video[b] = temp;
					break;
				case 1:
					if(getMax(0,n-1,a,b,1) == b && getMin(0,n-1,a,b,1)== a)
						sb.append("YES").append("\n");
					else
						sb.append("NO").append("\n");
				}
			}		
		}
		System.out.println(sb.toString());
	}
}