package DAL;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;


public class Connection {

    private static SessionFactory sessionFactory;
    protected static Session session;
    private static Transaction transaction;

    protected static void setUp() throws Exception {

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // por defecto: hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    public void abrirSesion(){
        try {
            setUp();
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
        } catch (Exception e) {
            System.err.println("ERROR: Error al iniciar la session");
        }

    }

    public void cerrarSesion() {
        try {
            transaction.commit();
            System.out.println("Peticion gestionada correctamente");
        } catch (Exception e) {
            System.err.println("ERROR: No se ha podido realizar el commit, por ello ser procede a un rollback");
            transaction.rollback();
        }
        sessionFactory.close();
    }

    public Object guardar(Object objeto){

        return session.save(objeto);
    }

    public void borrar(Object objeto){
        session.remove(objeto);
    }

    public void saveFromFile(String queryStr) {
    try{
    abrirSesion();
    Query query = session.createQuery(queryStr);
    query.executeUpdate();
    }catch(Exception e) {
    throw e;
    }
    }
}
