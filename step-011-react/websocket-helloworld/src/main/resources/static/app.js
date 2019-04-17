var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);

    if (connected) {
        $("#conversation").show();
    } else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('http://localhost:8080/greetingsEndPoint');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (response) {
            showGreeting(JSON.parse(response.body));
        });
    });
}

function showGreeting(data) {
    $("#greetings").append("<tr><td>" + data.content + "</td></tr>");
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function hello() {
    stompClient.send("/app/hello", {}, $("#name").val());
}

function bye() {
    stompClient.send("/app/bye", {}, $("#name").val());
}

$(document).ready(function () {

    $("#conversation").hide();

    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#hello").click(function () {
        hello();
    });
    $("#bye").click(function () {
        bye();
    });
});