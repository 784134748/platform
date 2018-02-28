<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%--跳出iframe--%>
<script type="text/javascript">
    if (top.location !== self.location) {
        top.location = self.location;
    }
</script>
<%--跳出iframe--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>