package prog3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

/** Clase principal de minijuego de coche para Práctica 02 - Prog III
 * Ventana del minijuego.
 * @author Andoni Eguíluz
 * Facultad de Ingeniería - Universidad de Deusto (2014)
 */
public class VentanaJuego extends JFrame {
	private static final long serialVersionUID = 1L;  // Para serialización
	JPanel pPrincipal;         // Panel del juego (layout nulo)
	MundoJuego miMundo;        // Mundo del juego
	CocheJuego miCoche;        // Coche del juego
	EstrellaJuego miEstrella;

	
	Coche coche;
	
	JLabel pMensaje;
	
	MiRunnable miHilo = null;  // Hilo del bucle principal de juego	
	
		
	
	
	//El array que memorice todas las teclas pulsadas (para tener presentes pulsaciones múltiples) 
	boolean[] controlCursores;
	
	Double fuerza=0.0;
	/** Constructor de la ventana de juego. Crea y devuelve la ventana inicializada
	 * sin coches dentro
	 */
	public VentanaJuego() {
		// Liberación de la ventana por defecto al cerrar
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		
		controlCursores= new boolean[4];
	
		// Creación contenedores y componentes	
		pPrincipal = new JPanel();
		
//		JPanel pBotonera = new JPanel();
//		JButton bAcelerar = new JButton( "Acelera" );
//		JButton bFrenar = new JButton( "Frena" );
//		JButton bGiraIzq = new JButton( "Gira Izq." );
//		JButton bGiraDer = new JButton( "Gira Der." );
		
		//Creamos el panel de texto
		pMensaje= new JLabel();	
		//pPrincipal.add(pMensaje);

		
		
		// Formato y layouts
		pPrincipal.setLayout( null );
		pPrincipal.setBackground( Color.white );
		
		// Añadido de componentes a contenedores
		add( pPrincipal, BorderLayout.CENTER );
		
		//Botones que al principio necesitábamos
//		pBotonera.add( bAcelerar );
//		pBotonera.add( bFrenar );
//		pBotonera.add( bGiraIzq );
//		pBotonera.add( bGiraDer );
		
		//Añadir el JLabel de texto al sur de la pantalla
		add( pMensaje, BorderLayout.SOUTH );
		
		
		// Formato de ventana
		setSize( 1000, 750);
		setResizable( false );
		
		
		// Escuchadores de botones
		
//		bAcelerar.addActionListener( new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				miCoche.acelera( 10, 1 );
//				// System.out.println( "Nueva velocidad de coche: " + miCoche.getVelocidad() );
//			}
//		});
//		bFrenar.addActionListener( new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//								
//				miCoche.acelera( -10, 1 );
//				// System.out.println( "Nueva velocidad de coche: " + miCoche.getVelocidad() );
//			}
//		});
//		bGiraIzq.addActionListener( new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				miCoche.gira( +10 );
//				// System.out.println( "Nueva dirección de coche: " + miCoche.getDireccionActual() );
//			}
//		});
//		bGiraDer.addActionListener( new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				miCoche.gira( -10 );
//				// System.out.println( "Nueva dirección de coche: " + miCoche.getDireccionActual() );
//			}
//		});
//		
		
		// Añadido para que también se gestione por teclado con el KeyListener
		pPrincipal.addKeyListener( new KeyAdapter() {
			@Override
				public void keyPressed(KeyEvent e) {								
					switch (e.getKeyCode()) {
					
					case KeyEvent.VK_UP: {
						controlCursores[0]=true;
						break;
					}	
					
						
						case KeyEvent.VK_DOWN: {	
							controlCursores[1]=true;	
							break;
						}

						case KeyEvent.VK_LEFT: {
							controlCursores[2]=true;
							break;
						}
						case KeyEvent.VK_RIGHT: {
							controlCursores[3]=true;
							break;
						}
					}
	
			}
			@Override
			public void keyReleased(KeyEvent e) {								
					switch (e.getKeyCode()) {
					
					case KeyEvent.VK_UP: {
						controlCursores[0]=false;
						break;
					}
						
					case KeyEvent.VK_DOWN: {
						controlCursores[1]=false;	
						break;
					}
					
					case KeyEvent.VK_LEFT: {
						controlCursores[2]=false;	
						break;
					}
					case KeyEvent.VK_RIGHT: {
						controlCursores[3]=false;
						break;
					}
					}
				}
			
		});		
	
	
		pPrincipal.setFocusable(true);
		pPrincipal.requestFocus();
		pPrincipal.addFocusListener( new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				pPrincipal.requestFocus();
			}
		});
		// Cierre del hilo al cierre de la ventana
		addWindowListener( new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (miHilo!=null) miHilo.acaba();
			}
		});
	}
	
	public static double setPosX(){
		double start = 950;
		double end = 1;
		double valorAleatorioX = new Random().nextDouble();
		double result = start + (valorAleatorioX * (end - start));
	
		return result;
	}
	public static double setPosY(){
		double start = 700;
		double end = 1;
		double valorAleatorioY = new Random().nextDouble();
		double result = start + (valorAleatorioY * (end - start));
		
		return result;
	}
	
	/** Programa principal de la ventana de juego
	 * @param args
	 */
	public static void main(String[] args) {
		// Crea y visibiliza la ventana con el coche
		try {
			final VentanaJuego miVentana = new VentanaJuego();
			SwingUtilities.invokeAndWait( new Runnable() {
				@Override
				public void run() {
					miVentana.setVisible( true );
				}
			});
			
			miVentana.miMundo = new MundoJuego( miVentana.pPrincipal );
			
			//Creamos coche
			miVentana.miMundo.creaCoche( 150, 100 );
			miVentana.miCoche = miVentana.miMundo.getCoche();
			miVentana.miCoche.setPiloto( "Fernando Alonso" );
			
						
			// Crea el hilo de movimiento del coche y lo lanza
			miVentana.miHilo = miVentana.new MiRunnable();  // Sintaxis de new para clase interna
			Thread nuevoHilo = new Thread( miVentana.miHilo );
			nuevoHilo.start();
		} catch (Exception e) {
			System.exit(1);  // Error anormal
		}
	}
	
	/** Clase interna para implementación de bucle principal del juego como un hilo
	 * @author Andoni Eguíluz
	 * Facultad de Ingeniería - Universidad de Deusto (2014)
	 */
	class MiRunnable implements Runnable {
		boolean sigo = true;
		double fuerzaAdelante;
		double fuerzaAtras;
		double segundos;
		
		
		@Override
		public void run() {
			
			double fuerzaAdelante;
			double fuerzaAtras;
			
			
			// Bucle principal forever hasta que se pare el juego...
			while (sigo) {
				// Mover coche
				miCoche.mueve( 0.040 );
				
				
				
				// Chequear choques
				// (se comprueba tanto X como Y porque podría a la vez chocar en las dos direcciones (esquinas)
				if (miMundo.hayChoqueHorizontal(miCoche)) // Espejo horizontal si choca en X
					miMundo.rebotaHorizontal(miCoche);
				if (miMundo.hayChoqueVertical(miCoche)) // Espejo vertical si choca en Y
					miMundo.rebotaVertical(miCoche);
				
				if(controlCursores[0]==true){
					
					fuerzaAdelante=miCoche.fuerzaAceleracionAdelante();
					
					miMundo.aplicarFuerza(fuerzaAdelante, miCoche);
					
				}else if(controlCursores[0]==false){
										
					double aplicarFuerzaRozamiento=  miMundo.calcFuerzaRozamiento(miCoche.getMasa(), miCoche.getCoefSuelo(), miCoche.getCoefAire(),miCoche.getVelocidad());
					miMundo.aplicarFuerza(aplicarFuerzaRozamiento, miCoche);
				}
				if(controlCursores[1]==true){
					
					fuerzaAtras = miCoche.fuerzaAceleracionAtras();
			
					miMundo.aplicarFuerza(-fuerzaAtras, miCoche);

				}else if(controlCursores[1]==false){
					
					double aplicarFuerzaRozamiento=  miMundo.calcFuerzaRozamiento(miCoche.getMasa(), miCoche.getCoefSuelo(), miCoche.getCoefAire(),miCoche.getVelocidad());
					miMundo.aplicarFuerza(-aplicarFuerzaRozamiento, miCoche);
				}
				if(controlCursores[2]==true){
					miCoche.gira( +10 );	
				}
				if(controlCursores[3]==true){
					miCoche.gira( -10 );
				}
				
				if(segundos>=1.2){
				
					//Creamos la estrella
					miMundo.creaEstrella(setPosX(), setPosY());
					segundos=0.0;			

					
				}else{
					segundos=segundos+0.040;
				}
				
				//Que cada 6 segundos se quite la estrella
				int perdidas = miMundo.quitaYRotaEstrellas(6000);
				
				int comidas= miMundo.choquesConEstrellas();
				
				int puntuacion = comidas*5;
				
				pMensaje.setText( "      Comidas :                 " + comidas + "                           Puntuación :               " + puntuacion +"                           Perdidas :               " + perdidas );
				
				// Dormir el hilo 40 milisegundos
				try {
					Thread.sleep( 40 );

				} catch (Exception e) {
				
				}
//Para que cuando se acumulen 10 estrellas sin comer se salga de la aplicación.MIRAR NO HACE BIEN!!!!
				if(perdidas>=3){
					acaba();
					//Para que cierre el panel principal
					pPrincipal.setVisible(false);
					
					//Para que  se cierre la ventana
					System.exit(0); 
				}
		
			}
		}
		/** Ordena al hilo detenerse en cuanto sea posible
		 */
		public void acaba() {
			sigo = false;
		}
	};
	
}
