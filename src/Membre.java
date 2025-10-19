//Mehdi NAOUI
//B3 + L
//TP - Généricité
//Groupe b
//Class Membre
// 10/2025

import java.util.ArrayList;
import java.util.List;

public class Membre {
    private String nom;
    private int id;
    private List<Media> mediasEmpruntes = new ArrayList<>();

    public Membre(String nom,int id){
        this.nom=nom;
        this.id=id;
    }

    public String getNom(){
        return nom;
    }

    public void emprunterMedia(Media media){
        mediasEmpruntes.add(media);
    }

    public List<Media> getMediasEmpruntes(){
        return mediasEmpruntes;
    }

    public void listMediaEmpruntes(){
        System.out.println("Liste medias empruntes");
            for(Media media:mediasEmpruntes){
                System.out.println( media.toString());
        }
    }
    @Override
    public String toString(){
        return "Membre {" + nom + ", " +id + "}";
    }
}
