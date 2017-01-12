<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<portlet:actionURL var="addRecordActionUrl">
    <portlet:param name="act" value="addRecord" />
</portlet:actionURL>
<portlet:renderURL var="homeUrl">
    <portlet:param name="act" value="records" />
</portlet:renderURL>

<form:form name="addRecordForm" modelAttribute="record" method="post" action="${addRecordActionUrl}">
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
            <td><input type="submit" value="Add Record" /></td>
        </tr>
    </table>
</form:form>
<br>