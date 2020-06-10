let selectedSeats = [];

new seatsio.SeatingChart({
    divId: 'chart',
    workspaceKey: '8a84d781-237d-46ed-aecb-860387b9287a',
    event: '9b14fa0e-d626-406a-84a7-b04b0e4ae7cd',
    colorScheme: 'dark',
    onObjectSelected: function (object) {
        // add the selected seat id to the array
        selectedSeats.push([object.id, object.selectedTicketType,object.accessible]);
    },
    onObjectDeselected: function (object) {
        // remove the deselected seat id from the array
        var index = selectedSeats.indexOf(object.id);
        if (index !== -1) selectedSeats.splice(index, 1);
    },
    pricing: [
        {'category': 1, 'ticketTypes': [
                {'ticketType': 'Adult'},
                {'ticketType': 'Child'},
                {'ticketType': 'Student'}
            ]},
        {'category': 2, 'ticketTypes': [
                {'ticketType': 'Adult'},
                {'ticketType': 'Child'},
                {'ticketType': 'Student'}
            ]},
        {'category': 3, 'ticketTypes': [
                {'ticketType': 'Adult'},
                {'ticketType': 'Child'},
                {'ticketType': 'Student'}
            ]},
        {'category': 4,'ticketTypes': [
                {'ticketType': 'Adult/Child'}]}
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
        zoomOnSelect: true,
    },
    showViewFromYourSeatOnDesktop: false,
}).render();

function selectSeats() {
    console.log(selectedSeats);
}

function myStandardFunction() {

    window.scrollTo(0,900);
}