import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[] apple;
	static int[] depth;
	static int[] start, end;
	static int[][] parent;
	static int n, k, ind = 1;

	static void dfs(int x, int d) {
		Stack<Integer> stack = new Stack<Integer>();
		int now;
		while (x <= 2 * n) {
			if(apple[x]==0) {
				start[ind] = x;
				depth[ind] = stack.size()+1;
				if(stack.size()!=0)
					parent[ind][0] = stack.peek();
				stack.add(ind++);
			}
			else {
				now = stack.pop();
				end[now] = x;
			}
			x++;
		}
	}
	
	static void setParent() {
		for(int i = 0;i<k;i++) {
			for(int j = 1;j<=n;j++) {
				if(parent[j][i]!=0 && parent[parent[j][i]][i]!=0) {
					parent[j][i+1] = parent[parent[j][i]][i];
				}
			}
		}
	}
	
	static int lca(int a, int b) {
		if(depth[a]>depth[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		int v;
		
		for(int i = k-1;i>=0;i--) {
			v = (int)Math.pow(2, i);
			if(v<=depth[b]-depth[a]) {
				b = parent[b][i];
			}
		}
		
		if(a==b)
			return a;
		
		for(int i = k-1;i>=0;i--) {
			if(parent[a][i]!=parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		
		return parent[a][0];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		k = (int) Math.ceil(Math.log10(n) / Math.log10(2));
		start = new int[n+1];
		end = new int[n+1];
		depth = new int[n+1];
		parent = new int[n+1][k];
		apple = new int[2 * n+1];
		char[] arr;
		arr = br.readLine().toCharArray();
		for (int i = 1; i <= 2 * n; i++) {
			apple[i] = arr[i-1] - '0';
		}

		dfs(1, 1);
		
		setParent();
		
		st = new StringTokenizer(br.readLine()," ");
		
		int i,j;
		
		i  = Integer.parseInt(st.nextToken());
		j = Integer.parseInt(st.nextToken());
		
		int a=0,b=0;
		
		for(int c = 1;c<=n;c++) {
			if(start[c]==i ||end[c]==i) {
				if(a!=0)
					b = c;
				else
					a = c;
			}
			if(start[c]==j ||end[c]==j) {
				if(a!=0)
					b = c;
				else
					a = c;
			}
		}
		int cut = lca(a,b);
		
		System.out.println(start[cut]+" "+end[cut]);
		
	}

}
