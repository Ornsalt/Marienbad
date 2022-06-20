/**
 * It's a class that represents a scenario of the game Marienbad
 */
public class ScenarioMarienbad {
    /**
     * teste un appel de la Methode confirmation.
     * +-----------------------------------------------------------------------+
     * 
     * @param demande la String à afficher servant de requête à l'utillisateur.
     * @param res     Booléen, resultat attendu.
     */
    private static void testCasConfirmation(String demande, Boolean res) {
        boolean resExec = Marienbad.confirmation(demande);

        System.out.printf("confirmation(\" %s + \") \t=  %b\t : ", demande, res);
        if (resExec == res) {
            System.out.println("OK");
        } else {
            System.err.println("ERREUR");
        }
    }

    /**
     * Teste la méthode confirmation().
     */
    private static void testConfirmation() {
        System.out.println("\n*** testConfirmation()\n/!\\ TESTES HUMAIN /!\\\n");
        testCasConfirmation("Ecrivez \"O\".", true);
        testCasConfirmation("Ecrivez \"N\".", false);
        testCasConfirmation("Ecrivez n'importe quoi, puit \"O\" pour sortir.", true);
    }

    /**
     * teste un appel de la Methode saisirIntervalle.
     * +-----------------------------------------------------------------------+
     * 
     * @param min     un Entier, la valeure minimum de l'intervale.
     * @param max     un Entier, la valeure maximum de l'intervale.
     * @param demande la String à afficher servant de requête à l'utillisateur.
     * @param res     un Entier, resultat attendu.
     */
    private static void testCasSaisirIntervalle(int min, int max, String demande, int res) {
        int resExec = Marienbad.saisirIntervalle(min, max, demande);

        System.out.printf("saidirIntervalle(\"%d, %d, %s, %d\") \t= %s \t : ", min, max, demande, res);
        if (resExec == res) {
            System.out.printf("OK\n");
        } else {
            System.err.printf("ERREUR\n");
        }
    }

    /**
     * Teste la méthode saisirIntervalle().
     */
    private static void testSaisirIntervalle() {
        System.out.printf("\n*** testSaisirIntervalle()\n/!\\ TESTES HUMAIN /!\\\n");
        testCasSaisirIntervalle(0, 9, "Ecrivez 5. ", 5);
        testCasSaisirIntervalle(9, 0, "Ecrivez 5. ", 5);
        testCasSaisirIntervalle(8, 8, "Ecrivez n'importe quoi, puit 8 pour sortir. ", 8);
    }

    /**
     * teste un appel de la Methode definirJoueur.
     * +-----------------------------------------------------------------------+
     * 
     * @param demande la String à afficher servant de requête à l'utillisateur.
     * @param res     un tableau d'Entier, resultat attendu.
     */
    private final static void testCasDefinirJoueur(String demande, String[] res) {
        System.out.println(demande);
        String[] resExec = Marienbad.definirJoueur();
        boolean ver = true;

        System.out.print("definirJoueur(\"\") \t= {");
        if (res != null) {
            for (int i = 0; i < res.length; i++) {
                if (i < res.length - 1) {
                    System.out.print(res[i] + ", ");
                } else {
                    System.out.print(res[i]);
                }
            }
        }
        System.out.print("}\t : ");
        for (int i = 0; i < res.length && ver; i++) {
            if (!res[i].equals(resExec[i])) {
                ver = false;
            }
        }
        if (ver) {
            System.out.println("OK");
        } else {
            System.err.println("ERREUR");
        }
    }

    /**
     * Teste la méthode definirJoueur().
     */
    private final static void testDefinirJoueur() {
        String[] j1 = { "Axolot", "Pangolin" };
        String[] j2 = { "Jotaro", "Dio", "POLNAREFF", "Joseph" };

        System.out.println("\n*** testDefinirJoueur()");
        System.out.println("/!\\ TESTES HUMAIN /!\\");
        testCasDefinirJoueur("Saisir 2, " + j1[0] + ", " + j1[1] + ".", j1);
        testCasDefinirJoueur("Saisir 2, " + j1[0] + ", 00, " + j1[0] + ", " + j1[1] + ".",
                j1);
        testCasDefinirJoueur("Saisir 4, " + j2[0] + ", " + j2[1] + ", " + j2[2] + ", " +
                j2[3] + ".", j2);
    }

