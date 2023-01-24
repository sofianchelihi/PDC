public class ParCash implements PayStrategy{
    public int calculerCout(VoitureDecore v){
        return v.getPrixBase() + v.getPrixAjouter();
    }
}
