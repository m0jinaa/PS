import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t = 1;t<=10;t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			boolean answer = true;
			
			int[][] tree = new int[n+1][];
			int left = -1;
			int right = -1;
			
			for(int i = 0;i<n;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int m = Integer.parseInt(st.nextToken());
				String node = st.nextToken();
				int val = 1;
				if(node.equals("*")||node.equals("/")||node.equals("-")||node.equals("+"))
					val = 0;
				left = -1;
				right = -1;
				if(st.hasMoreTokens()) {
					left = Integer.parseInt(st.nextToken());
					if(st.hasMoreTokens()) {
						right = Integer.parseInt(st.nextToken());
					}
				}
				tree[m] = new int[] {val,left,right};
			}
			
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(1);
			boolean[] visited = new boolean[n+1];
			int isNumber = 0;
			while(!stack.isEmpty()) {
				int now = stack.pop();
				if(visited[now]) {
					if(tree[now][0]!=isNumber)
						isNumber = 1-isNumber;
					else {
						answer = false;
						break;
					}
				}
				else {
					visited[now] = true;
					if(tree[now][2]!=-1)
						stack.push(tree[now][2]);
					stack.push(now);
					if(tree[now][1]!=-1)
						stack.push(tree[now][1]);
				}					
			}
			if(answer)
				sb.append("#"+t+" 1\n");
			else
				sb.append("#"+t+" 0\n");
		}
		System.out.println(sb);
	}
}
