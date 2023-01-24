public class VoitureDecore extends AbstractVoiture{
    private AbstractVoiture voiture;
    private  int prixAjouter;
    public VoitureDecore(AbstractVoiture voiture,int prixAjouter){
        super(voiture.numChassis, voiture.matricule, voiture.marque, voiture.prixBase);
        this.voiture = voiture;
        this.prixAjouter=prixAjouter;
    }

    @Override
    public int getCout(){
        return this.prixAjouter + this.voiture.getCout();
    }
}
