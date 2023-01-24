import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        //AbstractVoiture voiture = new VoitureSimple("sofian","12.3256","458.56",1200000);
        //voiture = new VoitureColor(voiture,VoitureColor.BLANC);
       //( (VoitureDecore) voiture).setStrategy(new ParFacilite());
        //voiture = new VoitureToit(voiture,VoitureToit.DIAPORAMA);
        //voiture = new VoitureJante(voiture,VoitureJante.ALLIAGE);

        //System.out.println(voiture.getCout());

        boolean stop = false;
        Scanner input = new Scanner(System.in);
        StockageVoiture stockageVoiture = StockageVoiture.getInstance();
        int choix;
        int choixOption, choix3;
        AbstractVoiture voiture = null;
        AbstractVoiture oldVoiture = null;
        String marque, matricule, numChassis;
        int prixBase = 1200000;
        ParCash cash = new ParCash();
        ParFacilite facilite = new ParFacilite();
        PayStrategy strategy;

        int moteur, couleur, toit, jante;

        System.out.println("Bienvenu dans le système de gestion de voiture");

        while(stop == false) {

            System.out.println("1-ajouter voiture");
            System.out.println("2-afficher voiture");
            System.out.println("3-ajouter option");
            System.out.println("4-quitter");
            System.out.print("entrer votre choix:");

            choix = input.nextInt();
            switch(choix) {
                case 1:
                    System.out.println("entrer marque:");
                    input.nextLine();
                    marque = input.nextLine();

                    System.out.println("entrer numero de chassis:");
                    numChassis = input.nextLine();

                    System.out.println("entrer matricule:");
                    matricule = input.nextLine();

                    voiture = new VoitureSimple(numChassis, matricule, marque, prixBase);
                    stockageVoiture.add(voiture);
                    System.out.println("la voiture a été ajoutée avec succès\n\n");
                    break;

                case 2:
                    System.out.println("entrer matricule:");
                    input.nextLine();
                    matricule = input.nextLine();

                    stockageVoiture.afficherVoiture(matricule);
                    break;

                case 3:
                    System.out.println("1-ajouter moteur");
                    System.out.println("2-ajouter toit");
                    System.out.println("3-ajouter jantes");
                    System.out.println("4-ajouter couleur");
                    System.out.print("entrer votre choix:");
                    choixOption = input.nextInt();

                    System.out.println("entrer votre methode de paiement");
                    System.out.println("1-cash");
                    System.out.println("2-facilité");
                    System.out.println("entrer votre methode:");
                    if(input.nextInt() == 1) {
                        strategy = cash;
                    } else {
                        strategy = facilite;
                    }

                    switch(choixOption) {
                        case 1:
                            System.out.println("1- 1.6 essance");
                            System.out.println("2- 1.5 DCI");
                            System.out.println("3- 2.0 essance");
                            System.out.println("4- 2.0 DCI");
                            System.out.println("entrer votre choix:");
                            choix3 = input.nextInt();

                            if(choix3 == 1) {
                                moteur = VoitureMoteur.M1_6_ESSANCE;
                            } else if (choix3 == 2) {
                                moteur = VoitureMoteur.M1_5_DCI;
                            } else if (choix3 == 3) {
                                moteur = VoitureMoteur.M2_0_ESSANCE;
                            } else {
                                moteur = VoitureMoteur.M2_0_DCI;
                            }

                            System.out.println("entrer matricule:");
                            input.nextLine();
                            matricule = input.nextLine();

                            oldVoiture = stockageVoiture.getVoitureByMatricule(matricule);

                            voiture = new VoitureMoteur(oldVoiture, moteur);
                            ((VoitureDecore) voiture).setStrategy(strategy);
                            stockageVoiture.edit(oldVoiture, voiture);
                            //System.out.printf("moteur %d , prix: %d \n", moteur, voiture.getCout());
                            break;

                        case 2:
                            System.out.println("1- normal");
                            System.out.println("2- diaporama");
                            System.out.println("entrer votre choix:");
                            choix3 = input.nextInt();

                            if(choix3 == 1) {
                                toit = VoitureToit.NORMAL;
                            } else{
                                toit = VoitureToit.DIAPORAMA;
                            }
                            System.out.println("entrer matricule:");
                            input.nextLine();
                            matricule = input.nextLine();

                            oldVoiture = stockageVoiture.getVoitureByMatricule(matricule);
                            voiture = new VoitureToit(oldVoiture, toit);
                            ((VoitureDecore) voiture).setStrategy(strategy);
                            stockageVoiture.edit(oldVoiture, voiture);
                            break;


                        case 3:
                            System.out.println("1- jante tole");
                            System.out.println("2- jante alliage");
                            System.out.println("3- jante alluminium");
                            System.out.println("entrer votre choix:");
                            choix3 = input.nextInt();

                            if(choix3 == 1) {
                                jante = VoitureJante.TOLE;
                            } else if(choix3 == 2){
                                jante = VoitureJante.ALLIAGE;
                            }else {
                                jante = VoitureJante.ALLUMINIUM;
                            }
                            System.out.println("entrer matricule:");
                            input.nextLine();
                            matricule = input.nextLine();

                            oldVoiture = stockageVoiture.getVoitureByMatricule(matricule);
                            voiture = new VoitureJante(oldVoiture, jante);
                            ((VoitureDecore) voiture).setStrategy(strategy);
                            stockageVoiture.edit(oldVoiture, voiture);
                            break;


                        case 4:
                            System.out.println("1- rouge");
                            System.out.println("2- noire");
                            System.out.println("3- grise");
                            System.out.println("3- blanche");
                            System.out.println("entrer votre choix:");
                            choix3 = input.nextInt();

                            if(choix3 == 1) {
                                couleur = VoitureColor.ROUGE;
                            } else if(choix3 == 2){
                                couleur = VoitureColor.NOIR;
                            }else if(choix3 == 3) {
                                couleur = VoitureColor.GRIS;
                            }else {
                                couleur = VoitureColor.BLANC;
                            }
                            System.out.println("entrer matricule:");
                            input.nextLine();
                            matricule = input.nextLine();

                            oldVoiture = stockageVoiture.getVoitureByMatricule(matricule);
                            voiture = new VoitureColor(oldVoiture, couleur);
                            ((VoitureDecore) voiture).setStrategy(strategy);
                            stockageVoiture.edit(oldVoiture, voiture);
                            break;

                    }
                    break;


                case 4:
                    stop = true;
                    break;

            }




        }
    }
}