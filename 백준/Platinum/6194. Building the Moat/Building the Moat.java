import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n,r;
	static ArrayList<Dot> list = new ArrayList<Dot>();
	static LinkedList<Dot> dots = new LinkedList<Dot>();
	static LinkedList<Dot> convex = new LinkedList<Dot>();
	
	static class Dot implements Comparable<Dot>{
		long x,y;
		double degree;
		public Dot(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
		public void setDegree(double degree) {
			this.degree = degree;
		}
		@Override
		public String toString() {
			return "Dot [x=" + x + ", y=" + y + ", degree=" + degree + "]";
		}
		@Override
		public int compareTo(Dot d) {
			if(this.degree!=d.degree) {
				return this.degree<d.degree?-1:1;
			}
			else if(this.y != d.y) {
				return this.y<d.y?-1:1;
			}
			else {
				return this.x<d.x?-1:1;
			}
		}
	}
	
	static boolean ccw(Dot d1, Dot d2, Dot d3) {
		long v = (d2.x-d1.x)*(d3.y-d2.y)-(d3.x-d2.x)*(d2.y-d1.y);
//		System.out.println(d1+" "+d2+ " "+d3);
//		System.out.println(v<0?-1:v>0?1:0);
		if(v>0)
			return true;
		return false;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		n = Integer.parseInt(br.readLine());
		
		int sx = Integer.MAX_VALUE, sy = Integer.MAX_VALUE;
		
		int a,b;
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			if(b<sy) {
				sx = a;
				sy = b;
			}
			else if(b==sy && a<sx) {
				sx = a;
			}
			
			list.add(new Dot(a,b));
		}

		for(Dot d:list) {
			if(d.x==sx && d.y==sy) {
				convex.add(d);
				continue;
			}
			d.setDegree((Math.atan(1.0*(d.y-sy)/(d.x-sx))*180/3.14+360)%360);
			dots.add(d);
		}

		Collections.sort(dots);
		
		Dot d1,d2,d3;
		convex.add(dots.pollFirst());
		
		while(!dots.isEmpty()) {
//			System.out.println("Size = "+convex.size());
			d3 = dots.pollFirst();
			d2 = convex.pollLast();
			d1 = convex.pollLast();
			
			if(ccw(d1,d2,d3)) {
				convex.add(d1);
				convex.add(d2);
				convex.add(d3);
			}
			else {
				while(!convex.isEmpty() && !ccw(d1,d2,d3)) {
					d2 = d1;
					d1 = convex.pollLast();
				}
				if(ccw(d1,d2,d3)) {
					convex.add(d1);
					convex.add(d2);
					convex.add(d3);					
				}
				else {
					convex.add(d1);
					convex.add(d3);
				}
			}
		}
		
		//compare two last dots with the first dot
		if(convex.size()>2) {
			d3 = convex.peekFirst();
			d2 = convex.pollLast();
			d1 = convex.pollLast();
			
			while(!convex.isEmpty() && !ccw(d1,d2,d3)) {
				d2 = d1;
				d1 = convex.pollLast();
			}
			if(ccw(d1,d2,d3)) {
				convex.add(d1);
				convex.add(d2);
			}
			else {
				convex.add(d1);
			}
		}		
		double answer = 0;
		convex.add(convex.peekFirst());
		int size = convex.size();
		
		d1 = convex.get(0);
		for(int i = 1;i<size;i++) {
			d2 = convex.get(i);
			//System.out.println(d2);
			answer+=Math.sqrt(Math.pow(d2.x-d1.x, 2)+Math.pow(d2.y-d1.y, 2));
			d1 = d2;
		}

		System.out.printf("%.2f\n",answer);
	}
}