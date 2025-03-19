import java.util.ArrayList;

public class ListeUtilisateur
{
    private ArrayList<Utilisateur> utilisateurs;
    private Utilisateur deny = new Utilisateur("deny", "osef");

    public ListeUtilisateur()
    {
    }

    public Utilisateur connect(String nom, String pwd)
    {
        Utilisateur ret = null;
        if (nom.equals("deny"))
        {
            ret = this.deny;
        }
        else
        {
            for (Utilisateur u : utilisateurs)
            {
                if (nom.equals(u.getName()) && u.checkPwd(pwd))
                {
                    ret = u;
                    break;
                }
                else
                {
                    ret = this.deny;
                    break;
                }
            }
        }
        return ret;
    }

    public boolean contains(String n)
    {
        for (Utilisateur u : utilisateurs)
        {
            if (u.getName().equals(n)) return true;
        }
        return false;
    }

    public boolean ajouterUtilisateur(Utilisateur u)
    {
        if (u.conform())
        {
            this.utilisateurs.add(u);
            return true;
        }
        else
        {
            return false;
        }
    }
}
