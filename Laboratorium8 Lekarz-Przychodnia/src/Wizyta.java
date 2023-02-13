
public class Wizyta {
	private int kodChoroby;
	private int cenaWizyty;
	private boolean zwolnienie;
	private boolean recepta;
	
	public Wizyta()
	{
		kodChoroby=0;
		cenaWizyty=0;
		zwolnienie=false;
		recepta=false;
	}
	
	public Wizyta(int kod, int cena, boolean zwolnienie, boolean recepta)
	{
		kodChoroby=kod;
		cenaWizyty=cena;
		this.zwolnienie=zwolnienie;
		this.recepta=recepta;
	}
	
	public String toString()
	{
		return "[kodChoroby="+kodChoroby+",cenaWizyty= "+cenaWizyty+",zwolnienie="+zwolnienie+",recepta= "+recepta+"]";
	}

	public int getKodChoroby() {
		return kodChoroby;
	}

	public void setKodChoroby(int kodChoroby) {
		this.kodChoroby = kodChoroby;
	}

	public int getCenaWizyty() {
		return cenaWizyty;
	}

	public void setCenaWizyty(int cenaWizyty) {
		this.cenaWizyty = cenaWizyty;
	}

	public boolean isZwolnienie() {
		return zwolnienie;
	}

	public void setZwolnienie(boolean zwolnienie) {
		this.zwolnienie = zwolnienie;
	}

	public boolean isRecepta() {
		return recepta;
	}

	public void setRecepta(boolean recepta) {
		this.recepta = recepta;
	}
	
	
}
