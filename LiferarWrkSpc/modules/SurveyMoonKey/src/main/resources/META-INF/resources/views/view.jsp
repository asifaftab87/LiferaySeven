<%@ include file="/views/init.jsp" %>

<p>
	<b><liferay-ui:message key="lbl.title.page"/></b>
</p>
New content added
<portlet:renderURL  var="renderUrl" windowState="<%=LiferayWindowState.NORMAL.toString() %>" 
					copyCurrentRenderParameters="true" portletMode="<%=LiferayPortletMode.VIEW.toString()%>">
 	<portlet:param name="myParam" value="Nilang"/>
 	<portlet:param name="myParamTwo" value="Second"/>
</portlet:renderURL>

<%-- <%
    PortletURL actionURL = renderResponse.createActionURL();
    actionURL.setParameter("javax.portlet.action", "someProcessAction");
    actionURL.setWindowState(LiferayWindowState.MAXIMIZED);
%>
 --%>
<portlet:actionURL var="addStudentActionURL" windowState="normal" name="someProcessAction">
</portlet:actionURL>


<a href="${renderUrl}">RenderURL Created by Portlet Tag</a>
<br />
<a href="<%=addStudentActionURL%>">Call Process Action</a>


<form action="<%=addStudentActionURL%>" name="studentForm"  method="POST">
	<b>First Name</b><br/>
	<input  type="text" name="<portlet:namespace/>firstName" id="<portlet:namespace/>firstName"/><br/>
	<b>Last Name</b><br/>
	<input type="text" name="<portlet:namespace/>lastName" id="<portlet:namespace/>lastName"/><br/>
	<b>Exam Fee</b><br/>
	<input type="text" name="<portlet:namespace/>examFee" id="<portlet:namespace/>examFee"/><br/>
	<input type="submit" name="addStudent" id="addStudent" value="Add Student"/>
</form>