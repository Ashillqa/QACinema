$(function () {
    var API_KEY = $('#api-key').val();
    // Create a Stripe client.
    var stripe = Stripe('pk_test_GwCd84zI1Z3VX9tEnsUPYf66008O6XRGTe');

    // Create an instance of Elements.
    var elements = stripe.elements();

    // Create an instance of the card Element.
    var card = elements.create('card');

    // Add an instance of the card Element into the `card-element` <div>.
    card.mount('#card-element');

    // Handle real-time validation errors from the card Element.
    card.addEventListener('change', function (event) {
        var displayError = document.getElementById('card-errors');
        if (event.error) {
            displayError.textContent = event.error.message;
        } else {
            displayError.textContent = '';
        }
    });

    // Handle form submission.
    var form = document.getElementById('payment-form');
    form.addEventListener('submit', function (event) {
        event.preventDefault();
        // handle payment
        handlePayments();
    });

    //handle card submission
    function handlePayments() {
        stripe.createToken(card).then(function (result) {
            if (result.error) {
                // Inform the user if there was an error.
                var errorElement = document.getElementById('card-errors');
                errorElement.textContent = result.error.message;
            } else {
                // Send the token to your server.
                var token = result.token.id;
                var email = $('#email').val();
                var amount = sessionStorage.getItem("total");
                $.post(
                    "/create-charge",
                    {email: email, token: token, amount: amount},
                    function (data) {
                        alert(data.details);
                        location.replace("paymentComplete.html");
                    }, 'json');
            }
        });
    }
});

function postBookingDetails() {

    let bookingDetails = `{"movie":{"id": ${sessionStorage.getItem('movieId')}}, "movieName": "${sessionStorage.getItem('movieName')}", "dateTime": "${sessionStorage.getItem('movieTime')}",
        "totalPrice": ${sessionStorage.getItem('total')}, "emailAddress": "${sessionStorage.getItem('email')}", "phoneNumber": "${sessionStorage.getItem('phone')}", "customerName":"${sessionStorage.getItem('name')}",
    "adultNr": ${sessionStorage.getItem('adult')}, "childNr": ${sessionStorage.getItem('child')}, "studentNr": ${sessionStorage.getItem('student')}}`;


    axios.post(`http://${window.location.href.toString().split("/")[2]}/booking/createBooking`, JSON.parse(bookingDetails)).then(
        res =>{
            console.log(res);
        }
    )

}