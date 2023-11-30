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

//MÅSTE SKRIVAS OM OCH FIXAS SÅ ATT DEN SPARAS I LOCAL STORAGE BARA EFTER ATT ANVÄNDAREN LYCKATS LOGGA IN ELLER LYCKATS SKAPA KONTO 
//KANSKE VIKTIGT, VI KAN TA UPP DET TILLSAMMANS