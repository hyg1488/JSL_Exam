
public class HakData extends Hak implements Account {
	int [] score1 = new int[5];
	int tot;
	int avg;
	boolean bool; 
	
	HakData(int a, String s, int b) {
		super.bun = a;
		super.name = s;
		super.score = b;
		bool = true;
	}
	HakData(int a, String s, int[] b) {
		bun = a;
		name = s;
		total(b);
		bool = false;
	}
	
	
	
	@Override
	public void total(int[] score) {
		score1 = score;
		for (int i = 0; i < score1.length; i++) {
			tot += score1[i];
		}
		avg = tot/score1.length;
	}
	
	public void print() {
		if(bool) {
			System.out.println("번호\t이름\t점수");
			System.out.println(bun + "\t"+name+"\t"+score);
			System.out.println();
		}
		else {
			System.out.println("번호\t이름\t점수\t\t합계\t평균");
			System.out.print(bun + "\t"+name+"\t");
			for (int i = 0; i < score1.length; i++) {
				System.out.print(score1[i]+" ");
			}
			System.out.print("\t"+tot+"\t"+avg);
		}
	}
}
