//Mehdi NAOUI
//B3 + L
//TP - Généricité
//Groupe b
//Class Main - Point d'entrée
// 10/2025

import java.util.*;

import java.util.function.Predicate;

import java.util.stream.Stream;
import java.util.stream.Collectors;

import static java.util.Collections.copy;

public class Main {

    public static <T> void afficherListe(List<T> liste){
        //affiche la liste en argument
        System.out.println("\nListe de média:\n");
        for(T item : liste){
            System.out.println(item.toString());
        }
    }


    public static <T> List<T> filtrer(Collection<T> collection, Predicate<T> critere){
        //filtre la liste en argument avec le prédicat passé en second argument.
        return collection.stream().filter(critere).collect(Collectors.toList());
    }

    /*
    public int compare(Media media1 , Media media2 ){
        int value = Integer.compare(media1.getAnneePublication(), media2.getAnneePublication());
        if (value !=0) return value;
        return 0;
    }
    */

    //Méthode générique pour copier les éléments sans perdre le type
    public static <T>void  copieCollection(Collection<T> source,Collection<T> destination){
        destination.addAll(source);

    }



	public static void main(String[] args)
	{
        //Etape 3 - Collections

        //--Structures stoquants medias, membres et Emprunts--
        List<Media> Medias = new ArrayList<Media>();
        Set<Membre> Membres = new HashSet<Membre>();
        HashMap<Membre,List<Media>> Emprunts = new HashMap<>();

        //--Créations de membres--
        Membre m1 = new Membre("Dupont", 1);
        Membre m2 = new Membre("Naoui", 2);
        Membre m3 = new Membre("Bernard", 3);
        Membre m4 = new Membre("Martin", 4);
        Membre m5 = new Membre("Albert", 5);

        //--Ajout des membres dans le set Membres--
        Membres.add(m1);
        Membres.add(m2);
        Membres.add(m3);
        Membres.add(m4);
        Membres.add(m5);

        //Créations des medias

        // --- Livres ---
        Livre l1 = new Livre("Le Petit Prince", 1943, "Antoine de Saint-Exupéry", 96);
        Livre l2 = new Livre("L'Étranger", 1942, "Albert Camus", 185);
        Livre l3 = new Livre("Harry Potter à l'école des sorciers", 1942, "J.K. Rowling", 309);

        // --- CDs ---
        CD c1 = new CD("Thriller", 1982, "Michael Jackson", 42);
        CD c2 = new CD("Back in Black", 1980, "AC/DC", 41);
        CD c3 = new CD("Random Access Memories", 2013, "Daft Punk", 74);

        //--- Ajout des médias dans la list Medias ---
        Medias.add(l1);
        Medias.add(l2);
        Medias.add(l3);

        Medias.add(c1);
        Medias.add(c2);
        Medias.add(c3);



        //Création emprunts

        m1.emprunterMedia(l1);
        m1.emprunterMedia(c1);
        m1.emprunterMedia(l2);

        m2.emprunterMedia(l2);
        m2.emprunterMedia(c2);

        m3.emprunterMedia(l3);
        m3.emprunterMedia(c3);

        //Affiche media emprunter par m3
        m3.listMediaEmpruntes();

        //Ajout des emprunts dans le dictionnaire(hashmap) Emprunts
        for(Membre m : Membres){
            Emprunts.put(m, m.getMediasEmpruntes());
        }

        afficherListe(Medias);

        //Etape 4 - Méthode généricité

        // --- Création des prédicats pour utiliser dans le filtre

        Predicate<Media> estAvant2010 = m -> m.getAnneePublication() < 2010;
        Predicate<Membre> estCommenceParA = m -> m.getNom().matches("(?i)^a.*");

        // --- Retourne les medias paru avant 2010
        System.out.println(filtrer(Medias, estAvant2010));

        // --- Retourne les medias qui commence par un A
        System.out.println(filtrer(Membres, estCommenceParA));

        //Etape 5 - Utilisation du comparateur



        //-- Création de l'objet comparateur en utilisant la class SortByAscendantYear
        System.out.println("Comparator normal\n");
        Comparator MyComparator = new SortByAscendentYear();



        System.out.println("Avant le trie: ");

        for (Media m : Medias){
            System.out.println(m.toString());
        }

        System.out.println("\n");

        System.out.println("Aprés le trie: ");

        Collections.sort(Medias,MyComparator);

        for (Media m : Medias){
            System.out.println(m.toString());
        };


        //-- Création de l'objet comparateur en utilisant la class SortByAscendantYearBook

        //TODO Ici le comparateur ne fonctionne pas avec la lise MEDIAS classique car il y a des CD.
        /*
        System.out.println("Comparator Book\n");
        Comparator MyComparator2 = new SortByAuthor();



        System.out.println("Avant le trie: ");

        for (Media m : Medias){
            System.out.println(m.toString());
        }

        System.out.println("\n");

        System.out.println("Aprés le trie: ");

        Collections.sort(Medias,MyComparator2);

        for (Media m : Medias){
            System.out.println(m.toString());
        };
        */

        //Etape 6 - défi avancé

        //--Copie les éléments sans perdre le type
        List <Media> medias2 = new ArrayList();
        copieCollection(Medias,medias2);
        System.out.println("Voici la copie de la liste media:");
        System.out.println(medias2 + "\n");

        //Vérification des types dans la liste copié.
        System.out.println("Vérification des types:\n");
        for(Media m: medias2){
            System.out.println("\"" + m.getTitre() + "\"" + " est de la classe " + "\"" + m.getClass() +  "\"" + "\n");
        }

        //--Media empruntés sans doublons
        Set<Media> setMedias = new HashSet();

        for(List<Media> m : Emprunts.values()){
            m.forEach(e->setMedias.add(e));
        }
        System.out.println("Le setMedias dépourvue le doublons: " + setMedias + "\n");

        //--Filtrage polymorphe : Utilisez filtrer() pour obtenir uniquement les objets de type Livre (ex : m -> m instanceof Livre).

        Predicate<Media> estUnLivre = m -> m instanceof Livre;

        System.out.println("Voici la liste média filtré pour n'afficher que les livres: " + filtrer(setMedias,estUnLivre));

        //Etape 7 - Bonus
        System.out.println("\nVoici l'affichage des descriptions via la méthode afficherDetail(): ");
        for (Media m : Medias){
            System.out.println(m.afficherDetail());
        }
    }




}
