import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        ArrayList<ArrayList<Integer>> wireList = new ArrayList<>();
        for(int i =0; i<=n;i++){
            ArrayList<Integer> arr = new ArrayList<>();
            wireList.add(arr);
        }
        for(int i =0;i<wires.length;i++){
            wireList
                    .get(wires[i][0])
                    .add(wires[i][1]);
            wireList
                    .get(wires[i][1])
                    .add(wires[i][0]);
        }
        //메서드로 쪼개기
        //wireList에서 wires 배열의 요소중 하나의 배열을 지우고
        for(int i =0;i<wires.length;i++){
            wireList
                    .get(wires[i][0])
                    .remove((Integer) wires[i][1]);
            wireList
                    .get(wires[i][1])
                    .remove((Integer) wires[i][0]);
            //지운 배열의 두 값을 RootNode로 bfs를 시행해서 각각 총 노드의 개수를 반환한다.
            Integer a = bfs(wireList,wires[i][0]);
            Integer b = bfs(wireList,wires[i][1]);
            //각각 시행한 bfs를 통해 반환받은 노드의 개수의 차를 구해서 음수의 경우 양수로 전환해준다
            Integer result = a-b;
            if(result < 0) result *= -1;
            //이전에 시행했던 값보다 작을경우 해당값을 결과값으로 저장한다.
            if(answer > result) answer = result;
            //다시 원래 wireList로 값 추가 해줌
            wireList
                    .get(wires[i][0])
                    .add(wires[i][1]);
            wireList
                    .get(wires[i][1])
                    .add(wires[i][0]);
        }
        //모든 wires 배열을 요소를 지우면서 값을 구하고 결과값을 반환한다.
        return answer;
    }

    Integer bfs(ArrayList<ArrayList<Integer>> wireList, Integer rootNode){
        //다녔던 경로를 확인하기 위한 Integer[101] 배열 만든다 -> n은 2이상100이하인 자연수
        int[] route = new int[101];
        //일단 큐를 만들어 큐에 루트노드를 집어넣는다.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(rootNode);
        //집어 넣으면서 Integer[rootNode] +1 or Boolean true 해준다
        route[rootNode]++;
        //wireList에 get으로 큐에 넣었던 루트노드 값을 poll해주면서 ArrayList를 가져오고
        while(queue.size() != 0){
            ArrayList<Integer> arr = wireList.get(queue.poll());
            for(int i =0; i<arr.size();i++){
                //이제 큐에 있는 값을 순차적으로 하나하나 꺼내면서 동일한 일을 반복해준다.
                //거기에 값이 있으면 Integer[값] 1 or true인지 확인하고 없으면 넣는다.
                Integer nowResult = arr.get(i);
                if(route[nowResult] != 1) {
                    queue.add(nowResult);
                    route[nowResult]++;
                }
            }
        }
        //모든 값을 돌고 Integer에서 true이거나 +1인 수 를 집계해서 반환한다.
        Integer answer = 0;
        for(int i =0;i<route.length;i++){
            if(route[i] == 1) answer++;
        }
        return answer;
    }
}