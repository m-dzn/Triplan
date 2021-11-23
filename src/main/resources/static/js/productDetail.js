var productDetail = {
    itemGroupBreadCrumb: $("#itemGroupBreadCrumb"),
    itemImgCarousel: $("#itemImgCarousel"),
    itemImgCarouselIndicator: $("#itemImgCarouselIndicator"),
    itemGroupTitle: $("#itemGroupTitle"),
    itemGroupLikeCount: $("#itemGroupLikeCount"),
    itemGroupSummaryExplain: $("#itemGroupSummaryExplain"),
    itemGroupDetailExplain: $("#itemGroupDetailExplain"),
    itemGroupDetailImg: $("#itemGroupDetailImg"),

    wishBtn: $("#wishBtn"),
    itemGroupLikeCount: $("#itemGroupLikeCount"),

    itemCardContainer: $("#itemCardContainer"),

    reviewForm: $(document.reviewForm),
    reviewContainer: $("#reviewContainer"),
    reviewPaginationGroup: $("#reviewPaginationGroup"),

    qnaTable: $("#itemGroupQnaTable"),
    qnaPaginationGroup: $("#qnaPaginationGroup"),
    qnaWriteBtn: $("#qnaWriteBtn"),

    itemGroup: null,
    itemList: null,

    searchParams: null,
    itemGroupId: null,
    start: null,
    end: null,

    pageSize: null,

    init: function() {
        var _this = this;

        var url = new URL(location.href);
        this.searchParams = location.search;
        this.itemGroupId = url.searchParams.get("itemGroupId");
        this.start = url.searchParams.get("startDate");
        this.end = url.searchParams.get("endDate");
        this.pageSize = 5;

        this.fetchItemGroupDetail.bind(this);
        this.fetchItemCards.bind(this);
        this.fetchReviewList.bind(this);
        this.addReview.bind(this);
        this.fetchQuestionList.bind(this);

        this.fetchItemGroupDetail();
        this.fetchItemCards(this.start, this.end);
        this.fetchReviewList(this.pageSize, 1);
        this.fetchQuestionList(this.pageSize, 1);

        this.wishBtn.click(() => this.toggleWishlist(this.itemGroup));
        this.reviewForm.submit((event) => this.addReview(event));

        this.qnaWriteBtn.attr("href", `proqnawri?itemGroupId=${this.itemGroupId}`);

         // 단일 날짜 선택용
        $(() => {
            $('input[name="prodetCalender"]').daterangepicker({
                "locale": {
                    "format": "YYYY-MM-DD",
                    "separator": " ~ ",
                    "applyLabel": "확인",
                    "cancelLabel": "취소",
                    "fromLabel": "From",
                    "toLabel": "To",
                    "customRangeLabel": "Custom",
                    "weekLabel": "W",
                    "daysOfWeek": ["월", "화", "수", "목", "금", "토", "일"],
                    "monthNames": ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
                    "firstDay": 1
                },
                showDropdowns: true,
                singleDatePicker: true,
                showDropdowns: true,
                minYear: 2020,
                maxYear: 2099
            }, (start, end, label) => {
                var years = moment().diff(start, 'years');
            });
        });

        // 다중 날짜 선택용
        $(() => {
            $('input[name="prodetCalender"]').daterangepicker({
                startDate: this.start || moment(),
                endDate: this.end || moment().add(1, 'd'),
                locale: {
                    "format": "YYYY-MM-DD",
                    "separator": " ~ ",
                    "applyLabel": "확인",
                    "cancelLabel": "취소",
                    "fromLabel": "From",
                    "toLabel": "To",
                    "customRangeLabel": "Custom",
                    "weekLabel": "W",
                    "daysOfWeek": ["월", "화", "수", "목", "금", "토", "일"],
                    "monthNames": ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
                    "firstDay": 6
                },
                "drops": "down"
            }, (start, end, label) => {
                this.start = start.format('YYYY-MM-DD');
                this.end = end.format('YYYY-MM-DD');

                this.fetchItemCards(this.start, this.end);
            });
        });
    },

    fetchItemGroupDetail: function() {
        $.ajax({
            type: "GET",
            url: `${BASE_URL}/api/item-groups/${this.itemGroupId}/items`,
            dataType: "json",
            success: (itemGroup) => {
                this.itemGroup = itemGroup;

                this.itemGroupBreadCrumb.text(itemGroup.name);
                this.itemGroupTitle.text(itemGroup.name);
                this.itemGroupLikeCount.text(`(${itemGroup.likeCount})`);
                this.itemGroupSummaryExplain.text(itemGroup.summaryExplain);
                this.itemGroupDetailExplain.text(itemGroup.detailExplain);

                if (itemGroup.detailImg) {
                    this.itemGroupDetailImg.attr("src", `${RESOURCES_COMMON_URL}${itemGroup.detailImg}`);
                } else {
                    this.itemGroupDetailImg.css("display", "none");
                }

                this.wishBtn.find("span").first().text(itemGroup.liked ? "🖤" : "♡");

                var firstCarousel = `
                    <div class="carousel-item active">
                        <img src="${RESOURCES_COMMON_URL}${itemGroup.itemImg}" class="d-block w-100" alt="...">
                    </div>
                `;

                var firstCarouselIndicator = `
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                `;

                /* <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button> */

                itemImgCarousel.append($(firstCarousel).get(0));
                itemImgCarouselIndicator.append($(firstCarouselIndicator).get(0));
            }
        })
    },

    fetchItemCards: function(startDate, endDate) {
        $.ajax({
            type: "GET",
            url: `${BASE_URL}/api/items/item-groups/${this.itemGroupId}?${startDate ? `startDate=${startDate}&`:``}${endDate ? `endDate=${endDate}` : ``}`,
            dataType: "json",
            success: (itemList) => {
                this.itemList = itemList;

                this.itemCardContainer.empty();
                itemList.forEach(item => this.itemCardContainer.append($(`
                    <div class="border bg-white rounded-3 border-2  margin-bottom-8 padding-16">
                        <div class="row d-flex justify-content-between">
                            <span class="col-auto font-size-20 font-weight-bold">${item.name}</span>
                            <div class="col-auto">
                                <span class="col-auto">1박 당 / ${item.pricePerDay.toLocaleString("ko-KR")}원</span>
                            </div>
                            <div class="row d-flex margin-top-32 justify-content-between align-items-end">
                                <pre class="col-auto">${item.explain}</pre>
                                <form class="col-auto">
                                    <input type="hidden" name="총액" value="총액">
                                    <a href="pay?itemGroupId=${this.itemGroupId}&itemId=${item.itemId}&startDate=${this.start}&endDate=${this.end}&sellerId=${this.itemGroup.sellerId}" class="btn btn-primary col-auto" id="button_solid">바로 예약</a>
                                </form>
                            </div>
                        </div>
                    </div>
                `).get(0)));
            }
        })
    },

    fetchReviewList: function(pageSize, currentPage) {
        $.ajax({
            type: "GET",
            url: `${BASE_URL}/api/reviews/item-groups/${this.itemGroupId}?pageSize=${pageSize}&currentPage=${currentPage}`,
            dataType: "json",
            success: (pagination) => {

                reviewContainer.innerHTML = pagination.list.map(review => `<div class="row mt-3 p-2">
                      <div class="col-12 d-flex">
                          <div>
                              <img src="${review.profileImg ? `${RESOURCES_COMMON_URL}${review.profileImg}` : "https://horang2film.co.kr/common/img/default_profile.png"}" class="review-avatar">
                          </div>
                          <div class="flex-grow-1 d-flex flex-column ms-4">
                              <div>
                                  <strong>${review.nickname} (${moment(review.createdAt).format(DATETIME_FORMAT_KOR)})</strong>
                              </div>
                              <div class="mt-1">${review.content}</div>
                          </div>
                      </div>
                  </div>
                `).join("");

                // 페이지네이션
                this.reviewPaginationGroup.empty();

                var prevBtn = $(`
                    <li class="page-item ${pagination.hasPrev ? '' : 'disabled'}">
                        <button class="page-link" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </button>
                    </li>
                `);
                if (pagination.hasPrev) {
                    prevBtn.click(() => this.fetchReviewList(this.pageSize, pagination.startPage - 1));
                }
                this.reviewPaginationGroup.append(prevBtn.get(0));

                for (let i = pagination.startPage; i <= pagination.endPage; i++) {
                    this.reviewPaginationGroup.append($(`
                        <li class="page-item">
                            <button class="page-link">
                                ${i}
                            </button>
                        </li>
                    `).click(() => this.fetchReviewList(this.pageSize, i)).get(0));
                }

                var nextBtn = $(`
                    <li class="page-item ${pagination.hasNext ? '' : 'disabled'}">
                        <button class="page-link" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </button>
                    </li>
                `);
                if (pagination.hasNext) {
                    nextBtn.click(() => this.fetchReviewList(this.pageSize, pagination.endPage + 1));
                }
                this.reviewPaginationGroup.append(nextBtn.get(0));
            }
        });
    },

    toggleWishlist: function(itemGroup) {
        if (itemGroup.liked) {
            $.ajax(`${BASE_URL}/api/wishlists?itemGroupId=${itemGroup.itemGroupId}`, {
                method: "DELETE",
                dataType: "text",
                success: (msg) => {
                    itemGroup.liked = false;
                    itemGroup.likeCount--;
                    this.wishBtn.find("span").first().text("♡");
                    this.itemGroupLikeCount.text(`(${itemGroup.likeCount})`);
                }
            });
        } else {
            $.ajax(`${BASE_URL}/api/wishlists?itemGroupId=${itemGroup.itemGroupId}`, {
                method: "POST",
                dataType: "text",
                success: (msg) => {
                    itemGroup.liked = true;
                    itemGroup.likeCount++;
                    this.wishBtn.find("span").first().text("🖤");
                    this.itemGroupLikeCount.text(`(${itemGroup.likeCount})`);
                }
            });
        }
    },

    addReview: function(event) {
        event.preventDefault();

        var formData = new FormData();

        var review = {
            content: this.reviewForm.find("[name=content]").val(),
            reviewScore: this.reviewForm.find("input[name=starScore]:checked").val(),
            itemGroupId: this.itemGroupId
        }

        formData.append("review", new Blob([JSON.stringify(review)], { type: 'application/json' }));

        $.ajax({
            url: `${BASE_URL}/api/reviews`,
            type: "POST",
            contentType: false,
            processData: false,
            data: formData,
            success: (msg) => {
                this.fetchReviewList(this.pageSize, 1);
            }
        })
    },

    fetchQuestionList: function(pageSize, currentPage) {
        $.ajax({
            url: `${BASE_URL}/api/questions/item-groups/${this.itemGroupId}?pageSize=${pageSize}&currentPage=${currentPage}`,
            type: 'GET',
            dataType: 'json',
            success: (pagination) => {

                var qnaTBody = this.qnaTable.find("tbody").first();
                qnaTBody.empty();

                pagination.list.forEach(question => qnaTBody.append($(`
                    <tr>
                        <td><a href="proqnacon${this.searchParams}&questionId=${question.questionId}">${question.title}</a></td>
                        <td>${question.nickname}</td>
                        <td>${moment(question.createdAt).format(DATE_FORMAT_KOR)}</td>
                    </tr>
                `).get(0)));

                // 페이지네이션
                this.qnaPaginationGroup.empty();

                var prevBtn = $(`
                    <li class="page-item ${pagination.hasPrev ? '' : 'disabled'}">
                        <button class="page-link" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </button>
                    </li>
                `);
                if (pagination.hasPrev) {
                    prevBtn.click(() => this.fetchQuestionList(this.pageSize, pagination.startPage - 1));
                }
                this.qnaPaginationGroup.append(prevBtn.get(0));

                for (let i = pagination.startPage; i <= pagination.endPage; i++) {
                    this.qnaPaginationGroup.append($(`
                        <li class="page-item">
                            <button class="page-link">
                                ${i}
                            </button>
                        </li>
                    `).click(() => this.fetchQuestionList(this.pageSize, i)).get(0));
                }

                var nextBtn = $(`
                    <li class="page-item ${pagination.hasNext ? '' : 'disabled'}">
                        <button class="page-link" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </button>
                    </li>
                `);
                if (pagination.hasNext) {
                    nextBtn.click(() => this.fetchQuestionList(this.pageSize, pagination.endPage + 1));
                }

                this.qnaPaginationGroup.append(nextBtn.get(0));
            }
        });
    }
}

productDetail.init();