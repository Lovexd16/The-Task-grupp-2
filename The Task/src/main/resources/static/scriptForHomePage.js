let title = document.getElementById("title");

title.textContent = localStorage.getItem("loggedInAs");

function addTask() {
    var taskInput = document.getElementById('taskInput');
    var timeInput = document.getElementById('timeInput');
    var todoArea = document.getElementById('toDoArea');
    var doneArea = document.getElementById('doneArea')
    var taskText = taskInput.value;
    var timeText = + ' - ' + timeText + '\n';
    taskInput.value = '';
    timeInput.value = '';
}