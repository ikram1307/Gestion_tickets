    function calculateTotalPrice() {
        // Get the selected ticket type
        const ticketTypeElements = document.getElementsByName('typeTicket');
        let ticketType;
        for (const element of ticketTypeElements) {
            if (element.checked) {
                ticketType = element.value;
                break;
            }
        }

        // Get the number of tickets
        const nbrTkt = document.getElementById('nbrTkt').value;

        // Define prices for ticket types
        const prices = {
            VIP: 100,
            Standard: 50
        };

        // Calculate total price
        if (ticketType && nbrTkt > 0) {
            const pricePerTicket = prices[ticketType];
            const totalPrice = nbrTkt * pricePerTicket;
            document.getElementById('totalPrice').innerText = 'Total Price: $' + totalPrice;
        } else {
            document.getElementById('totalPrice').innerText = 'Please select a ticket type and enter a valid number of tickets.';
        }
    }