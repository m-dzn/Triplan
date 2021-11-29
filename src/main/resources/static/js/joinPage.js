var joinPage = {
    joinBtn: $("#joinBtn"),

    init: function() {
        this.onClickJoin.bind(this);

        this.joinBtn.click((event) => this.onClickJoin(event));
    },

    onClickJoin: function(event) {
        event.preventDefault();

        var joinForm = {
            nickname: document.joinForm.nickname.value,
            email: document.joinForm.email.value,
            password: document.joinForm.password.value
        }

        $.ajax({
            url: `${BASE_URL}/api/members`,
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(joinForm),
            success: () => {
                location.href = '/';
                alert('회원 가입 성공');
            }
        });
    }
}

joinPage.init();