//자바스크립트 타이머와 싱글스레드와의 관계
// 자바스크립트 타이머는 요청한 시간을 보장하지 못한다.
// 그이유는 싱글 스레드에 있다.
function yo(){
    setTimeout(function()  {  //timer는 자바스크립트안에서하는것이 아니라
        // 웹 api에서 제공하는친구. timer에게 넘겨줌.
        console.log('1.5초 타이머 끝');
    }, 1500);

    for (let i = 0; i < 3; i++) {
        // doSomething();//가정:매번 1초가 걸리는일
        console.log(i);
        
}
        console.log('3초가 걸리는 for문 끝');
}
yo();

console.log('main 끝');
//프로그램에 대해 설명하자면 
// dosomething을 하면서 시간이 지나는데 타이머 1.5초가 돼도
//바로 실행을 하지않고 기존에 있던아이들을 게속 실행하게됨.
// 결국  main끝까지 실행하면 callstack이 비어지니 
// 1.5초 타이머 끝이라는것이 찍힘.