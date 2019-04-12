function validateForm() {
  var errMessages = "";
  errMessages = validatefirstname(errMessages);
  errMessages = validatelastname(errMessages);

  errMessages = validatemail(errMessages);

  errMessages = validateaddress(errMessages);
  errMessages = validatecity(errMessages);
  errMessages = validateprovince(errMessages);


  if (errMessages !== "") {
    showErrors(errMessages);
    return false;
  }
  else {
    clearShowErrors();
    var firstname = document.getElementById('fName').value;
    firstname = firstname.toUpperCase();
    document.getElementById('fName').value = firstname;
    var lastname = document.getElementById('sName').value;
    lastname = lastname.toUpperCase();
    document.getElementById('lName').value = lastname;
    return true;
  }
}

function showErrors(messages) {
  document.getElementById('reserved').innerHTML = messages;

}  //  End of function



function clearShowErrors() {
  document.getElementById('reserved').innerHTML = "";
}  //  End of function

function validatefirstname(messages) {
  var firstname = document.getElementById('fName').value;
  if (firstname.length === 0) {
    messages += "FirstName must be present" + "<br>";
  }
  else if (!isNaN(firstname)) {
    messages += "Allowable characters - upper or lower alphabets - one optional hyphen" + "<br>";
  }

  else if (firstname.length < 3) {
    messages += "Must have at least 3 alphabets at the beginning" + "<br>";
  }

  else if (firstname.charAt(firstname.length - 1) === '-') {
    messages += "If a hyphen is present, the hyphen cannot be at the end" + "<br>";
  }
  return messages;
}

function validatelastname(messages) {
  var lastname = document.getElementById('sName').value;

  if (lastname.length === 0) {
    messages += "SurName must be present" + "<br>";
  }

  if (!isNaN(lastname)) {
    messages += "Allowable characters - upper or lower alphabets - one optional hyphen" + "<br>";
  }

  if (lastname.length < 4) {
    messages += "Must have at least 4 alphabets at the beginning" + "<br>";
  }


  if (lastname.charAt(lastname.length - 1) === '-' || lastname.charAt(lastname.length - 1) === "'") {
    messages += "If a hyphen or an apostrophe are present, they cannot be at the end" + "<br>";
  }

  var hyphen = -1;
  var apostrophe = -1;
  for (var i = 0; i < lastname.length; i++) {
    if (lastname[i] === "'") {
      if (apostrophe !== -1) {
        return { messages: "Client name must contain at most one aprostrophes (')" };
      } else {
        apostrophe = i;
      }

    }
    else if (lastname[i] === "-") {
      if (hyphen !== -1) {
        return { messages: "Client name must contain at most one hyphen (-)" };
      } else {
        hyphen = i;
      }
    }
  }

  if (hyphen !== -1 && apostrophe !== -1) {
    var diff = hyphen - apostrophe;
    if (diff === 1 || diff === -1) {
      return messages += "Client name can't have an apostrophe (') and a hyphen (-) next to each other";
    }
  }

  return messages;
}

function validatemail(messages) {
  var email = document.getElementById('email').value;
  if (email.length === 0) {
    messages += "Email Must be present" + "<br>";
  }

  var myarray = email.split('@');
  for (var i = 0; i < myarray.length; i++) {
    if (myarray[i].length < 3) {
      messages += "minimum 3 - can be alphabets or numbers or a mix" + "<br>";
    }
  }

  var myarray1 = email.split('.');
  if (myarray1[1] !== "com") {
    messages += "can only be com or ca" + "<br>";
  }

  var count = 0;

  for (var i = 0; i < email.length; i++) {
    if (email.charAt(i) == "@") {
      count++;
    }
  }

  if (count > 1) {
    messages += "only one @ character is allowed in the email address" + "<br>";
  }

  var countdot = 0;
  for (var i = 0; i < email.length; i++) {
    if (email.charAt(i) == ".") {
      countdot++;
    }
  }

  if (countdot > 1) {
    messages += "only one . character is allowed in the email address" + "<br>";
  }

  if (email.charAt(email.length - 1) === '.' || email.charAt(email.length - 1) === "@") {
    messages += "The @ or the period [.] cannot be at the beginning or at the end of the email address" + "<br>";
  }

  var at = -1;
  var dot = -1;
  for (var i = 0; i < email.length; i++) {
    if (email[i] === ".") {

      at = i;
    }


    else if (email[i] === "@") {

      dot = i;
    }

  }

  if (dot !== -1 && at !== -1) {
    var diff1 = dot - at;
    if (diff1 === 1 || diff1 === -1) {
      return messages += "Client name can't have (@) and a hyphen (.) next to each other";
    }
  }
  return messages;
}

function validateaddress(messages) {
  var address = document.getElementById('address').value;

  if (address.length === 0) {
    messages += "Address Must be Present" + "<br>";
  }

  var counting = 0;
  for (var i = 0; i < address.length; i++) {
    if (address.charCodeAt(i) >= 65 && address.charCodeAt(i) <= 90 || address.charCodeAt(i) >= 97 && address.charCodeAt(i) <= 121) {
      counting++;
    }
  }

  if (counting < 5) {
    messages += "Must have atleast 5 alphabets" + "<br>";
  }

  return messages;
}

function validatecity(messages) {
  var city = document.getElementById('city').value;
  if (city.length === 0) {
    messages += "City must be present" + "<br>";
  }

  else if (!isNaN(city)) {
    messages += "Allowable characters - upper or lower alphabets - one optional hyphen" + "<br>";
  }

  var counting = 0;
  for (var i = 0; i < city.length; i++) {
    if (city.charCodeAt(i) >= 65 && city.charCodeAt(i) <= 90 || city.charCodeAt(i) >= 97 && city.charCodeAt(i) <= 121) {
      counting++;
    }
  }

  if (counting < 5) {
    messages += "Must have atleast 5 alphabets at the beginning" + "<br>";
  }

  if (city.charAt(city.length - 1) === '-') {
    messages += "If a hyphen is present, it cannot be at the end" + "<br>";
  }

  return messages;
}

function validateprovince(messages) {
  var province = document.getElementById('province').value;
  if (province.length === 0) {
    messages += "A Province must be selected from the list of provinces";
  }
  return messages;
}