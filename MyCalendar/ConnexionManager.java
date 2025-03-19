import java.util.Scanner;

public class ConnexionManager
{
    public ConnexionManager(){}

    public Utilisateur connecter(ListeUtilisateur utilisateurs, Scanner scanner)
    {
        Utilisateur res;
        String name;
        String pwd;
        while (res == null)
        {
            System.out.print("Nom d'utilisateur : ");
            name = scanner.nextLine();
            if (utilisateurs.contains(name))
            {
                System.out.println("Mot de passe : ");
                pwd = scanner.nextLine();
                res = utilisateurs.connect(name, pwd);
            }
            else
            {
                System.out.println("Cet utilisateur n'existe pas.\n Voulez-vous le créer ? [O/N]");
                String rep = scanner.nextLine();
                if (rep.toLowerCase().equals("o"))
                {
                    System.out.print("Mot de passe: ");
                    pwd = scanner.nextLine();
                    System.out.print("Répéter mot de passe: ");

                    if (scanner.nextLine().equals(pwd)) {
                        Utilisateur res = new Utilisateur(name, pwd);
                        boolean added = utilisateurs.ajouterUtilisateur(res);
                        if (!added) res = null;
                    } else {
                        System.out.println("Les mots de passes ne correspondent pas...");
                        name = null;
                    }
                    break;

                }
                else if (rep.toLowerCase().equals("n"))
                {
                    System.out.println("Ok pas de soucis, veuillez retenter de vous connecter.");
                }
                else
                {
                    System.out.println("Réponse inattendue, veuillez retenter de vous connecter.");
                }
            }
        }
        return res;
    }
}
