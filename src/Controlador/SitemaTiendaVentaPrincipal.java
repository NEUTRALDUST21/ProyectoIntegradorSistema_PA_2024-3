package Controlador;

import Vista.Entrada;
import Vista.Sesion;

public class SitemaTiendaVentaPrincipal {
	
	public static void main(String[] args) {
		Entrada entrada = new Entrada();
		entrada.setVisible(true);
        try
        {
            for(int i=0; i <=100; i++)
            {
                Thread.sleep(40);
                entrada.Myprogress.setValue(i);
                entrada.Percentage.setText(Integer.toString(i)+"%");
            }
        } catch (Exception e)
        {
            System.out.println("Error al entrar");
        }
        new Sesion().setVisible(true);
        entrada.dispose();
	}

}
