package main;

import dzien.Dzien;
import dzien.DzienBuilder;
import osoba.Osoba;
import osoba.OsobaBuilder;
import plan.PlanZajec;
import plan.PlanZajecBuilder;
import zajecia.Zajecia;
import zajecia.ZajeciaBuilder;

public class Main {

	public static void main(String[] args) {
		
		Osoba wykladowca1 = (new OsobaBuilder()).imie("Jan").nazwisko("Kowalski").identyfikator("72191827").build();
		Osoba wykladowca2 = (new OsobaBuilder()).imie("Robert").nazwisko("Nowak").indeks("9998").build();
		Zajecia chemia = (new ZajeciaBuilder()).nazwa("Chemia").prowadzacy(wykladowca1).tryb("Stacjonarny").build();
		Zajecia matematyka = (new ZajeciaBuilder()).nazwa("Matematyka").prowadzacy(wykladowca2).tryb("Zdalny").rodzajZaliczenia("Egzamin").build();
		Zajecia fizyka = (new ZajeciaBuilder()).nazwa("Fizyka").prowadzacy(wykladowca2).tryb("Stacjonarny").rodzajZaliczenia("Kolowkium").build();

		
		
		Dzien poniedzialek = (new DzienBuilder()).nLekcja(1,chemia).nLekcja(3,matematyka).nLekcja(5,chemia).addUroczystosci("Rozpoczecie roku").build();
		Dzien czwartek = (new DzienBuilder()).nLekcja(2,fizyka).nLekcja(7,matematyka).nLekcja(8,chemia).build();

		
		
		PlanZajec plan = (new PlanZajecBuilder()).nDzien(1,poniedzialek).nDzien(4, czwartek).numerTygodnia(1).build();
		plan.wyswietlPlan();
	}

}
