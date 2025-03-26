document.addEventListener("DOMContentLoaded", function () {
    const addCartButtons = document.querySelectorAll(".add-cart-btn");

    addCartButtons.forEach(button => {
        button.addEventListener("click", function (event) {
            // a 태그로 이동 막기
            event.stopPropagation();
            // 혹시 모를 기본 동작 방지
            event.preventDefault();

            // 장바구니 추가 버튼에 묶은 속성 가져옴
            const bookId = button.dataset.bookId;
            const price = button.dataset.price;

            axios.post("/cart/add/one", {
                bookId: bookId,
                price: price
            }).then(response => {
                const message = response.data;

                if (message === "LOGIN_REQUIRED") {
                    if (confirm("로그인이 필요합니다. 로그인 페이지로 이동할까요?")) {
                        window.location.href = "/login/login";
                    }
                } else {
                    alert(message);
                }
            }).catch(error => {
                console.log(error)
                alert("장바구니 요청 중 문제가 발생했습니다.");
            });
        });
    });
});