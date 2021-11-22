var product = {
    productCardList: [],
    productCardContainer: $("#productCardContainer"),
    productPaginationGroup: $("#productPaginationGroup"),
    pageSize: '',
    currentPage: '',
    sortType: '',
    tags: '',

    init: function() {
        var url = new URL(location.href);
        this.pageSize = url.searchParams.get("pageSize") || 10;
        this.currentPage = url.searchParams.get("currentPage") || 1;
        this.sortType = url.searchParams.get("sortType") || "";
        this.tags = url.searchParams.get("tags") || "";

        var startDate = url.searchParams.get("startDate");

        this.fetchProductList();
    },

    fetchProductList: function() {
        $.ajax({
            type: "GET",
            url: `${BASE_URL}/api/item-groups/filter?pageSize=${this.pageSize}&currentPage=${this.currentPage}&sortType=${this.sortType}&tags=${this.tags}`,
            dataType: 'json',
            success: (pagination) => {
                console.log(pagination);
                pagination.list.forEach((itemGroup, idx) => {
                    var itemGroupCardHTML = `<a href="prodet?itemGroupId=${itemGroup.itemGroupId}" th:fragment="thumbnail_Card_a">
                        <div class="row border bg-white rounded-3 border-2 margin-window margin-top-16">

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

                    this.productCardList.push(productCard.get(0));
                });

                this.productCardContainer.empty();
                this.productCardList.forEach(card => this.productCardContainer.append(card));

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
                }
            });
        }
    }
}

product.init();