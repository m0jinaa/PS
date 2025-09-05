import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
      
        int n = Integer.parseInt(br.readLine());
      
        int[] cnt = new int[n + 1];
      
        List<Integer>[] canGo = new ArrayList[n+1];
      
        int u, v;
      
        for(int i = 1;i <= n;i++){
            canGo[i] = new ArrayList<>();
        }      
      
        for(int i = -3;i < n;i++){
            st = new StringTokenizer(br.readLine(), " ");
        
            u = Integer.parseInt(st.nextToken());  
            v = Integer.parseInt(st.nextToken());  
        
            cnt[u]++;
            cnt[v]++;
            canGo[v].add(u);
            canGo[u].add(v);
        }
      
        //가오리의 핵심 정점은 정점에 연결된 노드의 개수가 1,3,4개인 경우이다.
      
        int head = 0;
        int leftWing = 0;
        int center = 0;
        int rightWing = 0;
        int bottomWing = 0;
        int tail = 0;
      
        boolean[] visited = new boolean[n + 1];
        LinkedList<Integer> q = new LinkedList<>();
      
        int now;
        int temp;
      
        
        //꼬리쪽에서 출발하기 때문에 도착하는 순서는 아래와 같다.
        //1. 꼬리
        //2. 아래쪽 날개
        //3. 왼쪽날개, 오른쪽날개, 중심
        //4. 머리
        //주의 : 동순위의 것들중에서는 무엇이 먼저 도달할지 모름
        //      왼쪽날개 정점번호 < 오른쪽날개 정점번호
        
        // 꼬리 찾기
        for(int i = 1;i <= n;i++){
            if(cnt[i] != 1)
                continue;
            tail = i;
            break;
        }
        
        //아래쪽 날개 찾기
        q.add(tail);
        visited[tail] = true;

        end:while(!q.isEmpty()){
            now = q.poll();
            
            for(int next : canGo[now]){
                if(visited[next])
                    continue;
                visited[next] = true;
                
                if(cnt[next] != 2){
                  bottomWing = next;
                  break end;
                }                
                //일반 정점인 경우에는 핵심 정점이 나올때까지 이동
                q.add(next);
            }
        }
        
        //왼쪽 날개, 오른쪽날개, 중심 찾기
        q.clear();
        q.add(bottomWing);

        while(!q.isEmpty()){
            now = q.poll();
            
            for(int next : canGo[now]){
                if(visited[next])
                    continue;
                visited[next] = true;
                
                if(cnt[next] != 2){
                    if(cnt[next] == 4){
                        center = next;
                    }
                    else if(leftWing == 0){
                        leftWing = next;
                    }
                    else{
                        rightWing = next;
                    
                        if(leftWing > rightWing){
                            temp = leftWing;
                            leftWing = rightWing;
                            rightWing = temp;
                        }
                    }
                } 
                else{
                    //일반 정점인 경우에는 핵심 정점이 나올때까지 이동
                    q.add(next);                    
                }
            }
        }   
        
        // 머리 찾기
        q.clear();
        q.add(center);

        end:while(!q.isEmpty()){
            now = q.poll();
            
            for(int next : canGo[now]){
                if(visited[next])
                    continue;
                    
                visited[next] = true;
                
                if(cnt[next] != 2){
                  head = next;
                  break end;
                }                
                //일반 정점인 경우에는 핵심 정점이 나올때까지 이동
                q.add(next);
            }
        }
      
        sb.append(head).append(" ").append(leftWing).append(" ").append(center).append(" ").append(rightWing).append(" ").append(bottomWing).append(" ").append(tail).append("\n");      
      
        System.out.print(sb.toString());
    }
}