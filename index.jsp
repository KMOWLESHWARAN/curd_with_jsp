<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>JSP Home</title>
</head>
<style>
  body{
    background-color: coral;
  }
</style>
<body>
  <h2>CURD OPERATION</h2>

  <p>Add product data into DB:</p>
  <form action="<%= request.getContextPath() %>/insertData" method="post">
    <label for="id">Product ID:</label>
    <input type="text" name="id" id="id" required><br><br>

    <label for="name">Product Name:</label>
    <input type="text" name="name" id="name" required><br><br>

    <button type="submit">Insert</button>
  </form>

  <hr>

  <p>Delete product in DB:</p>
  <form action="<%= request.getContextPath() %>/deleteData" method="post">
    <label for="id">Product ID:</label>
    <input type="text" name="id" id="id" required><br><br>

    <button type="submit">Delete</button>
  </form>
  
  <hr>

  <p>Update product data in DB:</p>
  <form action="<%= request.getContextPath() %>/updateData" method="post">
    <label for="id">Product ID:</label>
    <input type="text" name="id" id="id" required><br><br>

    <label for="name">Product Name:</label>
    <input type="text" name="name" id="name" required><br><br>

    <button type="submit">Update</button>
  </form>

  <hr>

  <p>Click here to view product details:</p>
  <button type="button" id="btnJs">Click me</button>
  <button type="button" id="btnJsdata">View Products</button>

  <script>
    document.getElementById('btnJs').addEventListener('click', function () {
    window.location.href = '<%= request.getContextPath() %>/dbtest';
    });

    document.getElementById('btnJsdata').addEventListener('click', function () {
      window.location.href = '<%= request.getContextPath() %>/dbtestdata';
    });
  </script>

</body>
</html>
