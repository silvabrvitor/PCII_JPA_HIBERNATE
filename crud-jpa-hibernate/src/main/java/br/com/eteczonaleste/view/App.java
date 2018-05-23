package br.com.eteczonaleste.view;

import javax.swing.JFrame;

import br.com.eteczonaleste.controller.ClienteJpaDAO;
import br.com.eteczonaleste.model.Cliente;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Cliente cliente = new Cliente();
        cliente.setCpf("372.468.423-53");
        cliente.setId(1);
        cliente.setNome("Bruce Willis");
        cliente.setRg("52.563.456-2");
        ClienteJpaDAO.getInstance().merge(cliente);
        
        Cliente cliente2 = new Cliente();
        cliente2.setCpf("322.588.223-83");
        cliente2.setId(2);
        cliente2.setNome("Joey Ramone");
        cliente2.setRg("36.789.654-1");
        //ClienteJpaDAO.getInstance().merge(cliente2);
        ClienteJpaDAO.getInstance().removeById(2);
        System.out.println("Objetos salvo com sucesso!!");
    }
}
