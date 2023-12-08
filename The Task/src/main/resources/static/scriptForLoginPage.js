let createUserBtn = document.getElementById("createUserBtn");

let usernameField = document.getElementById("User2");

createUserBtn.addEventListener("click", function () {
    localStorage.setItem("loggedInAs", usernameField.value)
});

let loginBtn = document.getElementById("loginBtn");

let usernameField2 = document.getElementById("User1");

loginBtn.addEventListener("click", function () {
    localStorage.setItem("loggedInAs", usernameField2.value)
});

let listclick = document.getElementById("listclick")

listclick.addEventListener("click", () =>{
    
} )
