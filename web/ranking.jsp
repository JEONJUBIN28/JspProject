<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>현재 개표현황</title>
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <div class="container mt-4">
        <h1 class="mb-4">Ranking List</h1>
        <div class="table-responsive">
            <table class="table table-striped table-bordered">
                <thead class="thead-light">
                <tr>
                    <th>번호</th>
                    <th>이름</th>
                    <th>기표횟수</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="rank" items="${rankList}">
                    <tr>
                        <td>${rank.memberCode}</td>
                        <td>${rank.memberName}</td>
                        <td>${rank.memberNum}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
