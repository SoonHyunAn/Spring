/* 
 * Aside menu Control
 */

$(document).ready(function(){ // event 등록
  $('#stateMsgBtn').click(function(e){
    $('#stateMsgInput').attr({'class': mt-2}); // 입력창(stateMsgInput) class의 d-none 을 없애줌. -> 보이게 해줌.
    $('#stateInput').val($('#stateMsg').text()); // 입력창에 stateMsg 내용이 보이게
  });
  $('#stateMsgSubmit').click(changeStateMsg); // 이벤트 등록
});