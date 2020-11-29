 package Repository;

import Connection.HibernateUtils;
import Tables.Pet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

    public class PetRepository {

        public void addPet(Pet pet) {

            Transaction transaction = null;
            try {
                Session session = HibernateUtils.getSessionFactory ().openSession ();
                transaction = session.beginTransaction ();
                session.save (pet);
                transaction.commit ();
                session.close ();
            }catch (Exception e) {
                if (transaction != null){
                    transaction.rollback ();
                }e.printStackTrace ();
            }
        }

        public List<Pet> getAllPets(){

            Session session = HibernateUtils.getSessionFactory().openSession ();

            List<Pet> pets = session.createQuery("from Pet", Pet.class).list ();

            for(Pet pet : pets){
                System.out.println (pet.toString ());
            }

            session.close();

            return pets;
        }

        public void updatePet(Pet pet){

            Transaction transaction = null;
            try {
                Session session = HibernateUtils.getSessionFactory ().openSession ();
                transaction = session.beginTransaction ();
                session.update (pet);
                transaction.commit ();
                session.close ();
            }catch (Exception e) {
                if (transaction != null){
                    transaction.rollback ();
                }e.printStackTrace ();
            }
        }

        public void deletePet(Pet pet){

            Transaction transaction = null;
            try {
                Session session = HibernateUtils.getSessionFactory ().openSession ();
                transaction = session.beginTransaction ();
                session.delete (pet);
                transaction.commit ();
                session.close ();
            }catch (Exception e) {
                if (transaction != null){
                    transaction.rollback ();
                }e.printStackTrace ();
            }
        }

    }

