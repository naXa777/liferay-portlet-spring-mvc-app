<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<portlet:actionURL var="editRecordActionUrl">
    <portlet:param name="act" value="editRecord" />
</portlet:actionURL>
<portlet:renderURL var="homeUrl">
    <portlet:param name="act" value="records" />
</portlet:renderURL>

<form:form name="editRecordForm" commandName="record" method="post" action="${editRecordActionUrl}">
    <table>
        <tr align="left">
            <td><a href="${homeUrl}">Home</a></td>
        </tr>
    </table>
    <form:hidden path="recordId" />
    <form:label path="name">Name:</form:label>
    <form:input path="name" />
    <table align="center">
        <tr>
            <td><input type="submit" value="Update Record" /></td>
        </tr>
    </table>
</form:form>
<br>