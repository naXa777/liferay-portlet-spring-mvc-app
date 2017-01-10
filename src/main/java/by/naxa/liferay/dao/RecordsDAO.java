package by.naxa.liferay.dao;

import by.naxa.liferay.model.Record;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by phomal on 1/10/2017.
 */
@Repository
@Transactional
public class RecordsDAO {

    @PersistenceContext
    private EntityManager em;

    public void createRecord(Record entity) {
        em.persist(entity);
    }

    public void updateRecord(Record entity) {
        em.merge(entity);
    }

    public void deleteRecord(long recordId) {
        Record record = getRecordById(recordId);
        if (record != null) {
            em.remove(record);
        }
    }

    @Transactional(readOnly = true)
    public Record getRecordById(long recordId) {
        return em.find(Record.class, recordId);
    }

}
