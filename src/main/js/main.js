var socket = $.atmosphere;

var request = {
    url: 'localhost:9000/gameevents',
    contentType: "application/json",
    logLevel: 'debug',
    transport: 'websocket',
    fallbackTransport: 'long-polling'
};


request.onOpen = function(response) {
    content.html($('<p>', {
        text: 'Atmosphere connected using ' + response.transport
    }));
};

request.onMessage = function(response) {
    var message = response.responseBody;
    try {
        var json = JSON.parse(message);
    } catch (e) {
        console.log('This does not look like a valid JSON: ', message.data);
        return;
    }
    addMessage(json, 'black', new Date());
};

request.onError = function(response) {
    content.html($('<p>', {
        text: 'Sorry, but there is some problem with your ' + 'socket or the server is down'
    }));
};

var subSocket = socket.subscribe(request);

function addMessage(message, color, datetime) {
    content.append('<p><span style="color:' + color + '">'@ ' +
        +(datetime.getHours() < 10 ? '0' + datetime.getHours() : datetime.getHours()) + ':' + (datetime.getMinutes() < 10 ? '0' + datetime.getMinutes() : datetime.getMinutes()) + ': ' + message + '</p>');
}

