import java.io.*;
import java.util.ArrayList;

public class StockageVoiture {
    private ArrayList<AbstractVoiture> liste;
    private static StockageVoiture instance = new StockageVoiture();

    private StockageVoiture() {
        this.liste = new ArrayList<AbstractVoiture>();
    }

    public static StockageVoiture getInstance() {
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

    public AbstractVoiture getVoitureByMatricule(String Matricule) {
        for(AbstractVoiture v: liste) {
            if(v.getMatricule().equals(Matricule)) {
                return v;
            }
        }

        return null;
    }

    public void sauvegarder() {
        try {
            FileOutputStream f = new FileOutputStream("save.bin");
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(this.liste);
        } catch (IOException e) {
            System.out.println("Erreur dans la sauvegarde de fichier");
        }
    }

    private void lireDonees() {
        try {
            FileInputStream f = new FileInputStream("save.bin");
            ObjectInputStream o = new ObjectInputStream(f);
            this.liste = (ArrayList<AbstractVoiture>)o.readObject();
            o.close();
            f.close();
        } catch (Exception c) {
            System.out.println("Erreur dans la sauvegarde de fichier");
        }
    }
}
