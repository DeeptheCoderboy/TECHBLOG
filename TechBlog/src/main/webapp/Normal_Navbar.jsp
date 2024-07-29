<%@page import="com.tech.blog.entities.User"%>

<nav class="navbar navbar-expand-lg navbar-dark primary-background">
    <a class="navbar-brand" href="index.jsp"> <span class="fa fa-asterisk"></span>   Tech Blog</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#"> <span class="	fa fa-bell-o"></span> Deep<span class="sr-only">(current)</span></a>
            </li>

            <li class="nav-item ">
            
            <%
                            
                            User user2=(User)session.getAttribute("currentUser");
                            if(user2!=null){%>
                             <a class="nav-link dropdown-toggle" href="profile.jsp" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="	fa fa-check-square-o"></span> Categories
                              </a>
                            <%} %>
                            <%if(user2==null){ %>
                             <a class="nav-link dropdown-toggle" href="login_page.jsp" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="	fa fa-check-square-o"></span> Categories
                              </a>
                           <%} %>
               
               
            </li>

            
            <li class="nav-item">
                <a class="nav-link" href="login_page.jsp"> <span class="fa fa-user-circle "></span> Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="register_page.jsp"> <span class="fa fa-user-plus "></span> Sign up</a>
            </li>

        </ul>
        <form class="form-inline my-2 my-lg-0" action="NavSearchServlet" method="post">
            <input name="searching" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>