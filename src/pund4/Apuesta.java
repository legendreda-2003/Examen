/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pund4;
    /**
 * La clase Apuesta modela una apuesta en un partido de fútbol.
 * Permite a los usuarios realizar apuestas sobre el número de goles marcados por los equipos local y visitante,
 * así como verificar si su apuesta coincide con el resultado real del partido.
 */

public class Apuesta {
      // Código de la clase
   
    /**
 * Obtiene el número de goles marcados por el equipo local.
 * @return El número de goles del equipo local.
 */
    public int getGoles_local() {
        return goles_local;
    }

   /**
 * Establece el número de goles marcados por el equipo local.
 * @param goles_local El número de goles del equipo local.
 */ 
    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }
/**
 * Obtiene el número de goles marcados por el equipo visitante.
 * @return El número de goles del equipo visitante.
 */
  
    public int getGoles_visitante() {
        return goles_visitante;
    }
 /**
 * Establece el número de goles marcados por el equipo visintante.
 * @param goles_visitante El número de goles del equipo visitante.
 */ 
    
    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }

    
    public int getApostado() {
        return apostado;
    }

    
    public void setApostado(int apostado) {
        this.apostado = apostado;
    }

    private int dinero_disp;
    private int goles_local;
    private int goles_visitante;
    private int apostado;

    /*Contructor por defecto*/
    public Apuesta() {
         // Código del constructor
    }

    /**
 * Constructor de la clase Apuesta que permite inicializar los atributos con valores específicos.
 * @param dinero_disp El saldo inicial disponible para apostar.
 * @param goles_local El número de goles pronosticados para el equipo local.
 * @param goles_visitante El número de goles pronosticados para el equipo visitante.
 */
    
    public Apuesta(int dinero_disp, int goles_local, int goles_visitante) {
        this.dinero_disp = dinero_disp;
        this.goles_local = goles_local;
        this.goles_visitante = goles_visitante;
        this.apostado = 0;
    }
    /*Método para obtener el valor del atributo dinero_disp*/

    public int getDinero_disp() {
        return dinero_disp;
    }
    /*Método para modificar el valor del atributo dinero_disp*/

    public void setDinero_disp(int dinero_disp) {
        this.dinero_disp = dinero_disp;
    }

    /*Método para apostar.
     * Permite elegir la cantidad a apostar, no pudiendo ser inferior a 1 ni superior a tu saldo disponible
     * Este método será probado con JUnit
     */
    /**
 * Permite realizar una apuesta en el partido.
 * @param dinero La cantidad de dinero a apostar.
 * @throws Exception Si la cantidad de dinero es menor o igual a cero, o si excede el saldo disponible.
 */
    public void apostar(int dinero) throws Exception {
        if (dinero <= 0) {
            throw new Exception("No se puede apostar menos de 1€");
        }

        if (dinero > getDinero_disp()) {
            throw new Exception("No se puede apostar mas de lo que tienes");
        }
        {
            setDinero_disp(dinero - getDinero_disp());
            setApostado(dinero);
        }
    }
    /*Método que comprueba si se ha acertado el resultado del partido
     * En caso de que lo haya acertado devuelve true. Chequea que no se metan menos de 0 goles
     * 
     */
    
    
    /**
 * Comprueba si la apuesta coincide con el resultado real del partido.
 * @param local El número de goles marcados por el equipo local.
 * @param visitante El número de goles marcados por el equipo visitante.
 * @return true si la apuesta coincide con el resultado, false en caso contrario.
 * @throws Exception Si alguno de los parámetros es menor que cero.
 */
    public boolean comprobar_resultado(int local, int visitante) throws Exception {
        boolean acertado = false;
        if ((local < 0) || (visitante) < 0) {
            throw new Exception("Un equipo no puede meter menos de 0 goles, por malo que sea");
        }

        if (getGoles_local() == local && getGoles_visitante() == visitante) {
            acertado = true;
        }
        return acertado;
    }
    /* Método para cobrar la apuesta.
     * Comprueba que se acertó el resultado y, en ese caso, añade el valor apostado multiplicado por 10
     * al saldo disponible
     * Este método se va a probar con Junit
     */
    
    /**
 * Cobra la apuesta si el resultado es acertado.
 * @param cantidad_goles_local El número de goles marcados por el equipo local en el resultado real.
 * @param cantidad_goles_visit El número de goles marcados por el equipo visitante en el resultado real.
 * @throws Exception Si la apuesta no es acertada.
 */

    void cobrar_apuesta(int cantidad_goles_local, int cantidad_goles_visit) throws Exception {

        if (comprobar_resultado(cantidad_goles_local, cantidad_goles_visit) == false) {
            throw new Exception("No se puede cobrar una apuesta no acertada");
        }
        setDinero_disp(getDinero_disp() * 10);

    }
}