<!DOCTYPE html>
<%@page import="jb_customer_package.SaveCustomer"%>
<html lang="en" class="nojs">
<head>
  <title>Production Problem 01</title>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width,initial-scale=1.0,shrink-to-fit=no" />
  <link rel="stylesheet" media="screen" href="screen.css" />
  <link rel="stylesheet" href="//basehold.it/22" />
</head>
<body>
  <h1>Form</h1>
  <p class="warning">
  <%if (SaveCustomer.flag == true) {%>
  <%for(int x = 0; x < SaveCustomer.errorViolation.size();x++ ) {%>
  <%out.println(SaveCustomer.errorViolation.get(x) + "</br>");} }%>
  </p>
  <form id="signup-form">
    <ol id="form-content">
      <li id="form-item-name">
        <label for="name">Name </label>
        <input type="text" name="name" placeholder="John Doe" id="name" />
      </li>
      <li id="form-item-ssn">
        <label for="ssn">Social Security Number </label>
        <input type="text" name="ssn" placeholder="333-33-3333" id="ssn" />
      </li>
      <li>
        <label for="zip">Zip Code </label>
        <input type="text" name="zip" placeholder="12345-1234" id="zip" />
      </li>
      <li>
        <label for="email">Email </label>
        <input type="email" name="email" placeholder="JohnDoe@example.com" id="email" />
      </li>
      <li id="form-item-address">
        <label for="address">Address </label>
        <input type="text" name="address" placeholder="12234 S Street" id="address" />
      </li>
      <li>
        <label for="city">City </label>
        <input type="text" name="city" placeholder="City" id="city" />
      </li>
      <li>
        <label>Select State</label>
        <select name="states" form="signup-form" id="state">
        	<option value="AL">Alabama</option>
        	<option value="AK">Alaska</option>
        	<option value="AZ">Arizona</option>
        	<option value="AR">Arkansas</option>
        	<option value="CA">California</option>
        	<option value="CO">Colorado</option>
        	<option value="CT">Connecticut</option>
        	<option value="DE">Delaware</option>
        	<option value="DC">District Of Columbia</option>
        	<option value="FL">Florida</option>
        	<option value="GA">Georgia</option>
        	<option value="HI">Hawaii</option>
        	<option value="ID">Idaho</option>
        	<option value="IL">Illinois</option>
        	<option value="IN">Indiana</option>
        	<option value="IA">Iowa</option>
        	<option value="KS">Kansas</option>
        	<option value="KY">Kentucky</option>
        	<option value="LA">Louisiana</option>
        	<option value="ME">Maine</option>
        	<option value="MD">Maryland</option>
        	<option value="MA">Massachusetts</option>
        	<option value="MI">Michigan</option>
        	<option value="MN">Minnesota</option>
        	<option value="MS">Mississippi</option>
        	<option value="MO">Missouri</option>
        	<option value="MT">Montana</option>
        	<option value="NE">Nebraska</option>
        	<option value="NV">Nevada</option>
        	<option value="NH">New Hampshire</option>
        	<option value="NJ">New Jersey</option>
        	<option value="NM">New Mexico</option>
        	<option value="NY">New York</option>
        	<option value="NC">North Carolina</option>
        	<option value="ND">North Dakota</option>
        	<option value="OH">Ohio</option>
        	<option value="OK">Oklahoma</option>
        	<option value="OR">Oregon</option>
        	<option value="PA">Pennsylvania</option>
        	<option value="RI">Rhode Island</option>
        	<option value="SC">South Carolina</option>
        	<option value="SD">South Dakota</option>
        	<option value="TN">Tennessee</option>
        	<option value="TX">Texas</option>
        	<option value="UT">Utah</option>
        	<option value="VT">Vermont</option>
        	<option value="VA">Virginia</option>
        	<option value="WA">Washington</option>
        	<option value="WV">West Virginia</option>
        	<option value="WI">Wisconsin</option>
        	<option value="WY">Wyoming</option>
        </select>
      </li>
      <li>
        <button id="button" type="button">Complete Sign Up!</button>
      </li>
    </ol>
  </form>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="site.js"></script>
 <script src="map.js"></script> 
</body>
</html>
