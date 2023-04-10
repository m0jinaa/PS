import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static Dot[] list;
	static List<Dot> dots = new ArrayList<>();
	static Stack<Integer> convex = new Stack<>();
	static long sx,sy;
	
	private static int ccw(Dot d1, Dot d2, Dot d3) {

		long v = (d2.x-d1.x)*(d3.y-d2.y)-(d3.x-d2.x)*(d2.y-d1.y);

		if(v<0)
			return -1;
		else if(v>0)
			return 1;
		else
			return 0;

	}
	static class Dot{
		long x, y;
		
		public Dot(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static double dist(Dot a, Dot b) {
		return Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2);
	}
	static long convexHull(int ind) {
		dots.clear();
		convex.clear();
		
		sx = 1_000_000_000;
		sy = 1_000_000_000;
		
		for(int i = 0;i<=ind;i++) {
			if(list[i].y<sy) {
				sx = list[i].x;
				sy = list[i].y;
			}
			else if(list[i].y==sy && list[i].x<sx)
				sx = list[i].x;
			dots.add(list[i]);
		}
		
		Collections.sort(dots, new Comparator<Dot>() {

			@Override
			public int compare(Dot a, Dot b) {
                long v = ccw(new Dot(sx, sy), a, b);
                if( v > 0)
                	return -1;
                else if(v<0)
                	return 1;
                else {
                	Double d1 = dist(new Dot(sx,sy),a);
                	Double d2 = dist(new Dot(sx,sy),b);
                	
                	if(d1<d2) {
                		return -1;
                	}
                	else if(d2<d1) {
                		return 1;
                	}
                	else
                		return 0;
                }  
			}
		});
			
        convex.push(0);
        int N = dots.size();
        for(int i=1; i<N; i++){
            while(convex.size() > 1 && ccw(dots.get(convex.get(convex.size()-2)), dots.get(convex.peek()), dots.get(i)) <=0 ){
                convex.pop();
            }
            convex.add(i);
        }
        
        return getSize();

	}
	static long getSize() {
		long space = 0;
		Dot d1,d2;
		int size = convex.size();
		for(int j = 0;j<size;j++) {
			d1 = dots.get(convex.get(j));
			d2 = dots.get(convex.get((j+1)%size));
			
			space+=d1.x*d2.y-d2.x*d1.y;
		}
		return space;
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		long A = Long.parseLong(st.nextToken());
		int a,b;
		String answer = "draw";
		list = new Dot[n+3];
		for(int i = 0;i<n+3;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			list[i] = new Dot(a,b);
		}	
		
		int s = 3;
		int e = n+2;
		int mid;
		while(s<=e) {
			mid = (s+e)/2;
			if(convexHull(mid)>=2*A) {
				if(mid%2!=0) {
					answer = "wapas";
				}
				else {
					answer = "wider";
				}
				e = mid-1;
			}
			else {
				s = mid+1;	
			}
		}
		System.out.println(answer);
	}
}