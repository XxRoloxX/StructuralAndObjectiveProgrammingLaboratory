package waluta;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import konwerter.Konwerter;

public class Waluta {
	
	private JButton przyciskCzyszczenia;
	private JLabel nazwaPierwszejWaluty;
	private JLabel nazwaDrugiejWaluty;
	private JTextField polePierwszejWaluty;
	private JTextField poleDrugiejWaluty;
	
	public void rysuj()
	{
		JFrame ramka = new JFrame();
		JPanel panel = new JPanel();
		przyciskCzyszczenia = new JButton("Wyczyść pola");
		nazwaPierwszejWaluty = new JLabel("Złoty");
		nazwaDrugiejWaluty = new JLabel("Euro");
		polePierwszejWaluty = new JTextField();
		poleDrugiejWaluty = new JTextField();
		
		
		panel.setLayout(new GridLayout(3,2));
		panel.add(nazwaPierwszejWaluty);
		panel.add(polePierwszejWaluty);
		panel.add(nazwaDrugiejWaluty);
		panel.add(poleDrugiejWaluty);
		panel.add(przyciskCzyszczenia);
		ramka.getContentPane().add(panel);
		
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ramka.setSize(500,200);
		ramka.setTitle("Konwerter Walut");
		ramka.setVisible(true);
		
		przyciskCzyszczenia.addActionListener(new ReakcjaNaPrzycisk());
		polePierwszejWaluty.addActionListener(new ReakcjaNaZmianePierwszejWaluty());
		poleDrugiejWaluty.addActionListener(new ReakcjaNaZmianeDrugiejWaluty());
		
		
	}
	
	class ReakcjaNaZmianePierwszejWaluty implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			poleDrugiejWaluty.setText(String.format("%.2f",Konwerter.zloteNaEuro(
					Double.parseDouble(polePierwszejWaluty.getText()))));
			}catch(java.lang.NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(null, "Nieprawidłowy format liczby", "",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	class ReakcjaNaZmianeDrugiejWaluty implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			polePierwszejWaluty.setText(String.format("%.2f",Konwerter.euroNaZlote(
					Double.parseDouble(poleDrugiejWaluty.getText()))));
			}catch(java.lang.NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(null, "Nieprawidłowy format liczby", "",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	class ReakcjaNaPrzycisk implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			polePierwszejWaluty.setText(null);
			poleDrugiejWaluty.setText(null);
		}
		
	}
	
}
