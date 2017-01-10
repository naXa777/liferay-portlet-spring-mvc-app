package by.naxa.liferay.dao;

import by.naxa.liferay.model.Record;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author phomal
 */
@Repository
@Transactional
public interface RecordsDAO extends CrudRepository<Record, Long> {

}
