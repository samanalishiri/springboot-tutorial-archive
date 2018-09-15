function readModel(xhttp, name){
    return JSON.parse(xhttp.responseText)[name];
}