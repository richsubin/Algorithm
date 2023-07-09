import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] numList, tempList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numList = new int[N];//입력한것들
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			numList[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numList); // 오름차순 정렬
		
		tempList = new int[M]; // 출력용 값들 넣는 배열
		dfs(0,0);
	}
	
	public static void dfs(int cnt, int startIndex) {
		if(cnt == M) {
			for(int num : tempList) {
				System.out.print(num +" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=startIndex;i<N;i++) {
			if(i!=0 && numList[i-1] == numList[i]) continue; //중복방지위해
			tempList[cnt] = numList[i];
			dfs(cnt+1, i);
		}
	}
}