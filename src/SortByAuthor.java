//Mehdi NAOUI
//B3 + L
//TP - Généricité
//Groupe b
//Class SortByAuthor
// 10/2025


import java.util.Comparator;

public class SortByAuthor implements Comparator<Livre> {

    //Ici j'utilise un manière différente que dans mon comparateur SortByAscendentYear.
    //Je place mon type livre directement dans l'opérateur en diamant collé au "implements Comparator"
    //Plus besoin de caster.

    @Override
        public int compare(Livre l1, Livre l2) {

        if (l1.getAuteur() != l2.getAuteur()) {

            return String.CASE_INSENSITIVE_ORDER.compare(l1.getAuteur(), l2.getAuteur());

        } else {
            return String.CASE_INSENSITIVE_ORDER.compare(l1.getTitre(), l2.getTitre());


        }

    }

}
