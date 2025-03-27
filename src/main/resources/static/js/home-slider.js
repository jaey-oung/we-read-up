 (() => {
    const images_list = [
        {
            "url": "/img/slides/new-java.png",
            "name": "신간도서_자바의_정석_4판",
            "link": "/search?option=all&keyword=자바의+정석+4판" /* 책 추가 후 bookDetail로 연결 */
        },
        {
            "url": "/img/slides/rec-health.png",
            "name": "추천_건강의_날_건강도서",
            "link": "/bookList?category=cm_1" /* 국내 건강 도서 기준 */
        },
        {
            "url": "/img/slides/event-join.png",
            "name": "회원가입_이벤트",
            "link": "/register/form"
        },
        {
            "url": "/img/slides/new-golf.png",
            "name": "신간도서_골프",
            "link": "/search?option=all&keyword=골프" /* 책 추가 후 bookDetail로 연결 */
        },
        {
            "url": "/img/slides/event-spring.png",
            "name": "봄_이벤트_쿠폰",
            "link": "/search?option=all&keyword=" /* 국내 도서 전체 리스트 출력 */
        },
        {
            "url": "/img/slides/rec-travel.png",
            "name": "추천_여행도서",
            "link": "/bookList?category=cm_2" /* 국내 여행 도서 기준 */
        },
        {
            "url": "/img/slides/benefit-member.png",
            "name": "회원_혜택",
            "link": "/login/login"
        }
    ];

     let slider_id = document.querySelector("#h-slider-1");
     let images_div = "";

     /* 이미지 슬라이드 태그 생성, img의 alt 값은 name과 동일 */
     for (let i = 0; i < images_list.length; i++) {
         let href = (images_list[i].link === "" ? "":' href="'+images_list[i].link+'"');
         images_div += '<a' + href + ' class="h-slides"' + (i === 0 ? ' style="display:flex"' : ' style="display:none"') + '>' +
             '<img src="' + images_list[i].url + '" alt="' + images_list[i].name + '">'
             + '</a>';
     }

     slider_id.querySelector(".h-slider-body").innerHTML = images_div;

     let slide_index = 0; /* 현재 슬라이드 번호 */
     let slider_number = slider_id.querySelector("#h-slide-number");

     function setNumberText() {
         slider_number.innerHTML = (slide_index < 10 ? "0" : "") + (slide_index + 1) + ' - ' + (images_list.length < 10 ? "0" : "") + images_list.length;
     }

     const images = slider_id.querySelectorAll(".h-slides");
     const prev_button = slider_id.querySelector("#h-slide-prev");
     const next_button = slider_id.querySelector("#h-slide-next");

     setNumberText(); /* 슬라이드 1번에도 slide-number 보이도록 설정 */

 })();