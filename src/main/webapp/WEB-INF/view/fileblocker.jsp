<%--
  Created by IntelliJ IDEA.
  User: kimsungmin
  Date: 2022/12/30
  Time: 4:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <style>
        ul {
            display: flex;
        }
        li {
            list-style: none;
        }

        .bot{
            margin-top: 20px;
        }

        .custom-box {
            width: 250px;
            height: 250px;
            border: 1px solid gray;
            border-radius: 3px;
            padding: 0px 10px 10px;
        }

        .custom-bnt{
            border: 1px solid gray;
            border-radius: 3px;
            background-color: aliceblue;
        }

        .custom-bnt:hover {
            background-color: cadetblue;
        }

        .custom-bnt>a:hover {
            cursor: pointer;
        }

    </style>
</head>
<c:set var="root" value="<%=request.getContextPath()%>"/>
<body>
    <div>
        <h1>&nbsp;파일 확장자 차단</h1>
        <hr/>
        <ul>
            <li style="margin-right:20px">
                <div><b>고정 확장자</b></div>
                <div class="bot"><b>커스텀 확장자</b></div>
            </li>
            <li>
                <span>
                    <c:forEach var="fixedExtn" items="${fixed_list}">
                        <c:choose>
                            <c:when test="${fixedExtn.status == 1}">
                                ${fixedExtn.name} <input type="checkbox" id="${fixedExtn.name}"
                                                         onchange="fixedCheck('${fixedExtn.name}')" checked>&nbsp;
                            </c:when>
                            <c:otherwise>
                                ${fixedExtn.name} <input type="checkbox" id="${fixedExtn.name}"
                                                         onchange="fixedCheck('${fixedExtn.name}')">&nbsp;
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </span>
                <div class="bot">
                    <div>
                        <input type="text" oninput="handleOnInput(this, 20)" placeholder="확장자 입력"
                            id="inputExtn">
                        &nbsp;
                        <button type="button" onclick="blkCustom()">+추가</button>
                    </div>
                    <br>
                    <div class="custom-box">
                        <p style="font-size: 10px">${count}/200</p>
                        <div class="custom-btn-box">
                            <c:forEach var="customExtn" items="${custom_list}">
                                <button type="button" class="custom-bnt">
                                    ${customExtn.name} <a onclick="unBlkCustom('${customExtn.name}')">x</a>
                                </button>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</body>
<script>

    /* 고졍형 확장자 체크박스 클릭시 차단/차단해제 요청 함수 */
    function fixedCheck(name){
        const checkExtn = document.getElementById(name);

        if(checkExtn.checked === true){
            axios({
                method: 'put',
                url:'block/fixed/'+ name,
            }).then(res=>{
                location.reload();
            })
        } else {
            axios({
                method: 'put',
                url:'unblock/fixed/'+name,
            }).then(res=>{
                location.reload();
            })
        }
    }

    /* input text 개수 제한 함수 */
    function handleOnInput(el, maxlength) {
        if(el.value.length > maxlength)  {
            el.value = el.value.substr(0, maxlength);
        }
    }

    /* 커스텀 확장자 차단 비동기 요청 함수 */
    function blkCustom(){
        const extn = document.getElementById('inputExtn');
        axios({
            method:'post',
            url:'block/custom',
            data: {'name': extn.value}
        }).then(res=>{
            alert(res.data);
            location.reload();
        }).catch(ex=>{
            alert(ex.response.data);
            extn.value = null;
        })
    }

    /* 커스텀 확장자 차단해제 비동기 요청 함수 */
    function unBlkCustom(name) {
        axios({
            method:'delete',
            url:'unblock/custom/'+ name,
        }).then(res=>{
            location.reload();
        })
    }

</script>
</html>
