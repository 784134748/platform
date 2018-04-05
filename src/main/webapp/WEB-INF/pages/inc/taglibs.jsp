<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%--登录超时--%>
<script type="text/javascript">
    if (top.location !== self.location) {
        self.location = "/rbac/timeout.do";
    }
</script>
<%--登录超时--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>