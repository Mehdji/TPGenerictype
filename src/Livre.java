//Mehdi NAOUI
//B3 + L
//TP - Généricité
//Groupe b
//Class Livre
// 10/2025
public class Livre extends Media implements Empruntable{
    private int nbPages;
    private String auteur;

    public Livre(String titre,int anneePublication, String auteur,int nbPages) {
        super(titre,anneePublication);
        this.auteur = auteur;
        this.nbPages = nbPages;
    }

    public String getAuteur(){
        return auteur;
    }

    public String getDescription(){
        return "Livre de " + auteur + " a " + nbPages + " pages";
    }

    public boolean emprunter(){
        return true;
    }


}
