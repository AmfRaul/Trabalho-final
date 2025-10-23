public abstract class Usuario {
    protected double id;
    protected String nome;
    protected int idade;
    protected String email;
    protected String perfil;


public Usuario(double id,String nome,int idade, String email) {
    this.id = id;
    this.nome = nome;
    this.idade = idade;
    this.email = email;
}


public double getId() { 
    return id; }
public String getNome() { 
    return nome; }
public int getIdade(){
    return idade;
}
public String getEmail() { 
    return email; }
public String getPerfil() { 
    return perfil; }
public void setPerfil(String p) { 
    this.perfil = p; }
}