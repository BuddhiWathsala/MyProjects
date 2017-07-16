<?php
  if(isset( $_POST["uid"])){
    $uid = $_POST["uid"];

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
    //$uid = 1;
    $date = date("Y-m-d h:i");

    $sql1 = "insert into request(u_id,date) values($uid,'$date')";
    $result = mysqli_query($conn,$sql1);

    if($result)
    {
      echo "true";
    }else{
      echo false;
    }

 ?>
