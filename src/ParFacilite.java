public class ParFacilite implements PayStrategy{
    public  int calculerCout(VoitureDecore v){
        return (v.getPrixBase() + v.getPrixAjouter())/12;
    }

}
