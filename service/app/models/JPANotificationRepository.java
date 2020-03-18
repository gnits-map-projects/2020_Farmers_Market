package models;

import play.db.jpa.JPAApi;
import javax.inject.Inject;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;

//import app/models/JPACropRepository.java:58

import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Provide JPA operations running inside of a thread pool sized to the connection pool
 */
public class JPANotificationRepository implements NotificationRepository {

    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public JPANotificationRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    @Override
    public CompletionStage<Notification> add(Notification notification) {
        return supplyAsync(() -> wrap(em -> insert(em, notification)), executionContext);
    }

    @Override
    public CompletionStage<Stream<Notification>> getNotifications(Long userId) {
        return supplyAsync(() -> wrap(em -> listNotifications(em, userId)), executionContext);
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private Notification insert(EntityManager em, Notification notification) {
        em.persist(notification);
        return notification;
    }

    private Stream<Notification> listNotifications(EntityManager em, Long userId) {
        List<Notification> notifications = em.createQuery("select n from Notification n where n.userId =: userId order by n.status desc", Notification.class).setParameter("userId", userId).getResultList();
        return notifications.stream();
    }

}
