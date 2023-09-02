import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long[] salary;
	static int[] tree;
	static int makeTree(int s, int e, int k) {
		if(s==e) {
			return tree[k] = s;
		}
		else {
			int m = (s+e)/2;
			int a = makeTree(s,m,2*k);
			int b = makeTree(m+1,e,2*k+1);
			return tree[k] = salary[a]<salary[b]?a:b;
		}
	}
	
	static int getMin(int l, int r, int s, int e, int k) {
		if(r<s || e<l)
			return -1;
		else if(s<=l && r<=e)
			return tree[k];
		else {
			int m = (l+r)/2;
			int a = getMin(l,m,s,e,2*k);
			int b = getMin(m+1,r,s,e,2*k+1);
			if(a==-1)
				return b;
			else if(b==-1)
				return a;
			else
				return salary[a]<salary[b]?a:b;
		}
	}
	
	static long getMaxSalary(int s, int e) {
		if(s==e) {
			return salary[s];
		}
		else {
			int ind = getMin(0,n-1,s,e,1);
			long answer = salary[ind]*(e-s+1);
			if(s<=ind-1) {
				answer = Math.max(answer,getMaxSalary(s,ind-1));
			}
			if(ind+1<=e) {
				answer = Math.max(answer, getMaxSalary(ind+1,e));
			}
			return answer;
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		salary = new long[n];
		tree = new int[4*n];
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 0;i<n;i++) {
			salary[i] = Long.parseLong(st.nextToken());
		}
		
		makeTree(0,n-1,1);
		
		System.out.println(getMaxSalary(0,n-1));
		
	}

}