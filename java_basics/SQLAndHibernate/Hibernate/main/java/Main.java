import EntityMapping.LinkedPurchaseList;
import EntityMapping.PurchaseList;
import Session.SingletonSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SingletonSession session =

        createDBAndGetSession();
        createNewTable(session.getSession());

        try {
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SingletonSession createDBAndGetSession() {
        return SingletonSession.getInstance();
    }

    public static void createNewTable(Session session) {
        Transaction transaction = session.beginTransaction();

        List<PurchaseList> purchaseLists = session
                .createQuery("FROM " + PurchaseList.class.getSimpleName(), PurchaseList.class)
                .getResultList();

        session.createNativeQuery("TRUNCATE TABLE LinkedPurchaseList", LinkedPurchaseList.class).executeUpdate();

        purchaseLists.stream()
                .map(LinkedPurchaseList::doMappingObj)
                .forEach(session::save);

        transaction.commit();
    }
}
