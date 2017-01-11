package by.naxa.liferay.web;

import by.naxa.liferay.service.RecordService;
import com.liferay.portal.kernel.util.ReleaseInfo;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.RenderRequest;

/**
 * ViewRecordController renders the portlet; shows the records from the database in html table.
 *
 * @author phomal
 */
@Controller
@RequestMapping("VIEW")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class ViewRecordController {

	private final RecordService recordService;

	@RenderMapping
	public String showRecords(RenderRequest request, Model model) {
		model.addAttribute("releaseInfo", ReleaseInfo.getReleaseInfo());

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		User loggedUser = themeDisplay.getUser();

		model.addAttribute("userName", loggedUser.getFullName());

		model.addAttribute("records", recordService.getRecords());

		return "portlet-demo/view";
	}

}