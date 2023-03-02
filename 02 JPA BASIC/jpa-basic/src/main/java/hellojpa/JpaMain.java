package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            // 비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("이름");

            // 영속
            em.persist(member);

            // 준영속
            em.detach(member);

            // 삭제
            em.remove(member);

            tx.commit();
        } catch (Exception e) {
            em.close();
        } finally {
            emf.close();

        }


    }
}
