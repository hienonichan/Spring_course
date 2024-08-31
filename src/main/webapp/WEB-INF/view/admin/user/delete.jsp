<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Delete User ${user.getId()}</title>
                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

                <link rel="stylesheet" href="/css/decor.css">
            </head>

            <body>
                <div class="container mt-5">
                    <div class="row">
                        <div class="col mx-auto">
                            <h3>Delete User Id : ${Id}</h3>
                            <hr />
                            <div class="alert alert-danger d-flex align-items-center" role="alert">
                                <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img"
                                    aria-label="Danger:">
                                    <use xlink:href="#exclamation-triangle-fill" />
                                </svg>
                                <div>
                                    Are you sure to delete this data?
                                </div>

                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col">
                            <form action="/admin/user/${Id}/delete" method="POST">
                                <button type="submit" class="btn btn-danger">Confirm</button>
                            </form>
                            <a href="/admin/user" class="btn btn-success">Back</a>
                        </div>
                    </div>
            </body>

            </html>