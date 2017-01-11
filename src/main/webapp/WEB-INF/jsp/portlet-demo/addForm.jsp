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

<form:form name="addRecordForm" commandName="record" method="post" action="${addRecordActionUrl}">
    <table>
        <tr align="left">
            <td><a href="${homeUrl}">Home</a></td>
        </tr>
    </table>
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="${record.name}"/></td>
        </tr>
    </table>
    <table align="center">
        <tr>
            <td><input type="submit" value="Add Record" /></td>
        </tr>
        <tr>
            <td>&nbsp;</td>
        </tr>
    </table>
</form:form>
<br>