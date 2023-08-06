import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] step = new int[N+1];
		int[] score = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			step[i] = Integer.parseInt(br.readLine());
		}
		if(N == 1) {
			score[1] = step[1];
		}
		else if(N == 2) {
			score[2] = step[1]+step[2];
		}
		else {
			score[1] = step[1];
			score[2] = step[1]+step[2];
			score[3] = Math.max(step[1], step[2])+step[3];
					
			for(int i=4;i<=N;i++) {
				score[i] = Math.max(score[i-3]+step[i-1], score[i-2])+step[i];
			}
		}

		bw.write(score[N]+"");
		bw.flush();
		bw.close();
	}
}