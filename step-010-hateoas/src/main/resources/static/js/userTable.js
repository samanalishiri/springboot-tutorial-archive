
function deleteRow(id) {
    var table = document.getElementById("users");
    var row = table.querySelectorAll('[model-id="' + id + '"]')[0];
    row.parentNode.removeChild(row);
}

function addRow(model) {
    var table = document.getElementById("users").getElementsByTagName('tbody')[0];
    var row = table.insertRow(0);
    row.setAttribute('model-id', model.id);

    var colName = row.insertCell(0);
    colName.innerHTML = "<label>" + model.username + "</label>"

    var colEmail = row.insertCell(1);
    colEmail.innerHTML = "<label>" + model.email + "</label>";

    var colViewButton = row.insertCell(2);
    colViewButton.innerHTML = "<td><input type='button' name='buttonView' value='View' onclick='view(" + model.id + ")'/></td>";
    colViewButton.style = "text-align: center";

    var colDeleteButton = row.insertCell(3);
    colDeleteButton.innerHTML = "<td><input type='button' name='buttonDelete' value='Delete' onclick='remove(" + model.id + ")'/></td>";
    colDeleteButton.style = "text-align: center";

    var colUserId = row.insertCell(4);
    colUserId.innerHTML = "<input type='hidden' value='" + model.id + "'/>";
    colUserId.style = "border-width: 0px";
}
