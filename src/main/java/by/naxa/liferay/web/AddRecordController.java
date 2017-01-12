package by.naxa.liferay.web;

import by.naxa.liferay.model.Record;
import by.naxa.liferay.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionResponse;

/**
 * {@code AddRecordController} shows the add record form and handles requests for adding a record to the database.
 *
 * @author phomal
 */
@Controller
@RequestMapping("VIEW")
@SessionAttributes(types = Record.class)
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class AddRecordController {

    private final RecordService recordService;

    @RenderMapping(params = "act=addRecordForm")
    public String showAddRecordForm() {
        return "portlet-demo/addForm";
    }

    @ActionMapping(params = "act=addRecord")
    public void addRecord(@ModelAttribute("record") Record record, ActionResponse response, SessionStatus sessionStatus) {
        recordService.addRecord(record);
        response.setRenderParameter("act", "records");
        // set the session status as complete to cleanup the model attributes
        // stored using @SessionAttributes, otherwise when you click
        // 'Add Record' button you'll see the record information pre-populated
        // because the getCommandObject method of the controller is not
        // invoked
        sessionStatus.setComplete();
    }

    @ModelAttribute("record")
    public Record populateRecord() {
        return new Record();
    }

}
