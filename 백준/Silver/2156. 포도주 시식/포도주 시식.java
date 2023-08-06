import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());//포도주 잔 개수
		
		int[] wine = new int[n+1];
		int[] drink = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		if(n==1) {
			drink[1] = wine[1];
		}
		else if(n==2) {
			drink[2] = wine[1]+wine[2];
		}
		else {
			drink[1] = wine[1];
			drink[2] = wine[1]+wine[2];
			
			for(int i=3;i<=n;i++) {
				drink[i] = Math.max(drink[i-2]+wine[i],Math.max(drink[i-1], drink[i-3]+wine[i-1]+wine[i]));
			}
		}
		
		bw.write(drink[n]+"");
		bw.flush();
		bw.close();
	}

}
