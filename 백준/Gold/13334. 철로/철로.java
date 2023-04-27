import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Line implements Comparable<Line>{
		int s,e;

		public Line(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Line l) {
			if(this.e != l.e)
				return this.e-l.e;
			else
				return this.s-l.s;
		}	
	}
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Line> lines = new ArrayList<>();
		
		int s,e,t;
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			if(s>e) {
				t = s;
				s = e;
				e = t;
			}
			lines.add(new Line(s,e));
		}
		
		Collections.sort(lines);
		
		int d = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> starts = new PriorityQueue<>();
		
		int answer = 0;
		
		for(Line l: lines) {
			if(l.e-d<=l.s) {
				starts.add(l.s);
			}
			
			while(!starts.isEmpty() && starts.peek()<l.e-d) {
				starts.poll();
			}
			
			answer = Math.max(answer, starts.size());
		}
	
		System.out.println(answer);
	}
}