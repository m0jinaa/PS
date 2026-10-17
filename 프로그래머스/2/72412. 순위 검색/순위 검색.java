import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        
        StringTokenizer st;
        
        String[] l = new String[]{" ","-"};
        String[] p = new String[]{" ","-"};
        String[] t = new String[]{" ","-"};
        String[] f = new String[]{" ","-"};
        int r;

        HashMap<String, ArrayList<Integer>> options = new HashMap<>();
            
        String h;
            
        ArrayList<Integer> list;
            
        
        //해당하는 경우의 수마다 다 넣어주기
        for(String s : info){
            st = new StringTokenizer(s," ");
            
            l[0] = st.nextToken();
            p[0] = st.nextToken();
            t[0] = st.nextToken();
            f[0] = st.nextToken();
            
            r = Integer.parseInt(st.nextToken());
            
            for(int a = 0;a<2;a++){
                for(int b = 0;b<2;b++){
                    for(int c = 0;c<2;c++){
                        for(int d = 0;d<2;d++){
                            h = l[a]+p[b]+t[c]+f[d];
                            
                            list = options.getOrDefault(h,new ArrayList<>());
                            list.add(r); 
                            
                            options.put(h,list);
                        }
                    }
                }
            }
        }
        
        //경우의 수마다 점수들 정렬
        for(String key : options.keySet()){
            Collections.sort(options.get(key));
        }
        
        int qsize = query.length;
        
        int[] answer = new int[qsize];
        
        String q;
        
        int s,e;
        int mid;
        int cnt;
        int score;
        
        for(int i = 0;i<qsize;i++){
            st = new StringTokenizer(query[i].replaceAll(" and ","")," ");
            
            //조건
            q = st.nextToken();
            
            //점수
            score = Integer.parseInt(st.nextToken());
            
            cnt = 0;
            
            if(options.containsKey(q)){
                list = options.get(q);

                s = 0;
                e = list.size()-1;

                while(s<=e){
                    mid = (s+e)/2;

                    if(list.get(mid)>=score){
                        cnt = list.size()-mid;
                        e = mid-1;
                    }
                    else{
                        s = mid+1;
                    }
                }
            }
            
            answer[i] = cnt;
        }
        
        return answer;
    }
}