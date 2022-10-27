import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static Stack<Dot> convex = new Stack<Dot>();
	static ArrayList<Dot> dots = new ArrayList<Dot>();
	static class Dot{
		long x,y;
		
		public Dot(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Dot minus(Dot d) {
			return new Dot(x-d.x,y-d.y);
		}
		
		public double dist(Dot d) {
			return Math.sqrt(Math.pow(x-d.x, 2)+Math.pow(y-d.y, 2));
		}

		@Override
		public String toString() {
			return "Dot [x=" + x + ", y=" + y + "]";
		}
	}
	static int ccw(Dot d1, Dot d2, Dot d3) {
		long v = (d2.x-d1.x)*(d3.y-d2.y)-(d3.x-d2.x)*(d2.y-d1.y);
		if(v>0)
			return 1;
		else if(v<0)
			return -1;
		else
			return 0;
	}
	static boolean getAngle(Dot a, Dot b) {
		if(a.x*b.y-a.y*b.x>0)
			return true;
		return false;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		long a,b;
		long sx = Long.MAX_VALUE,sy = Long.MAX_VALUE;
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());
			dots.add(new Dot(a, b));
			if(b<sy || (b==sy && a<sx)) {
				sx = a;
				sy = b;
			}
		}
		Dot d0 = new Dot(sx,sy);
		dots.sort(new Comparator<Dot>() {

			@Override
			public int compare(Dot d1, Dot d2) {
				int v = ccw(d0,d1,d2);
				if(v>0)
					return -1;
				else if(v<0)
					return 1;
				else {
					double dist1 = d0.dist(d1);
					double dist2 = d0.dist(d2);
					return Double.compare(dist1, dist2);
				}
			}
		});
		
		convex.add(d0);
		boolean v = false;
		for(int i = 1;i<n;i++) {
			while(convex.size()>1 && ccw(convex.get(convex.size()-2),convex.get(convex.size()-1),dots.get(i))<=0) {
				convex.pop();
			}
			convex.add(dots.get(i));
		}
//		System.out.println(convex.toString());
		int start = 0;
		int end = 1;
		int size = convex.size();
		for(int i = 0;i<size;i++) {
			if(convex.get(end).x<convex.get(i).x || (convex.get(end).x==convex.get(i).x && convex.get(end).y<convex.get(i).y))
				end=i;
			if(convex.get(start).x>convex.get(i).x || (convex.get(start).x==convex.get(i).x && convex.get(start).y>convex.get(i).y))
				start=i;
		}
				
		double answer = convex.get(start).dist(convex.get(end));
		double dist;
		for(int i = 0;i<size;i++) {
			if(getAngle(convex.get((start+1)%size).minus(convex.get(start)),convex.get(end).minus(convex.get((end+1)%size)))) {
				start = (start+1)%size;
			}
			else
				end = (end+1)%size;
			
			dist = convex.get(start).dist(convex.get(end));
			answer = answer<dist?dist:answer;
		}
		System.out.println(answer);		
	}
}
