<?php
  if((isset( $_POST["username"]))&&(isset( $_POST["lat"]))&&(isset( $_POST["lon"]))){
    $username = $_POST["username"];
    $lat = round(floatval($_POST["lat"]),6);
    $lon = round(floatval($_POST["lon"]),6);
  }else {
    return false;
  }
  /*$username = "Sudu putha";
  $lat = floatval("6.87");
  $lon = floatval("80.6");*/

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
      return false;

  } else {
    $sql1 = "insert into user(name,lat,lng) values('$username','$lat','$lon')";
    $result = mysqli_query($conn,$sql1);

    if($result)
    {
      $sql = "select * from user where name='".$username."'";
      $result = mysqli_query($conn, $sql);
      if (mysqli_num_rows($result) > 0) {
          $finalresult = mysqli_fetch_assoc($result);
          echo json_encode($finalresult);
      } else {
        return false;
      }
    }else{
      echo false;
    }
  }
 ?>
