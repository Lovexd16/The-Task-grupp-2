

// if (!localStorage.getItem("loggedInAs")) {
//     window.location.href = "/";
// }
// let title = document.getElementById("title");
// title.textContent = localStorage.getItem("loggedInAs");

setInterval(checkDeadline, 60000);

function checkDeadline() {
    var deadlineInput = document.getElementById("deadline").value;
    var deadline = new Date(deadlineInput);
    var now = new Date();

    if (deadline < now) {
        deadlineInputElement.style.backgroundColor = 'red';
    } else {
        deadlineInputElement.style.backgroundColor = '';
    }
}


function logout() {  
    window.location.href = "/";
}

