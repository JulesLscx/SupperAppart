package Rapport;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class CreerRapport {
    public static void main(String[] args) {
        OutputStream fileOut = null;
        InputStream modele = null;
        try {
            fileOut = new FileOutputStream("test.docx");
            modele = new FileInputStream("vide.docx");
            XWPFDocument document = new XWPFDocument(modele);
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText("Planning des cours… ");

            XWPFParagraph paragraph2 = document.createParagraph();
            XWPFRun run2 = paragraph2.createRun();

            run2.addCarriageReturn();
            run2.addCarriageReturn();
            run2.setText("Veuillez trouver ci-joint, l'ensemble des créneaux affichésdans la table.");
            run2.addCarriageReturn();
            run2.addCarriageReturn();

            XWPFTable tab = document.createTable();
            XWPFTableRow row = tab.getRow(0);
            XWPFTableCell cell = row.getCell(0);
            cell.setText("Début de semaine");
            XWPFTableCell cell2 = row.addNewTableCell();
            cell2.setText("Jour de la semaine");
            row.createCell().setText("Groupe");
            row.createCell().setText("Heure de début du cours");
            row.createCell().setText("Heure de fin de cours");
            row.createCell().setText("Type du cours");
            row.createCell().setText("Matière");
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOut != null) {
                    fileOut.close();
                }
                if (modele != null) {
                    modele.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}