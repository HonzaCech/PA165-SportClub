<%--
  445403 Kristian Katanik
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" trimDirectiveWhitespaces="false" session="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <my:pagetemplate title="New coach">
<jsp:attribute name="body">

    <form:form method="post" action="${pageContext.request.contextPath}/coach/new"
               modelAttribute="coachCreate" cssClass="form-horizontal">
        <div class="form-group ${firstName_error?'has-error':''}">
            <form:label path="firstName" cssClass="col-sm-2 control-label">First name</form:label>
            <div class="col-sm-10">
                <form:input path="firstName" cssClass="form-control"/>
                <form:errors path="firstName" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group ${lastName_error?'has-error':''}">
            <form:label path="lastName" cssClass="col-sm-2 control-label">Last name</form:label>
            <div class="col-sm-10">
                <form:input path="lastName" cssClass="form-control"/>
                <form:errors path="lastName" cssClass="help-block"/>
            </div>
        </div>
        <div class="form-group ${email_error?'has-error':''}">
            <form:label path="email" cssClass="col-sm-2 control-label">Email</form:label>
            <div class="col-sm-10">
                <form:input path="email" cssClass="form-control"/>
                <form:errors path="email" cssClass="help-block"/>
            </div>
        </div>


        <button class="btn btn-primary" type="submit">Create coach</button>
    </form:form>


</jsp:attribute>
</my:pagetemplate>
