
// 쿠폰 번호로 쿠폰 등록
function getCouponByNum() {
    var num = document.getElementById("num").value;

    fetch(`${BASE_URL}/api/membercoupons/getcouponbynum/${num}`, {
        method: 'POST'
    }).then(response => {
        if (response.ok) {
            return response.text();
        }
    }).then(memberCouponNum => {
        alert("실험");
        console.log(memberCouponNum)
        if(memberCouponNum == -2) {
            alert("이미 가지고 있거나 사용한 쿠폰입니다.");
        }
        if(memberCouponNum == -1) {
            alert("시스템 오류로 쿠폰을 발급할 수 없습니다. 관리자에게 문의하세요.");
        }
        if(memberCouponNum == 0) {
            alert("존재하지 않거나 유효기간이 경과한 쿠폰입니다.");
        }
        if(memberCouponNum == 1) {
            alert("쿠폰이 발급되었습니다.");
            location.reload();
        }
        return false;
    });
}