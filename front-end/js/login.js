const form = document.getElementById('form')
const username = document.getElementById('username')
const email = document.getElementById('email')
const password = document.getElementById('password')
const confirmPassword = document.getElementById('confirmPassword')

form.addEventListener('submit', (e) => {
    e.preventDefault()
    campsValidate()
})

function campsValidate() {
    const usernameValue = username.value.trim()
    const emailValue = email.value.trim()
    const passwordValue = password.value.trim()
    const confirmPasswordValue = confirmPassword.value.trim()
   

    checkEmail(emailValue)
    checkPasswordConfirm(password, confirmPasswordValue)
}

function checkEmail(email) {
    
}

function checkPasswordConfirm(password, confirmPassword) {

}