package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import Vue.AjouterContacts;
import Vue.FEN_Contacts;

public class GestionContacts implements ActionListener {
	private FEN_Contacts ai;

	public GestionContacts(FEN_Contacts ai) {
		this.ai = ai;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem Menu = (JMenuItem) e.getSource();

		switch (Menu.getText()) {
			case "Ajouter Contacts":
				AjouterContacts ac = new AjouterContacts();
				this.ai.getLayeredPane().add(ac);
				ac.setVisible(true);
				break;
		}
	}
}
