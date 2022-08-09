import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	Boolean isNumber;
	int left = -1;
	int right = -1;
	
	public Node(Boolean isNumber) {
		this.isNumber = isNumber;
	}

	public Node(Boolean isNumber, int left) {
		this.isNumber = isNumber;
		this.left = left;
	}

	public Node(Boolean isNumber, int left, int right) {
		this.isNumber = isNumber;
		this.left = left;
		this.right = right;
	}
	
}
public class Solution {
	static Node[] tree;
	static boolean[] result;
	static int index;
	static boolean answer;
	static void inOrder(int start) {
		if(start == -1||answer == false)
			return;
		inOrder(tree[start].left);
		if(index == 0||result[index-1]!=tree[start].isNumber)
			result[index++] = tree[start].isNumber;
		else {
			answer = false;
			return;
		}
		inOrder(tree[start].right);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t = 1;t<=10;t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			tree = new Node[n+1];
			index = 0;
			result = new boolean[n];
			answer = true;
			for(int i = 0;i<n;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int m = Integer.parseInt(st.nextToken());

				String token = st.nextToken();
				char c = token.charAt(0);
				if(st.hasMoreTokens()) {
					int left = Integer.parseInt(st.nextToken());
					if(st.hasMoreTokens()) {
						int right = Integer.parseInt(st.nextToken());
						if(token.length()==1 && (c==42||c==43||c==45||c==47))//연산자일 경우
							tree[m] = new Node(false,left,right);
						else
							tree[m] = new Node(true,left,right);
					}
					else {
						if(token.length()==1 && (c==42||c==43||c==45||c==47))//연산자일 경우
							tree[m] = new Node(false,left);
						else
							tree[m] = new Node(true,left);						
					}
				}
				else {
					if(token.length()==1 && (c==42||c==43||c==45||c==47))//연산자일 경우
						tree[m] = new Node(false);
					else
						tree[m] = new Node(true);				
				}
			}
			inOrder(1);
			
			if(answer)
				sb.append("#"+t+" 1\n");
			else
				sb.append("#"+t+" 0\n");
		}
		System.out.println(sb);
	}
}
