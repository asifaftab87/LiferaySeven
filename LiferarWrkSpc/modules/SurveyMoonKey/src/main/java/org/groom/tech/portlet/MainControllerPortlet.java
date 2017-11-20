package org.groom.tech.portlet;

import org.groom.tech.constants.MainControllerPortletKeys;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bestinet
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=SurveyMoonKey Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/views/view.jsp",
		"javax.portlet.name=" + MainControllerPortletKeys.MainController,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class MainControllerPortlet extends MVCPortlet {
	
	Log logger = LogFactoryUtil.getLog(MainControllerPortlet.class);
	
	@ProcessAction(name="someProcessAction")
	public void someProcessAction(ActionRequest actionRequest, ActionResponse actionResponse){
	    String value = ParamUtil.getString(actionRequest, "firstName");
	    System.out.println("#######Value##############"+value);
	    System.out.println("#######Calling some process action##############");
	}
	
	@ProcessAction(name = "addBook")
	public void addBook(ActionRequest actionRequest, ActionResponse actionResponse){
	    //Some logic here
		logger.info("action class");
	}
	
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
			
		logger.info("This is Survey Controller doView");
		super.doView(renderRequest, renderResponse);
	}
	
	@Override
	 public void render(RenderRequest request, RenderResponse response)
	   throws PortletException, IOException {
		
		logger.info(" This is render method of RenderURLByPortletTagPortlet");
		String data = request.getParameter("myParam");
		String data1= ParamUtil.getString(request, "myParamTwo","");
		logger.info("parameter with request.getParameter is =>"+data);
		logger.info("parameter with ParamUtil.getString is =>"+data1);
		super.render(request, response);
	 }
	
}