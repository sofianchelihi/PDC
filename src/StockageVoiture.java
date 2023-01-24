import java.io.*;
import java.util.ArrayList;

public class StockageVoiture {
    private ArrayList<AbstractVoiture> liste;
    private static StockageVoiture instance;

    private StockageVoiture() {
        this.liste = new ArrayList<AbstractVoiture>();
    }

    public static StockageVoiture getInstance() {
        if(instance == null) {
            instance = new StockageVoiture();
        }

        return instance;
    }

    public void add(AbstractVoiture v) {

        liste.add(v);
    }

    public void remove(AbstractVoiture v) {
        liste.remove(v);
    }

    public ArrayList<AbstractVoiture> getListe() {
        return liste;
    }

    public void afficherListe() {
        for(AbstractVoiture v: liste) {
            System.out.printf("matricule: %s | marque: %s | num chassis: %s\n", v.getMatricule(), v.getMarque(), v.getNumChassis());
        }
    }


    public AbstractVoiture getVoitureByMatricule(String matricule) {
        for(AbstractVoiture v: liste) {
            if(v.getMatricule().equals(matricule)) {
                return v;
            }
        }

        return null;
    }


    public void afficherVoiture(String matricule) {
        AbstractVoiture v = this.getVoitureByMatricule(matricule);
        if(v == null) {
            System.out.println("aucune voiture avec ce matricule");
        } else {
            System.out.printf("matricule: %s | marque: %s | num chassis: %s | prix à payer: %s\n", v.getMatricule(), v.getMarque(), v.getNumChassis(), v.getCout());
        }
    }


    public void edit(AbstractVoiture old, AbstractVoiture newOne) {
        liste.remove(old);
        liste.add(newOne);
    }



}
