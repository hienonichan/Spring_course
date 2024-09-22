<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
                <meta name="author" content="Hỏi Dân IT" />
                <title>Create User</title>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <script>
                    $(document).ready(() => {
                        const avatarFile = $("#avatarFile");
                        avatarFile.change(function (e) {
                            const imgURL = URL.createObjectURL(e.target.files[0]);
                            $("#avatarPreview").attr("src", imgURL);
                            $("#avatarPreview").css({ "display": "block" });
                        });
                    });
                </script>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>

            </head>
            <jsp:include page="../layout/header.jsp" />
            <div id="layoutSidenav">
                <jsp:include page="../layout/sidebar.jsp" />
                <div id="layoutSidenav_content">
                    <main>
                        <div class="container-fluid px-4">
                            <h1 class="mt-4">Create User</h1>
                            <a href="/admin">Dashboard</a>
                            <div class="container mt-5">
                                <div class="row">
                                    <div class="col-md-6 mx-auto">
                                        <h1>Create User</h1>
                                        <hr />
                                        <form:form action="/admin/user/create" method="POST" modelAttribute="newUser"
                                            enctype="multipart/form-data">
                                            <div class="row">
                                                <div class="col-12 col-md-6">
                                                    <form:label path="email" class="form-label">Email</form:label>
                                                    <c:set var="ErrorEmail">
                                                        <form:errors path="email" cssClass="invalid-feedback" />
                                                    </c:set>
                                                    <form:input type="email" path="email"
                                                        class="form-control ${not empty ErrorEmail ? 'is-invalid':''}" />
                                                    ${ErrorEmail}
                                                </div>
                                                <div class="col-12 col-md-6">
                                                    <div class="mb-3">
                                                        <form:label path="password" class="form-label">Password
                                                        </form:label>
                                                        <c:set var="ErrorPassword">
                                                            <form:errors path="password" cssClass="invalid-feedback" />
                                                        </c:set>
                                                        <form:input type="password" path="password"
                                                            class="form-control ${not empty ErrorPassword ? 'is-invalid' : ''}" />
                                                        ${ErrorPassword}
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <div class="col-12 col-md-6">
                                                    <div class="mb-3">
                                                        <c:set var="ErrorName">
                                                            <form:errors path="name" cssClass="invalid-feedback" />
                                                        </c:set>
                                                        <form:label path="name" class="form-label">Name</form:label>
                                                        <form:input type="text" path="name"
                                                            class="form-control  ${not empty ErrorName ? 'is-invalid':''}" />
                                                        ${ErrorName}
                                                    </div>
                                                </div>
                                                <div class="col-12 col-md-6">
                                                    <div class="mb-3">
                                                        <form:label path="phone" class="form-label">Phone</form:label>
                                                        <form:input type="text" path="phone" class="form-control" />
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="mb-3">
                                                <form:label path="address" class="form-label">Address</form:label>
                                                <form:input type="text" path="address" class="form-control" />
                                            </div>

                                            <div class="row">
                                                <div class="col-12 col-md-6">
                                                    <div class="mb-3">
                                                        <label for="role">Role</label>
                                                        <form:select path="role.name" class="form-select mb-3" id="role"
                                                            aria-label="Default select example">
                                                            <form:option value="ADMIN">ADMIN</form:option>
                                                            <form:option value="USER">USER</form:option>
                                                        </form:select>
                                                    </div>
                                                </div>
                                                <div class="col-12 mb-3 col-md-6">
                                                    <div class="mb-3">
                                                        <label for="avatarFile" class="form-label">Avatar</label>
                                                        <input class="form-control" type="file" id="avatarFile"
                                                            name="avatarFile" accept=".png, .jpg, .jpeg">
                                                    </div>
                                                </div>

                                                <div class="col-12 mb-3">
                                                    <img style="max-height:250px; display: none;" alt="avatar preview"
                                                        id="avatarPreview">
                                                </div>
                                            </div>
                                            <div class="col-12 col-md-6">
                                                <button type="submit" class="btn btn-primary">Create</button>
                                            </div>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                    </main>
                    <jsp:include page="../layout/footer.jsp" />
                </div>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                crossorigin="anonymous"></script>
            <script src="/js/scripts.js"></script>
            </body>

            </html>