var qnaWritePage = {
    qnaWriteForm: $(document.qnaWriteForm),

    itemGroupId: null,

    init: function() {
        var url = new URL(location.href);
        this.itemGroupId = url.searchParams.get("itemGroupId");

        this.writeQuestion.bind(this);

        this.qnaWriteForm.submit((event) => this.writeQuestion(event))
    },

    writeQuestion: function(event) {
        event.preventDefault();

        console.log(this.qnaWriteForm.get(0));
        var question = {
            title: this.qnaWriteForm.find("[name=title]").val(),
            content: this.qnaWriteForm.find("[name=content]").val(),
            type: "CUSTOMER",
            hide: this.qnaWriteForm.find("[name=hide]").is(':checked'),
            itemGroupId: this.itemGroupId
        }

        $.ajax({
            url: `${BASE_URL}/api/questions`,
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(question),
            success: (msg) => {
                console.log(msg);
                location.href = `${BASE_URL}/prodet?itemGroupId=${this.itemGroupId}`
            }
        });
    }
}

qnaWritePage.init();