import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AbstractVoiture voiture = new VoitureSimple("sofian","12.3256","458.56",1200000);
        voiture = new VoitureColor(voiture,VoitureColor.BLANC);
        voiture = new VoitureToit(voiture,VoitureToit.DIAPORAMA);
        voiture = new VoitureJante(voiture,VoitureJante.ALLIAGE);


        StockageVoiture instance = StockageVoiture.getInstance();
      instance.add(voiture);
      //  List<AbstractVoiture> list = new ArrayList<AbstractVoiture>();
      //  list.add(voiture);
       System.out.println(instance.getListe().get(0).getMarque());
    }
}