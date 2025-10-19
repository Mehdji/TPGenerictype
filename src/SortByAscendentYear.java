//Mehdi NAOUI
//B3 + L
//Groupe b


//Mehdi NAOUI
//B3 + L
//TP - Généricité
//Groupe b
//Class SortByAscendentYear
// 10/2025

import java.util.Comparator;

class SortByAscendentYear implements Comparator {


    @Override
    public int compare(Object o1, Object o2) {

        // Ici je cast Media afin de m'assurer que le compilateur
        // le condidére l'objet en arg comme un media

        Media m1 = (Media) o1;
        Media m2 = (Media) o2;


        //Comparaison des objets, en l'occurence la date de publication
        // et ensuite le titre pour ce comparateur.
        if (m1.getAnneePublication() != m2.getAnneePublication()) {
            /*
            if (m1.getAnneePublication() < m2.getAnneePublication()) return -1;
            if (m1.getAnneePublication() > m2.getAnneePublication()) return 1;

             */
            return Integer.compare(m1.getAnneePublication(), m2.getAnneePublication());
        }else {
                /*
                if (m1.getTitre().charAt(0) < m2.getTitre().charAt(0)) return -1;
                if (m1.getTitre().charAt(0) > m2.getTitre().charAt(0)) return 1;
                */

               return String.CASE_INSENSITIVE_ORDER.compare(m1.getTitre(), m2.getTitre());
            }



    }
}

