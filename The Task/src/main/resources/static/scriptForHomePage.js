// if (!localStorage.getItem("loggedInAs")) {
//     window.location.href = "/";
// }
// let title = document.getElementById("title");
// title.textContent = localStorage.getItem("loggedInAs");

function addTask() {
    var taskInput = document.getElementById('taskInput');
    var dateInput = document.getElementById('dateInput');
    var timeInput = document.getElementById('timeInput');
    
    var taskText = taskInput.value;
    var dateText = dateInput.value;
    var timeText = timeInput.value;
    var todoArea = document.querySelector('.toDoArea');

    if (!isValidDate(dateText) || !isValidTime(timeText)) {
        alert('Please enter a valid date (MM/DD) and time (HH:MM).');
        taskInput.value = '';
        dateInput.value = '';
        timeInput.value = '';
        return;
        //liten ändring ta bort detta
    }

    var output = document.createElement('div');
    output.className = 'output';

    var taskElement = document.createElement('span');
    taskElement.textContent = taskText;

    var dateElement = document.createElement('span');
    dateElement.textContent = dateText;

    var timeElement = document.createElement('span');
    timeElement.textContent = timeText;

    var doneBtn = document.createElement('button');
    doneBtn.textContent = 'Done';
    doneBtn.onclick = function() {
        moveTaskToDone(output);
    };

    output.appendChild(taskElement);
    output.appendChild(dateElement);
    output.appendChild(timeElement);
    output.appendChild(doneBtn);

    output.style.display = 'flex';
    output.style.justifyContent = 'space-between';

    todoArea.appendChild(output);

    // taskInput.value = '';
    // dateInput.value = '';
    // timeInput.value = '';
}
function moveTaskToDone(output) {
    var todoArea = document.querySelector('.toDoArea');
    var doneArea = document.querySelector('.doneArea');

    output.removeChild(output.lastChild);
    var deleteBtn = document.createElement('button');
    deleteBtn.textContent = 'Delete';
    deleteBtn.onclick = function() {
        deleteTask(output);
    };

    output.appendChild(deleteBtn);
    todoArea.removeChild(output);
    doneArea.appendChild(output);
}
function deleteTask(output) {
    doneArea.removeChild(output);
}

function newListBtn() {
    var scrollBox = document.querySelector('.scrollBox');
    var newListName = prompt('Name of your new list:');
 
    if (newListName) {
        var newList = document.createElement('div');
        newList.className = 'listContainer';
        newList.textContent = '-' + newListName + '-';

        newList.onclick = function() {
            listClick();
        }
        var removeBtn = document.createElement('button');
        removeBtn.textContent = 'X';
        removeBtn.onclick = function() {
            removeListBtn(newList);
        };
        newList.appendChild(removeBtn);
        scrollBox.appendChild(newList);
     
    }
}
function listClick() {
   //Funktion för att hantera listorna
}

function removeListBtn(newList) {
    var scrollBox = document.querySelector('.scrollBox');
    scrollBox.removeChild(newList);
}

function logout() {
    localStorage.removeItem('loggedInAs');
    window.location.href = "/";
}
function isValidDate(dateText) {
    var dateRegex = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])$/;
    var parts = dateText.split('/');
    var day = parseInt(parts[0], 10);
    var month = parseInt(parts[1], 10);

    if (dateRegex.test(dateText) && day >= 1 && day <= 31 && month >= 1 && month <= 12) {
        return true;
    } else {
        return false;
    }
}


function isValidTime(timeText) {
    var timeRegex = /^([01]\d|2[0-3]):([0-5]\d)$/;
    return timeRegex.test(timeText);
}

function logout() {
    
    window.location.href = "/";
}

