package Model;

public class Utilisateur {
	private int id;
    private String email;
    private String nom;
    private String prenom;
    private long codePostale;
    private String ville;
	private String tele;
	private String motPasse;
	
	public Utilisateur(String email, String nom, String prenom, String adresse, long codePostale, String ville,
			String tele, String motPasse) {
		super();
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		
		this.codePostale = codePostale;
		this.ville = ville;
		this.tele = tele;
		this.motPasse = motPasse;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public long getCodePostale() {
		return codePostale;
	}
	public void setCodePostale(long codePostale) {
		this.codePostale = codePostale;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return motPasse;
	}
	public void setMdp(String mdp) {
		this.motPasse = mdp;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Utilisateur(String email, String mdp, String nom) {
		super();
		this.email = email;
		this.motPasse = mdp;
		this.nom = nom;
	}
	public Utilisateur() {
		super();
	}
	

}
