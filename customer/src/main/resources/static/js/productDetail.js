var productDetail = {
    itemGroupBreadCrumb: $("#itemGroupBreadCrumb"),
    itemGroupTitle: $("#itemGroupTitle"),
    itemGroupLikeCount: $("#itemGroupLikeCount"),
    itemGroupSummaryExplain: $("#itemGroupSummaryExplain"),
    itemGroupDetailExplain: $("#itemGroupDetailExplain"),

    reviewContainer: $("#reviewContainer"),
    reviewPaginationGroup: $("#reviewPaginationGroup"),

    itemGroupId: null,
    startDate: null,
    endDate: null,

    init: function() {
        var url = new URL(location.href);
        this.itemGroupId = url.searchParams.get("itemGroupId");
        this.startDate = url.searchParams.get("startDate");
        this.endDate = url.searchParams.get("endDate");

        this.fetchItemGroupDetail();
        this.fetchItemCards();
        this.fetchReviewList();
    },

    fetchItemGroupDetail: function() {
        $.ajax({
            type: "GET",
            url: `${BASE_URL}/api/item-groups/${this.itemGroupId}/items`,
            dataType: "json",
            success: (itemGroup) => {
                console.log(itemGroup);
                itemGroupBreadCrumb.innerText = itemGroup.name;
                itemGroupTitle.innerText = itemGroup.name;
                itemGroupLikeCount.innerText = `(${itemGroup.likeCount})`;
                itemGroupSummaryExplain.innerText = itemGroup.summaryExplain;
                itemGroupDetailExplain.innerText = itemGroup.detailExplain;
            }
        })
    },

    fetchItemCards: function() {
        $.ajax({
            type: "GET",
            url: `${BASE_URL}/api/items/item-groups/${this.itemGroupId}?${this.startDate ? `startDate=${this.startDate}&`:``}${this.endDate ? `endDate=${this.endDate}` : ``}`,
            dataType: "json",
            success: (item) => {
                console.log(item);
            }
        })
    },

    fetchReviewList: function() {
        $.ajax({
            type: "GET",
            url: `${BASE_URL}/api/reviews/item-groups/${this.itemGroupId}`,
            dataType: "json",
            success: (pagination) => {
                console.log(pagination);

                var pageSize = 10;
                var currentPage = 1;

                reviewContainer.innerHTML = pagination.list.map(review => `<div class="row mt-3 p-2">
                      <div class="col-12 d-flex">
                          <div>
                              <img src="https://horang2film.co.kr/common/img/default_profile.png" class="review-avatar">
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
                var _html = `<li class="page-item ${pagination.hasPrev ? '' : 'disabled'}">
                <a class="page-link" href="${BASE_URL}/product?pageSize=${pageSize}&currentPage=${pagination.endPage + 1}" aria-label="Previous">
                  <span aria-hidden="true">&laquo;</span>
                </a>
                </li>`;

                for (var i = pagination.startPage; i <= pagination.endPage; i++) {
                _html += `<li class="page-item"><a class="page-link" href="http://localhost:8082/prodet?pageSize=${pageSize}&currentPage=${i}">${i}</a></li>`;
                }

                _html += `<li class="page-item ${pagination.hasNext ? '' : 'disabled'}">
                  <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                  </a>
                </li>`;

                reviewPaginationGroup.innerHTML = _html;
            }
        });
            fetch(`${BASE_URL}/api/reviews/item-groups/${this.itemGroupId}`, {
                method: 'GET'
            }).then(response => {
                if (response.ok) {
                    return response.json();
                }
            }).then(pagination => {

            });
        }
}

productDetail.init();