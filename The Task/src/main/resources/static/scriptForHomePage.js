setInterval(checkDeadline, 10000);

function checkDeadline() {
    let now = new Date();
    let dateInput = document.getElementById("date").value;
    let timeInput = document.getElementById("time").value;

    let deadlineDate = new Date(dateInput);
    let deadlineTime = new Date(timeInput);

    if (deadline < now) {
        deadlineInputElement.style.backgroundColor = 'red';
    } else {
        deadlineInputElement.style.backgroundColor = '';
    }
}
console.log(deadlineDate);

function logout() {  
    window.location.href = "/";
}