    /**
     * teste un appel de la Methode definirPlateau.
     * +-----------------------------------------------------------------------+
     * 
     * @param demande la String à afficher servant de requête à l'utillisateur.
     * @param res     un tableau d'Entier, resultat attendu.
     */
    private final static void testCasDefinirPlateau(String demande, int[] res) {
        System.out.println(demande);
        int[] resExec = Marienbad.definirPlateau();
        boolean ver = true;

        System.out.print("DefinirPlateau(\"\") \t= {");
        if (res != null) {
            for (int i = 0; i < res.length; i++) {
                if (i < res.length - 1) {
                    System.out.print(res[i] + ", ");
                } else {
                    System.out.print(res[i]);
                }
            }
        }
        System.out.print("}\t : ");
        for (int i = 0; i < res.length && ver; i++) {
            if (res[i] != resExec[i]) {
                ver = false;
            }
        }
        if (ver) {
            System.out.println("OK");
        } else {
            System.err.println("ERREUR");
        }
    }

    /**
     * Teste la méthode DefinirPlateau().
     */
    private final static void testDefinirPlateau() {
        int[] p1 = { 1, 3, 5, 7, 16 };
        int[] p2 = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 100 };

        System.out.println("\n*** testDefinirPlateau()");
        System.out.println("/!\\ TESTES HUMAIN /!\\");
        testCasDefinirPlateau("saisir 4.", p1);
        testCasDefinirPlateau("saisir 10.", p2);
    }

    /**
     * Teste la méthode affichePlateau().
     */
    private final static void testAffichePlateau() {
        int[] p1 = { 1, 3, 5, 7, 16 };
        int[] p2 = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 100 };

        System.out.println("\n*** testAffichePlateau()");
        System.out.println("/!\\ TESTES HUMAIN /!\\");
        Marienbad.affichePlateau(p1);
        Marienbad.affichePlateau(p2);
    }

    /**
     * teste un appel de la Methode humain.
     * +-----------------------------------------------------------------------+
     * 
     * @param t       un entier qui indique le tour du joueur.
     * @param p       un tableau d'entier, contenant le tableau de jeu.
     * @param demande la String à afficher servant de requête à l'utillisateur.
     * @param res     un tableau d'Entier, resultat attendu.
     */
    private final static void testCasHumain(int t, int[] p, String demande, int[] res) {
        System.out.println(demande);
        int[] resExec = Marienbad.humain(t, p);

        System.out.print("humain(\"" + t + ", {");
        if (p != null) {
            for (int i = 0; i < p.length; i++) {
                if (i < p.length - 1) {
                    System.out.print(p[i] + ", ");
                } else {
                    System.out.print(p[i]);
                }
            }
        }
        System.out.print("}\")\t= {");
        if (p != null) {
            for (int i = 0; i < res.length; i++) {
                if (i < res.length - 1) {
                    System.out.print(res[i] + ", ");
                } else {
                    System.out.print(res[i]);
                }
            }
        }
        System.out.print("}\t : ");
        if (res[0] == resExec[0] && res[1] == resExec[1]) {
            System.out.println("OK");
        } else {
            System.err.println("ERREUR");
        }
    }

    /**
     * Teste la méthode humain().
     */
    private final static void testHumain() {
        int[] p = { 1, 3, 5, 7, 16 };
        int[] res1 = { 0, 1 };
        int[] res2 = { 3, 7 };

        System.out.println("\n*** testHumain()");
        System.out.println("/!\\ TESTES HUMAIN /!\\");
        testCasHumain(1, p, "retirer 1 batons ligne 0.", res1);
        testCasHumain(2, p, "retirer 7 batons ligne 3.", res2);
    }

    /**
     * teste un appel de la Methode aiOrdis.
     * +-----------------------------------------------------------------------+
     * 
     * @param t   un entier qui indique le tour du joueur.
     * @param p   un tableau d'entier, contenant le tableau de jeu.
     * @param res un ableau d'Entier, resultat attendu.
     */
    private final static void testCasAiOrdis(int t, int[] p, int[] res) {
        int[] resExec = Marienbad.aiOrdis(t, p);

        System.out.print("aiOrdis(\"" + t + ", {");
        if (p != null) {
            for (int i = 0; i < p.length; i++) {
                if (i < p.length - 1) {
                    System.out.print(p[i] + ", ");
                } else {
                    System.out.print(p[i]);
                }
            }
        }
        System.out.print("}\")\t= {");
        if (p != null) {
            for (int i = 0; i < res.length; i++) {
                if (i < res.length - 1) {
                    System.out.print(res[i] + ", ");
                } else {
                    System.out.print(res[i]);
                }
            }
        }
        System.out.print("}\t : ");
        if (res[0] == resExec[0] && res[1] == resExec[1]) {
            System.out.println("OK");
        } else {
            System.err.println("ERREUR");
        }
    }

    /**
     * Teste la méthode aiOrdis().
     */
    private final static void testAiOrdis() {
        int[] p = { 1, 3, 5, 7, 9, 25 };
        int[] res1 = { 4, 8 };
        int[] res2 = { 3, 6 };

        System.out.println("\n*** aiOrdis()");
        testCasAiOrdis(1, p, res1);
        p[4] -= 8;
        p[5] -= 8;
        testCasAiOrdis(2, p, res2);
    }

    /**
     * teste un appel de la Methode joueur.
     * +-----------------------------------------------------------------------+
     * 
     * @param t       un entier qui indique le tour du joueur.
     * @param p       un tableau d'entier, contenant le tableau de jeu.
     * @param j       un tableau de string, contenant les noms des joueurs.
     * @param demande la String à afficher servant de requête à l'utillisateur.
     * @param res     un Entier, resultat attendu.
     */
    private final static void testCasJoueur(int t, int[] p, String[] j, String demande, int[] res) {
        System.out.println(demande);
        int resExec = Marienbad.joueur(t, p, j);

        System.out.print("joueur(\"" + t + ", {");
        if (p != null) {
            for (int i = 0; i < res.length; i++) {
                if (i < res.length - 1) {
                    System.out.print(res[i] + ", ");
                } else {
                    System.out.print(res[i]);
                }
            }
        }
        System.out.print("}, {" + j[0] + ", " + j[1] + ", " + j[2] + "}");
        System.out.print("\")\t= " + res[0] + "\t : ");
        if (res[0] == resExec && p[res[1]] == res[2] && res[3] == p[p.length - 1]) {
            System.out.println("OK");
        } else {
            System.err.println("ERREUR");
        }
    }

    /**
     * Teste la méthode joueur().
     */
    private final static void testJoueur() {
        String[] j = { "Axolot", "Pengolin", "Ordis" };
        int[] p = { 1, 3, 5, 7, 9, 25 };
        int[] res1 = { 2, 0, 0, 24 };
        int[] res2 = { 3, 3, 0, 17 };
        int[] res3 = { 1, 4, 1, 9 };

        System.out.println("\n*** testjoueur()");
        System.out.println("/!\\ TESTES HUMAIN /!\\");
        testCasJoueur(1, p, j, "retirer 1 batons ligne 0.", res1);
        testCasJoueur(2, p, j, "retirer 7 batons ligne 3.", res2);
        testCasJoueur(3, p, j, "", res3);
    }

    /**
     * A test function.
     * 
     * @param args the arguments send as parameters.
     */
    public static void main(String[] args) {
        testConfirmation();
        testSaisirIntervalle();
        testDefinirJoueur();
        testDefinirPlateau();
        testAffichePlateau();
        testHumain();
        testAiOrdis();
        testJoueur();
    }
}
