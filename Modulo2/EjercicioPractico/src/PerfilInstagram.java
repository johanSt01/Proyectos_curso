public class PerfilInstagram {

    // Atributos
    private String userName;
    private int seguidores;
    private String bio;

    // Constructores
    public PerfilInstagram() {
    }

    public PerfilInstagram(String userName, String bio) {
        this.userName = userName;
        this.seguidores = 0;
        this.bio = bio;
    }

    // Métodos getters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (userName != null && !userName.trim().isEmpty()) {
            this.userName = userName;
        } else {
            System.out.println("ERROR: -> El userName no puede estar vacío");
        }
    }

    public int getSeguidores() {
        return seguidores;
    }

    public void follow() {
        this.seguidores++;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "PerfilInstagram [userName=" + userName + ", seguidores=" + seguidores + ", bio=" + bio + "]";
    }

}
