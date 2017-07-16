<?php
  if(isset( $_POST["username"])){
    $username = $_POST["username"];
  }else {
    return false;
  }


  $servername = "localhost";
  $usernamedb = "root";
  $password = "";
  $db = "maps";

  // Create connection
  $conn = mysqli_connect($servername, $usernamedb, $password,$db);

  // Check connection
  if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
  }

  $sql = "select * from user where name='".$username."'";

  $result = mysqli_query($conn, $sql);

  if (mysqli_num_rows($result) > 0) {
      $finalresult = mysqli_fetch_assoc($result);
      echo json_encode($finalresult);
  } else {
    return false;
  }
 ?>
