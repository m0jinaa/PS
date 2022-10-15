import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static ArrayList<Dot> list = new ArrayList<Dot>();
	static LinkedList<Dot> dots = new LinkedList<Dot>();
	static LinkedList<Dot> convex = new LinkedList<Dot>();
	
	static class Dot implements Comparable<Dot>{
		long x,y;
		int ind;
		double degree;
		public Dot(long x, long y,int ind) {
			super();
			this.x = x;
			this.y = y;
			this.ind = ind;
		}
		public void setDegree(double degree) {
			this.degree = degree;
		}
		@Override
		public String toString() {
			return "Dot [x=" + x + ", y=" + y + ", ind=" + ind + ", degree=" + degree + "]";
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
		else
			return false;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		long sx = Long.MAX_VALUE, sy = Long.MAX_VALUE;
		int a,b;
		int[] answer = new int[n];
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
			
			list.add(new Dot(a,b,i));
		}
		Dot d1,d2,d3;
		int floor=0;
		while(list.size()>2) {
			floor++;
			long nsx = Long.MAX_VALUE, nsy = Long.MAX_VALUE;
			
			for(Dot d:list) {
				if(d.x==sx && d.y==sy) {
					convex.add(d);
					continue;
				}
				d.setDegree((Math.atan(1.0*(d.y-sy)/(d.x-sx))*180/3.14+360)%360);
				dots.add(d);
			}
			
			list.clear();
			
			Collections.sort(dots);
			
			convex.add(dots.pollFirst());
			boolean v;
			while(!dots.isEmpty()) {
//			System.out.println("ConvexSize = "+convex.size());
//			System.out.println("ListSize = "+list.size());
				d3 = dots.pollFirst();
				d2 = convex.pollLast();
				d1 = convex.pollLast();
				v = ccw(d1,d2,d3);
				if(v) {
					convex.add(d1);
					convex.add(d2);
					convex.add(d3);
				}
				else {
					while(!convex.isEmpty() && !v) {

						list.add(d2);
						if(d2.y<nsy) {
							nsx = d2.x;
							nsy = d2.y;
						}
						else if(d2.y==nsy && d2.x<nsx) {
							nsx = d2.x;
						}							
						d2 = d1;
						d1 = convex.pollLast();
						v = ccw(d1,d2,d3);
					}
					if(v) {
						convex.add(d1);
						convex.add(d2);
						convex.add(d3);					
					}
					else {
						list.add(d2);
						if(d2.y<nsy) {
							nsx = d2.x;
							nsy = d2.y;
						}
						else if(d2.y==nsy && d2.x<nsx) {
							nsx = d2.x;
						}							
						convex.add(d1);
						convex.add(d3);
					}
				}
			}
			
			//compare two last dots with the first dot
			if(convex.size()>3) {
				d3 = convex.peekFirst();
				d2 = convex.pollLast();
				d1 = convex.pollLast();
				
				while(!(v=ccw(d1,d2,d3)) && !convex.isEmpty()) {
					list.add(d2);
					if(d2.y<nsy) {
						nsx = d2.x;
						nsy = d2.y;
					}
					else if(d2.y==nsy && d2.x<nsx) {
						nsx = d2.x;
					}	
					d2 = d1;
					d1 = convex.pollLast();
				}
				if(v) {
					convex.add(d1);
					convex.add(d2);
				}
				else {
					list.add(d2);
					if(d2.y<nsy) {
						nsx = d2.x;
						nsy = d2.y;
					}
					else if(d2.y==nsy && d2.x<nsx) {
						nsx = d2.x;
					}							
					
					convex.add(d1);
				}
			}
			if(convex.size()>2) {
				for(Dot d : convex) {
					//System.out.println(d);
					answer[d.ind] = floor;
				}				
			}
			//System.out.println();
			convex.clear();
			sx = nsx;
			sy = nsy;
		}	
		
		for(int i:answer) {
			sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
	}
}