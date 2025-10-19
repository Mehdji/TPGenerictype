//Mehdi NAOUI
//B3 + L
//TP - Généricité
//Groupe b
//Class Media
// 10/2025

public abstract class Media {
    protected String titre;
    private int anneePublication;

    public Media(String titre, int anneePublication){
        this.titre = titre;
        this.anneePublication = anneePublication;
    }

    public String getTitre(){
        return titre;
    }

    public int getAnneePublication(){
        return anneePublication;
    }

    public abstract String getDescription();

    public String afficherDetail(){
        return this.getDescription();
    }


    @Override
    public String toString() {
        return  titre + "(" + anneePublication + ")";
        }

}
