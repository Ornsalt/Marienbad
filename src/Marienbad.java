
// Importe la classe Input depuis le paquet terminal.
import terminal.Input;

/**
 * Marienbad JcJ édition.
 * Une jeu de société qui appartient à la famille plus large des jeuxde Nim.
 * +---------------------------------------------------------------------------+
 * Comment jouer ?
 * +---------------------------------------------------------------------------+
 * Choisissez un nombre de joueurs entre 2 et 4 et leurs noms.
 * Choisissez une taille de plateau entre 3 ey 50.
 * Le Joueur qui saisie le dernier bâton à gagner (auto si la somme = 1).
 * +---------------------------------------------------------------------------+
 */
public final class Marienbad {

    /**
     * Pose à L'utillisateur une question et il doit répondre par Oui ou Non.
     * +-----------------------------------------------------------------------+
     * 
     * @param demande la String à afficher servant de requête à l'utillisateur.
     * @return un Booléen, true si Oui est saisie et false si Non est saisie.
     */
    public final static boolean confirmation(String demande) {
        String val = Input.getStr(demande + "[O/N] ");

        // Boucle en l'attente d'un réponse valide (Oui ou Non).
        while (!val.equals("O") && !val.equals("N")) {
            val = Input.getStr(demande + "[O/N] ");
        }
        // Renvoie vrais si Oui sinon renvoi faux.
        return ((val.equals("O")) ? true : false);
    }

    /**
     * Demande à l'utillisateur de saisir une valeure dans un intervale donné.
     * Il à une sécurité pour inverser les valeurs min et max si mal ordonné.
     * +-----------------------------------------------------------------------+
     * 
     * @param min     un Entier, la valeure minimum de l'intervale.
     * @param max     un Entier, la valeure maximum de l'intervale.
     * @param demande la String à afficher servant de requête à l'utillisateur.
     * @return un Entier, compris dans l'intervale [ min ; max ].
     */
    public final static int saisirIntervalle(int min, int max, String demande) {
        int val = min;

        // échange les valeures min et max si inversé
        if (min > max) {
            min = max;
            max = val;
        }
        // Boucle en l'attente d'un valeure compris dans [ min ; max ].
        do {
            val = (int) Input.getNbr(demande + "[" + min + "/" + max + "] ");
            if (val < min || val > max) {
                System.err.printf("%d n'est pas dans [%d : %d].", val, min, max);
            }
        } while (val < min || val > max);
        // renvoie la valeure.
        return (val);
    }

    /**
     * Demande aux utillisateurs de le nombre de joueur [2 : 4] et leurs nom.
     * +-----------------------------------------------------------------------+
     * 
     * @return un tableau de String.
     */
    public final static String[] definirJoueur() {
        int nbrJoueur = saisirIntervalle(2, 4, "Nombre de joueurs:\n");
        String[] joueur = new String[nbrJoueur];
        int i = 0; // index pour parcourir le tableau joueur.
        int j = 0; // index pour vérifier les valeures de joueur.

        // Sécurité en cas de probléme d'allocation mémoire.
        if (joueur != null) {
            // Boucle pour récupérer les noms.
            while (i < joueur.length) {
                joueur[i] = Input.getStr("[J" + (i + 1) + "] est ");
                // Vérifie la validité et unicité des noms (>= 3 char / non null).
                for (j = 1; i - j >= 0 && !joueur[i].equals(joueur[i - j]); j++)
                    ;
                i = (joueur[i].length() > 2 && i - j < 0) ? i + 1 : i;
            }
        }
        System.out.printf("TOUT LE MONDE EST LA !\n");
        return (joueur);
    }

    /**
     * Demande la taille de plateau de jeu et le rempli en conséquence.
     * +-----------------------------------------------------------------------+
     * 
     * @return un tableau d'Entier.
     */
    public final static int[] definirPlateau() {
        int taille = saisirIntervalle(3, 50, "Taille du plateau de jeu:\n");
        int[] plateau = new int[taille + 1];

        // Sécurité en cas de probléme d'allocation mémoire.
        if (plateau != null) {
            // Remplie le plateau.
            for (int i = 0; plateau != null && i < plateau.length - 1; i++) {
                plateau[i] = 1 + (i * 2);
                plateau[taille] += plateau[i];
            }
        }
        return (plateau);
    }

