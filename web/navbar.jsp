<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dinod
  Date: 24. 8. 29.
  Time: 오후 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- navbar.jsp -->
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/member/members.do"/>">후보조회</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/votepage.do"/>">투표하기</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/votelist.do"/>">투표점수조회</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/member/rank.do"/>">후보자등수</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/home.do"/>">홈으로</a>
            </li>
        </ul>
    </div>
</nav>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


