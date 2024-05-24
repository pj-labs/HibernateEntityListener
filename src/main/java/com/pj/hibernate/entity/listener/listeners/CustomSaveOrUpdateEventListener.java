package com.pj.hibernate.entity.listener.listeners;

import com.pj.hibernate.entity.listener.domain.MaterializedBookAuthor;
import com.pj.hibernate.entity.listener.repository.MaterializedBookAuthorRepository;
import org.hibernate.event.spi.*;
import org.hibernate.persister.entity.EntityPersister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CustomSaveOrUpdateEventListener implements PostDeleteEventListener, PostInsertEventListener, PostUpdateEventListener {
    private final MaterializedBookAuthorRepository repository;
    private final Logger logger = LoggerFactory.getLogger(CustomSaveOrUpdateEventListener.class);

    public CustomSaveOrUpdateEventListener(MaterializedBookAuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onPostDelete(PostDeleteEvent event) {
        final Object entity = event.getEntity();
        logger.info("CustomSaveOrUpdateEventListener.onPostDelete: {}", entity);
        if (entity instanceof com.pj.hibernate.entity.listener.domain.Book book) {
            repository.deleteById(book.getId());
        }
    }

    @Override
    public void onPostInsert(PostInsertEvent event) {
        final Object entity = event.getEntity();
        logger.info("CustomSaveOrUpdateEventListener.onPostInsert: {}", entity);

        if (entity instanceof com.pj.hibernate.entity.listener.domain.Book book) {
            var materializedBookAuthor = repository.findById(book.getId()).orElse(new MaterializedBookAuthor(book.getId()));
            materializedBookAuthor.setBookId(book.getId());
            materializedBookAuthor.setTitle(book.getTitle());
            materializedBookAuthor.setIsbn(book.getIsbn());
            materializedBookAuthor.setPublisher(book.getPublisher());
            materializedBookAuthor.setYearOfPublication(book.getYearOfPublication());
            materializedBookAuthor.setAuthorId(book.getAuthor().getId());
            materializedBookAuthor.setFirstName(book.getAuthor().getFirstName());
            materializedBookAuthor.setLastName(book.getAuthor().getLastName());
            materializedBookAuthor.setEmail(book.getAuthor().getLastName());
            materializedBookAuthor.setPhoneNumber(book.getAuthor().getPhoneNumber());

            repository.save(materializedBookAuthor);
        }
    }

    @Override
    public void onPostUpdate(PostUpdateEvent event) {
        final Object entity = event.getEntity();
        logger.info("CustomSaveOrUpdateEventListener.onPostUpdate: {}", entity);
    }

    /**
     * Does this listener require that after transaction hooks be registered?
     *
     * @param persister The persister for the entity in question.
     *
     * @return {@code true} if after transaction callbacks should be added.
     */
    @Override
    public boolean requiresPostCommitHandling(EntityPersister persister) {
        return true;
    }
}
