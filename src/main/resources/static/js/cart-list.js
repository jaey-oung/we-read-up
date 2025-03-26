document.addEventListener('DOMContentLoaded', () => {
    updateTotalPrice();
});

function updateTotalPrice() {
    let total = 0;

    // 모든 장바구니에 대한 단가 * 수량 계산
    document.querySelectorAll('.cart-item').forEach(item => {
        const salePrice = parseInt(item.querySelector('.sale-price').getAttribute("data-sale-price"));
        const quantity = parseInt(item.querySelector('.quantity-number').innerText);

        total += salePrice * quantity;
    });

    // 총 주문 금액 출력
    document.getElementById("total-price").innerText = total.toLocaleString() + '원';
}