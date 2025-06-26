package BLL;



public class Usuario extends Persona{

	//Atributos
		protected String id;
		protected String pass;
		
		//Constructor
		public Usuario (String nobmre, String apellido, String id, String pass) {
			super(nobmre, apellido);
			this.id = id;
			this.pass = pass;
		}
		
		public Usuario() {}
		
		//Setters & Getters
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}
		
		
		
		//To String
		@Override
		public String toString() {
			return "Usuario [nobmre=" + nombre + ", apellido=" + apellido + ", id=" + id + ", pass=" + pass + "]";
		}

}
