<?php
include "db.php";

// sql query
$sql = "SELECT * FROM game ORDER BY title asc";

// execute
$result = $conn->query($sql);

// if any result
if ($result->num_rows > 0) {

        echo "<table><th>Title</th><th>Release Year</th><th>Genre</th><th>Platform</th><th>Rating</th>";

        while($row = $result->fetch_assoc()) {
                echo "<tr><td>".$row['title']."</td><td>".$row['year']."</td><td>".$row['genre']."</td><td>".$row['platform']."</td><td>".$row['rating']."</td></tr>";
  }
} else {
  echo "0 results";
}

// close connection
$conn->close();
?>