<%--<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--<jsp:useBean id="item" scope="request" type="com.rubincomputers.paystub.Period"/>--%>
<html>
<body>
list hours worked  <br>
<c:forEach items="${list}" var="item" varStatus="loop">
    ${item.date}  ${item.hoursMinutes} <br>
</c:forEach>

</body>
</html>