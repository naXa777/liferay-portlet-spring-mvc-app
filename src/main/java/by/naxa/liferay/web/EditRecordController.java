package by.naxa.liferay.web;

import by.naxa.liferay.model.Record;
import by.naxa.liferay.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionResponse;

/**
 * EditRecordController shows the Edit Record form and does request processing of the edit record action.
 *
 * @author phomal
 */
@Controller
@RequestMapping("VIEW")
@SessionAttributes("record")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class EditRecordController {
    
    private final RecordService recordService;

    @RenderMapping(params="act=editRecordForm")
    public String showEditRecordForm() {
        return "portlet-demo/editForm";
    }

    @ActionMapping(params="act=editRecord")
    public void editRecord(@ModelAttribute Record record, ActionResponse response, SessionStatus sessionStatus) {
        recordService.editRecord(record);
        response.setRenderParameter("act", "records");
        sessionStatus.setComplete();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Mark fields as disallowed to avoid unwanted modifications by malicious users when binding HTTP
        // request parameters.
        binder.setDisallowedFields("recordId");
    }

    @ModelAttribute("record")
    public Record getRecord(@RequestParam Long recordId) {
        return recordService.getRecord(recordId);
    }
}