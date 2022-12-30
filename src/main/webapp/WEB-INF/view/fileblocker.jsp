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

        .custom-bnt:active{
            background-color: cadetblue;
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
                                ${fixedExtn.name} <input type="checkbox" value="${fixedExtn.name}" checked>
                            </c:when>
                            <c:otherwise>
                                ${fixedExtn.name} <input type="checkbox" value="${fixedExtn.name}">
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
<%--                    bat <input type="checkbox">&nbsp;--%>
<%--                    cmd <input type="checkbox">&nbsp;--%>
<%--                    com <input type="checkbox">&nbsp;--%>
<%--                    cpl <input type="checkbox">&nbsp;--%>
<%--                    exe <input type="checkbox">&nbsp;--%>
<%--                    scr <input type="checkbox">&nbsp;--%>
<%--                    js <input type="checkbox">&nbsp;--%>
                </span>
                <div class="bot">
                    <div>
                        <input type="text" oninput="handleOnInput(this, 20)" placeholder="확장자 입력"
                            id="inputExtn">
                        &nbsp;
                        <button type="button" onclick="addCustomBtn()">+추가</button>
                    </div>
                    <br>
                    <div class="custom-box">
                        <p style="font-size: 10px">${count}/200</p>
                        <div class="custom-btn-box">
                            <c:forEach var="customExtn" items="${custom_list}">
                                <button type="button" class="custom-bnt">
                                    ${customExtn.name} <a onclick="">x</a>
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

    function handleOnInput(el, maxlength) {
        if(el.value.length > maxlength)  {
            el.value
                = el.value.substr(0, maxlength);
        }
    }

    function addCustomBtn(){
        const extn = document.getElementById('inputExtn');
        axios({
            method:'post',
            url:'add-extn',
            data: {'name': extn.value}
        }).then(res=>{
            console.log(res);
            location.reload();
        })
    }


</script>
</html>
