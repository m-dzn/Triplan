var loginPage = {
    loginForm: $(document.loginForm),

    init: function() {
        this.onClickLogin.bind(this);

        this.loginForm.submit((event) => this.onClickLogin(event));
    },

    onClickLogin: function(event) {
        event.preventDefault();

        var loginForm = {
            email: this.loginForm.find("[name=email]").val(),
            password: this.loginForm.find("[name=password]").val()
        }

        console.log(loginForm);

        $.ajax({
            url: `${BASE_URL}/api/members/login`,
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(loginForm),
            success: (msg) => {
                location.href = "/";
            }
        })
    }
}

loginPage.init();