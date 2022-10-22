import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{
	static int N,M;
	static ArrayList<Dot> list = new ArrayList<Dot>();
	static LinkedList<Dot> dots = new LinkedList<Dot>();
	static LinkedList<Dot> convex = new LinkedList<Dot>();
	static Dot start;
	static double dist(Dot a, Dot b) {
		return Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2);
	}
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
		
		public Dot plus(Dot d) {
			return new Dot(x+d.x,y+d.y);
		}
		@Override
		public String toString() {
			return x+" "+y+"\n";
		}
		
		@Override
		public int compareTo(Dot d) {
			int v = ccw(start,this,d);
			if(v!=0)
				return -v;
			else
				return dist(start,this)<dist(start,d)?-1:1;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (x ^ (x >>> 32));
			result = prime * result + (int) (y ^ (y >>> 32));
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Dot other = (Dot) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
	}
	
	static int ccw(Dot d1, Dot d2, Dot d3) {
		long v = (d2.x-d1.x)*(d3.y-d2.y)-(d3.x-d2.x)*(d2.y-d1.y);
//		System.out.println(d1+" "+d2+ " "+d3);
//		System.out.println(v<0?-1:v>0?1:0);
		if(v>0)
			return 1;
		else if(v<0)
			return -1;
		else
			return 0;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Dot[] A = new Dot[N];
		Dot[] B = new Dot[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			A[i] = new Dot(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			B[i] = new Dot(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
		}
		
		long sx = Long.MAX_VALUE, sy = Long.MAX_VALUE;
		Set<Dot> set = new HashSet<Dot>();
		Dot temp;
		for(Dot a:A) {
			for(Dot b:B) {
				temp = a.plus(b);
				if(set.contains(temp))
					continue;
				if(temp.x<sx) {
					sx = temp.x;
					sy = temp.y;
				}
				else if(temp.x==sx && temp.y<sy) {
					sy = temp.y;
				}
				
				list.add(temp);				
			}
		}
		start = new Dot(sx,sy);
		Dot d1,d2,d3;
		for(Dot d:list) {
			if(d.x==sx && d.y==sy) {
				convex.add(d);
				continue;
			}
			d.setDegree((Math.atan(1.0*(d.y-sy)/(d.x-sx))*180/3.14+450)%360);
			dots.add(d);
		}
		
		list.clear();
		
		Collections.sort(dots);
		convex.add(dots.pollFirst());
		int v;
		while(!dots.isEmpty()) {
			d3 = dots.pollFirst();
			while(convex.size()>=2 && ccw(convex.get(convex.size()-2),convex.peekLast(),d3)<=0)
				convex.pollLast();
			convex.add(d3);
		}
		sb.append(convex.size()).append("\n");
		for(Dot d:convex) {
			sb.append(d);
		}
		
		System.out.println(sb.toString());
	}
}