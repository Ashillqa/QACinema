
let empty = false;

function sendEmail(event) {
    event.preventDefault();
    var username = document.getElementById("username").value;
    var email = document.getElementById("email").value;
    var subject = document.getElementById("subject").value;
    var feedback = document.getElementById("feedback").value;



    const emailValidator = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    let validated = emailValidator.test(String(email).toLowerCase());

    let info = `{"email": "${email}", "username": "${username}", "subject": "${subject}", "body": "${feedback}"}`;

    if(!validated){
        alert("Your email does not seem to be in the right format\n_______________________________\n" +
            "Please take a look at it and make the necessary changes\n_______________________________\n");
    }

    var fields = $(".sign__group")
        .find("textarea, input").serializeArray();

    $.each(fields, function(i, field) {
        if (!field.value) {
            alert(field.name + ' is required');
            empty = true;
        }
});
console.log(!empty);
console.log(validated);


    if(!empty && validated){
        console.log("Entering");
        axios.post(`http://${window.location.href.toString().split("/")[2]}/sendEmail`, JSON.parse(info)).then( res =>{
                alert("Thank you for your feedback!\n_______________________________\n" +
                    "Your Email has now been successfully sent!\n_______________________________\n" +
                    "We will get back to you if we need to via the email address that you have specified");
                console.log("YESSSSSSSSS");
        }

            // console.log(res);
            // location.replace("contactUs.html");
        );
    }
    console.log(fields);

    console.log(info);

    // event.preventDefault();

    empty = false;

    // window.location.reload();

}