public class VoitureSimple extends AbstractVoiture{


    public VoitureSimple(String numChassis,String matricule,String marque ,int prixBase){
        this.numChassis=numChassis;
        this.marque=marque;
        this.matricule=matricule;
        this.prixBase=prixBase;

    }
    public  int getCout(){
        return this.getPrixBase();
    }
}
