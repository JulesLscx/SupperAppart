package Controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import Vue.FEN_Accueil;
import Vue.FEN_AssuranceImmeuble;
import Vue.FEN_Caution;
import Vue.FEN_Connexion;
import Vue.FEN_Contacts;
import Vue.FEN_Contrat;
import Vue.FEN_Diagnostics;
import Vue.FEN_DocumentsAnnuels;
import Vue.FEN_Entrepreneur;
import Vue.FEN_Facture;
import Vue.FEN_Facture_Travaux_Immeuble;
import Vue.FEN_Facture_Travaux_Logement;
import Vue.FEN_Immeuble;
import Vue.FEN_Locataire;
import Vue.FEN_Logement;
import Vue.FEN_Paiements;
import Vue.FEN_Regularisation;
import Vue.FEN_TypeFacture;
import Vue.FEN_Type_diagnostic;

public class GestionPrincipale implements ActionListener {
	private FEN_Accueil pr;

	public GestionPrincipale(FEN_Accueil pr) {
		this.pr = pr;
	};

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		switch (item.getText()) {
			case "Contacts":
				if (!this.pr.getOuverte()) {
					this.pr.switchOuverte();
					FEN_Contacts ai = new FEN_Contacts();
					this.pr.getLayeredPane().add(ai);
					ai.setLocation(80, 127);
					ai.setVisible(true);
				}
				break;
			case "Assurance Immeuble":
				if (!this.pr.getOuverte()) {
					this.pr.switchOuverte();
					FEN_AssuranceImmeuble ai = new FEN_AssuranceImmeuble();
					this.pr.getLayeredPane().add(ai);
					ai.setLocation(80, 127);
					ai.setVisible(true);
				}
				break;
			case "Cautions":
				if (!this.pr.getOuverte()) {
					this.pr.switchOuverte();
					FEN_Caution cau = new FEN_Caution();
					this.pr.getLayeredPane().add(cau);
					cau.setLocation(80, 127);
					cau.setVisible(true);
				}
				break;
			case "Contrats":
				if (!this.pr.getOuverte()) {
					this.pr.switchOuverte();
					FEN_Contrat co = new FEN_Contrat();
					this.pr.getLayeredPane().add(co);
					co.setLocation(80, 127);
					co.setVisible(true);
				}
				break;
			case "Diagnostics":
				if (!this.pr.getOuverte()) {
					this.pr.switchOuverte();
					FEN_Diagnostics di = new FEN_Diagnostics();
					this.pr.getLayeredPane().add(di);
					di.setLocation(80, 127);
					di.setVisible(true);
				}
				break;
			case "Documents Annuels":
				if (!this.pr.getOuverte()) {
					this.pr.switchOuverte();
					FEN_DocumentsAnnuels da = new FEN_DocumentsAnnuels();
					this.pr.getLayeredPane().add(da);
					da.setLocation(80, 127);
					da.setVisible(true);
				}
				break;
			case "Entrepreneurs":
				if (!this.pr.getOuverte()) {
					this.pr.switchOuverte();
					FEN_Entrepreneur en = new FEN_Entrepreneur();
					this.pr.getLayeredPane().add(en);
					en.setLocation(80, 127);
					en.setVisible(true);
				}
				break;
			case "Facture Immeuble":
				if (!this.pr.getOuverte()) {
					this.pr.switchOuverte();
					FEN_Facture fa = new FEN_Facture();
					this.pr.getLayeredPane().add(fa);
					fa.setLocation(80, 127);
					fa.setVisible(true);
				}
				break;
			case "Immeubles":
				if (!this.pr.getOuverte()) {
					this.pr.switchOuverte();
					FEN_Immeuble im = new FEN_Immeuble();
					this.pr.getLayeredPane().add(im);
					im.setLocation(80, 127);
					im.setVisible(true);
				}
				break;
			case "Locataires":
				if (!this.pr.getOuverte()) {
					this.pr.switchOuverte();
					FEN_Locataire loc = new FEN_Locataire();
					this.pr.getLayeredPane().add(loc);
					loc.setLocation(80, 127);
					loc.setVisible(true);
				}
				break;
			case "Logements":
				if (!this.pr.getOuverte()) {
					this.pr.switchOuverte();
					FEN_Logement lo = new FEN_Logement();
					this.pr.getLayeredPane().add(lo);
					lo.setLocation(80, 127);
					lo.setVisible(true);
				}
				break;
			case "Paiements":
				if (!this.pr.getOuverte()) {
					this.pr.switchOuverte();
					FEN_Paiements pa = new FEN_Paiements();
					this.pr.getLayeredPane().add(pa);
					pa.setLocation(80, 127);
					pa.setVisible(true);
				}
				break;
			case "Regularisation":
				if (!this.pr.getOuverte()) {
					this.pr.switchOuverte();
					FEN_Regularisation re = new FEN_Regularisation();
					this.pr.getLayeredPane().add(re);
					re.setLocation(80, 127);
					re.setVisible(true);
				}
				break;
			case "Facture Travaux":
				if (!this.pr.getOuverte()) {
					this.pr.switchOuverte();
					FEN_Facture_Travaux_Logement tr = new FEN_Facture_Travaux_Logement();
					this.pr.getLayeredPane().add(tr);
					tr.setLocation(80, 127);
					tr.setVisible(true);
				}
				break;
			case "Travaux Immeuble":
				if (!this.pr.getOuverte()) {
					this.pr.switchOuverte();
					FEN_Facture_Travaux_Immeuble tri = new FEN_Facture_Travaux_Immeuble();
					this.pr.getLayeredPane().add(tri);
					tri.setLocation(80, 127);
					tri.setVisible(true);
				}
				break;
			case "Type Diagnostics":
				if (!this.pr.getOuverte()) {
					this.pr.switchOuverte();
					FEN_Type_diagnostic td = new FEN_Type_diagnostic();
					this.pr.getLayeredPane().add(td);
					td.setLocation(80, 127);
					td.setVisible(true);
				}
				break;
			case "Type Facture":
				if (!this.pr.getOuverte()) {
					this.pr.switchOuverte();
					FEN_TypeFacture tf = new FEN_TypeFacture();
					this.pr.getLayeredPane().add(tf);
					tf.setLocation(80, 127);
					tf.setVisible(true);
				}
				break;
			case "D\u00E9connecter":
				pr.activerItems(false);
				break;
			case "Connecter":
				FEN_Connexion fen_connexion = new FEN_Connexion();
				pr.getLayeredPane().add(fen_connexion);
				fen_connexion.setVisible(true);
				break;
		}
	}

}
