
public class Zadanie2 {
	public static void main(String[] args){
		int x=876;
		if(x==0) {
			System.out.print("0");
		}
		while(x>0) {
			System.out.print(x%10);
			x/=10;
		}
	}
}
