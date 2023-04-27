import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	static char[] word;
	static int m;
	static class Node{
		boolean isEnd;
		boolean isHead;
		int cnt;
		Node[] children;
		public Node() {
			this.isEnd = false;
			this.isHead = false;
			this.cnt = 0;
			this.children = new Node[26];
		}
		public Node(boolean isHead) {
			this.isEnd = false;
			this.isHead = true;
			this.cnt = 0;
			this.children = new Node[26];
		}
		
		public void add(int ind) {
			if(ind==m) {
				this.isEnd = true;
				return;
			}
			Node next = this.children[word[ind]-'a']; 
			if(next==null) {
				next = new Node();
				this.children[word[ind]-'a'] = next;
				this.cnt++;
			}
			next.add(ind+1);
		}
		
		public int find(char[] w) {
			Node now = this;
			int answer = 0;
			for(char c: w) {
				if(now.isHead)
					answer++;
				else if(now.isEnd)
					answer++;
				else if(now.cnt>1)
					answer++;
				now = now.children[c-'a'];
			}
			return answer;		
		}		
	}
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = "";
		int n;
		Node head = new Node();
		int answer = 0;
		char[][] words;
		while((input = br.readLine())!=null && !input.isEmpty()) {
			n = Integer.parseInt(input);
			head = new Node(true);
			answer = 0;
			words = new char[n][];
			
			for(int i = 0;i<n;i++) {
				words[i] = br.readLine().toCharArray();
				word= words[i];
				m = word.length;
				head.add(0);				
			}
			for(char[] w: words) {
				answer+=head.find(w);
			}
            
			sb.append(String.format("%.2f\n", answer*1.0/n));		
		}
		
		System.out.println(sb.toString());
	}
}