var product = {
    productCardContainer: $("#productCardContainer"),
    productPaginationGroup: $("#productPaginationGroup"),
    overPriceInput: $("#overPrice"),
    underPriceInput: $("#underPrice"),
    pageSize: '',
    currentPage: '',
    sortType: '',
    tags: '',

    start: null,
    end: null,
    sortType: null,
    overPrice: null,
    underPrice: null,

    init: function() {
        var url = new URL(location.href);
        this.pageSize = url.searchParams.get("pageSize") || 10;
        this.currentPage = url.searchParams.get("currentPage") || 1;
        this.sortType = url.searchParams.get("sortType") || "";
        this.tags = url.searchParams.get("tags") || "";
        this.start = url.searchParams.get("startDate") || moment().format(DATE_FORMAT_KOR);
        this.end = url.searchParams.get("endDate") || moment().add(7, 'd').format(DATE_FORMAT_KOR);

        if (moment(this.start).isAfter(this.end)) {
            this.end = moment(this.start).add(1, 'd').format(DATE_FORMAT_KOR);
        }


        this.fetchProductList.bind(this);
        this.onClickSortBtn.bind(this);

        this.fetchProductList();
        this.overPriceInput.blur((event) => {
            this.overPrice = event.target.value;
            this.fetchProductList();
        });
        this.underPriceInput.blur((event) => {
            this.underPrice = event.target.value;
            this.fetchProductList();
        });
        $("button[name=sort]").click((event) => this.onClickSortBtn(event));

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
                startDate: this.start,
                endDate: this.end,
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

                this.fetchProductList();
            });
        });
    },

    onClickSortBtn: function(event) {
        this.sortType = event.target.value;
        this.fetchProductList();
    },

    fetchProductList: function() {
        var queryParams = `${this.start ? `&startDate=${this.start}` : ``}${this.end ? `&endDate=${this.end}` : ``}` +
                           `${this.overPrice ? `&overPrice=${this.overPrice}` : ``}${this.underPrice ? `&underPrice=${this.underPrice}` : ``}` +
                           `${this.tags ? `&tags=${this.tags}` : ``}`;

        $.ajax({
            type: "GET",
            url: `${BASE_URL}/api/item-groups/filter?pageSize=${this.pageSize}&currentPage=${this.currentPage}&sortType=${this.sortType}${queryParams}`,
            dataType: 'json',
            success: (pagination) => {
                console.log(pagination);

                const productCardList = [];

                pagination.list.forEach((itemGroup, idx) => {
                    var itemGroupCardHTML = `<a class=" margin-window margin-top-16" href="prodet?itemGroupId=${itemGroup.itemGroupId}${this.start ? `&startDate=${this.start}` : ``}${this.end ? `&endDate=${this.end}` : ``}" th:fragment="thumbnail_Card_a">
                        <div class="row border bg-white rounded-3 border-2">

                            <div class="col-auto p-0">
                                <img src="${itemGroup.itemImg}" class="" id="thumbnailCard-img" alt="...">
                            </div>
                            <div class="col margin-card">
                                <div class="row d-flex justify-content-between">
                                    <div class="col-auto font-weight-bold font-size-20">${itemGroup.name}</div>
                                    <div class="col-auto">
                                        <input class="wish" id="heart-${itemGroup.itemGroupId}" type="checkbox">
                                        <label id="wish-label-${itemGroup.itemGroupId}" for="heart-${itemGroup.itemGroupId}">${itemGroup.liked ? '🖤' : '♡'}</label>
                                    </div>
                                </div>
                                <div class="row margin-top-16">
                                    <div class="col-auto">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
                                            <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z"/>
                                        </svg>
                                        ${itemGroup.address}
                                    </div>
                                </div>
                                <div class="row margin-top-40 d-flex justify-content-between">
                                    <div class="col-auto"><img src="img/star-signature.png" width="16" height="16">(3.96)</div>
                                    <div class="col-auto d-flex">
                                      ${itemGroup.discountPrice ? `
                                        <div class="col-auto font-weight-bold">39,800원</div>
                                        <div class="col-auto font-size-14 font-weight-bold color-primary">↓20%</div>
                                        <div class="col-auto font-size-14 margin-left-8 color-gray text-decoration-line-through">
                                          1박 당/ ${itemGroup.pricePerDay.toLocaleString("ko-KR")}원
                                        </div>
                                        ` : `
                                        <div class="col-auto font-weight-bold">
                                          1박 당 / ${itemGroup.pricePerDay.toLocaleString("ko-KR")}원
                                        </div>
                                        `}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>`

                    var productCard = $(itemGroupCardHTML);
                    productCard.find(".wish").click(() => this.clickWishlist(itemGroup));

                    productCardList.push(productCard.get(0));
                });

                this.productCardContainer.empty();
                productCardList.forEach(card => this.productCardContainer.append(card));

                // 페이지네이션
                var pageBtnList = [];

                var queryParams = `${this.pageSize ? `&pageSize=${this.pageSize}` : ``}${this.sortType ? `&sortType=${this.sortType}` : ``}`;

                pageBtnList.push($(
                    `<li class="page-item ${pagination.hasPrev ? "" : "disabled"}">` +
                        `<a class="page-link" href="${BASE_URL}/product?currentPage=${pagination.startPage - 1}${queryParams}" aria-label="Previous">` +
                            `<span aria-hidden="true">&laquo;</span>` +
                        `</a>` +
                    `</li>`
                ).get(0));

                for (var i = pagination.startPage; i <= pagination.endPage; i++) {
                    pageBtnList.push($(
                        `<li class="page-item">` +
                            `<a class="page-link" href="${BASE_URL}/product?currentPage=${i}${queryParams}">${i}</a>` +
                        `</li>`
                    ).get(0));
                }

                pageBtnList.push($(
                    `<li class="page-item ${pagination.hasNext ? "" : "disabled"}">` +
                        `<a class="page-link" href="${BASE_URL}/product?currentPage=${pagination.endPage + 1}${queryParams}" aria-label="Next">` +
                            `<span aria-hidden="true">&raquo;</span>` +
                        `</a>` +
                    `</li>`
                ).get(0));

                this.productPaginationGroup.empty();
                pageBtnList.forEach(pageBtn => this.productPaginationGroup.append(pageBtn));
            }
        });
    },

    clickWishlist: function(itemGroup) {
        if (!itemGroup.liked) {
            $.ajax({
                type: "POST",
                url: `${BASE_URL}/api/wishlists?itemGroupId=${itemGroup.itemGroupId}`,
                dataType: 'text',
                success: (msg) => {
                    this.productCardContainer.find(`#wish-label-${itemGroup.itemGroupId}`).text('🖤');
                    itemGroup.liked = !itemGroup.liked;
                }
            });
        } else {
            $.ajax({
                type: "DELETE",
                url: `${BASE_URL}/api/wishlists?itemGroupId=${itemGroup.itemGroupId}`,
                dataType: 'text',
                success: (msg) => {
                    this.productCardContainer.find(`#wish-label-${itemGroup.itemGroupId}`).text('♡');
                    itemGroup.liked = !itemGroup.liked;
                },
                error: () => {
                    if (confirm("로그인하시겠습니까?")) {
                        location.href = "/login";
                    }
                }
            });
        }
    }
}

product.init();