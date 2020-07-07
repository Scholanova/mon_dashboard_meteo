function filterTable(event) {
    var filter = event.target.value.toUpperCase();
    var rows = document.getElementById("tableBody").rows;
    var len = rows.length;
    for (let i = 0; i <= len; i++) {
        /* var firstCol = rows[i].cells[0].textContent.toUpperCase();*/
        var secondCol = rows[i].cells[1].textContent.toUpperCase();
        if (secondCol.indexOf(filter) > -1) {
            rows[i].style.display = "";
        } else {
            rows[i].style.display = "none";
        }
    }
}
document.querySelector('#myInput').addEventListener('keyup', filterTable, false);