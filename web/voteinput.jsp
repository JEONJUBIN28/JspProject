<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>투표 입력 폼</title>

    <script>
        const validateForm = (e) => {
            e.preventDefault();

            const form = e.target;
            const formData = new FormData(form);

            const jumin = formData.get('jumin').trim();
            const name = formData.get('name').trim();
            const voteNo = formData.get('voteNo');
            const voteTime = formData.get('voteTime').trim();
            const voteArea = formData.get('voteArea').trim();

            if (!jumin || !name || !voteNo || !voteTime || !voteArea) {
                alert("모든 값을 입력해 주세요.");
                return false;
            }

            if (!document.getElementById('confirm').checked) {
                alert("유권자 확인을 해주세요.");
                return false;
            }
            form.submit();
        }
    </script>
</head>
<body>
    <%@ include file="navbar.jsp" %>

    <div class="container mt-4">
        <h1 class="mb-4">투표 입력 폼</h1>
        <form action="addvote.do" method="post" onsubmit="validateForm(event)">
            <div class="form-group">
                <label for="jumin">주민번호:</label>
                <input type="text" id="jumin" name="jumin" class="form-control" maxlength="13" required />
            </div>

            <div class="form-group">
                <label for="name">성명:</label>
                <input type="text" id="name" name="name" class="form-control" maxlength="50" required />
            </div>

            <div class="form-group">
                <label for="voteNo">투표번호:</label>
                <select id="voteNo" name="voteNo" class="form-control" required>
                    <option value="">선택하세요</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="1">3</option>
                    <option value="2">4</option>
                    <option value="2">5</option>
                </select>
            </div>

            <div class="form-group">
                <label for="voteTime">투표시간:</label>
                <input type="text" id="voteTime" name="voteTime" class="form-control" maxlength="5" placeholder="HHMM" required />
            </div>

            <div class="form-group">
                <label for="voteArea">투표장소:</label>
                <input type="text" id="voteArea" name="voteArea" class="form-control" maxlength="50" required />
            </div>

            <div class="form-group">
                <label>유권자 확인:</label>
                <div class="form-check">
                    <input type="radio" id="confirm" name="confirm" value="Y" class="form-check-input" required />
                    <label for="confirm" class="form-check-label">유권자 확인</label>
                </div>
                <div class="form-check">
                    <input type="radio" id="No" name="confirm" value="N" class="form-check-input" checked />
                    <label for="No" class="form-check-label">유권자 미확인</label>
                </div>
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-primary">투표하기</button>
                <button type="reset" class="btn btn-secondary">다시하기</button>
            </div>
        </form>
    </div>

</body>
</html>
