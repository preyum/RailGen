<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Book a Train</title>
    <link rel="stylesheet" type="text/css" href="../css/styles.css">
</head>
<body>
    <h1>Book a Train</h1>
    <form action="../BookingServlet" method="post">
        <label for="name">Your Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="train">Select Train:</label>
        <select id="train" name="train">
            <option value="Viking Express">Viking Express</option>
            <option value="Valhalla Cruiser">Valhalla Cruiser</option>
        </select><br>
        <label for="fare">Fare:</label>
        <input type="text" id="fare" name="fare" required><br>
		<label for="origin">Origin:</label>
		<input type="text" id="origin" name="origin" required><br>
		<label for="destination">Destination:</label>
		<input type="text" id="destination" name="destination" required><br>

        <input type="submit" value="Book Now">
    </form>
</body>
</html>
