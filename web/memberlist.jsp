<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>후보 명단</title>
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <div class="container mt-4">
        <h1 class="mb-4">Member List</h1>
        <div class="table-responsive text-center">
            <table class="table table-striped table-bordered">
                <thead class="thead-light">
                <tr>
                    <th>후보 번호</th>
                    <th>성명</th>
                    <th>소속정당</th>
                    <th>최종학력</th>
                    <th>주민번호</th>
                    <th>지역구</th>
                    <th>대표전화</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="member" items="${memberList}">
                    <tr>
                        <td>${member.memberNum}</td>
                        <td>${member.memberName}</td>
                        <td>${member.memberCode}</td>
                        <td>${member.memberGraduate}</td>
                        <td>${member.memberSecurityNumber}</td>
                        <td>${member.memberAddress}</td>
                        <td>${member.memberPhoneNumber}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>