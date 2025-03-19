public class Utilisateur
{
    public final String DENY = "deny";
    String name;
    String password;

    public Utilisateur(String name, String password)
    {
        this.password = password;
        this.name = name;
    }

    public boolean checkPwd(String pwd)
    {
        return (pwd.equals(this.password));
    }

    public boolean conform()
    {
        if (this.password.length() >6 && !name.equals(DENY)) return true;
        else return false;
    }

    public String getName()
    {
        return name;
    }
}