    /**
     * Affiche le plateau, le n° de ligne suivi par le nombre de batons.
     * +-----------------------------------------------------------------------+
     * 
     * @param plateau la plateau a afficher.
     */
    public final static void affichePlateau(int[] plateau) {
        System.out.println(""); // Passe une ligne pour aérer.
        // Affiche le conytenue du tableau (avec des batons).
        for (int i = 0; i < plateau.length - 1; i++) {
            System.out.print(i + " :"); // écrit le n° de ligne.
            // écrit le nombre de baton de la ligne.
            for (int j = 0; j < plateau[i]; j++) {
                System.out.print(" |");
            }
            System.out.println("");
        }
        System.out.println(""); // Passe une ligne pour aérer.
    }

    /**
     * Une méthode en charge l'interaction humain/machine en traitant les
     * entrées de l'utillisateur.
     * +-----------------------------------------------------------------------+
     * 
     * @param tour un entier qui indique le tour du joueur.
     * @param plat un tableau d'entier, contenant le tableau de jeu.
     * @return la ligne et le nombre de batons retiré.
     */
    public final static int[] humain(int tour, int[] plat) {
        int[] entre = { 0, 0 };

        for (boolean res = false; !res;) {
            entre[0] = saisirIntervalle(0, plat.length - 2, "[J" + tour + "] Ligne:\n");
            if (plat[entre[0]] == 0) {
                System.err.println("La ligne est vide !");
            } else {
                entre[1] = saisirIntervalle(1, plat[entre[0]], "[J" + tour + "] Prend:\n");
                res = confirmation("Prendre " + entre[1] + " batons a la ligne " + entre[0] + " ?\n");
            }
        }
        return (entre);
    }

    /**
     * Une méthode en charge du joueur géré par l'Ordinateur.
     * Elle est basé sur la somme de Nim.
     * +-----------------------------------------------------------------------+
     * 
     * @param tour    un entier qui indique le tour du joueur.
     * @param plateau un tableau d'entier, contenant le tableau de jeu.
     * @return la ligne et le nombre de batons retiré.
     */
    public final static int[] aiOrdis(int tour, int[] plateau) {
        int tampon = (plateau[plateau.length - 1] - 1) % (100 + 1);
        int[] entre = { -1, tampon < 1 ? 2 : tampon };

        for (int i = plateau.length - 2; entre[0] == -1; i--) {
            if (i == -1) {
                i = plateau.length - 2;
                entre[1] = (entre[1] - 2 < 1) ? 1 : entre[1] - 2;
            }
            if (plateau[i] >= entre[1]) {
                entre[0] = i;
            }
        }
        return (entre);
    }

    /**
     * Une méthode en charge de la gestion des tours de chaque joueurs.
     * Elle récupére leurs entrées et les gére en conséquances.
     * +-----------------------------------------------------------------------+
     * 
     * @param tour   un entier qui indique le tour du joueur.
     * @param plat   un tableau d'entier, contenant le tableau de jeu.
     * @param joueur un tableau de string, contenant les noms des joueurs.
     * @return le numéro du prochain joueur.
     */
    public final static int joueur(int tour, int[] plat, String[] joueur) {
        int[] entre = new int[2];

        // Annonce le joueur.
        System.out.println("Au tour de J" + tour + ":" + joueur[tour - 1] + "!");
        // Si le joueur est un Ordinateur ou Humain.
        if (joueur[tour - 1].equals("Ordis")) {
            entre = aiOrdis(tour, plat);
        } else {
            entre = humain(tour, plat);
        }
        // Résume l'action du joueur.
        System.out.println("J" + tour + ":" + joueur[tour - 1] + " Prendre " + entre[1] +
                " batons a la ligne " + entre[0] + " !\n");
        plat[entre[0]] -= entre[1]; // retire le(s) baton(s) de la ligne
        plat[plat.length - 1] -= entre[1]; // retrire le(s) baton(s) de la pile.
        // passe ou joueur suivant sauf si victoire.
        if (plat[plat.length - 1] > 0)
            tour = (tour >= joueur.length) ? 1 : tour + 1;
        return (tour);
    }

    /**
     * Boucle Principale du jeu de Marienbad.
     * +-----------------------------------------------------------------------+
     * 
     * @param args les paramétres envoyer aux démarages (non utilisé).
     */
    public static void main(String[] args) {
        String[] joueur = definirJoueur();
        int[] plateau = definirPlateau();
        int tour = 1;

        // Sécurité en cas de probléme d'allocation mémoire.
        if (joueur != null && plateau != null) {
            // Boucle de jeu.
            while (plateau[plateau.length - 1] > 1) {
                affichePlateau(plateau);
                tour = joueur(tour, plateau, joueur);
            }
            // Victoire.
            System.out.printf("Victoir pour J%d:%s!", tour, joueur[tour - 1]);
        }
    }
}