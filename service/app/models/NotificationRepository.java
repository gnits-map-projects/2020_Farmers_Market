package models;

import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 */
@ImplementedBy(JPANotificationRepository.class)
public interface NotificationRepository {

    CompletionStage<Notification> add(Notification notification);

    CompletionStage<Stream<Notification>> getNotifications(Long uid);

    CompletionStage<String> notificationsRead(Long id);
}
