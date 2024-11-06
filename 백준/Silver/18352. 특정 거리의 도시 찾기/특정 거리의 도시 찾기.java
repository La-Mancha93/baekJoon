import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X 입력 받기
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int X = sc.nextInt();
        
        // 인접 리스트를 사용해 그래프를 표현
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 모든 도로 입력 받기
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            graph.get(A).add(B);
        }
        
        // 모든 도시의 최단 거리 초기화
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);
        distance[X] = 0; // 출발 도시의 거리는 0으로 설정
        
        // BFS 수행
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(X);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            // 현재 도시에서 이동할 수 있는 모든 도시 확인
            for (int next : graph.get(current)) {
                // 아직 방문하지 않은 도시라면
                if (distance[next] == -1) {
                    // 최단 거리 갱신
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }
        
        // 최단 거리가 K인 모든 도시의 번호를 오름차순으로 출력
        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                System.out.println(i);
                found = true;
            }
        }
        
        // 만약 최단 거리가 K인 도시가 없다면 -1 출력
        if (!found) {
            System.out.println(-1);
        }
    }
}