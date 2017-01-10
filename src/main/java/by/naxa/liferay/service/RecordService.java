package by.naxa.liferay.service;

import by.naxa.liferay.model.Record;

/**
 * Service interface for the demo portlet.
 *
 * @author phomal
 */
public interface RecordService {
    
    /**
     * Retrieve record list.
     *
     * @return all records in the database
     */
    Iterable<Record> getRecords();

    /**
     * Adds a record to the database
     *
     * @param record to be added to the database
     */
    void addRecord(Record record);

    /**
     * Retrieve a record based on its ID.
     *
     * @param id of the record which needs to be retrieved
     * @return record with the specified ID
     */
    Record getRecord(Long id);

    /**
     * Remove a record from the database.
     *
     * @param id of the record that needs to be removed from the database
     */
    void removeRecord(Long id);

    /**
     * Update the Record in the database.
     *
     * @param record the modified record
     */
    void editRecord(Record record);

}
