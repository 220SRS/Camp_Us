var slides = document.querySelectorAll('.slide');
var currentSlide = 0;
var slideInterval;

// 현재 슬라이드를 활성화 시키는 함수
function showSlide(n) {
  slides[currentSlide].classList.remove('active');
  currentSlide = (n + slides.length) % slides.length;
  slides[currentSlide].classList.add('active');
}

// 왼쪽 버튼 클릭 시
document.querySelector('.prev').addEventListener('click', function() {
  showSlide(currentSlide - 1);
});

// 오른쪽 버튼 클릭 시
document.querySelector('.next').addEventListener('click', function() {
  showSlide(currentSlide + 1);
});

// 초기 슬라이드 활성화
showSlide(currentSlide);

// 자동으로 넘어가는 기능 제거
function pauseSlide() {
  clearInterval(slideInterval);
}

pauseSlide();

