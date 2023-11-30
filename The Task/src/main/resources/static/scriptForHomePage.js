let title = document.getElementById("title");

title.textContent = localStorage.getItem("loggedInAs");

function addTask() {
    var taskInput = document.getElementById('taskInput');
    var timeInput = document.getElementById('timeInput');
    var todoArea = document.getElementById('toDoArea');
    var doneArea = document.getElementById('doneArea')
    var taskText = taskInput.value;
    var timeText = timeInput.value;
    
    todoArea.value += taskText + '-' + timeText +'\n';
    taskInput.value = '';
    timeInput.value = '';
}
function newListBtn() {
    var scrollBox = document.querySelector('.scrollBox');
    var newListName = prompt('Name of your new list:');
 
    if (newListName) {
        var newList = document.createElement('p');
        newList.textContent = '-' + newListName + '-';
        scrollBox.appendChild(newList);
    }
}
function logout() {
    localStorage.removeItem('loggedInAs');
    window.location.href = "/login";
}