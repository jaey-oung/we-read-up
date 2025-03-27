document.addEventListener("DOMContentLoaded", () => {
    selectAllItems();               // 모든 항목을 선택 상태로 초기화
    setupSelectAllCheckboxes();     // 전체 선택 과 개별 선택
    setupQuantityButtons();         // 장바구니에 담긴 도서 수량 증가 및 감소
    updateSummary();                // 선택된 항목의 총 수량과 금액 계산
});

// 모든 항목을 선택 상태로 초기화
function selectAllItems() {
    const selectAllCheckbox = document.querySelector(".select-all");
    const itemCheckboxes = document.querySelectorAll(".select-item");

    if (selectAllCheckbox)
        selectAllCheckbox.checked = true;

    itemCheckboxes.forEach(checkbox => checkbox.checked = true);
}

// 전체 선택 과 개별 선택
function setupSelectAllCheckboxes() {
    const selectAllCheckbox = document.querySelector(".select-all");
    const itemCheckboxes = document.querySelectorAll(".select-item");

    // 전체 선택
    selectAllCheckbox.addEventListener("change", () => {
        itemCheckboxes.forEach(checkbox => {
            checkbox.checked = selectAllCheckbox.checked;
        });
        updateSummary();
    });

    // 개별 선택
    itemCheckboxes.forEach(checkbox => {
        checkbox.addEventListener("change", updateSummary);
    });
}

// 장바구니에 담긴 도서 수량 증가 및 감소
function setupQuantityButtons() {
    document.querySelectorAll(".quantity-container").forEach(container => {
        const decreaseBtn = container.querySelector(".decrease-btn");
        const increaseBtn = container.querySelector(".increase-btn");
        const quantitySpan = container.querySelector(".quantity-number");

        const cartItem = container.closest(".cart-item");
        const cartId = parseInt(cartItem.dataset.cartId);
        const bookId = parseInt(cartItem.dataset.bookId);
        const salePrice = parseInt(cartItem.dataset.salePrice);

        // 수량 감소 버튼
        decreaseBtn.addEventListener("click", () => {
            let quantity = parseInt(quantitySpan.innerText);

            if (quantity <= 1)
                alert("1보다 작을 수 없습니다")

            if (quantity > 1) {
                quantity--;
                quantitySpan.innerText = quantity;

                const price = salePrice * quantity;
                updateCart(cartId, bookId, quantity, price);

                const priceSpan = cartItem.querySelector(".price");
                priceSpan.innerText = price.toLocaleString() + '원';
            }
        });

        // 수량 증가 버튼
        increaseBtn.addEventListener("click", () => {
            let quantity = parseInt(quantitySpan.innerText);

            quantity++;
            quantitySpan.innerText = quantity;

            const price = salePrice * quantity;
            updateCart(cartId, bookId, quantity, price);

            const priceSpan = cartItem.querySelector(".price");
            priceSpan.innerText = price.toLocaleString() + '원';
        });
    });
}

// 선택된 항목의 총 수량과 금액 계산
function updateSummary() {
    let cnt = 0;
    let total = 0;

    // 모든 장바구니에 대한 단가 * 수량 계산
    document.querySelectorAll(".cart-item").forEach(item => {
        const checkbox = item.querySelector(".select-item");

        if (checkbox.checked) {
            const salePrice = parseInt(item.dataset.salePrice);
            const quantity = parseInt(item.querySelector(".quantity-number").innerText);

            cnt += quantity;
            total += salePrice * quantity;
        }
    });

    // 총 주문 수량 출력
    const totalCntElement = document.querySelector(".total-cnt");

    if (totalCntElement)
        totalCntElement.innerText = cnt + '개';

    // 총 주문 금액 출력
    document.getElementById("total-price").innerText = total.toLocaleString() + '원';
}

// 수량 변경 시 장바구니 정보 업데이트
function updateCart(cartId, bookId, quantity, price) {
    axios.post("/cart/update", {
        cartId: cartId,
        bookId: bookId,
        quantity: quantity,
        price: price
    })
    .then(response => {
        const result = response.data;

        if (result === "LOGIN_REQUIRED") {
            if (confirm("로그인이 필요합니다. 로그인 페이지로 이동할까요?"))
                window.location.href = "/login/login";
        } else {
            alert(result);
            updateSummary();
        }
    })
    .catch(error => {
        console.error("장바구니 수정 중 오류:", error);
        alert("장바구니 수정 중 오류가 발생했습니다.");
    });
}