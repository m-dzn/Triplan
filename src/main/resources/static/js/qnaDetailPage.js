var qnaDetailPage = {
    qno: $("#qno"),
    questionCreatedAt: $("#createdAt"),
    questionTitle: $("#questionTitle"),
    questionContent: $("#questionContent"),
    updateQuestionBtn: $("#updateQuestionBtn"),
    deleteQuestionBtn: $("#deleteQuestionBtn"),

    listBtn: $("#listBtn"),

    itemGroupId: null,
    startDate: null,
    endDate: null,
    questionId: null,

    init: function() {
        var url = new URL(location.href);
        this.itemGroupId = url.searchParams.get("itemGroupId");
        this.startDate = url.searchParams.get("startDate");
        this.endDate = url.searchParams.get("endDate");
        this.questionId = url.searchParams.get("questionId");

        this.fetchQuestionDetail.bind(this);
        this.deleteQuestion.bind(this);

        this.fetchQuestionDetail();
        this.updateQuestionBtn.attr("href", `proqnaupd?questionId=${this.questionId}`)
        this.deleteQuestionBtn.click(() => this.deleteQuestion());

        this.listBtn.click(() => this.toList());
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
            type: 'DELETE',
            success: () => {
                history.back();
            }
        });
    },

    toList: function() {
        location.href = `/prodet?itemGroupId=${this.itemGroupId}&startDate=${this.startDate}&endDate=${this.endDate}`;
    }
}

qnaDetailPage.init();