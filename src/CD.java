//Mehdi NAOUI
//B3 + L
//TP - Généricité
//Groupe b
//Class CD
// 10/2025

public class CD extends Media implements Empruntable{
    private String artiste;
    private int duree;

    public CD(String titre, int anneePublication,String artiste, int duree){
        super(titre,anneePublication);
        this.artiste = artiste;
        this.duree = duree;
    }

    public String getDescription(){
        return "CD de " + artiste + ",durée: " + duree;
    }

    public boolean emprunter(){
       return true;
    }


}


