package view;

import org.hibernate.Session;
import controller.HibernateUtil;
import model.Alunos;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Alunos alunos = new Alunos();
    	alunos.setNome("Mark Bell");
    	alunos.setEndereco("New York Avenue");
    	
    	Alunos alunos2 = new Alunos();
    	alunos2.setNome("Clint Eastwood");
    	alunos2.setEndereco("Los Angeles Avenue");
		
    	Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(alunos);
		session.save(alunos2);
		session.getTransaction().commit();

    }
}
