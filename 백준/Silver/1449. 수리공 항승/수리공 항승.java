import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int cnt = 1;
		int[] water = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			water[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(water); //오름차순으로 정렬
		
		double loc = water[0]-0.5; //좌우 0.5 간격 줘야함
		for(int i=1;i<N;i++) {
			if(loc+L < water[i]) {
				loc = water[i]-0.5;
				cnt++;
			}
		}
		
		bw.write(cnt+"");
		bw.flush();
		bw.close();
	}
}