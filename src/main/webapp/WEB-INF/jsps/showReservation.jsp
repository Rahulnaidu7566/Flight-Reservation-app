<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
     <pre>
     <h2>Flight Details</h2>
     Flight Number: ${flight.flightNumber}
     Operating Airlines: ${flight.operatingAirlines}
     Departure City: ${flight.departureCity}
     Arrival City: ${flight.arrivalCity}
     Departure Date: ${flight.dateOfDeparture}
     Estimated Time: ${flight.estimatedDepartureTime}
     </pre>
     
     <h2>Enter Passenger Details</h2>
     <form action="confirmReservation"method="post">
     <pre>
     first name<input type="text" name="firstName"/>
     last name<input type="text" name="lastName"/>
     middle name<input type="text" name="middleName"/>
     email <input type="text" name="email"/>
     phone<input type="text" name="phone"/>
     <input type="hidden" name="flightId" value="${flight.id}"/>
     
     <h2>Enter the payment details</h2>
     Name On Card<input type="text" name="nameOfTheCard"/>
     Card Number<input type="text" name="cardNumber"/>
     Cvv<input type="text" name="cvv"/>
     Expiry Date<input type="text" name="expiryDate"/>
     Amount<input type="text" name="amount"/>
     <input type="submit" name="complete reservation"/>
     </pre>
     </form>
</body>
</html>

