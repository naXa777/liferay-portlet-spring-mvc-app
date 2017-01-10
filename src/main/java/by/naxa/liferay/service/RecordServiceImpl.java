package by.naxa.liferay.service;

import by.naxa.liferay.dao.RecordsDAO;
import by.naxa.liferay.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author phomal
 */
@Service(value="recordService")
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordsDAO recordsDAO;

    @Override
    public Iterable<Record> getRecords() {
        return recordsDAO.findAll();
    }

    @Override
    public void addRecord(Record record) {
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
