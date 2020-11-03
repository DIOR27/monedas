
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sebastián Medina
 */
public class moneda {

    public static Integer m;
    public static int[] monedas;

    public moneda() {
    }

    public moneda(Integer m, int[] monedas) {
        this.m = m;
        this.monedas = monedas;
    }

    public Integer getM() {
        return m;
    }

    public void setM(Integer m) {
        this.m = m;
    }

    public int[] getMonedas() {
        return monedas;
    }

    public void setMonedas(int[] monedas) {
        this.monedas = monedas;
    }

    public void pasarstring(String c) {

        String[] vector = c.split("\\,");
        int[] numeros = new int[vector.length];
        int n = numeros.length;
        for (int i = 0; i < vector.length; i++) {
            numeros[i] = Integer.parseInt(vector[i]);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    // swap temp and arr[i]
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }
        monedas = numeros;
    }
    
    public String tmp = "";
    
    public boolean comp()
    {
        boolean bandera = true;
        for (int i = monedas.length - 2; i >= 0; i--) 
		{  
			if (monedas[i+1] >= (monedas[i]*2)) 
			{ 
			 i--;	 
			}
			else
			{
			bandera = false;
			} 
		}
        return bandera;
    }

    public String cambio() {
        String aux = "";

        Vector<Integer> ans = new Vector<>();

        for (int i = monedas.length - 1; i >= 0; i--) {
            while (m >= monedas[i]) {
                aux+="¿Es  " + m + " mayor o igual a " + monedas[i] + "?\n\n";
                if (m>=monedas[i]) {
                    aux+="Si, entonces " + m + " - " + monedas[i] + "\n\n";
                } else {
                    aux+="No.\n";
                }
                m -= monedas[i];
                ans.add(monedas[i]);
            }
        }
        
        aux+="Cambio: ";
        for (int i = 0; i < ans.size(); i++) {
            aux+=ans.elementAt(i) + " ";
        }
        //JOptionPane.showMessageDialog(null, aux);
        return aux;
    }

}
