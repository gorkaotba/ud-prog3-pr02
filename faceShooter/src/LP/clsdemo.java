package LP;

	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.event.*;

	import javax.swing.*;

	/** Ventana del nivel 1 o demo
	 * @author Aran Rodas and Gorka Otermin
	 */
	public class clsdemo extends JFrame {
		private static final long serialVersionUID = 1L;  // Para serialización
		
		JPanel pprincipal;         // Panel del juego (layout nulo)
		
		
		/** Constructor de la ventana de juego. Crea y devuelve la ventana inicializada

		 */
	public clsdemo() {
		// Liberación de la ventana por defecto al cerrar
			setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		// Creación contenedores y componentes
			pprincipal = new JPanel();
		
			JPanel pespera = new JPanel();
			JPanel pjuego= new JPanel();
			JPanel pinformacion= new JPanel();
		
			add( pinformacion, BorderLayout.WEST);
			add( pespera, BorderLayout.SOUTH);
			add( pjuego, BorderLayout.NORTH);
			
			// Formato de ventana
			setSize( 700, 600 );
			
			// Escuchadores de botones
//			bAcelerar.addActionListener( new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					if (miCoche.getVelocidad()==0)
//						miCoche.acelera( +5 );
//					else 
//						miCoche.acelera( +5 );
//						// miCoche.acelera( miCoche.getVelocidad()*0.10 );   // para acelerar progresivo
//					System.out.println( "Nueva velocidad de coche: " + miCoche.getVelocidad() );
//				}
//			});
//			bFrenar.addActionListener( new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					miCoche.acelera( -5 );
//					System.out.println( "Nueva velocidad de coche: " + miCoche.getVelocidad() );
//				}
//			});
//			bGiraIzq.addActionListener( new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					miCoche.gira( +10 );
//					System.out.println( "Nueva dirección de coche: " + miCoche.getDireccionActual() );
//				}
//			});
//			bGiraDer.addActionListener( new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					miCoche.gira( -10 );
//					System.out.println( "Nueva dirección de coche: " + miCoche.getDireccionActual() );
//				}
//			});
//			// Añadido para que también se gestione por teclado con el KeyListener
//			pPrincipal.addKeyListener( new KeyAdapter() {
//				@Override
//				public void keyPressed(KeyEvent e) {
//					switch (e.getKeyCode()) {
//						case KeyEvent.VK_UP: {
//							miCoche.acelera( +5 );
//							break;
//						}
//						case KeyEvent.VK_DOWN: {
//							miCoche.acelera( -5 );
//							break;
//						}
//						case KeyEvent.VK_LEFT: {
//							miCoche.gira( +10 );
//							break;
//						}
//						case KeyEvent.VK_RIGHT: {
//							miCoche.gira( -10 );
//							break;
//						}
//					}
//				}
//			});
//			pPrincipal.setFocusable(true);
//			pPrincipal.requestFocus();
//			pPrincipal.addFocusListener( new FocusAdapter() {
//				@Override
//				public void focusLost(FocusEvent e) {
//					pPrincipal.requestFocus();
//				}
//			});
//			// Cierre del hilo al cierre de la ventana
//			addWindowListener( new WindowAdapter() {
//				@Override
//				public void windowClosing(WindowEvent e) {
//					if (miHilo!=null) miHilo.acaba();
//				}
//			});
//		}
}
}