var qnaUpdatePage = {
    qnaUpdateTable: $(document.qnaUpdateTable),

    questionId: null,

    init: function() {
        var url = new URL(location.href);
        this.questionId = url.searchParams.get("questionId");

        this.fetchQuestion.bind(this);
        this.updateQuestion.bind(this);

        this.fetchQuestion();
        this.qnaUpdateTable.submit((event) => this.updateQuestion(event));
    },

    fetchQuestion: function() {
        $.ajax({
            url: `${BASE_URL}/api/questions/${this.questionId}`,
            type: 'GET',
            dataType: 'json',
            success: (question) => {
                this.qnaUpdateTable.find("[name=title]").val(question.title);
                this.qnaUpdateTable.find("[name=content]").text(question.content);
                this.qnaUpdateTable.find("[name=hide]").attr("checked", question.hide);
            }
        });
    },

    updateQuestion: function(event) {
        event.preventDefault();

        var updatedQuestion = {
            title: this.qnaUpdateTable.find("[name=title]").val(),
            content: this.qnaUpdateTable.find("[name=content]").val(),
            hide: this.qnaUpdateTable.find("[name=hide]").is(":checked")
        }

        console.log('update', updatedQuestion);
        $.ajax({
            url: `${BASE_URL}/api/questions/${this.questionId}`,
            type: 'PUT',
            contentType: 'application/json',
            dataType: 'text',
            data: JSON.stringify(updatedQuestion),
            success: () => {
                location.href = `/proqnacon?questionId=${this.questionId}`
            }
        })
    }
}

qnaUpdatePage.init();