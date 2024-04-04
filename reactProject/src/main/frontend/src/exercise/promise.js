// 1. producer
const promise = new Promise((resolve, reject) => {
  // 네트워크 작업, 파일 작업 등으로 시간이 소요됨
  console.log('doing something');
  setTimeout(() => {
    // resolve('작업 결과');
    reject(new Error('에러 발생'));
  }, 2000)
});

// 2 .consumer
promise.then(value => { console.log(value); })
  .catch(error => { console.log(error); }); 


  //  - catch가 없을 때
  // doing something
  // C:\workspace\Spring\reactProject\src\main\frontend\src\exercise\promise.js:7
  //     reject(new Error('에러 발생'));
  //            ^
  
  // Error: 에러 발생
  //     at Timeout._onTimeout (C:\workspace\Spring\reactProject\src\main\frontend\src\exercise\promise.js:7:12)
  //     at listOnTimeout (node:internal/timers:573:17)
  //     at process.processTimers (node:internal/timers:514:7)
  

  //  - catch가 있을 때 
  // doing something
  // Error: 에러 발생
  //     at Timeout._onTimeout (C:\workspace\Spring\reactProject\src\main\frontend\src\exercise\promise.js:7:12)
  //     at listOnTimeout (node:internal/timers:573:17)
  //     at process.processTimers (node:internal/timers:514:7)