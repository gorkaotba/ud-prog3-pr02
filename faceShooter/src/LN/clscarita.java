package LN;


public class clscarita {


	protected String nombre = ""; //El nombre que va a tener cada carita
	protected double posX;  // Posición en X (horizontal)
	protected double posY;  // Posición en Y (vertical)
	protected double velocidad;  // Velocidad en la que se va a mover la carita, dependerá del nivel
	
	
	
	public clscarita(double posX, double posY, double velocidad, String nombre) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.velocidad = velocidad;
		this.nombre = nombre;
	}

	public void setFuncion(){
	
	}
	
	public void desaparecerCarita(){
		
	}
	
	public void disparo(){
		
	}

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public double getPosX() {
		return posX;
	}



	public void setPosX(double posX) {
		this.posX = posX;
	}



	public double getPosY() {
		return posY;
	}



	public void setPosY(double posY) {
		this.posY = posY;
	}



	public double getVelocidad() {
		return velocidad;
	}



	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	
	
	
	
	
}
