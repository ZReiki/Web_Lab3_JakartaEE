<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tabulation result</title>
    <meta type="author" content="Fedosiuk Oleksandr"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
    <a class="arrow-up" href="#change_input">↑</a>

    <div class="navigation-panel">
        <a id="change_input" class="nav-button" href="index.jsp">
            ← Змінити дані
        </a>

        <div class="extremum-buttons">
            <a class="nav-button maximum-button"
               href="#point_${maxValue.index()}">
                Максимальний
            </a>

            <a class="nav-button minimum-button"
               href="#point_${minValue.index()}">
                Мінімальний
            </a>
        </div>
    </div>

    <div class="print-values">
        <p>
            <span>Мінімальна точка</span>
            min(
            <fmt:formatNumber value="${minValue.value().x()}"
                              minFractionDigits="3"
                              maxFractionDigits="3"/>,
            <fmt:formatNumber value="${minValue.value().y()}"
                              minFractionDigits="6"
                              maxFractionDigits="6"/>
            ),
            №${minValue.index() + 1}
        </p>

        <p>
            <span>Максимальна точка</span>
            max(
            <fmt:formatNumber value="${maxValue.value().x()}"
                              minFractionDigits="3"
                              maxFractionDigits="3"/>,
            <fmt:formatNumber value="${maxValue.value().y()}"
                              minFractionDigits="6"
                              maxFractionDigits="6"/>
            ),
            №${maxValue.index() + 1}
        </p>
    </div>

<%--    Таблиця результату табулювання функції--%>
    <div class="tabulation-table">
        <table>
            <thead>
            <tr>
                <th>X</th>
                <th>Y</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${tab.points}" varStatus="status">
                <tr class="${status.index == maxValue.index() ? 'maximum' :
                            status.index == minValue.index() ? 'minimum' : ''}" id="point_${status.index}">
                    <td>
                        <fmt:formatNumber value="${p.x()}" type="number" minFractionDigits="3" maxFractionDigits="3"/>
                    </td>
                    <td>
                        <fmt:formatNumber value="${p.y()}" type="number" minFractionDigits="6" maxFractionDigits="6"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
