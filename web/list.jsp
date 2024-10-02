<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vote List</title>
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <div class="container mt-4">
        <h1 class="mb-4">Vote List</h1>
        <div class="table-responsive text-center">
            <table class="table table-striped table-bordered">
                <thead class="thead-light">
                <tr>
                    <th>성명</th>
                    <th>생년월일</th>
                    <th>나이</th>
                    <th>성별</th>
                    <th>후보번호</th>
                    <th>투표 시간</th>
                    <th>유권자확인</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="vote" items="${voteList}">
                    <tr>
                        <td>${vote.memberName}</td>
                        <td>${vote.birthday}</td>
                        <td>${vote.age}</td>
                        <td>${vote.sex}</td>
                        <td>${vote.personNumber}</td>
                        <td>${vote.voteTime}</td>
                        <td>${vote.voteConfirm}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
