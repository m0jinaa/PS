import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] distA, distB;

    static int getLastA(int x) {
        int ans = 0;
        int s = 0;
        int e = n-1;
        int m;

        while(s<=e) {
            m = (s+e)/2;
            if(distA[m]<=x) {
                ans = m+1;
                s = m+1;
            }
            else
                e = m-1;
        }

        return ans;
    }

    static int getLastB(int x) {
        int ans = 0;
        int s = 0;
        int e = n-1;
        int m;

        while(s<=e) {
            m = (s+e)/2;
            if(distB[m]<=x) {
                ans = m+1;
                s = m+1;
            }
            else
                e = m-1;
        }

        return ans;
    }

    public static class Home{
        int x,y;

        public Home(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        public int dist(Home h) {
            return (int) (Math.pow(x-h.x, 2)+Math.pow(y-h.y, 2));
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb  = new StringBuilder();
        Home[] homes;
        Home A,B;
        int x,y,r1,r2;
        int ax,ay,bx,by,q;
        int cnt;
        int t=0;
        while(true) {

            n = Integer.parseInt(br.readLine());

            if(n==0)
                break;
            t++;

            sb.append("Case ").append(t).append(":\n");

            homes = new Home[n];

            for(int i = 0;i<n;i++) {
                st = new StringTokenizer(br.readLine()," ");
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                homes[i] = new Home(x,y);
            }

            st = new StringTokenizer(br.readLine()," ");

            ax = Integer.parseInt(st.nextToken());
            ay = Integer.parseInt(st.nextToken());
            bx = Integer.parseInt(st.nextToken());
            by = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());

            A = new Home(ax,ay);
            B = new Home(bx,by);

            distA = new int[n];
            distB = new int[n];

            for(int i = 0;i<n;i++) {
                distA[i] = homes[i].dist(A);
                distB[i] = homes[i].dist(B);
            }

            Arrays.sort(distA);
            Arrays.sort(distB);
            cnt=0;

            for(int i = 0;i<q;i++) {
                st = new StringTokenizer(br.readLine()," ");
                r1 = Integer.parseInt(st.nextToken());
                r2 = Integer.parseInt(st.nextToken());
                cnt = n-(getLastA(r1*r1)+getLastB(r2*r2));
                sb.append(cnt>0?cnt:0).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}