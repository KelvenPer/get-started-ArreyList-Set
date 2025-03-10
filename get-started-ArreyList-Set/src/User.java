import java.util.Objects;

public class User {
    private String name; 
    private int code;

    public User(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    @Override
    public String toString(){
        return String.format("{'codigo: %s, Name: %s'}", this.code, this.name);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        User user = (User) obj;
        return this.code == user.code && Objects.equals(this.name, user.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(code, name);
    }

    
}
