<div id="wrap">
    <header id="header">
      <div class="inner">
        <!-- 로고 -->
        <h1 id="top-logo">
          <a href="/medici/signup/mypage.jsp">ARANG</a>
        </h1>
        <!-- 메인메뉴 -->
        <nav id="top-nav">
          <ul class="center_menu">
            <li><a href="/medici/page/artists_all.jsp">Artists</a></li>
            <li><a href="/medici/page/gallerys.jsp">Gallerys</a></li>
            <li><a href="/medici/list.do">Exhibitions</a></li>
            <li><a href="/medici/service/storage_service2.jsp">Storage</a></li>
            <li><a href="/medici/list.do">Notice</a></li>
          </ul>
          <ul class="side_menu">
            <li><a href="/medici/signup/select_user.do"><img class="top-img" src="../img/find.png"></a></li>
            <li><a href="/medici/signup/myInfo.jsp"><img class="top-img" src="../img/mypage.png"></a></li>
            <li><a href="/medici/signup/select_user2.do"><img class="top-img" src="../img/like.png"></a></li>
            <li><a href="#"><img class="top-img" src="../img/cart.png"></a></li>
			<c:if test="${userId==null}">
        	<li><a href='<c:url value="/signup/login"/>'>login</a></li>
        	</c:if>
            <c:if test="${userId!=null&&userId!='admin'}">
            <li><a href='<c:url value="/signup/logout"/>'>logout</a></li>
         	</c:if>
            <c:if test="${userId!=null&&userId=='admin'}">
            <li><a href='<c:url value="/signup/logout"/>'>logout</a></li>
            <li>${userId}(관리자)</li>
        	</c:if>
          </ul>
        </nav>
      </div>
    </header>