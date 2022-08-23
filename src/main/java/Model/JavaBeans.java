package Model;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {
	
	/** The id. */
	private int id;
	
	/** The nome. */
	private String nome;
	
	/** The tel. */
	private String tel;
	
	/** The email. */
	private String email;
	
	/**
	 * Instantiates a new java beans.
	 */
	public JavaBeans() {
		super();
	}
	
	/**
	 * Instantiates a new java beans.
	 *
	 * @param id the id
	 * @param nome the nome
	 * @param tel the tel
	 * @param email the email
	 */
	public JavaBeans(int id, String nome, String tel, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.tel = tel;
		this.email = email;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Gets the tel.
	 *
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Sets the tel.
	 *
	 * @param tel the new tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
