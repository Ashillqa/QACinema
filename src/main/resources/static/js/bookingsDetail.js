document.getElementById("movieName").innerHTML = sessionStorage.getItem(
  "movieName"
);

document.getElementById("movieTime").innerHTML = sessionStorage.getItem(
  "movieTime"
);

document.getElementById("customerName").innerHTML = sessionStorage.getItem(
  "name"
);
document.getElementById("customerEmail").innerHTML = sessionStorage.getItem(
  "email"
);
document.getElementById("customerPhone").innerHTML = sessionStorage.getItem(
  "phone"
);

document.getElementById("ticketNumber").innerHTML =
  "Adult:" +
  sessionStorage.getItem("adult") +
  ", Child:" +
  sessionStorage.getItem("child") +
  ", Student:" +
  sessionStorage.getItem("student");

let status;

if (sessionStorage.getItem("upgrade") === "true"){
    status = "YES";
}
else {
    status = "NO";
}

console.log(sessionStorage.getItem("upgrade"));
document.getElementById("upgrade").innerHTML = "Upgrade: " + status;


document.getElementById("totalPrice").innerHTML = "Total: £" + sessionStorage.getItem("total");

