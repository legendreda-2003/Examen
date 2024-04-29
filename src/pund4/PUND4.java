/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pund4;

/**
 *
 * @author javie
 */
public class PUND4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Apuesta laApuesta;
        int mi_dinero;

        laApuesta = new Apuesta(1000, 4, 2);
        operativa_Apuesta(laApuesta, 0);
        mi_dinero = laApuesta.getDinero_disp();
        System.out.println("El dinero que tengo tras las apuestas es " + mi_dinero);
    }

    private static void operativa_Apuesta(Apuesta laApuesta, int dinero) {
        try {
            System.out.println("Apostando...");
            laApuesta.apostar(25);
        } catch (Exception e) {
            System.out.println("Fallo al realizar la Apuesta");
        }

        try {
            System.out.println("Intento cobrar apuesta segun el resultado del partido");
            laApuesta.cobrar_apuesta(2, 3);
        } catch (Exception e) {
            System.out.println("Fallo al cobrar la apuesta");
        }
    }
    
}
