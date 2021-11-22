var qnaDetailPage = {
    qno: $("#qno"),
    questionCreatedAt: $("#createdAt"),
    questionTitle: $("#questionTitle"),
    questionContent: $("#questionContent"),
    updateQuestionBtn: $("#updateQuestionBtn"),
    deleteQuestionBtn: $("#deleteQuestionBtn"),

    questionId: null,

    init: function() {
        var url = new URL(location.href);
        this.questionId = url.searchParams.get("questionId");

        this.fetchQuestionDetail.bind(this);
        this.deleteQuestion.bind(this);

        this.fetchQuestionDetail();
        this.updateQuestionBtn.attr("href", `proqnaupd?questionId=${this.questionId}`)
        this.deleteQuestionBtn.click(() => this.deleteQuestion());
    },

    fetchQuestionDetail: function() {
        $.ajax({
            url: `${BASE_URL}/api/questions/${this.questionId}`,
            type: 'GET',
            dataType: 'json',
            success: (question) => {
                this.qno.text(question.questionId);
                this.questionCreatedAt.text(moment(question.createdAt).format(DATETIME_FORMAT_KOR));
                this.questionTitle.text(question.title);
                this.questionContent.text(question.content);
            },
            error: () => {
                history.back();
            }
        })
    },

    deleteQuestion: function() {
        $.ajax({
            url: `${BASE_URL}/api/questions/${this.questionId}`,
            type: 'DELETE'
        });
    }
}

qnaDetailPage.init();