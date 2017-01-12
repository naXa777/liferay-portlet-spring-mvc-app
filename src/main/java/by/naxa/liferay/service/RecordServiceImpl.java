package by.naxa.liferay.service;

import by.naxa.liferay.dao.RecordsDAO;
import by.naxa.liferay.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author phomal
 */
@Service(value="recordService")
@Transactional
public class RecordServiceImpl implements RecordService {

    private final RecordsDAO recordsDAO;

    @Autowired
    public RecordServiceImpl(RecordsDAO recordsDAO) {
        this.recordsDAO = recordsDAO;

        if (getRecords().spliterator().getExactSizeIfKnown() <= 0) {
            Record rec = new Record();
            rec.setName("Test Record 01");
            this.addRecord(rec);

            rec = new Record();
            rec.setName("Test Record 02");
            this.addRecord(rec);
        }
    }

    @Override
    public Iterable<Record> getRecords() {
        return recordsDAO.findAll();
    }

    @Override
    public void addRecord(Record record) {
        record.setRecordId(null);
        recordsDAO.save(record);
    }

    @Override
    public Record getRecord(Long id) {
        return recordsDAO.findOne(id);
    }

    @Override
    public void removeRecord(Long id) {
        recordsDAO.delete(id);
    }

    @Override
    public void editRecord(Record record) {
        recordsDAO.save(record);
    }
}
