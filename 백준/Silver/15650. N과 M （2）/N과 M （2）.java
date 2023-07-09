import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N, M;
	static int[] numbers;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		comb(0, 1);
	}
	
	public static void comb(int cnt, int startIndex) {
		if(cnt==M) { // M개 다 골랐음
			for(int i=0;i<M;i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i = startIndex;i<=N;i++){
			numbers[cnt] = i;
			comb(cnt+1, i+1);
		}	
	}
}