import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int num = Integer.parseInt(br.readLine());
		int[] result = new int[num+1];
		
		if(num<5) {
			System.out.print(num);
		}
		
		
		else {
			for(int i = 0;i<5;i++) {
				result[i] = i;
			}
			
			for(int i = 5;i<=num;i++) {
				result[i] = (result[i-3] * 3)%10007;
			}
			
			System.out.print(result[num]);
			
		}
	}
}