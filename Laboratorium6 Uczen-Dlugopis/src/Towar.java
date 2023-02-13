public class Towar {
	
 private int kod_towaru;
 private double cena;
 
 public Towar()
 {
	 kod_towaru=0;
	 cena=0;
 }
 public Towar(int kod_towaru, double cena)
 {
	 this.kod_towaru=kod_towaru;
	 this.cena=cena;
	 
 }
 
 public int getKod_towaru()
 {
	 return kod_towaru;
 }
 public double getCena()
 {
	 return cena;
 }
 public void setCena(double cena)
 {
	 this.cena=cena;
 }
 public void setKod_towaru(int kod_towaru)
 {
	 this.kod_towaru=kod_towaru;
 }
 public void getStan()
 {
	 System.out.printf("Kod towaru=%d cena=%.2f%n",kod_towaru,cena);
 }
 
}
