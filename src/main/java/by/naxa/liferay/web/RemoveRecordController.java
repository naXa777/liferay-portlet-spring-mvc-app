package by.naxa.liferay.web;

import by.naxa.liferay.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

/**
 * RemoveRecordController handles removal of Record from the database.
 *
 * @author phomal
 */
@Controller
@RequestMapping("VIEW")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class RemoveRecordController {

    private final RecordService recordService;

    @ActionMapping(params="act=removeRecord")
    public void removeRecord(@RequestParam Long id) {
        recordService.removeRecord(id);
    }
}
