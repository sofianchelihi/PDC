public class VoitureSimple extends AbstractVoiture{


    public VoitureSimple(String numChassis,String matricule,String marque ,int prixBase){
        super(numChassis,matricule,marque,prixBase);
    }
    public  int getCout(){
        return this.getPrixBase();
    }
}
