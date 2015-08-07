<%-- Settings --%>
<%@ page
	import="vn.tdt.mockproject.common.constant.PathConstants,vn.tdt.mockproject.common.constant.ParameterConstants,vn.tdt.mockproject.common.constant.RoleConstants, vn.tdt.mockproject.common.constant.PathConstants, vn.tdt.mockproject.common.constant.ValueConstants"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%-- Variables --%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"
	scope="application" />

<%-- Current User --%>
<c:set var="userPrincipalName" value="${pageContext.request.userPrincipal.name}"
	scope="request" />

<%-- current path --%>
<c:set var="currentPath"
	value="${requestScope['javax.servlet.forward.request_uri']}"
	scope="request" />



<%-- avatar image --%>
<c:set var="avatarPath"
	value="${pageContext.request.contextPath}/upload/avatar"
	scope="application" />




