function delay(ms) {
  return new Promise (resolver => setTimeout(resolver, ms));
}

// 비동기로 인한 오류
function getApple() {
  delay(3000);
  return '맛있는 사과';
}

// 비동기 오류 제어를 위한 방식 
async function getBanana(){
  await delay(3000);
  return '타이밍지리는 바나나';
}

console.log(getApple());

getBanana().then(data => {console.log(data);}); // promise는 반드시 이러한 방법으로
                                                // 값을 표시해야 함.