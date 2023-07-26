class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] arr = new int[N][N];
        
        // 최댓값으로 배열 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == j) {
                    continue;
                }
                arr[i][j] = 100000000;
            }
        }
        
        for(int i=0;i<road.length;i++){
            //마을이 1번부터니까 1뺴줌
            if(arr[road[i][0]-1][road[i][1]-1] >= road[i][2]){ //거리가 크면 안넣음
                arr[road[i][0] - 1][road[i][1] - 1] = road[i][2];
                arr[road[i][1] - 1][road[i][0] - 1] = road[i][2];
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    // jk를 바로 가는것과 i를 거쳐서 가는것중 i를 거쳐서 가는게 더 빠를 경우
                    if(arr[j][k] > arr[j][i] + arr[i][k]) {
                        arr[j][k] = arr[j][i] + arr[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if(arr[0][i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}