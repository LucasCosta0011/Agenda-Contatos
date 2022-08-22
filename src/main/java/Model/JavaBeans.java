package Model;

public class JavaBeans {
	private int id;
	private String nome;
	private String tel;
	private String email;
	
	public JavaBeans() {
		super();
	}
	
	public JavaBeans(int id, String nome, String tel, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.tel = tel;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public String getTel() {
		return tel;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
