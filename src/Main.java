import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AbstractVoiture voiture = new VoitureSimple("sofian","12.3256","458.56",1200000);
        voiture = new VoitureColor(voiture,VoitureColor.BLANC);
       ( (VoitureDecore) voiture).setStrategy(new ParFacilite());
        //voiture = new VoitureToit(voiture,VoitureToit.DIAPORAMA);
        //voiture = new VoitureJante(voiture,VoitureJante.ALLIAGE);

        System.out.println(voiture.getCout());
    }
}