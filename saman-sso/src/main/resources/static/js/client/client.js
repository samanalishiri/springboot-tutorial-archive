document.getElementById("buttonSave").addEventListener("click", () => create());

function create() {
    postAjaxRequest("/client/save", createModel(), (xhttp) => addRow(readModel(xhttp, "data")));

}

function remove(id) {
    deleteAjaxRequest("/client/delete/" + id, (xhttp) => deleteRow(id));
}

function view(id) {
    getAjaxRequest("/client/find/" + id, (xhttp) => bindModel(readModel(xhttp, "data")));
}

function bindModel(model){
    document.getElementById("userId").value = model.id;
    document.getElementById("textUsername").value = model.username;
    document.getElementById("textPassword").value = "";
    document.getElementById("textEmail").value = model.email;
}

function createModel() {
    var model = {
        "id": document.getElementById("userId").value,
        "username": document.getElementById("textUsername").value,
        "password": document.getElementById("textPassword").value,
        "email": document.getElementById("textEmail").value
    };

    return JSON.stringify(model);
}
