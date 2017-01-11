<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

This is the <b>Hello World</b> portlet.<br />

<jsp:useBean id="releaseInfo" scope="request" type="java.lang.String"/>
Release info: <c:out escapeXml="true" value="${releaseInfo}" />;<br />
<jsp:useBean id="userName" scope="request" type="java.lang.String"/>
Username: <c:out escapeXml="true" value="${userName}" />.

<portlet:renderURL var="showUrl">
</portlet:renderURL>

<form:form name="catalogForm" method="post">
    <jsp:useBean id="records" scope="request" type="java.lang.Iterable"/>
    <c:if test="${not empty records}">
        <table border="1">
            <tr bgcolor="#99CCFF">
                <td valign="top"><b>Name</b></td>
            </tr>
            <c:forEach var="record" items="${records}">
                <tr>
                    <td valign="top"><c:out value="${record.name}" /></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</form:form>