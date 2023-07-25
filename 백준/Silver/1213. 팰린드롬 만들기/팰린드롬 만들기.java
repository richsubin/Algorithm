import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		//알파벳 글자를 세어야함, 전부 대문자
		//알파벳은 26자이고, 사전순 정렬해야함
		int alpha[] = new int[26];
		StringBuilder result = new StringBuilder();
		
		for(int i=0;i<str.length();i++) {
			alpha[str.charAt(i)-'A']++; // 해당 알파벳 세기
		}
		//홀수인 글자는 가운데여야함 불가능
		int holsu = 0;
		int center = 0; //가운데 인덱스
		for(int i=0;i<26;i++) {
			if(alpha[i]%2 !=0) {
				holsu++;
				center = i;
			}
		}
		
		if(holsu>1 ) { //홀수가 1개보다 많으면 안된다
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		
		else {
			String front="";
			for(int i=0;i<26;i++) {
				for(int j=0;j<alpha[i]/2;j++) {//얖쪽 딱 반만 완성하고
					front+=(char)(i+'A'); //붙일때 위에 뺐던거 더해줌
				}
			}
			
			String back = new StringBuilder(front).reverse().toString();
			if(holsu==1) {
				front+=(char)(center+'A');
			}
			result.append(front+back);
		}
		System.out.println(result+"");
	}
}
