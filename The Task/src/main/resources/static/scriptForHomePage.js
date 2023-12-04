if (!localStorage.getItem("loggedInAs")) {
    window.location.href = "/login";
}
let title = document.getElementById("title");
title.textContent = localStorage.getItem("loggedInAs");

function addTask() {
    var taskInput = document.getElementById('taskInput');
    var timeInput = document.getElementById('timeInput');
    var taskText = taskInput.value;
    var timeText = timeInput.value;
    var todoArea = document.querySelector('.toDoArea');

    var output = document.createElement('div');
    output.className = 'output';

    var taskElement = document.createElement('span');
    taskElement.textContent = taskText;

    var timeElement = document.createElement('span');
    timeElement.textContent = timeText;

    var doneBtn = document.createElement('button');
    doneBtn.textContent = 'Done';
    doneBtn.onclick = function() {
        moveTaskToDone(output);
    };

    output.appendChild(taskElement);
    output.appendChild(timeElement);
    output.appendChild(doneBtn);

    output.style.display = 'flex';
    output.style.justifyContent = 'space-between';

    todoArea.appendChild(output);

    taskInput.value = '';
    timeInput.value = '';
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
