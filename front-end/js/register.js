const form = document.getElementById("form");
const password = document.getElementById("password");
const email = document.getElementById("email");

form.addEventListener("submit", (e) => {
    e.preventDefault()
    
  
    const formData = new FormData(form)
    const data = Object.fromEntries(formData)
    const url = "http://localhost:8080/usuario/login"

        fetch(url, {
            method: 'POST',
            headers: {
                'Accept' : 'application/json',
                'Content-Type' : 'application/json'
            },

            body: JSON.stringify({
                email: email.value,
                senha: password.value
                }),

            
        }).then(response => response.json())
        .then(data => {
            //setErrorInsert(spanError, data["message"])
            console.log(data)
            
            if(data["username"] != null){

                sessionStorage.setItem('username', data["username"] );
                sessionStorage.setItem('email', data["email"] );
                location.href = "AccessPage.html"
                setMessage()
            }
        })

        
        
    
})
function setMessage(){
    document.getElementById("username").innerHTML = sessionStorage.getItem('username')
    document.getElementById("email").innerHTML = sessionStorage.getItem('email')
}
function setErrorInsert(spanError, mensagem) {
    spanError.innerHTML = mensagem;
    spanError.style.display = 'block'
    spanError.style.color = '#B22222'
    spanError.style.textAlign = 'center'

}