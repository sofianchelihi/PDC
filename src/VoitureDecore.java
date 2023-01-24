public class VoitureDecore extends AbstractVoiture{
    private AbstractVoiture voiture;
    private  int prixAjouter;
    private PayStrategy strategy;
    public VoitureDecore(AbstractVoiture voiture,int prixAjouter){
        super(voiture.numChassis, voiture.matricule, voiture.marque, voiture.prixBase);
        this.voiture = voiture;
        this.prixAjouter=prixAjouter;
    }

    public int getPrixAjouter() {
        return prixAjouter;
    }

    public void setStrategy(PayStrategy s) {
        this.strategy = s;
    }

    @Override
    public int getCout(){
        return strategy.calculerCout(this);
    }
}
