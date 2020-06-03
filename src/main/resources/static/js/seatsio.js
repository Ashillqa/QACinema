var selectedSeats = [];

new seatsio.SeatingChart({
    divId: 'chart',
    workspaceKey: '8a84d781-237d-46ed-aecb-860387b9287a',
    event: '9b14fa0e-d626-406a-84a7-b04b0e4ae7cd',
    onObjectSelected: function (object) {
        // add the selected seat id to the array
        selectedSeats.push(object.id);
    },
    onObjectDeselected: function (object) {
        // remove the deselected seat id from the array
        var index = selectedSeats.indexOf(object.id);
        if (index !== -1) selectedSeats.splice(index, 1);
    },
    pricing: [
        {'category': 1, 'ticketTypes': [
                {'ticketType': 'Adult', 'price': 8},
                {'ticketType': 'Child', 'price': 4},
                {'ticketType': 'Student', 'price': 6}
            ]},
        {'category': 2, 'ticketTypes': [
                {'ticketType': 'Adult', 'price': 8},
                {'ticketType': 'Child', 'price': 4},
                {'ticketType': 'Student', 'price': 6}
            ]},
        {'category': 3, 'ticketTypes': [
                {'ticketType': 'Adult', 'price': 8},
                {'ticketType': 'Child', 'price': 4},
                {'ticketType': 'Student', 'price': 6}
            ]},
        {'category': 4,'ticketTypes': [
                {'ticketType': 'Adult/Child', 'price': 10}]}
    ],
    priceFormatter: function(price) {
        return '£' + price;
    },
    showLegend: true,
    legend: {
        hidePricing: true
    },
    enabled: true,
    multiSelect: true,
    zoomOnSelect: true,
    showMinimap: true,
    categoryFilter: {
        enabled: true,
        multiSelect: true,
        zoomOnSelect: false,
    },
    showViewFromYourSeatOnDesktop: false,
}).render();

function selectSeats() {
    console.log(selectedSeats);
}

function myStandardFunction() {

    window.scrollTo(0,900);
}