import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder result = new StringBuilder();
		while(true) {
			String str = br.readLine();
			if(str.length()<2) break;
			int cnt = 0;//몇을 더해줘야하는지
			int len = str.length(); // 문자열길이
			int num = Integer.parseInt(str);
			while(!isPalin(num+cnt++,len)) { //팰린 아님
			}
			result.append(cnt-1+"\n");
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
	
	public static boolean isPalin(int num, int len) {
		//팰린드롬인지 확인해주는 메소드
		String temp = String.valueOf(num);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<len-temp.length();i++) {//앞에 0추가해줘야함
			sb.append('0');
		}
		sb.append(temp);
		temp = sb.toString();
		
		for(int i=0;i<len/2;i++) {
			if(temp.charAt(i) != temp.charAt(len-1-i)) {
				return false;
			}
		}
		return true;
	}
}
