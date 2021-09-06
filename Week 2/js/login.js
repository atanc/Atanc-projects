function submit() {
let user = document.getElementById("user").value;
let password = document.getElementById("password").value;
let loggedIn = document.getElementById("LoggedIn");

loggedIn.innerText=""


if (user =="admin") {
    if (password == "password") {
        loggedIn.innerText ="You're logged in";
       return;
    }


   
}
loggedIn.innerText= "Incorrect user or password";


}
    