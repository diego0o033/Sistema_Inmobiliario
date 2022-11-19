/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio_Inmobiliaria;

/**
 *
 * @author diego vargas
 */
public class Departamento extends Propiedad 
{
    private int metros_cuadrados;
    private int cantidad_ambientes;
    private boolean balcon;
    
public Departamento(){}

public Departamento(String codigo,int cantidad, String direccion,String localidad ,double precio, int metros_cuadrados, int cantidad_ambientes, boolean balcon)
{
    super(codigo,cantidad, direccion, localidad ,precio);
    this.metros_cuadrados=metros_cuadrados;
    this.cantidad_ambientes=cantidad_ambientes;
    this.balcon=balcon;
}

    public void setMetros_cuadrados(int metros)
    {
        this.metros_cuadrados=metros;
    }
    
    public void setCantidad_ambientes(int cantidad)
    {
        this.cantidad_ambientes=cantidad;
    }
    
    public void setBalcon(boolean balcon)
    {
        this.balcon=balcon;
    }
    
    @Override
    public String toString()
{
    String balcon_depto="";
    if(balcon==true)
    {
        balcon_depto="si";
    }
    else
    {
        balcon_depto="no";
    }
    return "Departamento {' " + " Posee el codigo de identificacion:" + " " + super.getCodigo_Propiedad() + " " + "  y tiene" + " " + metros_cuadrados + " " + " metros cuadrados" +  
            "\n" + "ademas cuenta con la cantidad de ambientes" + cantidad_ambientes + " " + balcon_depto + " " + " cuenta con balcon " + " \n"    +
            " " + " se encuentra en la siguiente direccion: " + " " + super.getDireccion() + " " + " la cual pertenece a la localidad: " + " " + super.getLocalidad() + "   \n"
            + " " + "hay la siguiente cantidad disponible: " + " " + super.getCantidad() + " \n" + " tiene un valor en dolares de US$:" + " " + super.getPrecio() + '}';   
}

    @Override
    public int verificar_Cantidad_Disponible() 
    {   
        if(super.getCantidad()>0)
        {
            System.out.println("Hay cantidades disponibles del departamento solicitado...");
        }
        else
        {
            System.out.println("Lo siento, no hay cantidades disponibles para el departamento solicitado");
        }
     return super.getCantidad(); 
    }
    
 @Override
   public boolean verificarCodigo(String codigo)
{
    codigo= codigo.replaceAll("[^a-zA-Z0-9]", "");
    if(codigo.length() !=6)
    {
        return false;
    }
    
    if(codigo.substring(0, 3).matches("[A-Z]*"))
    {
         return false;
    }
    
    return codigo.substring(3).matches("[0-9]*");
    
}   


}
