import java.util.Objects;

public class Users {
    private int id;
    private String nome;

    public Users() {
    }

    public Users(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Users usuario = (Users) obj;
        return id == usuario.id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
