function sendEmail() {
    var username = document.getElementById("username").value;
    var email = document.getElementById("email").value;
    var subject = document.getElementById("subject").value;
    var feedback = document.getElementById("feedback").value;

    console.log(email);

    let info = `{"email": "${email}", "username": "${username}", "subject": "${subject}", "body": "${feedback}"}`;

    console.log(info);
    axios.post(`/sendEmail`, JSON.parse(info)).then(res =>  {
        alert("Thank you for your feedback!\n_______________________________\n" +
            "Your Email has now been successfully sent!\n_______________________________\n" +
        "We will get back to you if we need to via the email address that you have specified");
            console.log(res);
            // location.replace("paymentComplete.html");
        });
}