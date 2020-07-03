package Model;


	public class Articles {
		public int i=0;
		private int id;
		private String photo;
		private String description;
		private Double prix;
		private String autheur;

		
		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getLibelle() {
			return photo;
		}


		public void setLibelle(String libelle) {
			this.photo = libelle;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public String getAutheur() {
			return autheur;
		}


		public void setAutheur(String autheur) {
			this.autheur = autheur;
		}


		public Articles() {
		}
		
		
		public Double getPrix() {
			return prix;
		}
		public void setPrix(Double prix) {
			this.prix = prix;
		}
		
		

		public Articles(int id, double prix, String photo, String desc, String autheur) {
			this.id=id;
			this.prix=prix;
			this.photo=photo;
			this.description=desc;
			this.autheur=autheur;
			
		}


		public String getPhoto() {
			
	        return photo;
		}


		public void setPhoto(String photo) {
			this.photo = photo;
		}
		

	}



