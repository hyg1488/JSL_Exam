import java.util.Scanner;

public class loto{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("게임 수 입력 : ");
		int game = sc.nextInt();
		String[][] myNum = new String[game][7];	

		int[] lotoNum = new int[6];
		int hit=0;
		int bonus=0;
		boolean bool = true;
		
		System.out.println("본인의 번호를 입력하세요.");
		for (int i = 0; i < game; i++) {
			String num = sc.next();
			String[] myNum2 = num.split(",");
			for (int j = 0; j < myNum2.length; j++) {
				myNum[i][j] = myNum2[j];
				System.out.println(myNum[i][j]+" "+i);
			}
		}
		
//		for (int i = 0; i < myNum.length; i++) {
//			myNum[i] = num.split(",");
//		}
		
		for (int i = 0; i < lotoNum.length; i++) {
			int count=0;
			int newNum = (int)(Math.random()*45)+1;
			
			for (int j = 0; j < lotoNum.length; j++) {
				if(lotoNum[j] == 0) {
					bonus = (int)(Math.random()*45)+1;
					while(bool) {
						if(bonus == newNum) {
							bonus = (int)(Math.random()*45)+1;
						}
						else{
							bool = false;
						}
					}
					break;
				}
				
				if(newNum == lotoNum[j] || newNum == bonus) {
					System.out.println("! "+lotoNum[j]+" "+newNum+" 중복 발생 "+ "!");
					System.out.println("번호를 다시 생성합니다.");
					i--;
					count = 1;
				}
			}
			
			if(count == 0) {
				lotoNum[i] = newNum;
			}
		}
		
		System.out.println();
		System.out.println("게임 결과");
		System.out.print("당첨 번호 : ");
		for (int i = 0; i < lotoNum.length; i++) {
			System.out.print(lotoNum[i]+" ");
		}
		System.out.println("  보너스 "+bonus);
		
		for (int k = 0; k < game; k++) {
			
			System.out.print(k+" : ");
			for (int i = 0; i < myNum[k].length; i++) {
				System.out.print(myNum[k][i]+"\t");
			}
			for (int i = 0; i < lotoNum.length; i++) {
				for (int j = 0; j < lotoNum.length; j++) {
					if(Integer.parseInt(myNum[k][j])==lotoNum[i]) {
						hit++;
					}
					
				}
			}
			
			System.out.print("  ");
			switch(hit) {
				case 6: System.out.println("1등");
				case 5: 
					int cnt =0;
					for (int i = 0; i < myNum.length; i++) {
						if(Integer.parseInt(myNum[k][i]) == bonus) {
							System.out.println("2등");
							cnt = 1;
						}
					}
					if(cnt == 0) {
						System.out.println("3등");
					}
					
					break;
				case 4: System.out.println("4등");	
					break;
				case 3: System.out.println("5등");
				default: System.out.println("꽝");
			}
			
			hit = 0;
		}
	}
}
