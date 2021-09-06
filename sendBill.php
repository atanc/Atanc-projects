
<html>

<!--Customer IDs for the site are 20310, 20311, and 20312 -->
<head> 
        <title> Lee's Landscape </title>

<link rel="stylesheet" href="css/style.css">
</head>
<body>
<?php
include "db.php";
?>
<form method="post">
<h2> Get Billing Information </h2><br>
<!-- To Get customer ID from User -->
<strong><label> Customer ID : </label></strong> <input type-"text" name="cid" value="<?php if(isset($_POST['btnsbt'])){ echo $_POST['cid']; } ?>" required/><br><br>
<input type="submit" value="Get Details" name="btnsbt"/>
  
  <br>
  <br>
<!-- to Display Message-->
<span id="msg"></span>
</form>

<?php
if(isset($_POST["btnsbt"]))
{
        $cid = $_POST["cid"];


//Below basically selects information from the database, and joins the data

$sql = "SELECT * FROM customer,billing where customer.customer_ID = billing.customer_ID AND customer.customer_ID=$cid";
$result = $conn->query($sql);
if ($result->num_rows > 0) {

//Declare the table body
echo "<table>
<tr>
<th>Customer ID</th>
<th>Customer L Name</th>
<th>Customer F Name</th>
<th>Street address</th>
<th>Service</th>
<th>Customer Bill</th>
<th>Amount Paid</th>
<th>Bill Date</th>
<th>Bill Status</th>
</tr>";

while($row = $result->fetch_assoc()) {
//Now will fetch all the data from tables
$c_id = $row["customer_ID"];
$customer_L_Name = $row["customer_L_Name"];
$customer_F_Name = $row["customer_F_Name"];
$customer_Title = $row["customer_Title"].", ";
$customer_Email = $row["customer_Email"];
$street_Address = $row["street_Address"];
$service = $row["service"];
$customer_bill = $row["customer_bill"];
$amt_paid = $row["amt_paid"];
$bill_date = $row["bill_date"];
$calculate = $customer_bill - $amt_paid; //See if balance is there
$status = "None";

if ($calculate == 0) {
//if customer_bill - amt_paid = 0 then no dues are present
$message = "Hey,".$customer_Title."$customer_L_Name Greetings from Lee, </br> You have no dues and I wish for continued business with you.</br> Thank You.";
$status = "No dues";
}

elseif ($calculate > 0) {
//if customer_bill - amt_paid > 0 then due of $(customer_bill - amt_paid) is present
$message = "Hello,".$customer_Title."$customer_L_Name this is Mr. Lee. </br> You have approximately $".$calculate." due for your order of $service on $bill_date </br> Please pay your remaining balance. \n Thank you";
$status = "Due of $calculate";
}

else{
//if customer_bill - amt_paid < 0 then credit of $ abs(customer_bill - amt_paid) is present
$calculate = abs($calculate);
$status = "Credit of $calculate";
$message = "Hey,".$customer_Title."$customer_L_Name Greetings from Lee, </br> You have credit of $ $calculate and I wish for continued business with you.</br> Thank You.";
}

//Display Customers Billing information along with suitable message
  
echo "<tr><td>".$c_id."</td>
<td>".$customer_L_Name."</td>
<td>".$customer_F_Name."</td>
<td>".$street_Address."</td>
<td>".$service."</td>
<td>".$customer_bill."</td>
<td>".$amt_paid."</td>
<td>".$bill_date."</td>
<td>".$status."</td>
</tr>";

}
echo "</table>";
echo 
"<br/>

<strong>Message :</strong> ";

echo 

"<br/>

<font color=purple> $message</font>";

} else 
{
echo "<h3>0 results</h3>";
}
}
?>