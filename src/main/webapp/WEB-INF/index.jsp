<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Proselyte</title>
</head>
<body>
<h3>Proselyte presents</h3>
<br/>
<a href="<c:url value="/books"/>" target="_blank"> Books list </a>
<br/>
</body>
</html>


<%--<body>--%>
<%--<div class="container">--%>
  <%--<h1>This is secured!</h1>--%>
  <%--<p>--%>
    <%--Hello <b><c:out value="${pageContext.request.remoteUser}"/></b>--%>
  <%--</p>--%>
  <%--<c:url var="logoutUrl" value="/logout"/>--%>
  <%--<form class="form-inline" action="${logoutUrl}" method="post">--%>
    <%--<input type="submit" value="Log out" />--%>
    <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
  <%--</form>--%>
<%--</div>--%>
<%--</body>--%>