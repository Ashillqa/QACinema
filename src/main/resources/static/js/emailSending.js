function sendEmail() {
    var username = document.getElementById("username").value;
    var email = document.getElementById("email").value;
    var subject = document.getElementById("subject").value;
    var feedback = document.getElementById("feedback").value;

    console.log(email);

    let info = `{"email": "${email}", "username": "${username}", "subject": "${subject}", "body": "${feedback}"}`;

    console.log(info);
    axios.post(`http://${window.location.href.toString().split("/")[2]}/sendEmail`, JSON.parse(info)).then(res =>  {
            // alert(data);
            console.log(res);
            // location.replace("paymentComplete.html");
        });
}