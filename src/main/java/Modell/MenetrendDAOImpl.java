/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modell;
/*
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class MenetrendDAOImpl implements MenetrendDAO{
    private EntityManager em;
    public MenetrendDAOImpl(EntityManager em){
        this.em = em;
    }
    @Override
    public void createMenetrend(int ora, String munkanap, String Tanszunet, String Szabadnap, String Munkaszunet,int buszszam) {    
        Query q = em.createQuery("CREATE TABLE A"+buszszam+ 
   	"ORA NUMBER(2,0), TANITASI_IDOSZAK VARCHAR2(100 BYTE), TANSZUNET VARCHAR2(100 BYTE), SZOMBAT VARCHAR2(100 BYTE), VASARNAP VARCHAR2(100 BYTE), PRIMARY KEY (ORA)");
        q.executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public List<Menetrend> readMenetrend(int buszszam) {
        Query q = em.createQuery("SELECT b FROM A"+buszszam+" b");

        List<Menetrend> result = q.getResultList();

        return result;
    }

    @Override
    public void updateMenetrend(Menetrend m, int ora, String munkanap, String Tanszunet, String Szabadnap, String Munkaszunet,int buszszam) {
        Query q = em.createQuery("");
        q.executeUpdate();
    }

    @Override
    public void deleteMenetrend(int buszszam) {
        Query q = em.createQuery("drop table A"+buszszam);
        q.executeUpdate();
    }

    @Override
    public List<Menetrend> findMenetrend(String buszszam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
*/