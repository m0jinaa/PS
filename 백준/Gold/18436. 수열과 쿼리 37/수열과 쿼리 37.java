import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static int[] oddTree;
	static int[] evenTree;	
	static int[] nums;
	
	static int makeOddTree(int s, int e, int k) {
		if(s==e) {
			return oddTree[k] = nums[s]%2==0?0:1;
		}
		else {
			int mid = (s+e)/2;
			return oddTree[k] = makeOddTree(s,mid,2*k)+makeOddTree(mid+1,e,2*k+1);
		}
	}
	static int makeEvenTree(int s, int e, int k) {
		if(s==e) {
			return evenTree[k] = nums[s]%2==0?1:0;
		}
		else {
			int mid = (s+e)/2;
			return evenTree[k] = makeEvenTree(s,mid,2*k)+makeEvenTree(mid+1,e,2*k+1);
		}
	}
	
	static void updateOdd(int l, int r, int ind, int v, int k) {
		if(l<=ind && ind<=r) {
			if(l==r) {
				oddTree[k] = v%2==0?0:1;
			}
			if(l!=r) {
				int mid = (l+r)/2;
				updateOdd(l,mid,ind,v,2*k);
				updateOdd(mid+1,r,ind,v,2*k+1);				
				oddTree[k] = oddTree[2*k]+oddTree[2*k+1];
			}
		}
	}
	static void updateEven(int l, int r, int ind, int v, int k) {
		if(l<=ind && ind<=r) {
			if(l==r) {
				evenTree[k] = v%2==0?1:0;
			}
			if(l!=r) {
				int mid = (l+r)/2;
				updateEven(l,mid,ind,v,2*k);
				updateEven(mid+1,r,ind,v,2*k+1);				
				evenTree[k] = evenTree[2*k]+evenTree[2*k+1];
			}
		}
	}
	
	static int getOdd(int l, int r, int s, int e, int k) {
		if(r<s || e<l) {
			return 0;
		}
		else if(s<=l && r<=e) {
			return oddTree[k];
		}
		else {
			int mid = (l+r)/2;
			return getOdd(l,mid,s,e,2*k)+getOdd(mid+1,r,s,e,2*k+1);
		}
	}
	static int getEven(int l, int r, int s, int e, int k) {
		if(r<s || e<l) {
			return 0;
		}
		else if(s<=l && r<=e) {
			return evenTree[k];
		}
		else {
			int mid = (l+r)/2;
			return getEven(l,mid,s,e,2*k)+getEven(mid+1,r,s,e,2*k+1);
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");
		
		nums = new int[n];
		oddTree = new int[4*n];
		evenTree = new int[4*n];
		
		for(int i = 0;i<n;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		makeOddTree(0,n-1,1);
		makeEvenTree(0,n-1,1);
		
		int m = Integer.parseInt(br.readLine());
		int a,b,c;
		for(int i = 0;i<m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken())-1;
			switch(a) {
			case 1:
				c = Integer.parseInt(st.nextToken());
				updateOdd(0,n-1,b,c,1);
				updateEven(0,n-1,b,c,1);
				nums[b] = c;
				break;
			case 2:
				c = Integer.parseInt(st.nextToken())-1;
				sb.append(getEven(0,n-1,b,c,1)).append("\n");
				break;
			case 3:
				c = Integer.parseInt(st.nextToken())-1;
				sb.append(getOdd(0,n-1,b,c,1)).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}
}