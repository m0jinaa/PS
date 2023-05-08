import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Node{
		Node[] children;
		
		public Node() {
			children = new Node[2];
		}
		
		public void add(int x) {
			Node now = this;
			int next;
			for(int i = 30;i>=0;i--) {
				next = (x &(1<<i))>0?1:0;
				if(now.children[next]==null) {
					now.children[next] = new Node();
				}
				now = now.children[next];
			}
		}
		
		public int xor(int x) {
			int answer = 0;
			Node now = this;
			int next;
			for(int i = 30;i>=0;i--) {
				next = (x &(1<<i))>0?0:1;
				if(now.children[next]==null) {
					next = 1-next;
				}
				else {
					answer += (1<<i);
				}
				now = now.children[next];
			}
			return answer;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[n];
		
		st = new StringTokenizer(br.readLine()," ");
		
		Node head = new Node();
		
		for(int i = 0;i<n;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			head.add(numbers[i]);
		}
		
		int max = 0;
		int ret;
		for(int num : numbers) {
			ret = head.xor(num);
			max = Math.max(max, ret);
		}
		
		System.out.println(max);
	}
}
