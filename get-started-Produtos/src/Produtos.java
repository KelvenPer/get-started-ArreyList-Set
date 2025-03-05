import java.util.Objects;

public class Produtos {
    private int codigo;
    private String nome;

    public Produtos() {
    }

    public Produtos(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
        Produtos produtos = (Produtos) obj;
        return codigo == produtos.codigo;
    }

    @Override
    public int hashCode(){
        return Objects.hash(codigo);
    }

}
