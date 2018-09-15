
var CREATE_STATUS = 201;

var SUCCESS_STATUS = 200;

function postAjaxRequest(url, data, success) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("post", url, true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.setRequestHeader("Accept", "application/json");
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === XMLHttpRequest.DONE && xhttp.status === CREATE_STATUS)
            success(xhttp);
    };
    xhttp.send(data);
}

function getAjaxRequest(url, success){
    var xhttp = new XMLHttpRequest();
    xhttp.open("get", url, true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.setRequestHeader("Accept", "application/json");
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === XMLHttpRequest.DONE && xhttp.status === SUCCESS_STATUS)
            success(xhttp);
    };
    xhttp.send();
}

function deleteAjaxRequest(url, success) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("delete", url, true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.setRequestHeader("Accept", "application/json");
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState === XMLHttpRequest.DONE && xhttp.status === SUCCESS_STATUS)
            success(xhttp);
    };
    xhttp.send();
}