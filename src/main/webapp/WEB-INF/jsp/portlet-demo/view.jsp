<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

This is the <b>Hello World</b> portlet.<br />

<jsp:useBean id="releaseInfo" scope="request" type="java.lang.String"/>
Release info: <c:out escapeXml="true" value="${releaseInfo}" />;<br />
<jsp:useBean id="userName" scope="request" type="java.lang.String"/>
Username: <c:out escapeXml="true" value="${userName}" />.

<portlet:renderURL var="showAddRecordUrl">
    <portlet:param name="act" value="addRecordForm" />
</portlet:renderURL>
<portlet:renderURL var="showUrl">
</portlet:renderURL>

<form:form name="catalogForm" method="post" action="${showAddRecordUrl}">
    <jsp:useBean id="records" scope="request" type="java.lang.Iterable"/>
    <c:if test="${not empty records}">
        <table border="1">
            <tr bgcolor="#99CCFF">
                <td valign="top"><b>Name</b></td>
            </tr>
            <c:forEach var="record" items="${records}">
                <tr>
                    <td valign="top"><c:out value="${record.name}" /></td>
                    <td align="center" valign="top" width="100px"><a href="
						<portlet:renderURL>
							<portlet:param name="act" value="editRecordForm" />
							<portlet:param name="recordId" value="${record.recordId}" />
						</portlet:renderURL>
					"><b>Edit</b></a>
                        /
                        <a href="
						<portlet:actionURL>
							<portlet:param name="act" value="removeRecord" />
							<portlet:param name="id" value="${record.recordId}" />
						</portlet:actionURL>" onclick="return confirmRemove()">
                            <b>Remove</b></a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <br>
    <table align="center">
        <tr>
            <td><input type="submit" value="Add Record" /></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
        </tr>
    </table>
</form:form>