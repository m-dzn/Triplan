const main = {
    init: function() {
        _this = this;

        const sellerId = 1;

        _this.fetchItemCount(sellerId);
        _this.fetchResCount(sellerId);

        _this.drawSalesChart();
        _this.drawReservationChart();
    },

    fetchSellerInfo: function() {

    },

    fetchItemCount: function(sellerId) {
        const itemCounter = document.getElementById('itemCounter');

        fetch(`http://localhost:8083/api/items/count/sellers/${sellerId}`, {
            method: 'GET'
        }).then(response => {
            if (response.ok) {
                return response.text();
            } else {
                throw new Error('등록 상품 개수 출력 실패');
            }
        }).then(count => {
            itemCounter.innerText = count + '개';
        }).catch(e => console.log(e));
    },

    fetchResCount: function(sellerId) {
        const resCounter = document.getElementById('resCounter');

        fetch(`http://localhost:8083/api/reservations/count/sellers/${sellerId}`, {
            method: 'GET'
        }).then(response => {
            if (response.ok) {
                return response.text();
            } else {
                throw new Error('등록 예약 건수 출력 실패');
            }
        }).then(count => {
            resCounter.innerText = count + '건';
        }).catch(e => console.log(e));
    },

    drawSalesChart: function() {
        const salesChartElem = document.getElementById('salesChart');

        const salesChart = new Chart(salesChartElem, {
            type: 'bar',
            data: {
                labels: ['11-04', '11-05', '11-06', '11-07', '11-08', '11-09'],
                datasets: [{
                    label: '매출액',
                    data: [50000, 150000, 250000, 150000, 50000, 100000],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: false,
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    },

    drawReservationChart: function() {
        const reservationChartElem = document.getElementById('reservationChart');

        const reservationChart = new Chart(reservationChartElem, {
            type: 'line',
            data: {
                labels: ['11-04', '11-05', '11-06', '11-07', '11-08', '11-09'],
                datasets: [{
                    label: '예약 건수',
                    data: [12, 19, 3, 5, 2, 3],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                responsive: false,
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    }
}

main.init();