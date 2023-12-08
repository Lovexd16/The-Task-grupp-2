function checkAndUpdateDeadlines() {
    let now = new Date();
    let year = now.getFullYear();
    let month = ('0' + (now.getMonth() + 1)).slice(-2);
    let day = ('0' + now.getDate()).slice(-2);
    let hours = ('0' + now.getHours()).slice(-2);
    let minutes = ('0' + now.getMinutes()).slice(-2);
    let formattedDate = `${year}${month}${day}`;
    let formattedTime = `${hours}${minutes}`;
    let todoElements = document.querySelectorAll('.todos li');
    
    todoElements.forEach(todoElement => {
        let dateTimeString = todoElement.querySelector('span').textContent.split(' ');
        let date = dateTimeString[1];
        let time = dateTimeString[2];
        let formattedDateInput = date.split('-').join('');
        let formattedTimeInput = time.split(':').join('');

        if (formattedDateInput < formattedDate || formattedDateInput <= formattedDate && formattedTimeInput <= formattedTime) {
            todoElement.style.backgroundColor = 'red';       
        }
    });
    setTimeout(checkAndUpdateDeadlines, 10000);
}
checkAndUpdateDeadlines();

function toggleTodo(element) {
    element.classList.toggle('completed');
}

function logout() {
    window.location.href = "/";
}
