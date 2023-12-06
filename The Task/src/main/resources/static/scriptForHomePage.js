if (!localStorage.getItem("loggedInAs")) {
    window.location.href = "/login";
}
let title = document.getElementById("title");
title.textContent = localStorage.getItem("loggedInAs");

function addTask() {
    let taskInput = document.getElementById('taskInput');
    let dateInput = document.getElementById('dateInput');
    let timeInput = document.getElementById('timeInput');
    
    let taskText = taskInput.value;
    let dateText = dateInput.value;
    let timeText = timeInput.value;
    let todoArea = document.querySelector('.toDoArea');

    if (!isValidDate(dateText) || !isValidTime(timeText)) {
        alert('Please enter a valid date (MM/DD) and time (HH:MM).');
        taskInput.value = '';
        dateInput.value = '';
        timeInput.value = '';
        return;
    }
 
    let output = document.createElement('div');
    output.className = 'output';

    let taskElement = document.createElement('span');
    taskElement.textContent = taskText;

    let dateElement = document.createElement('span');
    dateElement.textContent = dateText;
    dateElement.className = 'date';

    let timeElement = document.createElement('span');
    timeElement.textContent = timeText;
    timeElement.className = 'time';

    let doneBtn = document.createElement('button');
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

    taskInput.value = '';
    dateInput.value = '';
    timeInput.value = '';

}
function moveTaskToDone(output) {
    let todoArea = document.querySelector('.toDoArea');
    let doneArea = document.querySelector('.doneArea');

    output.removeChild(output.lastChild);
    let deleteBtn = document.createElement('button');
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
    let scrollBox = document.querySelector('.scrollBox');
    let newListName = prompt('Name of your new list:');
 
    if (newListName) {
        let newList = document.createElement('div');
        newList.className = 'listContainer';
        newList.textContent = '-' + newListName + '-';

        newList.onclick = function() {
            listClick();
        }
        let removeBtn = document.createElement('button');
        removeBtn.textContent = 'X';
        removeBtn.onclick = function() {
            removeListBtn(newList);
        };
        newList.appendChild(removeBtn);
        scrollBox.appendChild(newList);
    }
}

function removeListBtn(newList) {
    let scrollBox = document.querySelector('.scrollBox');
    scrollBox.removeChild(newList);
}

function logout() {
    localStorage.removeItem('loggedInAs');
    window.location.href = "/";
}
function isValidDate(dateText) {
    const dateRegex = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])$/;
    const parts = dateText.split('/');
    const day = parseInt(parts[0], 10);
    const month = parseInt(parts[1], 10);

    if (dateRegex.test(dateText) && day >= 1 && day <= 31 && month >= 1 && month <= 12) {
        return true;
    } else {
        return false;
    }
}

function isValidTime(timeText) {
    const timeRegex = /^([01]\d|2[0-3]):([0-5]\d)$/;
    return timeRegex.test(timeText);
}

setInterval(checkTasksDueTime, 60000);

function checkTasksDueTime() {
    let currentTime = new Date();
    let taskElements = document.querySelectorAll('.output');

    taskElements.forEach(function (taskElement) {
        let timeElement = taskElement.querySelector('span.time');
        let dateElement = taskElement.querySelector('span.date');
       
        if (timeElement && dateElement) {
            let timeText = timeElement.textContent;
            let dateText = dateElement.textContent;
            if (isTaskDue(currentTime, dateText, timeText)) {
                handleTaskDue(taskElement);
            }
        }
    });
}

function isTaskDue(currentTime, dateText, timeText) {
    let [day, month] = dateText.split('/');
    let [hour, min] = timeText.split(':');
    
    let taskDueTime = new Date(currentTime.getFullYear(), month - 1, day, parseInt(hour, 10), parseInt(min, 10));

    return currentTime.getMonth() === taskDueTime.getMonth() && 
           currentTime.getDate() === taskDueTime.getDate() &&
           taskDueTime <= currentTime;
}

function handleTaskDue(taskElement) {
    taskElement.style.backgroundColor = 'red';
}