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
                <title>Product detail</title>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>
            <jsp:include page="../layout/header.jsp" />
            <div id="layoutSidenav">
                <jsp:include page="../layout/sidebar.jsp" />
                <div id="layoutSidenav_content">
                    <main>
                        <div class="container-fluid px-4">
                            <h1 class="mt-4">Product Detail</h1>
                            <a href="/admin">Dashboard</a>
                            <div class="container mt-5">
                                <div class="row">
                                    <div class="col mx-auto">
                                        <h1>Product detail Id : ${product.getId()}</h1>
                                        <hr />

                                        <div class="card" style="width:60%">
                                            <div class="card-header">
                                                Product Information
                                            </div>

                                            <img class="image-detail-product mx-auto"
                                                src="/image/product/${product.getImage()}" alt="product image">

                                            <ul class="list-group list-group-flush">
                                                <li class="list-group-item">ID : ${product.getId()}</li>
                                                <li class="list-group-item">Name : ${product.getName()}</li>
                                                <li class="list-group-item">Price : ${product.getPrice()}</li>
                                                <li class="list-group-item">Target : ${product.getTarget()}</li>
                                                <li class="list-group-item">detailDesc : ${product.getDetailDesc()}</li>
                                                <li class="list-group-item">shortDesc : ${product.getShortDesc()}</li>
                                                <li class="list-group-item">Quantity : ${product.getQuantity()}</li>
                                                <li class="list-group-item">Sold number : ${product.getSold()}</li>
                                                <li class="list-group-item">image : ${product.getImage()}</li>
                                            </ul>
                                        </div>
                                        <hr />
                                        <a href="/admin/product" class="btn btn-success">Back</a>
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