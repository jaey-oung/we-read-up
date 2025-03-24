document.addEventListener("DOMContentLoaded", function () {
    const userTab = document.querySelector("#user-tab");
    const memberTab = document.querySelector("#member-tab");
    const form = document.querySelector(".third-category");
    const title = document.querySelector("#signup-title");
    const memberFields = document.querySelectorAll(".member-field");

    // 회원 전용 필드 숨기기
    function hideMemberFields() {
        memberFields.forEach(el => el.style.display = "none");
        form.action = "/register/user";
        title.textContent = "비회원가입";
    }

    // 회원 전용 필드 보이기
    function showMemberFields() {
        memberFields.forEach(el => el.style.display = "block");
        form.action = "/register/member";
        title.textContent = "회원가입";
    }

    hideMemberFields();

    // 회원가입 눌렀을 때
    userTab.addEventListener("click", () => {
        userTab.classList.add("active");
        memberTab.classList.remove("active");
        hideMemberFields();
    });

    // 비회원가입 눌렀을 때
    memberTab.addEventListener("click", () => {
        memberTab.classList.add("active");
        userTab.classList.remove("active");
        showMemberFields();
    });
});